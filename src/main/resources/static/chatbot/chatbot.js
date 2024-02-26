/**
 * 
 */
var stompClient=null; 
var key=new Date().getTime();

$(function(){
	$("#btn-bot").click(btnBotClicked);
});

//선택지 선택시 텍스트 추출하여 메세지 보내기
function choiceValueSend(event) {
    let choiceValue = $(event.target).text(); // 클릭된 요소의 텍스트 값을 가져옴
    console.log(choiceValue)
	sendChatbotMessage(choiceValue);
}
function btnCloseClicked(){
	$("#bot-container").hide();
	$("#chat-content").html("");
	disconnect();
}
function btnBotClicked(){
	//1. 소켓 접속
	$("#bot-container").show();
	connect()
}

//1~9 -> 01~09 변환하는 함수
function fomatNumber(number){
	return number<10? '0'+number:''+number;
}

// 시간출력 ex) 오전 9:08
function formatTime(){
	var now=new Date();
	var ampm=(now.getHours()>11)?"오후":"오전";
	var hour=now.getHours()%12;
	if(hour==0)hour=12;
	return `${ampm} ${hour}:${fomatNumber(now.getMinutes())}`;
}

function userTag(text){
	var time=formatTime();
	return `
	<div class="msg user flex">
		<div class="message">
			<div class="part">
				<p>${text}</p>
			</div>
			<div class="time">${time}</div>
		</div>
	</div>
	`;
}

function botTag(text, choiceTag){
	var time=formatTime();
	return `
	<div class="msg bot flex">
		<div class="icon">
			<img src="/images/chatbot/robot-solid.svg">
		</div>
		<div class="message">
			<div class="part">
				<p>${text}</p>
			</div>
			<div>
				<ul class="choice-container flex">
					${choiceTag}
				</ul>
			</div>
			<div class="time">${time}</div>
		</div>
	</div>
	`;
}
function showMessage(tag){
	$("#chat-content").append(tag);
	//스크롤이 제일 아래로
	$("#chat-content").scrollTop($("#chat-content").prop("scrollHeight"));

}

function connect(){
	
	if(stompClient == null) {	
		stompClient=Stomp.over(new SockJS("/green-bot"));
	}
	stompClient.connect({},(frame)=>{
		//접속이 완료되면 인사말수신-구독
		stompClient.subscribe(`/topic/order/${key}`,(answerData)=>{
			//console.log(answerData.body);
			var message=JSON.parse(answerData.body);
			var text=message.content;
			let choiceArray = message.choices;
			
			/////////////////////////////
			let choiceTag = "";
			var tag;
			if(choiceArray) {
				choiceArray.forEach(choice => {
					console.log(choice)
					choiceTag += `<li><button onclick="choiceValueSend(event)" type="button" class="chatbot-choice">${choice}</button></li>`
				})
			}
			tag=botTag(text, choiceTag);
			/////////////////////////////
			showMessage(tag);
		})
		
		var data={
			key: key,
			name:"그린",
			content: "홈"
		}
		//인사말 보내줘
		stompClient.send("/message/bot",{},JSON.stringify(data));
	});
}
function disconnect() {
	stompClient.disconnect(function(){
		stompClient = null;
	});
}
function checkEnterKey(event){
	var keyCode=event.keyCode;
	if(keyCode===13){
		btnMsgSendClicked();
	}
}


function btnMsgSendClicked() {
	var content=$("#question").val().trim();
	sendChatbotMessage(content)
}

function sendChatbotMessage(content) {
	
	var data={
		key,
		name:"그린",
		content
	}
	
	stompClient.send("/message/bot",{},JSON.stringify(data))
	var tag=userTag(content);
	$("#question").val('');
	showMessage(tag);
	
}