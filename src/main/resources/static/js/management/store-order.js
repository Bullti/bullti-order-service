/**
 * 
 */

 document.getElementById('storeOpenclose').addEventListener('click', openCloseStroe);
 
 let storeOderStompClient = null;
 
 function openCloseStroe() {
	 $.ajax({
		 url: '/rabbit/order-service/1',
		 method: 'POST',
		 success: function(response) {
			 console.log('큐생성완료'+response)
		 }
		 
	 })
	if(storeOderStompClient == null) {
		storeOderStompClient=Stomp.over(new SockJS("/store-order"));
		storeOderStompClient.connect({},(frame)=>{
			
		})
	}
	$.ajax({
		url: '/store/list',
		method: 'GET',
		success: function(view) {
			$('#store-order-list').html(view)
			console.log(view);
		}
	})
 }