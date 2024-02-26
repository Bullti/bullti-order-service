/**
 * 
 */

function choiceMovie() {
            // 클릭된 li 요소를 가져옴
            var clickedLi = event.currentTarget;

            // li 요소 내부의 input 태그를 찾아서 값을 가져옴
            var hiddenInput = clickedLi.querySelector('input[type="hidden"]');
            var movieCd = hiddenInput.value;
			
			console.log(movieCd)
			sendChatbotMessage(movieCd);
        }