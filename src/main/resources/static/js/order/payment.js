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

var userId;
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

// 결제하기
async function payment() {
	try {
		let orderNo = await order(); // 주문 함수 비동기 호출
		console.log("orderNo: " + orderNo);
		// DB 저장
		paySaveDb(orderNo);

		IMP.init('imp86331017')
		IMP.request_pay({
			pg: 'kakaopay',
			merchant_uid: merchant_uid,
			/*상품명*/
			name: itemName,
			/*가격*/
			amount: itemAmount,
			buyer_email: userId,
			buyer_name: userName,
			//buyer_tel: '010-1234-5678',
			//buyer_addr: '서울특별시 강남구 삼성동',
			//buyer_postcode: '123-456',
			m_redirect_url: "http://localhost:8080/orders/payments/complete"+orderNo
		}, function(rsp) { // callback
			if (rsp.success) {
				$.ajax({
					url: "/orders/payments/complete/" + 1,
					contentType: 'application/json',
					type: 'post',
					data: JSON.stringify({
						imp_uid: rsp.imp_uid,
						merchant_uid: rsp.merchant_uid,
						orderNo: orderNo
					}),
				});
			} else {
				$.ajax({
					url: "/orders/payments/complete/" + 0,
					contentType: 'application/json',
					type: 'post',
				});
				alert(rsp.error_msg)
				console.log(rsp);
			}
		});
	} catch (error) {
		console.error("결제 에러", error);
		// 에러 처리
	}

}

// 주문하기
async function order() {
	try {
		let orderNo = await getOrderFromServer();
		console.error("주문 성공");
		console.log(orderNo);
		return orderNo;
	} catch (error) {
		console.error("주문 에러", error);
		throw error; // 예외를 다시 던지거나 적절히 처리
	}
}
function getOrderFromServer() {
	return new Promise((resolve, reject) => {
		$.ajax({
			url: '/orders',
			type: 'post',
			contentType: 'application/json',
			success: function(data) {
				resolve(data);
			},
			error: function(error) {
				reject(error);
			}
		});
	});
}
// 결제 정보 DB 저장
function paySaveDb(orderNo) {

	$.ajax({
		url: '/orders/payments',
		type: 'post',
		contentType: 'application/json',
		data: JSON.stringify({
			"orderNo": orderNo,
			"pg": "kakaopay",
			"merchant_uid": merchant_uid,
			"amount": itemAmount
		}),
		success: function() {
			console.log("결제 정보 DB 저장 완료");
		},
		error: function(error) {
			console.error("결제자 정보 에러" + error);
		}
	});
};

// 결제자 정보
function buyerInfo() {
	$.ajax({
		url: '/orders/members',
		type: 'get',
		success: function(data) {
			userId = data.id;
			userName = data.name;
		},
		error: function(error) {
			console.error("결제자 정보 에러" + error);
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
		data: JSON.stringify({
			"merchant_uid": merchant_uid,
			"amount": itemAmount
		}),
		success: function() {
			console.log("결제 금액 사전 등록");
		},
		error: function() {
			console.error("결제 금액 사전 등록 실패");
		}
	});
}