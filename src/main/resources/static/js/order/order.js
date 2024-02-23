

/* 수량버튼 */
document.addEventListener('DOMContentLoaded', function() {
    const btnUp = document.querySelector('.btn_up'); // 버튼 요소 선택
    const quantityInput = document.querySelector('.quantity'); // 수량 입력창 선택

    if (btnUp) {
        btnUp.addEventListener('click', function() {
            const num1 = parseInt(quantityInput.value); // 현재 수량 가져오기
            const plus = num1 + 1; // 1을 더하기
            quantityInput.value = plus; // 새로운 수량 설정
        });
    }
});

document.addEventListener('DOMContentLoaded', function() {
    const btnDown = document.querySelector('.btn_down'); // 버튼 요소 선택
    const quantityInput = document.querySelector('.quantity'); // 수량 입력창 선택

    if (btnDown) {
        btnDown.addEventListener('click', function() {
            const num2 = parseInt(quantityInput.value); // 현재 수량 가져오기
            const minus = Math.max(num2 - 1, 1); // 1을 빼기, 수량은 1 이상이어야 함
            quantityInput.value = minus; // 새로운 수량 설정
        });
    }
});

document.addEventListener('DOMContentLoaded', function() {
    const btnDel = document.querySelector('.btn_del');
    const listLi = document.querySelector('.listLi');

    if (btnDel && listLi) {
        btnDel.addEventListener('click', function() {
            // 버튼을 눌렀을 때 리스트 항목을 삭제
            listLi.remove();
        });
    }
});

$(document).ready(function() {
    // ... (기존 코드 생략)

    // 수량 변경에 따른 이벤트 처리
    $('#quantityInput').on('input', function() {
        updatePaymentAmount();
    });

    // 함수로 분리하여 결제 금액 업데이트
    function updatePaymentAmount() {
        var quantity = parseInt($('#quantityInput').val());
        var unitPrice = parseInt($('.title1 p:last').text().replace('원', ''));
		
		console.log(unitPrice);
		
        var totalAmount = quantity * unitPrice;

        // 각 항목에 대한 가격 업데이트
        $('.flex.between p:last').text(totalAmount + '원');  // 주문 금액
        $('.flex.between.border_bottom p:last').text('0원');  // 배달팁 (0원으로 가정)
        $('.flex.between:last p:last').text(totalAmount + '원');  // 총 결제 금액
    }
});



