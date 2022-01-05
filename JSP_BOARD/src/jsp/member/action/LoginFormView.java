package jsp.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.front.controller.CommandAction;

public class LoginFormView implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "views/members/loginForm.jsp";
	}
	

	
	

}
