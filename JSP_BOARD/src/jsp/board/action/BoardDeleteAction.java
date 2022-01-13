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
		BoardDAO bDAO = BoardDAO.getInstance();
		
		int num = Integer.parseInt(request.getParameter("num"));
		
		String file = bDAO.getFile(num);
		boolean result = bDAO.deleteBoard(num);
		
		if(file != null) {
			String folderPath = request.getServletContext().getRealPath("UploadFolder");
			
			String filePath = folderPath + "/" +file;
			
			File fileName = new File(filePath);
			if(fileName.exists()) {
				fileName.delete();
			}
		}
		
		if(result) {
			forward.setRedirect(true);
			forward.setPath("BoardListAction.bo");
		} else {
			return null;
		}
		
		return forward;
	}

}
