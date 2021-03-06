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
			#SignUpBtn{
				text-decoration: underline;
				color: #0064FF;
			}
			#SignUpBtn:hover{
				cursor: pointer;
			}
			
			@media (min-width: 768px) {
				.bd-placeholder-img-lg {
				font-si	ze: 3.5rem;
				}
			}
		</style>	
	
		<script type="text/javascript">
			function changeLoginView(value){
				// 회원가입 버튼 클릭시 회원가입 화면으로 이동
				location.href="SignUpForm.do";
			}
		
			function loginCheckAction() {
				let formName = document.loginInfo;
				
				let inputID = formName.memberID.value;
				let inputPWD = formName.memberPWD.value;
				
				if(inputID == "") { //아이디가 없으면
					alert("아이디를 입력하세요");
					formName.memberID.focus();
					return false;
				}
				if(inputPWD == "") { //비밀번호가 없으면
					alert("비밀번호를 입력하세요");
					formName.memberPWD.focus();
					return false;
				}
			}
		</script>
		<link href = "${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">
	<title>로그인 페이지</title>
	</head>
	<body class="text-center">
		<main class="form-signin">
			<!-- post방식 -->
			<form name="loginInfo" method="post" action="MemberLoginAction.do" onsubmit="return loginCheckAction()">	  
				<img class="mb-4" src="${pageContext.request.contextPath}/docs/5.1/assets/brand/bootstrap-logo.svg" width="72" height="57">
				<h1 class="h3 mb-3 fw-normal">로그인</h1>
				
				<div class="form-floating">
					<input type="text" class="form-control" id="floatingInput" name="memberID" placeholder="ID">
					<label for="floatingInput">아이디를 입력해주세요.</label>
				</div>
				<div class="form-floating">
					<input type="password" class="form-control" id="floatingPassword" name="memberPWD" placeholder="Password">
					<label for="floatingPassword">비밀번호를 입력해주세요.</label>
				</div>
				<input class="w-100 btn btn-lg btn-primary" type="submit" value="로그인"></input>
				<div class="py-4 px-5 text-center border mt-4">
					<c:if test="${sessionScope.sessionID==null}">
						<p class="m-0">
							계정이 없으신가요 ? <br>
							<a id="SignUpBtn" onclick="changeLoginView()" >회원가입하러 가기</a>
						</p>
					</c:if>
				</div>
				<p class="mt-5 mb-3 text-muted">&copy; Determination</p>
			</form>
		</main>
		<c:set var="failMessage" value="${requestScope.fail}"/>
			<c:if test="${failMessage!=null}">	
				<c:choose>
					<c:when test="${failMessage=='0'}">
						<script type="text/javascript">
						alert("사용자 정보가 일치하지 않습니다.");
						</script>
					</c:when>
					<c:otherwise>
						<script type="text/javascript">
						alert("사용자 정보가 일치하지 않습니다.");
						</script>
					</c:otherwise>
				</c:choose>
			</c:if>
	</body>
</html>