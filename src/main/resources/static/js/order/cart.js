

/* 수량버튼 */
document.addEventListener('DOMContentLoaded', function() {
    const btnUps = document.querySelectorAll('.btn_up');
    const quantityInputs = document.querySelectorAll('.quantity');

    if (btnUps.length > 0) {
        btnUps.forEach(function(btnUp, index) {
            btnUp.addEventListener('click', function() {
                const num1 = parseInt(quantityInputs[index].value);
                const plus = num1 + 1;
                quantityInputs[index].value = plus;
            });
        });
    }
});

document.addEventListener('DOMContentLoaded', function() {
    const btnDowns = document.querySelectorAll('.btn_down'); // 버튼 요소 선택
    const quantityInputs = document.querySelectorAll('.quantity'); // 수량 입력창 선택

    if (btnDowns.length > 0) {
        btnDowns.forEach(function(btnDown, index) {
            btnDown.addEventListener('click', function() {
                const num2 = parseInt(quantityInputs[index].value); // 현재 수량 가져오기
                const minus = Math.max(num2 - 1, 1); // 1을 빼기, 수량은 1 이상이어야 함
                quantityInputs[index].value = minus; // 새로운 수량 설정
            });
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



