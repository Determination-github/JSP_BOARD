package jsp.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.member.model.MemberDAO;

//회원정보 삭제 담당 Action 클래스
public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		
		MemberDAO mDAO = MemberDAO.getInstance();
		
		String id = session.getAttribute("memberID").toString();
		
		mDAO.deleteMember(id);
		
		//세션에 담긴 아이디값 삭제
		session.removeAttribute("memberID");
		
		forward.setRedirect(true);
		forward.setPath("ResultForm.do");
		
		session.setAttribute("msg", "2");
		
		return forward;
	}
}
