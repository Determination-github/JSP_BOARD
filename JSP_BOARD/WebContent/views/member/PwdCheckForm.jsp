<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
	<head>
		<title>회원정보 상세보기</title>
		<style>
		.container {
		 padding-top: 30px;
		 text-align: center;
		 width: 300px;
		 margin-top: 100px;
		}
		
		.btn{
		 margin-top: 20px;
		}
		
		.text{
		 -webkit-text-security: disc;
		}

		@media (min-width: 768px) {
    	.bd-placeholder-img-lg {
		    font-size: 3.5rem;
    	  }
		}
		</style>
		<script type="text/javascript">
			function pwdCheckAction() {
				let formPWD = document.pwdInfo;
						    	   
				let inputPWD = formPWD.memberPWD.value;
		    	   
		    	   if(inputPWD == "") { //비밀번호가 없으면
		    		   alert("비밀번호를 입력하세요");
		    		   formPWD.memberPWD.focus();
		    		   return false;
		    	   }
		    	   if(inputPWD != "") { //비밀번호가 입력됐으면
		    		   if(inputPWD == "${sessionScope.memberPWD}"){
		    			   location.href="MeberDetailAction.do";
		    		   } else {
		    			   alert("비밀번호가 틀렸습니다.");
			    		   formPWD.memberPWD.focus();
			    		   return false;
		    		   }
		    	   }
			}
		</script>
	</head>
	<body class="bg-light">
		<form name="pwdInfo" method="post" action="MemberDetailAction.do" onsubmit="return pwdCheckAction()">
			<div class="container">
				<label for="lastName" class="form-label">비밀번호를 다시 한번 입력해주세요.</label>
				<input type="password" class="form-control" id="pwd" name="memberPWD">
					<div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
	   				<button type="submit" class="btn btn-primary btn-lg px-3 gap-2">회원정보 상세보기</button>
			</div>
		</form>
</body>
</html>
