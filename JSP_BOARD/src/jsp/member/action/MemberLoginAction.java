package jsp.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.member.model.MemberDAO;

//로그인 처리를 담당하는 Action 클래스
public class MemberLoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		//ActionForward 객체 생성
		HttpSession session = request.getSession();
		//HttpSession 객체 생성
		
		//입력한 아이디와 비밀번호 가져오기
		String id = request.getParameter("memberID");
		String password = request.getParameter("memberPWD");
		
		//DB에 접근해서 아이디와 비밀번호 확인하기
		MemberDAO mDAO = MemberDAO.getInstance();
		int check = mDAO.loginCheck(id, password);
		
		//반환값이 0이면
		if(check == 0) {
			//fail 설정
			request.setAttribute("fail", "0");
			forward.setRedirect(false);
			forward.setPath("LoginForm.do");
			
		//반환값이 -1이면	
		} else if (check == -1) {
			//fail 설정
			request.setAttribute("fail", "-1");
			forward.setRedirect(false);
			forward.setPath("LoginForm.do");
		
		//반환값이 1이면(로그인 성공)
		} else if (check == 1) {
			//세션에 아이디와 비밀번호 저장
			session.setAttribute("memberID", id);
			session.setAttribute("memberPWD", password);
			forward.setRedirect(true);
			forward.setPath("main.do");
		}
		
		return forward;
	}
}