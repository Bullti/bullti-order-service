var data; // 전역 변수로 데이터 저장
		var markers = []; // 전역 변수로 마커 배열 저장
		var infowindows = []; // 전역 변수로 인포윈도우 배열 저장

		// GET 요청 예제
		fetch('/sl/fran')
		  .then(response => {
		    if (!response.ok) {
		      throw new Error('Network response was not ok');
		    }
		    return response.json();
		  })
		  .then(jsonData => {
		    data = jsonData; // 데이터 저장
		    // 성공적으로 응답을 받았을 때의 처리
		    for (var item of data) {
		      createMarker(item);
		    }
		  })
		  .catch(error => {
		    // 오류 발생 시의 처리
		    console.error('Fetch error:', error);
		  });

		function getAddressCoords(address) {
			var geocoder = new kakao.maps.services.Geocoder();
		    return new Promise(function(resolve, reject) {
		        geocoder.addressSearch(address, function(result, status) {
		            if (status === kakao.maps.services.Status.OK) {
		                var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		                resolve(coords);
		            } else {
		                reject("주소 검색 실패: " + status);
		            }
		        });
		    });
		}
		
		var mapContainer = document.getElementById('map'),
		    mapOption = {
		        center: new kakao.maps.LatLng(37.6572060679004, 127.062335636997),
		        level: 1
		    };

		var map = new kakao.maps.Map(mapContainer, mapOption);

		function createMarker(item) {
			  // closedat이 null이 아니라면 마커를 생성하지 않습니다.
			  if (item.closedAt !== null) {
			    return;
			  }
		  getAddressCoords(item.address)
		    .then(function(coords) {
		      var imageSrc = "/img/location/image.webp";
		      var imageSize = new kakao.maps.Size(80, 90);
		      var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

		      var marker = new kakao.maps.Marker({
		        map: map,
		        position: coords,
		        image: markerImage
		      });

		      markers.push(marker); // 생성된 마커를 배열에 저장

		      var infowindow = new kakao.maps.InfoWindow({
		        content: `<div style="margin-left:33px; width:80px;text-align:center;display: center;padding:6px 0;">${item.name}</div>`
		      });

		      infowindows.push(infowindow); // 생성된 인포윈도우를 배열에 저장

		      kakao.maps.event.addListener(marker, 'click', function() {
			        // 현재 마커에 연결된 인포윈도우 상태 확인
			        var currentInfowindow = infowindow.getMap();
			        
			        // 열려있는 경우 닫고, 닫혀있는 경우 열기
			        if (currentInfowindow) {
			          infowindow.close();
			        } else {
			          infowindow.open(map, marker);
			        }
			        
			        // 클릭한 마커로 지도의 중심좌표 이동
			        map.setCenter(coords);
			        map.setLevel(4); // 지도 레벨 조절 (옵션)
			      });
			    })
			    .catch(function(error) {
			      console.error(error);
			    });
			}

		function removeMarkers() {
		  for (var i = 0; i < markers.length; i++) {
		    markers[i].setMap(null);
		    infowindows[i].close();
		  }
		  markers = []; // 배열 초기화
		  infowindows = []; // 배열 초기화
		}

		function searchPlaces() {
		  var keyword = document.getElementById('keyword').value;

		  // 검색어가 비어있으면 모든 매장 표시
		  if (!keyword) {
		    removeMarkers(); // 모든 마커 제거
		    for (var item of data) {
		      createMarker(item);
		    }
		    return;
		  }

		  // 검색어가 있는 경우, 특정 매장만 표시
		  removeMarkers(); // 모든 마커 제거
		  for (var item of data) {
		    if (item.name.includes(keyword)) {
		      createMarker(item);
		    }
		  }
		}