<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% session = request.getSession(true); %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
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
	    </style>
    <!-- Custom styles for this template -->
    	<script type="text/javascript">
    		function changeFirstView(value) {
    			if(value == 0) {
    				location.href = "SignUpForm.do";
    			} else if(value == 1) {
    				location.href = "LoginForm.do";
    			} else if(value == 2) {
    				location.href = ""; //아직 미구현
    			} else if(value == 3) {
    				const link = "https://determination.tistory.com/";
    				window.open(link);

    			}
    		}
    	
    	</script>
  </head>
  <body>
    
	<main>
		<h1 class="visually-hidden">Heroes examples</h1>
		<!-- 세션에 id 값이 널이면?(로그인이 안되어 있으면) -->
		<c:if test="${sessionScope.memberID==null}">
			<div class="px-4 py-5 my-5 text-center">
	    		<img class="d-block mx-auto mb-4" src="${pageContext.request.contextPath}/docs/5.1/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
	    		<h1 class="display-5 fw-bold">방문을 환영합니다!</h1>
	    			<div class="col-lg-6 mx-auto">
	      				<p class="lead mb-4">게시판에 글을 남기고 댓글을 남겨주세요!
	      				<br> 게시판에 글을 남기기 위해서는 회원가입과 로그인이 필요합니다.
	      				</p>
	      				<div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
	        				<button type="button" class="btn btn-primary btn-lg px-4 gap-3" onclick="changeFirstView(0)">회원가입 하러가기</button>
	        				<button type="button" class="btn btn-outline-secondary btn-lg px-4" onclick="changeFirstView(1)">로그인 하러가기</button>
	      				</div>
	    			</div>
	  			</div>
   		</c:if>   
   		<c:if test="${sessionScope.memberID!=null}">
			<div class="px-4 py-5 my-5 text-center">
	    		<img class="d-block mx-auto mb-4" src="${pageContext.request.contextPath}/docs/5.1/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
	    		<h1 class="display-5 fw-bold">${sessionScope.memberID}님 환영합니다!</h1>
	    			<div class="col-lg-6 mx-auto">
	      				<p class="lead mb-4">게시판에 글을 남기고 댓글을 남겨주세요!
	      				<br> 해당 게시판에 관한 내용은 블로그를 통해 확인할 수 있습니다.
	      				</p>
	      				<div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
	        				<button type="button" class="btn btn-primary btn-lg px-4 gap-3" onclick="changeFirstView(2)">게시판 바로가기</button>
	        				<button type="button" class="btn btn-outline-secondary btn-lg px-4" onclick="changeFirstView(3)">블로그 바로가기</button>
	      				</div>
	    			</div>
	  			</div>
   		</c:if>    
   </body>
</html>
