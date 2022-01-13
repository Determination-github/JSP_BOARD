<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정페이지</title>
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
	</style>
	<script type="text/javascript">
		function checkValue() {
			const form = document.boardForm;
			const subject = form.boardSubject.value;
			const content = form.boardContent.value;
			
			if(!subject) {
				alert("제목을 입력해주세요.");
				return false;
			} else if(!content) {
				alert("내용을 입력해주세요.");
				return false;
			}
		}
		function goToList() {
			location.href = "BoardListAction.bo";
		}
	</script>
</head>
<body>
	<div class="container">
		<form method="post" action="BoardUpdateAction.bo?page=${page}" name="boardForm" enctype="multipart/form-data" onsubmit="return checkValue()">
			<input type="hidden" name="boardID" value="${sessionScope.memberID}">
			<input type="hidden" name="boardFile" value="${board.boardFile}">
			<input type="hidden" name="boardNum" value="${board.boardNum}">
			<div class="input-group">
	  			<span class="input-group-text" id="inputGroup-sizing-default">제목</span>
	  			<input name="boardSubject" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" value="${board.boardSubject}"/>
			</div>
			<div class="input-group mb-3">
				<input name="newBoardFile" type="file" class="form-control" id="inputGroupFile02">
				<label class="input-group-text" for="inputGroupFile02">Upload</label>
			</div>
			<div class="input-group">
	  			<span class="input-group-text">내용</span>
	  			<textarea name="boardContent" class="form-control" aria-label="With textarea" rows="20">${board.boardContent}</textarea>
			</div>
	
			<div id="btn" class="d-grid gap-2 d-sm-flex justify-content-sm-center">
				<input type="submit" class="btn btn-primary btn-sm px-3 gap-3" value="등록"></button>
				<input type="button" class="btn btn-outline-secondary btn-sm px-3" value="취소" onclick="goToList()"></input>
			</div>
		</form>
	</div>
</body>
</html>