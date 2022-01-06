<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>Insert title here</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
 <style>
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
	#loginBtn{
	  text-decoration: underline;
	  color: #0064FF;
	}
	#loginBtn:hover{
	  cursor: pointer;
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
               location.href="LoginForm.do";
           }
       }
   </script>
</head>
 <body>
	<section class="py-4">
	  <div class="container">
	    <div class="row d-flex align-items-center justify-content-center">
	      <div style="max-width:420px;">
	        <form action="#" class="bg-white border py-4 px-5" method="get">
	          <div class="text-center mb-3">
	            <i class="fab fa-bootstrap fa-5x text-secondary mb-2"></i>
	            <p class="text-muted fw-bold">
	    			<img class="mb-4" src="${pageContext.request.contextPath}/docs/5.1/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
	            </p>
	          </div>
	         <!--  <div class="mb-3">
	            <a class="btn btn-primary d-block bg-gradient" href="#"><i class="fab fa-facebook"></i> Log in with facebook</a>
	            <p class="my-3 text-center or">
	              OR
	            </p>
	          </div> -->
	          <div class="form-floating mb-3">
	            <input class="form-control" name="email" placeholder="Email" required="" type="email" /><label>이메일</label>
	          </div>
	          <div class="form-floating mb-3">
	            <input class="form-control" name="fullname" placeholder="Full Name" required="" type="text" /><label>이름</label>
	          </div>
	          <div class="form-floating mb-3">
	            <input class="form-control" name="username" placeholder="Username" required="" type="text" /><label>아이디</label>
	          </div>
	          <div class="form-floating mb-3">
	            <input class="form-control" name="password" placeholder="Password" required="" type="password" /><label>비밀번호</label>
	          </div>
	          <div class="mb-2">
	            <button class="btn btn-primary fw-bold w-100 bg-gradient" href="#" type="submit">회원 가입</button>
	          </div>
	          <div class="small text-center">
	          </div>
	        </form>
	        <div class="bg-white py-4 px-5 text-center border mt-4">
	       	  <c:if test="${sessionScope.sessionID==null}">
	         	 <p class="m-0">
	            	계정이 있으신가요 ? <a id="loginBtn" onclick="changeView(1)">로그인하러 가기</a>
	       	     </p>
       	      </c:if>
	        </div>
	      </div>
	    </div>
	  </div>
	</section>
	<script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
 </body>
</html>