package jsp.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.board.model.BoardBean;
import jsp.board.model.BoardDAO;
import jsp.common.action.Action;
import jsp.common.action.ActionForward;

public class BoardDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		int num =  Integer.parseInt(request.getParameter("num"));
		String page = request.getParameter("page");
		
		BoardDAO bDAO = BoardDAO.getInstance();
		BoardBean board = bDAO.getDetail(num);
		boolean result = bDAO.viewCount(num);
		
		request.setAttribute("board", board);
		request.setAttribute("page", page);
		
		if(result) {
			forward.setRedirect(false);
			forward.setPath("BoardDetailForm.bo");
		}
		
		return forward;
	}
	
}
