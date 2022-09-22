# RisingTest 개발 일지
### RC 9기 꿩 - 김재연

### ✅ 라이징 테스트 1일차 9월 18일 토요일

### 👌 라이징 테스트 첫날

<aside>
💡 라이징 테스트 첫날은 크게 다음과 같이 진행 되었다.

</aside>

- 오전 10시에 라이징 테스트 세미나가 시작
- 오전 10시부터 4시까지 팀 별로 회의 진행
- 기획서를 작성하면서 기능 메뉴판에 따라서 앱의 우선 순위를 정함
- 각자 개발 시작(중간 중간 디스코드를 통해 변경사항 적용)

<aside>
💡 Team 오늘의집 B로 배정되었다.

</aside>

<aside>
💡 팀 이름에서도 알 수 있듯이 앱은 “오늘의집” 으로 정해졌다.

</aside>

### 👌 라이징 테스트 규칙

- 1일 1commit , 개발 일지 작성이 필수로 요구 된다.
- 테스트 전용 템플릿이 있는데 템플릿 양식에 맞춰 개발을 해야 한다.

### 👌 클라이언트 1주차 작업 범위

<aside>
💡 1차 피드백 전까지의 작업 범위를 정하였다.

</aside>

- 스플래시 이미지
- 이메일 로그인 및 회원가입
- 메인 바텀 네비게이션
- 메인 화면 다이얼로그
- 홈 프래그먼트
- 스토어 프래그먼트

### 👌 1일 차 진행 상황

<aside>
💡 스플래시 이미지 구현 완료

</aside>

<aside>
💡 이메일 로그인 및 회원가입 UI 및 화면 전환 구현 완료

</aside>

❓아직 서버분이 구축 중이시기 때문에 API 연결은 할 수 없어 UI와 간단한 기능들 부터 구현하기로 하였다.

<aside>
💡 회원가입 액티비티와 연결되는 웹뷰 액티비티 구현 완료

</aside>

### 👌 2일 차 진행 상황

<aside>
💡 메인 액티비티 진입 시 뜨는 다이얼로그 구현 완료

</aside>

<aside>
💡 메인 바텀 네비게이션 바 구현 완료

</aside>

<aside>
💡 바텀 바와 프래그먼트 연결 후 스토어 프래그먼트 구현 중

</aside>

<aside>
💡 홈 프래그먼트 UI중 막히는 부분이 있어서 현재 해결 중

</aside>

### 👌 3일 차 진행 상황

<aside>
💡 홈 프래그먼트 UI 해결 완료

</aside>

<aside>
💡 스토어 프래그먼트 리사이클러뷰 부분 구현, 툴바 구현 완료

</aside>

<aside>
💡 홈 프래그먼트에 툴바를 달아주고 CoordinatorLayout으로 툴바만 접히게 기능 구현

</aside>

<aside>
💡 홈 프래그먼트에 프래그먼트가 결합된 뷰페이저와 탭 레이아웃을 연결 시키고 내용 구현 중

</aside>

👋 팀 위클리 스크럼 일정

- 9월 20일 (화) 위클리 스크럼 1시 ~ 3시

❓팀 기획서 변동사항

- (서버) - 회원가입 API 화요일 아침 완성 예정
- 회원가입에 필요한 정보 이메일 / 비밀번호 / 별명 으로 지정
- 마이페이지 - 알림, 좋아요, 스크랩 정보 그대로 기존에 가져오던 정보 사용
- 나의 쇼핑 - 쿠폰 뷰만 구현
- 나의 쇼핑 - 포인트 정보만 받아와서 프론트 단에서 처리
- 나의 쇼핑 - 주문 / 배송은 결제 완료까지만 처리
- 사진 - 사진은 서버로 보낼때 url 형식으로 보내줄것

‼️ 개발 이슈

- 홈 프래그먼트에서 Coordinator Layout을 사용하였는데 기존에 사용해본적이 없어서 낯설었고 레이아웃을 이해하는데 시간이 꽤 소요되었다. 결국 멘토님에게 도움을 요청해서 레이아웃을 수정하였다.

👉 그 후 추가적으로 뷰를 수정하는데 스크롤이 잘 안먹이는 이슈가 있었다. 이유를 살펴보니, coordinatorLayout 안에 뷰 페이저를 behavior로 사용할 때에는 NestedScrollView로 뷰 페이저를 감싸는 것이 아니라 뷰 페이저 안 프래그먼트의 아이템 레이아웃 최상단을 NestedScrollView로 감싸야 한다.

