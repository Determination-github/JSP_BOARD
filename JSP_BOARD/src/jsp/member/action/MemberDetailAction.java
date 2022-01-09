package jsp.member.action;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.member.model.members.MemberBean;
import jsp.member.model.members.MemberDAO;

public class MemberDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		MemberDAO mDAO = MemberDAO.getInstance();
		
		String id = (String) session.getAttribute("memberID");
		
		MemberBean member = mDAO.inquireData(id);
		request.setAttribute("memberInfo", member);
		
		forward.setRedirect(false);
		forward.setPath("MemberDetail.do");
		
		return forward;
	}
	

}
