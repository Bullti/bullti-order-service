/**
 * 
 */

 document.getElementById('storeOpenclose').addEventListener('click', openCloseStroe);
 
 let storeOderStompClient = null;
 
 function openCloseStroe() {
	if(storeOderStompClient == null) {
		storeOderStompClient=Stomp.over(new SockJS("/store-order"));
		storeOderStompClient.connect({},(frame)=>{
			
		})
	}
 }