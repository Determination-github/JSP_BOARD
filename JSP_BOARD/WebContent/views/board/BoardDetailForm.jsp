<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.boardSubject}</title>
	<style type="text/css">
		.container{
			margin-top: 100px;
		}
		.input-group{
			margin-bottom: 5px;
		}
		#btn{
			margin-top: 20px;
		}
		#subject, #content{
			background-color: white;
		}
	</style>
	<script type="text/javascript">
		function detailAction(value) {
			if(value == 0){
				location.href = "BoardUpdateFormAction.bo?num=${board.boardNum}&page=${page}";
			} else if(value == 1) {
				if(confirm("정말로 삭제하시겠습니까?")){
					location.href="BoardDeleteAction.bo?num=${board.boardNum}";
					return true;
				} else {
					return false;
				}
			} else if(value == 2) {
				location.href = "BoardListAction.bo";
			}
		}
	</script>
</head>
<body>
	<div class="container">
		<input type="hidden" name="boardID" value="${sessionScope.memberID}">
		<div class="input-group">
  			<input id="subject" name="boardSubject" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" value="${board.boardSubject}" readonly/>
			<span class="input-group-text" id="basic-addon2">${board.boardDate}</span>			
		</div>
		<div class="input-group mb-3">
			<span type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="basic-addon2">
			<a href="FileDownloadAction.bo?file_name=${board.boardFile}">
					${board.boardFile}
			</a>
			</span>
			<label class="input-group-text" for="inputGroupFile02">첨부파일</label>
		</div>
		<div class="input-group">
  			<textarea id="content" name="boardContent" class="form-control" aria-label="With textarea" rows="20" readonly>${board.boardContent}</textarea>
		</div>
		
		<div id="btn" class="d-grid gap-2 d-sm-flex justify-content-sm-center">
			<c:if test="${sessionScope.memberID!=null}">
				<c:if test="${sessionScope.memberID == board.boardID}">
					<button type="button" class="btn btn-primary btn-sm px-3 gap-3" onclick="detailAction(0)">수정</button>
					<button type="button" class="btn btn-outline-secondary btn-sm px-3" onclick="detailAction(1)">삭제</button>
				</c:if>
			</c:if>
			<button type="button" class="btn btn-outline-secondary btn-sm px-3" onclick="detailAction(2)">목록</button>
		</div>
	</div>
</body>
</html>