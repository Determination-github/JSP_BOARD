package jsp.member.action;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.member.model.members.MemberDAO;

public class MemberLoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		
		String id = request.getParameter("memberID");
		String password = request.getParameter("memberPWD");
		
		
		MemberDAO mDAO = MemberDAO.getInstance();
		int check = mDAO.loginCheck(id, password);
		
		if(check == 0) {
			request.setAttribute("fail", "0");
			forward.setRedirect(false);
			forward.setPath("LoginForm.do");
			
			
		} else if (check == -1) {
			request.setAttribute("fail", "-1");
			forward.setRedirect(false);
			forward.setPath("LoginForm.do");
			
		} else if (check == 1) {
			session.setAttribute("memberID", id);
			session.setAttribute("memberPWD", password);
			forward.setRedirect(true);
			forward.setPath("main.do");
		}
		
		return forward;
	}
}