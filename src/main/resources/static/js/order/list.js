$(document).ready(function () {
		        var temporaryData = {}; // 선택 메뉴와 수량을 임시로 저장하는 객체
		
		        $('.title1').click(function () {
		            var name = $(this).find('p:first').text();
		            var content = $(this).find('#eng').text();
		            var price = parseInt($(this).find('p:last').text().replace(/[^0-9]/g, ''), 10);
		            var count = parseInt($(this).find('.quantity').val(), 10);
		
		            $('.title1, section.selected').removeClass('selected');
		            $(this).addClass('selected');
		            $(this).closest('section').addClass('selected');
		
		            // 임시로 선택한 메뉴와 수량을 저장
		            temporaryData = {
		                name: name,
		                content: content,
		                price: price,
		                count: count
		            };
		
		            console.log('Temporary data:', temporaryData);
		        });
		
		        $('#confirmButton').click(function () {
		            // 확인 버튼 클릭 시 임시로 저장된 데이터를 서버로 전송
		            $.ajax({
		                type: 'POST',
		                url: '/list',
		                data: temporaryData,
		                success: function (response) {
		                    console.log('Data sent to the server');
		                    // 이후에 필요한 동작 수행
		                },
		                error: function (error) {
		                    console.error('Error:', error);
		                }
		            });
		        });
		    });
		    
		    
 $('.menu-button').click(function() {
              $('.cart-q').show();
              event.preventDefault()
            });

            // "취소" 버튼 클릭 시 숨겨진 div를 다시 숨기도록 변경
            $('.button2').click(function() {
                $('.cart-q').hide();
            });