✅ 감싸주었더니 스크롤이 정상 작동 하였다.

- 스토어 프래그먼트에서 두가지 이슈가 있었다.

👉  첫번째는 bind로 스토어 프래그먼트의 xml을 연결시켜주어야 하는데 홈 프래그먼트의 xml을 연결시키고 말았다.

✅ 수정 후에 에러가 해결 되었고, 정신 차려서 개발해야겠다고 다짐 했다.

👉 두번째는 스토어 프래그먼트에서 scrollView와 SwipeRefreshLayout을 같이 사용하는데 이때 스와이프 기능을 Y축 최상단에 도달했을 경우에만 작동하도록 하기 위해서

ViewTreeObserver의 OnScrollChangedListener를 사용하였는데 리스너 사용후 해제를 해주지 않아 프래그먼트가 계속 꺼지는 에러가 발생하였다.

✅ 프래그먼트의 onStop() 메소드를 호출하고 메소드 내부에 리스너를 해제 해주는 코드를 넣어주었다.

### 👌 4일차 진행상황

- 4일차에는 5시에 첫번째 순서로 피드백을 받았다.
- 위클리 스크럼 진행에 따라 팀 기획서가 변동 되었다.
- 위클리 스크럼, 피드백을 진행함에 따라 변동사항이 많아져 기획 회의를 가지고 우선 순위 파악후에 다시 개발하기로 하였다.
- 피드백에 따른 내용을 일부 먼저 수정 하기로 했다.

### 👋 피드백 내용

- 회원가입 액티비티 부분을 구현할 때 Detail을 살리는 것은 좋지만 어떤 부분이 더 우선인지 정하고 Detail 수정에 들어가는게 좋을 것 같다고 하셨다.
    
    👉 예를 들면, 회원가입에서 전체 체크시 or 이메일이나 패스워드 입력시 버튼이 활성화 되는데 그런 필요한 부분 먼저 Detail 수정이 들어가면 좋겠다고 하셨다.
    
    👉 하지만, 일단 현재는 Detail 수정 보다 기능 구현이 우선이기 때문에 API를 이용한 회원가입 기능을 먼저 구현하고 후 순위로 진행하기로 하였다.
    
- 커스텀 다이얼로그 전체 레이아웃 위 양쪽 모서리가 radius가 적용이 안되는 오류를 해결 하기 위해서 다음 두가지를 해보라고 조언해 주셨다.
    
    👉 Theme 다이얼로그를 상속받아서 스타일을 건들여보기
    
    👉 커스텀 다이얼로그 레이아웃 최상단을 카드뷰로 지정해보기
    

- 상태바 색상을 변경 했으므로 배경색 뒤에 가려진 텍스트가 보이게 수정해달라고 하셨다.

- 홈 프래그먼트 - 인기 탭의 아이템들 중 여러개의 리사이클러뷰가 있는데 그 뷰들을 이중 리사이클러뷰로 처리해보라고 조언해주셨다.

- 추후에  Horizontal ScrollView나 RecyclerView를 이용해 가로 스크롤뷰 를 구현할때 현재 전체 레이아웃이 프래그먼트 형식의 뷰페이저로 되어있어 두 뷰 간의 스크롤 문제를 어떻게 해결할것인지 미리 생각하라고 하셨다.

- 추후에 명세서에 클라이언트 반영 여부 작성시 반영한 클라이언트 담당의 이름 으로 적어달라고 하셨다.

- 홈 프래그먼트 - 인기 탭에 각 리사이클러뷰 밑에 버튼 들이 있는데 그 버튼의 그림자를 제거하라고 하셨다.

- 툴바 아이템 간의 간격을 수정하라고 하셨다.

- 오늘의집앱을 보았을 때 홈 쪽도 중요하지만 보통 가구나 기타 상품들을 구매하려고 하는 앱 이기 때문에 앱의 우선순위를 고려했을때 스토어 프래그먼트 쪽을 먼저하는게 좋겠다고 하셨다.

### 👌 구현 진행 상황

<aside>
💡 앱 상단의 툴바위의 상태바 글씨가 안보이는 오류 수정 완료

</aside>

<aside>
💡 메인 액티비티 진입시 나타나는 커스텀 다이얼로그 레이아웃 카드뷰로 변경 완료

</aside>

<aside>
💡 바텀 네비게이션바의 기존의 버튼을 플로팅 액션 버튼으로 변경 완료

</aside>

