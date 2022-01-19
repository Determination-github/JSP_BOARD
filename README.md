# 💻JSP 게시판
**MVC MODEL 2**로 구현한 **JSP/Servlet 게시판**입니다.

<br>

## 🛠구현 기능

 - 로그인
 - 로그아웃
 - 회원가입
 - 회원정보 수정 및 삭제
 - 게시글 작성 및 조회
 - 게시글 수정 및 삭제
 - 페이징 처리
 - 파일 첨부

<br>

## 🛠개발 환경 및 기술

 - Window 10 64bit
 - eclipse
 - DBeaver
 - apache-tomcat v9.0
 - JSP/Servlet
 - Oracle 11g
 - EL / JSTL
 - Bootstrap 5.1
 
<br>

## 🛠게시판 구성

게시판은 크게 회원/게시글 화면으로 나뉩니다.

 - 회원 : 회원 가입을 하여 로그인을 할 수 있습니다. 회원 가입 후 로그인을 하면 회원 정보 조회 페이지에서 회원 정보를 수정하거나 회원 정보를 삭제할 수 있습니다.
 - 게시글 : 비로그인 상태에서는 게시글을 조회할 수 있습니다. 로그인 상태에서는 게시글을 조회하고, 본인이 작성한 글의 경우 게시글을 수정하거나 삭제할 수 있습니다.
 
 
 <br>

