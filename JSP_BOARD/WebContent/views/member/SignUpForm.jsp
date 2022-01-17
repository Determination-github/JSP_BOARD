<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>회원가입 페이지</title>
		<style>
			.py-4{
				margin-top: 50px;
			}
			.or{
				position: relative;
			}
			.or:before{
				content: '';
				height: 1px;
				background: linear-gradient(to right,silver,silver,rgba(255,255,255,0),rgba(255,255,255,0),silver,silver);
				position: absolute;
				left: 0;
				top: 50%;
				width: 100%;
				z-index: 0;
			}
			#loginButton{
				text-decoration: underline;
				color: #0064FF;
			}  
			#loginBtn:hover{
				cursor: pointer;
			}
		</style>
	 	<script type="text/javascript">
	 	//화면전환
		function changeSignUpView(){
			// 로그인 버튼 클릭시 로그인 화면으로 이동
			{
				location.href="LoginForm.do";
			}
		}
	    
		//회원가입 폼에 입력값들이 입력됐는지 올바른 값이 입력됐는지 검사	 	
		function signUpCheckAction() {
			//form 태그 가져오기
			let formName = document.signUpInfo;
			
			//form태그의  name값으로 value 가져오기
			let inputEmail = formName.memberEmail.value;
			let inputName = formName.memberName.value;
			let inputID = formName.memberID.value;
			let inputPWD = formName.memberPWD.value;
			let pwdCheck = formName.memberPWDCheck.value;
	  
	  
			if(inputEmail == "") { //이메일이 없으면
				alert("이메일을 입력하세요");
				formName.memberEmail.focus();
				return false;
			}
			if(inputName == "") { //이름이 없으면
				alert("이름을 입력하세요");
				formName.memberName.focus();
				return false;
			}
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
			if(inputPWD != pwdCheck) { //비밀번호가 동일하지 않으면
				alert("비밀번호가 동일하지 않습니다.");
				formName.memberPWDCheck.focus();
				return false;
			}
		}
	</script>	
	</head>
	<body class="text-center">
		<section class="py-4">
			<div class="container">
				<div class="row d-flex align-items-center justify-content-center">
					<div style="max-width:420px;">
						<form action="MemberSignUpAction.do" name="signUpInfo" class="bg-white border py-4 px-5" method="post" onsubmit="return signUpCheckAction()">
							<div class="text-center mb-3">
								<i class="fab fa-bootstrap fa-5x text-secondary mb-2"></i>
								<p class="text-muted fw-bold">
								<img class="mb-4" src="${pageContext.request.contextPath}/docs/5.1/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
								</p>
							</div>
							<div class="form-floating mb-3">
								<input class="form-control" name="memberEmail" placeholder="Email" type="email" /><label>이메일</label>
							</div>
							<div class="form-floating mb-3">
								<input class="form-control" name="memberName" placeholder="UserName" type="text" /><label>이름</label>
							</div>
							<div class="form-floating mb-3">
								<input class="form-control" name="memberID" placeholder="ID" type="text" /><label>아이디</label>
							</div>
							<div class="mb-2">
								<button class="btn btn-primary fw-bold w-100 bg-gradient" type="submit" onclick="idCheck()">아이디 중복 확인</button>
							</div>
							<div class="form-floating mb-3">
								<input class="form-control" name="memberPWD" placeholder="Password" type="password" /><label>비밀번호</label>
							</div>
							<div class="form-floating mb-3">
								<input class="form-control" name="memberPWDCheck" placeholder="Password" type="password" /><label>비밀번호 확인</label>
							</div>
							<div class="mb-2">
								<button class="btn btn-primary fw-bold w-100 bg-gradient" type="submit">회원 가입</button>
							</div>
						</form>
						<div class="bg-white py-4 px-5 text-center border mt-4">
							<p class="m-0">
							계정이 있으신가요 ? <a id="loginButton" onclick="changeSignUpView()">로그인하러 가기</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</section>
	</body>
</html>