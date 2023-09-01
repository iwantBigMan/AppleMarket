# AppleMarket
## 내일배움캠프 안드로이드 숙련 개인과제
### 제작 기한 
* 8/21 ~ 9/1 14:00
### 기술 스택
* Kotlin
* Android Studio
### 필수 요구사항 
- 디자인 및 화면 구성을 최대한 동일
- 상품 데이터는 노션 링크 dummy data 를 사용
- RecyclerViewer를 이용해 리스트 화면을 구현
- 상단 툴바를 제거하고 풀스크린 화면으로 세팅
- 상품 이미지 모서리를 라운드 처리
- 상품 이름 최대 두 줄, 넘어가면 뒷 부분에 …으로 처리
- 뒤로가기(BACK)버튼 클릭시 종료하시겠습니까? [확인][취소] 다이얼로그 구현
- 상단 종모양 아이콘을 누르면 Notification (알림)
- 상품 가격은 1000단위로 콤마(,) 처리
- 상품 아이템들 사이에 회색 라인을 추가해서 구분
- 상품 선택시 상품 상세 페이지로 이동
- 상품 상세페이지 이동시 intent로 객체를 전달 (Parcelize 사용)
### 선택 요구사항
- fab 클릭 시 리스트 최상단 이동 후 버튼 hide()
- 좋아요 버튼 구현
- LongClickListener 사용해서 아이템 롱클릭 시 상품 삭제 다이얼로그 띄운 후 삭제 버튼 클릭 시 아이템 삭제 기능 