## 🛠웹 프로젝트 구조
![웹프로젝트](https://user-images.githubusercontent.com/92250627/150120415-ace249a4-7da2-4513-9b1b-5f787e0725be.png)

<br>

## 🛠UML 구조
![JSP UML](https://user-images.githubusercontent.com/92250627/150120481-b9d58c1c-7dfd-4210-802e-9ce5993987c0.gif)

 - 회원 관련 클래스 다이어그램
 - 게시글 관련 클래스 다이어그램
<br>

## 🛠JSP/Servlet

<br>

> 🔉공통부분
<img width="140" alt="공통부분" src="https://user-images.githubusercontent.com/92250627/150121893-322191e2-230d-4774-bff2-0db64a298cbc.PNG">

<br>

 - Action : execute() 메서드를 실행하며 ActionForward 객체를 반환
 - ActionForward : forward/redirect 설정 및 경로 설정
 - DBConnection : DB에 접근하기 위한 객체
 - EncodingFilter : 한글 인코딩을 위한 Filter
 
<br>

> 🔉회원부분
<img width="175" alt="회원부분" src="https://user-images.githubusercontent.com/92250627/150121774-247c3285-92b4-4894-89ea-47e33aa99dee.PNG">
<img width="144" alt="회원부분2" src="https://user-images.githubusercontent.com/92250627/150121796-883ede90-5ef0-4d06-9d05-7f359ddf1932.PNG">

<br>

 - Model
	 - MemberBean : 회원 데이터 관련 getter/setter 구현
	 - MemberDAO : 회원 데이터와 관련된 데이터 처리 담당
 - Properties
	 - member.properties : 회원 관련 property
 - Action
	 - MeberDeleteAction : 회원 삭제 구현
	 - MeberDetailAction : 회원 정보 상세 보기 구현
	 - MeberFormChangeAction : 뷰 페이지 전환 구현
	 - MeberLoginAction : 로그인 구현
	 - MeberLogoutAction : 로그아웃 구현
	 - MeberModifyAction : 회원 정보 수정 구현
	 - MeberSignUpAction : 회원 가입 구현
 - Controller
	 - MemberController : 회원 관련 컨트롤러
	 
<br>

> 🔉게시글부분
<img width="188" alt="게시글부분" src="https://user-images.githubusercontent.com/92250627/150121826-fe023683-d12a-43f1-9bd8-54121c32ee02.PNG">
<img width="151" alt="게시글부분2" src="https://user-images.githubusercontent.com/92250627/150121835-22f30441-ec5f-406b-8a2a-fa00e172ef6a.PNG">

<br>

 - Model
	 - BoardBean : 게시글 데이터 관련 getter/setter 구현
	 - BoardDAO : 게시글 데이터와 관련된 데이터 처리 담당
 - Properties
	 - board.properties : 게시글 관련 property
 - Action
	 - BoardDeleteAction : 게시글 삭제 구현
	 - BoardDetailAction : 게시글 상세보기 구현
	 - BoardDownloadAction : 첨부파일 다운로드 구현
	 - BoardFormChangeAction : 뷰 페이지 전환 구현
	 - BoardListAction : 게시글 목록 표시 구현
	 - BoardUpdateAction : 게시글 수정 구현
	 - BoardUpdateFormAction : 게시글 수정 화면으로 전환 구현
	 - BoardWriteAction : 게시글 작성 구현
 - Controller
	 - BoardController : 게시글 관련 컨트롤러
	 
<br>

> 🔉뷰 페이지
<img width="161" alt="뷰페이지" src="https://user-images.githubusercontent.com/92250627/150121872-f0879ed9-93bd-4eab-8869-116d651e7412.PNG">

<br>

 - main : 메인 페이지 구현
 - header : 화면 상단 구현
 - firstView : 최초 접속 시 표시되는 화면 구현

화면은 main 페이지에서 header와 content를 'include'하여 구현할 수 있도록 하였고, 전달되는 content가 없을 경우 기본적으로 'firstView'를 출력할 수 있도록 화면을 분리하여 구현하였습니다.

- board
	- BoardDetailForm : 게시글 상세 보기 화면
	- BoardListForm : 게시글 목록 화면
	- BoardUpdateForm : 게시글 수정 화면
	- BoardWriteForm : 게시글 작성 화면
- member
	- LoginForm : 로그인 화면
	- MemberDetail : 회원 정보 상세보기 화면
	- PwdCheckForm : 비밀번호 확인 화면
	- ResultForm : 결과 화면
	- SignUpForm : 회원가입 화면
	
<br>

## 🛠테이블/시퀀스

### 📑테이블 구조
<img width="20%" alt="테이블 구조 1" src="https://user-images.githubusercontent.com/92250627/150120680-fecc72c2-10e5-4ef1-a15f-014c7d6a912a.PNG">
  - MEMBER와 BOARD로 구성

<br>

### 📑MEMBER
 
- 멤버 테이블 구조
 <img width="50%" alt="멤버테이블 1" src="https://user-images.githubusercontent.com/92250627/150121000-9862f2bf-7f26-4992-a1ab-a80a58737348.PNG">
 <img width="20%" alt="회원 테이블 구조" src="https://user-images.githubusercontent.com/92250627/150121223-457937a9-3fc5-4ad8-bff5-20b1fab62cd1.PNG">

<br>

- 멤버 테이블 DDL 

<br>

<img width="50%" alt="멤버 ddl" src="https://user-images.githubusercontent.com/92250627/150121040-9519ee24-d243-402e-b812-a384d4dfb5f5.PNG">
  
<br>

### 📑BOARD


- 게시글 테이블 구조 

<br>

<img width="50%" alt="게시글테이블 1" src="https://user-images.githubusercontent.com/92250627/150121460-6903d099-9d24-49a9-a9e8-a8c9e0c4bdf4.PNG">
<img width="20%" alt="게시글테이블 2" src="https://user-images.githubusercontent.com/92250627/150121505-1a1c875e-ae66-4662-927b-d556df3d89e4.PNG">

<br>

- 게시글 테이블 DDL 

<br>

<img width="50%" alt="게시글 테이블 ddl" src="https://user-images.githubusercontent.com/92250627/150121533-b0c9fac4-f94e-4eba-9fa3-75558fa7abf3.PNG">

<br>

### 📑시퀀스

<br> 

게시글 번호 자동 증가를 위한 시퀀스 

<br>

<img width="20%" alt="시퀀스" src="https://user-images.githubusercontent.com/92250627/150121593-c4e4b2cc-9570-438d-89c2-87721f30a9f1.PNG">

<br>

## 🛠동작 화면

 1. 웰컴 페이지 입니다. 회원가입 화면으로 이동해보겠습니다.
<br>
<img width="958" alt="1웰컴페이지" src="https://user-images.githubusercontent.com/92250627/150133242-f635bf18-8864-47de-a893-d3383c4ff4f3.PNG">
 2. 회원가입 화면입니다.

<br>
<img width="957" alt="2회원가입" src="https://user-images.githubusercontent.com/92250627/150133131-cb0111e0-9881-442f-aac6-28d21e6f8311.PNG">
<br>
 3. 내용을 입력하지 않고 회원가입 시도시 경고창이 표시됩니다.
<br>
<img width="959" alt="3회원가입경고창" src="https://user-images.githubusercontent.com/92250627/150133132-6f196cfc-8398-4b55-9a2a-3bf574bedbeb.PNG">
<br>
 4. 비밀번호의 경우 2번 체크하도록 기능을 구현했습니다.
<br>
<img width="957" alt="4회원가입비밀번호체크" src="https://user-images.githubusercontent.com/92250627/150133134-bc5a6516-bbc4-4bcf-a37c-978deb1212b9.PNG">
<br>
 5. 회원가입 결과창입니다.
<br>
<img width="958" alt="5회원가입결과창" src="https://user-images.githubusercontent.com/92250627/150133135-27ac114a-fc19-40df-98cf-113aa6fe9629.PNG">
<br>
 6. 이제 로그인 화면으로 이동해보겠습니다.
<br>
<img width="958" alt="6로그인화면" src="https://user-images.githubusercontent.com/92250627/150133138-f778ca1e-3d09-49a3-aebc-e6170535f75a.PNG">
<br>
 7. 로그인 정보를 잘 못 입력하면 경고창이 표시됩니다.
<br>
<img width="959" alt="7로그인경고창" src="https://user-images.githubusercontent.com/92250627/150133141-aba3fccd-0f43-4efc-a29a-825da8ecb8d7.PNG">
<br>
 8. 로그인을 하고 나면 웰컴 페이지가 바뀝니다.
<br>
<img width="959" alt="8로그인후웰컴페이지" src="https://user-images.githubusercontent.com/92250627/150133144-ec4f83c9-c181-4af9-8560-4227eb5602e9.PNG"> 
<br>
 9. 회원정보 상세보기 화면을 누르면 비밀번호 확인창이 표시됩니다.
<br>
<img width="956" alt="9메뉴회원정보비밀번호확인" src="https://user-images.githubusercontent.com/92250627/150133149-031c2fce-8619-4053-8c26-18c7881112ab.PNG">
<br>
 10. 비밀번호를 알맞게 입력하면 회원정보 상세보기가 가능합니다.
<br>
<img width="947" alt="10회원정보상세보기" src="https://user-images.githubusercontent.com/92250627/150133151-903afd94-136f-4791-aefc-e7568839628f.PNG">
<br>
 11. 회원정보 수정을 클릭하여 회원정보를 수정할 수 있습니다.
<br>
<img width="949" alt="11회원정보수정클릭" src="https://user-images.githubusercontent.com/92250627/150133388-3b2aa4b2-7036-4bc6-8599-223e05d4acda.PNG">
<br>
 12. 회원정보 수정 후 확인을 클릭하면 아래와 같은 결과 페이지를 얻을 수 있습니다.
<br>
<img width="956" alt="12회원정보수정후결과페이지" src="https://user-images.githubusercontent.com/92250627/150133154-be7ab676-4341-4907-a0a5-91aa0078aa9c.PNG">
<br>
 13. 회원정보 삭제를 클릭하면 아래와 같은 결과 페이지를 얻을 수 있습니다.
<br>
<img width="951" alt="13회원정보삭제" src="https://user-images.githubusercontent.com/92250627/150133099-27f5ed1c-80a9-4848-bdfa-8ff7d60199dc.PNG">
<br>
 14. 게시판으로 이동하겠습니다.
<br>
<img width="950" alt="15게시판화면" src="https://user-images.githubusercontent.com/92250627/150133107-672e4b0d-318b-4888-b9a1-daec00c37a73.PNG">
<br>
 15. 로그인을 하지 않으면 '글쓰기' 버튼이 출력되지 않습니다.
<br>
<img width="950" alt="16게시판화면(비로그인)" src="https://user-images.githubusercontent.com/92250627/150133109-4de3cf03-1b60-4605-a049-c879d68a1869.PNG">
<br>
 16. 글 작성 화면입니다.
<br>
<img width="957" alt="17글작성화면" src="https://user-images.githubusercontent.com/92250627/150133114-ce4463d3-887a-43d1-8b93-dcab7f8d10ef.PNG">
<br>
 17. 글을 작성하면 아래와 같이 게시글 목록이 업데이트 됩니다.
<br>
<img width="952" alt="19게시글추가" src="https://user-images.githubusercontent.com/92250627/150133115-5016cc1e-814c-47df-b876-dc2083307c65.PNG">
<br>
 18. 게시글 상세보기 화면입니다.
<br>
<img width="957" alt="22게시글상세보기화면" src="https://user-images.githubusercontent.com/92250627/150133123-b22b5e42-b262-42c7-a89f-ea7ae52d72c4.PNG">
<br>
 19. 게시글 수정을 누르고 첨부파일을 추가해보겠습니다.
<br>
<img width="959" alt="20게시글수정" src="https://user-images.githubusercontent.com/92250627/150133118-3b59b00a-fb90-48e1-a1e1-0e0703b665bb.PNG">
<br>
<img width="956" alt="21첨부파일추가" src="https://user-images.githubusercontent.com/92250627/150133119-868b6dbb-1e01-421c-b66c-3854ab02e44c.PNG">
<br>
 20. 게시글 상세보기를 하여 추가한 첨부파일을 다운받을 수 있습니다.
<br>
<img width="956" alt="22첨부파일다운로드" src="https://user-images.githubusercontent.com/92250627/150133125-61ffa872-28a2-455b-a40e-9010571ee387.PNG">
<br>
 21. 게시글을 삭제를 누르면 게시글 삭제 확인창이 출력됩니다.
<br>
<img width="959" alt="24게시글삭제확인창" src="https://user-images.githubusercontent.com/92250627/150133126-42b0d1e0-ec99-46f0-9550-4064d7885456.PNG">
<br>
 22. 확인을 누르면 아래와 같이 게시판 목록에서 해당 글이 삭제된 것을 볼 수 있습니다.
<br>
<img width="949" alt="25게시글삭제확인" src="https://user-images.githubusercontent.com/92250627/150133128-ff7c2690-45c1-4870-8046-75898fff8dc4.PNG">

## 🛠자세한 설명
게시판 구현에 대한 자세한 설명은 블로그에 자세하게 정리해뒀습니다.
해당 웹사이트가 어떻게 동작하는지 이해하고 싶은 분들은
블로그 링크를 통해 블로그에서 내용을 확인해주세요!
[***블로그 이동하기***](https://determination.tistory.com/entry/JSP-%EA%B2%8C%EC%8B%9C%ED%8C%90-Model-2-JSPServlet-%EA%B2%8C%EC%8B%9C%ED%8C%90-%EB%A7%8C%EB%93%A4%EA%B8%B010-%EC%B5%9C%EC%A2%85)

## 🛠작성자

👩‍💻 김웅섭
 - BLOG : [Determination](https://determination.tistory.com/)
 - Email : ungseopkim@naver.com
