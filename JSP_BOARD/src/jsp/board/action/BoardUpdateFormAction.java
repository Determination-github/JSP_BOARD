package jsp.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.board.model.BoardBean;
import jsp.board.model.BoardDAO;
import jsp.common.action.Action;
import jsp.common.action.ActionForward;

public class BoardUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		String page = request.getParameter("page");
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardDAO bDAO = BoardDAO.getInstance();
		BoardBean board = bDAO.getDetail(num);
		
		request.setAttribute("board", board);
		request.setAttribute("page", page);
		
		forward.setRedirect(false);
		forward.setPath("BoardUpdateForm.bo");
		
		return forward;
	}

}
