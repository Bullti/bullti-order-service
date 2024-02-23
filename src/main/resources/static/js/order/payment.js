/**
 * 
 */


var IMP = window.IMP;
var merchant_uid;
var today = new Date();

var date = String(today.getDate()); //날짜
var hours = String(today.getHours()); // 시
var minutes = String(today.getMinutes());  // 분
var seconds = String(today.getSeconds());  // 초
var milliseconds = String(today.getMilliseconds());
var makeMerchantUid = date + hours + minutes + seconds + milliseconds;

var userEmail;
var userName;
var itemName;
var itemAmount;
var storeNo;


$(document).ready(function() {
	
	merchant_uid = "IMP" + makeMerchantUid;
	itemName = $('#itemName').val();
	itemAmount = $('#itemAmount').val();
	storeNo = $('#storeNo').val();
	
	//결제자 정보
	buyerInfo();
	
	//결제 금액 사전 등록
	payPrepare();
	
});


function payment() {
	
	/*주문하기
	return : 주문번호
	*/
	var orderNo = order();
	
	//DB 저장
	paySaveDb(orderNo);
	
	/*가맹점 식별코드 예: 'imp00000000a'*/
	IMP.init('imp86331017')
	IMP.request_pay({
		pg: 'kakaopay',
		merchant_uid: merchant_uid,
		/*상품명*/
		name: itemName,
		/*가격*/
		amount: itemAmount,
		buyer_email: userEmail,
		buyer_name: userName,
		//buyer_tel: '010-1234-5678',
		//buyer_addr: '서울특별시 강남구 삼성동',
		//buyer_postcode: '123-456',
		m_redirect_url: "http://localhost:8080/orders/payments/complete"
	}, function(rsp) { // callback
		if (rsp.success) {
			console.log(rsp);
			
			//DB && portone 유효성 검증
			

			if (response.status == 200) { // DB저장 성공시
				alert('결제 완료!')
				window.location.reload();
			}
		} else {
			alert(rsp.error_msg)
			console.log(rsp);
		}
	});
}

// 주문하기
function order(){
	
	let orderNo;
	
	$.ajax({
		url: '/orders',
		type: 'post',
		contentType: 'application/json',
		success: function() {
			console.error("주문 성공");
		},
		error: function(error) {
			console.error("주문 에러"+error);
		}
	});
	
	return orderNo;
}

// 결제 정보 DB 저장
function paySaveDb(orderNo) {
	$.ajax({
		url: '/orders/payments',
		type: 'post',
		contentType: 'application/json',
		data : {
			"orderNo" : orderNo,
			"pg" : kakaopay,
			"merchant_uid" : merchant_uid,
			"amount" : itemAmount
		},
		success: function(data) {
			userEmail = data.eamil;
			userName = data.name;
		},
		error: function(error) {
			console.error("결제자 정보 에러"+error);
		}
	});
};

// 결제자 정보
function payPrepare() {
	$.ajax({
		url: '/orders/members',
		type: 'get',
		success: function(data) {
			userEmail = data.eamil;
			userName = data.name;
		},
		error: function(error) {
			console.error("결제자 정보 에러"+error);
		}
	});
};

// 결제 금액 사전 등록
function payPrepare() {
	itemAmount = $('#itemAmount').val();
	$.ajax({
		url: '/orders/payments/prepare',
		type: 'post',
		contentType: 'application/json',
		data : JSON.stringify({
			"merchant_uid" : merchant_uid,
			"amount" : itemAmount
		}),
		success: function() {
			console.log("결제 금액 사전 등록");
		},
		error: function() {
			console.error("결제 금액 사전 등록 실패");
		}
	});
}