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
		
		//전달받은 num 파라미터 가져오기
		int num =  Integer.parseInt(request.getParameter("num"));
		//전달받은 page 파라미터 가져오기
		String page = request.getParameter("page");
		
		BoardDAO bDAO = BoardDAO.getInstance();
		//getDetail 메서드 실행
		BoardBean board = bDAO.getDetail(num);
		//조회수 증가를 위해 viewCount 메서드 실행
		boolean result = bDAO.viewCount(num);
		
		//request 객체에 BoardBean객체와 page 값 담기
		request.setAttribute("board", board);
		request.setAttribute("page", page);

		if(result) {
			forward.setRedirect(false);
			forward.setPath("BoardDetailForm.bo");
		}
		
		return forward;
	}
	
}
