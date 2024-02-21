function selectAll(selectAll)  {
  const checkboxes 
       = document.getElementsByName('cart');
  
  checkboxes.forEach((checkbox) => {
    checkbox.checked = selectAll.checked;
  })
}

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
    const btnAllDel = document.querySelector('.btn_all_del');
    const listLiItems = document.querySelectorAll('.listLi');
    const selectAllCheckbox = document.querySelector('.all-select input[name="cart"]');

    if (btnAllDel && listLiItems.length > 0 && selectAllCheckbox) {
        btnAllDel.addEventListener('click', function() {
            // 모든 .listLi 요소를 삭제
            listLiItems.forEach(function(listLi) {
                listLi.remove();
            });

            // 전체 선택 체크박스의 상태를 해제
            selectAllCheckbox.checked = false;
        });
    }
});

document.addEventListener('DOMContentLoaded', function() {
    const btnAllDel = document.querySelector('.btn_all_del');
    const selectAllCheckbox = document.querySelector('.all-select input[name="cart"]');
    const btnDelItems = document.querySelectorAll('.btn_del');

    if (btnAllDel && selectAllCheckbox && btnDelItems.length > 0) {
        btnAllDel.addEventListener('click', function() {
            // 모든 .listLi 요소를 삭제
            deleteListItems();
            // 전체 선택 체크박스의 상태를 해제
            selectAllCheckbox.checked = false;
        });

        // 각 .btn_del 버튼에 대한 이벤트 리스너 등록
        btnDelItems.forEach(function(btnDel) {
            btnDel.addEventListener('click', function() {
                // 현재 클릭된 .btn_del 버튼의 부모인 .listLi 요소를 삭제
                const listItem = btnDel.closest('.listLi');
                if (listItem) {
                    listItem.remove();
                }

                // 모든 .listLi 요소를 삭제
                deleteListItems();
                // 전체 선택 체크박스의 상태를 갱신
                updateSelectAllCheckbox();
            });
        });
    }

    function deleteListItems() {
        // 모든 .listLi 요소를 삭제
        const listLiItems = document.querySelectorAll('.listLi');
        listLiItems.forEach(function(listLi) {
            listLi.remove();
        });
    }

    function updateSelectAllCheckbox() {
        // 전체 선택 체크박스의 상태를 갱신
        const listLiItems = document.querySelectorAll('.listLi');
        selectAllCheckbox.checked = listLiItems.length > 0 && Array.from(listLiItems).every(function(listLi) {
            return listLi.querySelector('.listLi-check').checked;
        });
    }
});