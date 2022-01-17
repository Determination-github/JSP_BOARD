package jsp.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;

//Action 클래스를 구현한다.
public class MemberFormChangeAction implements Action{
	
	//contentPage = 파라미터값
	//나중에 main.jsp에서 contentPage의 값을 가져와 화면을 구성한다.
	private String form = "main.jsp?contentPage=views/member/";
	private String path;
	
	public void setCommand(String command) {
		int idx = command.indexOf("."); //ex) LoginForm.do에서 .의 인덱스를 가져온다.
		path = command.substring(0, idx)+".jsp"; // ex) 가져온 index를 이용해 LoginForm.jsp와 같이 만든다.
		System.out.println(path);
	}

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		if(path.equals("main.jsp")) { //가져온 경로가 main.jsp와 같으면
			forward.setPath(path); //그대로 main.jsp를 경로로 설정한다.
			System.out.println(path);
		} else { //가져온 경로가 main.jsp와 다르면
			forward.setPath(form+path); // ex) 'main.jsp?contentPage=view/member/LoginForm.jsp'와 같이 경로를 설정한다.
		}
		
		return forward;
	}
}