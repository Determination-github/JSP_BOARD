package jsp.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;

//회원정보 삭제 담당 Action 클래스
public class MemberLogoutAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		//세션에 담긴 아이디값 삭제
		request.getSession().removeAttribute("memberID");
		
		//메인화면으로 이동
		forward.setRedirect(true);
		forward.setPath("main.do");
		
		return forward;
	}
}