<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
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
          font-size: 3.5rem;
        }
      }
    </style>
    <script type="text/javascript">
       function changeView(value){
           
           if(value == "0") // 회원가입 버튼 클릭시 첫화면으로 이동
           {
               location.href="main.jsp";
           }
           else if(value == "1") // 로그인 버튼 클릭시 로그인 화면으로 이동
           {
               location.href="SignUpForm.do";
           }
       }
       
       function loginAction() {
    	   
    	   inputID = document.loginInfo.floatingInput;
    	   if(!inputID) {
    		   alert("아이디를 입력하세요");
    		   inputID.id.focus();
    		   return false;
    	   }
    	   inputPWD = document.loginInfo.floatingPassword;
    	   if(!inputPWD) {
    		   alert("아이디를 입력하세요");
    		   inputPWD.id.focus();
    		   return false;
    	   }
       }
    </script>
    <link href = "${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">
    <title>Hello, world!</title>
  </head>
  <body class="text-center">
	<main class="form-signin">
	  <form name="loginInfo" method="post" action="MemberLoginAction.do" onsubmit="return loginAction()">	  
	    <img class="mb-4" src="${pageContext.request.contextPath}/docs/5.1/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
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
	            	<a id="SignUpBtn" onclick="changeView(1)" >회원가입하러 가기</a>
	       	     </p>
       	      </c:if>
	        </div>
	    <p class="mt-5 mb-3 text-muted">&copy; Determination</p>
	  </form>
	</main>
	<script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    
  </body>
</html>