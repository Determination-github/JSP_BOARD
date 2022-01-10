package jsp.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.member.model.members.MemberBean;
import jsp.member.model.members.MemberDAO;

public class MemberJoinAction implements Action {
	
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		MemberDAO mDAO = MemberDAO.getInstance();
		
		//입력된 정보 자바빈으로 세팅하기
		MemberBean member = new MemberBean();
		member.setMemberID(request.getParameter("memberID"));
		member.setMemberPWD(request.getParameter("memberPWD"));
		member.setMemberName(request.getParameter("memberName"));
		member.setMemberEmail(request.getParameter("memberEmail"));
		
		//insert 실행
		mDAO.joinMember(member); 
		
		//회원가입 후 화면 전환
		forward.setRedirect(true);
		forward.setPath("ResultForm.do");
		
		request.getSession().setAttribute("msg", "0");
		
		return forward;
	}

}
