package jsp.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.member.model.members.MemberBean;
import jsp.member.model.members.MemberDAO;

public class MemberModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		MemberDAO mDAO = MemberDAO.getInstance();
		
		String id = session.getAttribute("memberID").toString();
		
		MemberBean member = new MemberBean();
		member.setMemberID(id);
		member.setMemberPWD(request.getParameter("memberPWD"));
		member.setMemberEmail(request.getParameter("memberEmail"));
		member.setMemberName(request.getParameter("memberName"));
		
		mDAO.updateMember(member);
		
		forward.setRedirect(true);
		forward.setPath("ResultForm.do");
		
		request.getSession().setAttribute("msg", "1");
		
		return forward;
	}
	
}