<aside>
💡 플로팅 액션 버튼 클릭시 애니메이션과 커스텀 다이얼로그 구현(90%)

</aside>

### ‼️ 개발 이슈

- 큰 오류나 수정 사항들은 피드백 때 받았기 때문에 제일 컸던 이슈를 생각해보았다.

<aside>
💡 오늘의집이 자동 업데이트가 되었는데 안드로이드 버전이 다른데도 서로 최신 업데이트 날짜가 달랐다.

</aside>

❓문제는 앱이 업데이트 되면서 뷰가 크게 변동되었다… 

✅ 급하게 검색을 통해 이전 APK 버전을 받을 수 있는 방법을 통해 오늘의집 이전 버전 APK 를 받았는데 완전히 

완전히 동일한 버전을 찾을 수가 없어 필요한 부분이 있으면 사진을 받아 작업 하기로 하였다.

### 👌 5일차 진행상황

👌 구현 진행 상황

- 진행중이던 홈 프래그먼트를 중단하고 우선순위에 맞춰 스토어 프래그먼트를 계속 개발
- 홈 프래그먼트의 상단 바가 접히는 기능이 기존 앱과 다른 점이 있어 수정하여 기존 앱과 동일한 기능 구현 완료
- 커스텀 다이얼로그의 뷰의 크기들이 안맞는 오류를 일부 수정

- 카테고리를 보여주는 가로 스크롤 형식의 리사이클러뷰 구현 완료
- 스토어 프래그먼트의 최근 본 상품 리사이클러뷰 구현 완료 - 이미지만 연동 안했음

👌 구현 스크린 샷


<img src = "https://user-images.githubusercontent.com/95080196/191545813-b106d81e-a134-4466-b388-05f0202c4fb5.jpeg" width="30%" height="30%">

‼️ 개발 이슈

- 홈 프래그먼트 스크롤시 coordinatorLayout에 의해 AppbarLayout이 접히게 되는데 이때 기존의 collapsingtoolbarlayout을 이용해 구현했을때는 가운데서 열리는듯한 모습으로 열고 닫았다.

✅ AppbarLayout만으로 연결한 결과 실제 앱처럼 서랍 형식으로 열고 닫는 듯한 모습이 구현되었다.

- 커스텀 다이얼로그를 실행했을때 바텀 바는 영향을 받지 않아야 하는데 바텀바 위에 까지 덮어버리는 현상이 있어 현재 해결 중이다.

- 가로형 리사이클러뷰에서 똑같은 이미지 크기로 했는데 카테고리만 크기가 조금 달라 추후 수정 예정 이다.

### 👌 6일차 진행상황

### 👌 구현 진행상황

<aside>
💡 홈 프래그먼트에서 탭 레이아웃이 기존에 세개만 있어 앱을 처음 실행시 허전한 느낌이 있어 프래그먼트를 추가하여 탭 레이아웃과 연결

</aside>

<aside>
💡 스토어 프래그먼트에서 상단 광고 배너를 보여주는 뷰페이저를 구현하고 인디케이터를 연동

</aside>

<aside>
💡 스토어 프래그먼트에서 나머지 가로형 리사이클러뷰와 페이징이 적용되어 스크롤시 데이터를 계속 해서 보여주는 리사이클러뷰 구현 (페이징은 현재 구현 x, 그리드 형식)

</aside>

<aside>
💡 회원가입 API 연동전 포스트맨을 사용해서 서버의 Request & Response 여부를 확인, 회원가입 연동 예정

</aside>

### ‼️ 개발 이슈

<aside>
💡 스토어 프래그먼트 전체를 감싸는 스크롤뷰가 작동하지 않는 이슈가 발생하였다.

</aside>

✅ 내부의 ConstraintLayout들 간의 제약이 맞지 않아 발생하였던 오류로 제약 조건을 다시 걸어주어 스크롤 오

류를 해결하였다.

<aside>
💡 스토어 프래그먼트의 스크롤뷰를 상하로 이동하니 스크롤이 부드럽지 않고 렉걸리는 듯한 현상이 발견되었다.

</aside>

✅ NestedScrollView 내부에 리사이클러뷰들이 들어가면 리사이클러뷰 스크롤이 안되는 현상도 해결되고, 나의 문제를 해결하기 위해서는 각 리사이클러뷰에 android:nestedScrollingEnabled=”false” 속성을 넣어주면 해결된다.

다만, 이 속성을 넣을 경우 리사이클러뷰의 메모리절약 장점이 사라지는 단점이 발생한다.. 😔
