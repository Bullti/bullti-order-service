/**
 * 
 */

 let storeOderStompClient = null;
 
document.getElementById('storeOpenclose').addEventListener('click', openCloseStroe);



function handleOrderAction(button, action) {
	let dtoNo = button.value;
    // AJAX 요청을 보냅니다.
    fetch('/store', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ orderNo: dtoNo, action: action })
    })
    .then(function(response) {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        requestOrderList()
        console.log('주문 처리 완료');
    })
    .catch(function(error) {
        console.error('오류 발생:', error);
    });
}
 
 function openCloseStroe() {
	 $.ajax({
		 url: `/rabbit/order-service/${storeNo}`,
		 method: 'POST',
		 success: function(response) {
			 console.log('created rabbitMQ'+response)
		 }
		 
	 })
	 requestOrderList()
	if(storeOderStompClient == null) {
		storeOderStompClient=Stomp.over(new SockJS("/store-order"));
		storeOderStompClient.connect({},(frame)=>{
			storeOderStompClient.subscribe(`/topic/store-order/${storeNo}`,(response)=>{
				requestOrderList()})
		})
	}
 }

 function requestOrderList() {
	 
	$.ajax({
		url: '/store/list',
		method: 'GET',
		success: function(view) {
			$('#store-order-list').html(view)
		}
	})
 }