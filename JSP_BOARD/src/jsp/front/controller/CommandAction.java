package jsp.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//매니저 클래스
//서블릿으로부터 명령어의 처리를 지시 받아 해당 명령에 대한 작업을 처리하고 작업 결과를 서블릿으로 리턴
//실제 작업 처리는 구현 클래스가 수행

public interface CommandAction {
	
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable;
	
}
