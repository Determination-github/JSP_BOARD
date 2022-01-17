package jsp.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.member.model.MemberBean;
import jsp.member.model.MemberDAO;

public class MemberModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession(); //session 객체 생성
		
		MemberDAO mDAO = MemberDAO.getInstance();
		
		String id = session.getAttribute("memberID").toString(); //memberID 값 가져오기	
		
		MemberBean member = new MemberBean();
		
		//MemberBean 객체에 업데이트 값 세팅
		member.setMemberID(id);
		member.setMemberPWD(request.getParameter("memberPWD"));
		member.setMemberEmail(request.getParameter("memberEmail"));
		member.setMemberName(request.getParameter("memberName"));
		
		mDAO.updateMember(member);
		
		forward.setRedirect(true);
		forward.setPath("ResultForm.do");
		
		session.setAttribute("msg", "1");

		return forward;
	}
}
