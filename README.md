
# 치킨 가맹점 주문시스템(빌드테스트3)


- 배포 URL (모바일) : https://manjuu.shop
- 주문관리 페이지 (PC) : https://manjuu.shop/store
- Test ID : green
- Test PW : green
  
<br>

<img src="https://github.com/Bullti/bullti-order-service/assets/141596791/392d829f-4719-4d2e-89b5-6d092716605c">

## 프로젝트 소개

- 가맹점 주문시스템입니다.
- UI는 배달의 민족, 색상은 요기요를 참고하였습니다.
- 사용자화면에서 상품주문시 상품을 주문한 가맹점페이지에 주문내역이 생성됩니다.
- 사용자화면은 모바일기준(width : 430px)으로 제작하였습니다. 

<br>

## 팀원 구성

<div align="center">

| **김병욱** | **최영진** | **최현종** | **인성빈** | **이예슬** |
| :------: |  :------: | :------: | :------: | :------: |
| <img src="https://github.com/Bullti/bullti-order-service/assets/141594307/aa0ad0bb-7137-4f4a-9d3a-485551c56b90" height=150 width=150> <br/> | <img src="https://github.com/Bullti/bullti-order-service/assets/141594307/98bf040a-078c-46dc-b3b1-b2dc1306e591" height=150 width=150> <br/> | <img src="https://github.com/Bullti/bullti-order-service/assets/141594307/3739cd61-3c0f-4c29-9243-bed01adff675" height=150 width=150> <br/> | <img src="https://github.com/Bullti/bullti-order-service/assets/141594307/758ec7fc-ee0d-42c1-a897-e01b84f38216" height=150 width=150> <br/> | <img src="https://github.com/Bullti/bullti-order-service/assets/141594307/3aa3af43-7db0-4888-8f02-4a8380597ff9" height=150 width=150> <br/> |

</div>


<br>

## 1. 개발 환경

- Front : HTML, CSS, JavaScript, jQuery
- Back-end : SpringBoot
- API : 영화진흥위원회 오픈API, 공공데이털포털 오픈API
- 버전 및 이슈관리 : Github
- 협업 툴 : Notion, Github, Padlet
- 서비스 배포 환경 : AMAZON EC2 Linux
- 디자인 : Figma
  
<br>

## 2. 협업 전략

### 스크럼(애자일 개발 프로세스)

 - 매일 15분 정도의 스탠드업 회의 진행 (개발순서, 방향성 공유)
 - 일일 작업일지 작성하여 페들렛 공유
 - 요구사항에 대한 즉각적인 반영

### 브레인스토밍

 - 핵심기능, 일반기능 분류
 - 개발 우선순위 부여

### Notion

 - 프로젝트 간트차트작성 및 공유
 - 협업을 통한 URL설계로 삭제/수정/등록 url 정의

### Padlet

 - 작업일지 및 회의내용 기록
 - 간단한 자료 공유
   
<br>

## 3. 프로젝트 구조

<br>

## 4. 역할 분담

### 김병욱

- **UI**
    - 페이지 : 가맹점페이지
- **기능**
    - RabbitMQ를 활용한 주문알림, 가맹점 챗봇
<br>
    
### 최영진

- **UI**
    - 페이지 : 헤더푸터 레이아웃, 마이페이지, 주문내역페이지, 주문상세페이지
- **기능**
    - CI/CD, spring-config, 결제시스템, 챗봇(영화관API)

<br>

### 최현종

- **UI**
    - 페이지 : 장바구니, 로그인
- **기능**
    - 스프링시큐리티, 회원가입, 로그인

<br>

### 인성빈

- **UI**
    - 페이지 : HOME, 매장선택페이지
- **기능**
    - 챗봇(버스API), 매장검색
    
<br>

### 이예슬

- **UI**
    - 상품리스트페이지, 주문페이지
- **기능**
    - 장바구니, 주문서비스
    
<br>

## 5. 개발 기간

### 개발 기간

- 전체 개발 기간 : 2024-02-14 ~ 2024-02-27
- 요구사항 분석 및 설계 : 2024-02-13 ~ 2024-02-14
- UI 구현 : 2024-01-14 ~ 2024-01-18
- 기능 구현 : 2024-02-18 ~ 2024-02-25
- 테스트 및 발표 준비: 2024-02-26

<br>

## 6. 페이지별 기능

### [초기화면]
- 서비스 접속 초기화면으로 splash 화면이 잠시 나온 뒤 다음 페이지가 나타납니다.
    - 로그인이 되어 있지 않은 경우 : SNS 로그인 페이지
    - 로그인이 되어 있는 경우 : README 홈 화면
- SNS(카카오톡, 구글, 페이스북) 로그인 기능은 구현되어 있지 않습니다.

| 초기화면 |
|----------|

<br>
