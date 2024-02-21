/**
 * 
 */


var IMP = window.IMP;
IMP.init('imp86331017') // 예: 'imp00000000a'

var today = new Date();
var hours = today.getHours(); // 시
var minutes = today.getMinutes();  // 분
var seconds = today.getSeconds();  // 초
var milliseconds = today.getMilliseconds();
var makeMerchantUid = hours + minutes + seconds + milliseconds;

function requestPay() {

	console.log("requestPay()실행");

	IMP.request_pay({
		pg: 'kakaopay',
		merchant_uid: "IMP" + makeMerchantUid,
		name: '당근 10kg',
		amount: 1004,
		buyer_email: 'Iamport@chai.finance',
		buyer_name: '아임포트 기술지원팀',
		buyer_tel: '010-1234-5678',
		buyer_addr: '서울특별시 강남구 삼성동',
		buyer_postcode: '123-456',
		m_redirect_url: "/order"
	}, function(rsp) { // callback
		if (rsp.success) {
			console.log(rsp);
		} else {
			console.log(rsp);
		}
	});
}