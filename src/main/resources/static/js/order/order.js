

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

document.addEventListener('DOMContentLoaded', function() {
	const count = document.querySelector('.quantity');
	const price = document.querySelector('.price');
	
	console.log(count);
	console.log(price);
	
});




