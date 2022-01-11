<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jsp.member.model.members.MemberBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
	<head>
		<title>회원정보 상세보기</title>
		<style>
		.container {
		 padding-top: 30px;
		}
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
		</style>
		
		<script type="text/javascript">
			function changeDetailView() {
				location.href = "main.do";
			}
			
			function btnModify() {
				
				const pwd = document.getElementById('pwd');
				const username = document.getElementById('username');
				const email = document.getElementById('email');
				$(pwd).removeAttr('disabled');
				$(username).removeAttr('disabled');
				$(email).removeAttr('disabled');
			}
			
			function detailCheckAction() {
		    	   
		    	   let formName = document.detailInfo;
		    	   
		    	   let inputPWD = formName.memberPWD.value;
		    	   let inputEmail = formName.memberEmail.value;
		    	   let inputName = formName.memberName.value;
		    	   
		    	   
		    	   if(inputPWD == "") { //비밀번호가 없으면
		    		   alert("비밀번호를 입력하세요");
		    		   formName.memberPWD.focus();
		    		   return false;
		    	   }
		    	   else if(inputEmail == "") { //메일이 없으면
		    		   alert("메일을 입력하세요");
		    		   formName.memberEmail.focus();
		    		   return false;
		    	   }
		    	   else if(inputName == "") { //이름이 없으면
		    		   alert("이름을 입력하세요");
		    		   formName.memberName.focus();
		    		   return false;
		    	   }
		       }
			
			function btnDelete() {
				if(confirm("정말로 삭제하시겠습니까?")){
					location.href="MemberDeleteAction.do"
					return true;
				} else {
					return false;
				}
			}
		</script>

		<!-- Custom styles for this template -->
		<link href="${pageContext.request.contextPath}/form-validation.css" rel="stylesheet">
	</head>
	<body class="bg-light">
   		<c:set var="member" value="${requestScope.memberInfo}"/> <!-- request에 저장된 객체를 사용하기위해 requestScope 사용 -->
		<div class="container text-center">
			<main>
				<div class="py-5">
					<img class="d-block mx-auto mb-4" src="${pageContext.request.contextPath}/docs/5.1/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
					<h2>회원정보</h2>
					<p class="lead">
						회원정보를 확인해주세요!<br>
						회원정보를 수정하거나 삭제하고 싶으시면 아래 버튼을 눌러주세요.
					</p>
				</div>
				
				<div class="py-2">
  					<h4 class="mb-3">회원 상세정보</h4>
					<form class="needs-validation" name="detailInfo" method="post" action="MemberModifyAction.do" onsubmit="return detailCheckAction()">
						<div class="row g-3">
	      					<div class="col-sm-6">
	        				<label for="firstName" class="form-label">아이디</label>
	        				<input type="text" class="form-control" id="id" name="memberID" placeholder="ID" value="${member.memberID}" disabled>
	      					</div>
	      			
		      				<div class="col-sm-6">
			        		<label for="lastName" class="form-label">비밀번호</label>
			        		<input type="text" class="form-control" id="pwd" name="memberPWD" placeholder="Password" value="${member.memberPWD}" disabled>
		      				</div>
		      		
							<div class="col-12">
					  		<label for="username" class="form-label">이름</label>
					 		<div class="input-group has-validation">
						    <input type="text" class="form-control" id="username" name="memberName" placeholder="Username" value="${member.memberName}" disabled>
						  	</div>
							</div>
		
							<div class="col-12">
							  <label for="email" class="form-label">이메일</label>
							  <input type="email" class="form-control" id="email" name="memberEmail" placeholder="you@example.com" value="${member.memberEmail}" disabled>
							</div>
		
							<div class="col-12">
							  <label for="address" class="form-label" >가입일자</label>
							  <input type="text" class="form-control" id="date" placeholder="2022-01-01" value="${member.memberReg}" disabled>
							</div>
						</div>
						<hr class="my-4">
					    	<div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
		        				<button type="button" class="btn btn-primary btn-lg px-4 gap-3" onclick="changeDetailView()">메인화면으로 이동</button>
		        				<button type="button" id="buttonModify" class="btn btn-outline-secondary btn-lg px-4" onclick="btnModify()">회원정보 수정</button>
		        				<button type="button" id="buttonDelete" class="btn btn-outline-secondary btn-lg px-4" onclick="btnDelete()">회원정보 삭제(탈퇴)</button>
		        				<input type="submit" id="buttonDelete" class="btn btn-outline-secondary btn-lg px-4" value="확인"></button>
	      					</div>
						</div>
					</form>
			</main>

			<footer class="my-5 pt-5 text-muted text-center text-small">
			  <p class="mb-1">&copy; Determination</p>
			</footer>
		</div>
</body>
</html>
