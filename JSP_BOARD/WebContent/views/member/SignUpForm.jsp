<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
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
        
       function changeSignUpView(value){
           
           if(value == "0") // 회원가입 버튼 클릭시 첫화면으로 이동
           {
               location.href="main.jsp";
           }
           else if(value == "1") // 로그인 버튼 클릭시 로그인 화면으로 이동
           {
               location.href="LoginForm.do";
           }
       }
       
       function signUpCheckAction() {
    	   
     	  /*  inputID = document.loginInfo.memberID.value;
     	   inputPWD = document.loginInfo.memberPWD.value; */
     	   let formName = document.signUpInfo;
     	   
     	   let inputEmail = formName.memberEmail.value;
     	   let inputName = formName.memberName.value;
       	   let inputID = formName.memberID.value;
    	   let inputPWD = formName.memberPWD.value;
     	   
     	   
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
    		   formName.memberID.focus();
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
	        <form action="MemberjoinAction.do" name="signUpInfo" class="bg-white border py-4 px-5" method="post" onsubmit="return signUpCheckAction()">
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
	            <input class="form-control" name="memberName" placeholder="Full Name" type="text" /><label>이름</label>
	          </div>
	          <div class="form-floating mb-3">
	            <input class="form-control" name="memberID" placeholder="Username" type="text" /><label>아이디</label>
	          </div>
	          <div class="form-floating mb-3">
	            <input class="form-control" name="memberPWD" placeholder="Password" type="password" /><label>비밀번호</label>
	          </div>
	          <div class="mb-2">
	            <button class="btn btn-primary fw-bold w-100 bg-gradient" type="submit">회원 가입</button>
	          </div>
	          <div class="small text-center">
	          </div>
	        </form>
	        <div class="bg-white py-4 px-5 text-center border mt-4">
	         	 <p class="m-0">
	            	계정이 있으신가요 ? <a id="loginButton" onclick="changeSignUpView(1)">로그인하러 가기</a>
	       	     </p>
	        </div>
	      </div>
	    </div>
	  </div>
	</section>
 </body>
</html>