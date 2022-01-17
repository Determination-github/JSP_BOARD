package jsp.board.action;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import jsp.board.model.BoardDAO;
import jsp.common.action.Action;
import jsp.common.action.ActionForward;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		//파라미터로 전달받은 페이지 값 저장
		int num = Integer.parseInt(request.getParameter("num"));
		
		//파일 가져오기
		BoardDAO bDAO = BoardDAO.getInstance();
		String file = bDAO.getFile(num);
		//파일 삭제하기
		boolean result = bDAO.deleteBoard(num);
		
		//파일이 존재한다면
		if(file != null) {
			//절대 경로 가져오기
			String folderPath = request.getServletContext().getRealPath("UploadFolder");
			
			String filePath = folderPath + "/" +file;
			
			//폴더+파일 네임으로 파일 찾기
			File fileName = new File(filePath);
			//파일이 존재한다면 파일 삭제
			if(fileName.exists()) {
				fileName.delete();
			}
		}
		
		//삭제가 진행되었다면
		if(result) {
			//redirect
			forward.setRedirect(true);
			forward.setPath("BoardListAction.bo");
		} else {
			return null;
		}
		
		return forward;
	}

}
