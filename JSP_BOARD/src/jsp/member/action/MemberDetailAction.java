package jsp.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.member.model.MemberBean;
import jsp.member.model.MemberDAO;

//회원정보 상세보기 구현 클래스
public class MemberDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HttpSession session = request.getSession();
		MemberDAO mDAO = MemberDAO.getInstance();
		
		String id = (String)session.getAttribute("memberID"); //세션에서 아이디 가져오기
		
		MemberBean member = mDAO.inquireData(id); //아이디를 파라미터로 해서 회원정보 모두 가져오기
		request.setAttribute("memberInfo", member); //회원정보를 전달

		forward.setRedirect(false);
		forward.setPath("MemberDetail.do"); //MemberDetail.do로 이동
		
		return forward;
	}
}
