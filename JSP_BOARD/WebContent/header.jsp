<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
	<style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      a {
      	cursor: pointer;
      }
    </style>
    
    <script type="text/javascript">
		function changeView(value){
		    
			if(value == "0") // HOME 버튼 클릭시 첫화면으로 이동
			{
			    location.href="main.do";
			}
			else if(value == "1") // 로그인 버튼 클릭시 로그인 화면으로 이동
			{
			    location.href="LoginForm.do";
			}
			else if(value == "2") // 회원가입 버튼 클릭시 회원가입 화면으로 이동
			{
			    location.href="SignUpForm.do";
			}
			else if(value == "3") // 회원정보 버튼 클릭시 회원정보 상세보기 화면으로 이동
			{
			    location.href="PwdCheckForm.do";
			}
			else if(value == "4") // 로그아웃 버튼 클릭시 로그아웃 처리
			{
			    location.href="MemberLogoutAction.do";
			}
			else if(value == "5") // 보드 버튼 클릭시 보드 게시판 화면으로 이동
			{
			    location.href="BoardListAction.bo";
			}
		}
    </script>

    <link href="${pageContext.request.contextPath}/css/navbar-top-fixed.css" rel="stylesheet">
  	</head>
  	<body>
		<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
			<div class="container-fluid">
				<a class="navbar-brand" onclick="changeView(0)">JSP 웹페이지</a>
				<button class="navbar-toggler"  type="button" data-bs-toggle="collapse" 
				data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" 
				aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarCollapse">
					<ul class="navbar-nav me-auto mb-2 mb-md-0">
					<li class="nav-item">
					<a class="nav-link active" aria-current="page" href="main.do">Home</a>
					</li>
					<li class="nav-item">
					<a class="nav-link" onclick="changeView(5)">Board</a>
					</li>
					</ul>
					<div class="dropdown">
						<button class="btn btn-secondary dropdown-toggle" type="button" 
						id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
					 		Menu
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
							<!-- // 로그인 안되었을 경우 - 로그인, 회원가입 버튼을 보여준다. -->
							<c:if test="${sessionScope.memberID==null}">
								<li><a id="loginBtn" class="dropdown-item" onclick="changeView(1)">로그인</a></li>
								<li><a id="joinBtn" class="dropdown-item" onclick="changeView(2)">회원가입</a></li>
							</c:if>
							<!-- // 로그인 되었을 경우 - 회원정보, 로그아웃 버튼을 보여준다. -->
							<c:if test="${sessionScope.memberID!=null}">
								<li><a id="loginBtn" class="dropdown-item" onclick="changeView(3)">회원정보</a></li>
								<li><a id="loginBtn" class="dropdown-item" onclick="changeView(4)">로그아웃</a></li>
							</c:if>
						</ul>	
					</div>
				</div>
			</div>
		</nav>
	</body>
</html>