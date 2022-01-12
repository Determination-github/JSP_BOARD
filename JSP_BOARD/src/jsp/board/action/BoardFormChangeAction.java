package jsp.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;

public class BoardFormChangeAction implements Action{
	
	private String form = "main.jsp?contentPage=views/board/";
	private String path;
	
	public void setCommand(String command) {
		int idx = command.indexOf(".");
		path = command.substring(0, idx)+".jsp";
		System.out.println(path);
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		if(path.equals("main.jsp")) {
			forward.setPath(path);
			System.out.println(path);
		} else {
			forward.setPath(form+path);
		}
		
		return forward;
	}
}