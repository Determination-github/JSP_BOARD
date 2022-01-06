package jsp.front.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.common.action.Action;
import jsp.common.action.ActionForward;
import jsp.member.action.MemberFormChangeAction;

public class MemberController extends HttpServlet {
	
	private HashMap<String, Action> commandMap;
	
	//명령어와 처리클래스가 매핑된 properties 파일을 읽어 Map객체에 저장
	public void init(ServletConfig config) throws ServletException { //서블렛 초기화
		super.init(config);
		String props = config.getInitParameter("propertyConfig");
		Properties properties = new Properties(); //명령어와 처리클래스의 매핑 정보를 저장할 프로퍼티 객체
		FileInputStream fis = null;
		commandMap = new HashMap<String, Action>();
		try {
			fis = new FileInputStream(props); //command.properties 파일을 fis에 넣기
			properties.load(fis); //command.properties를 properties 객체에 저장하기
		} catch (IOException e) {
			e.printStackTrace(); //오류 로그 처리 나중에
		} finally {
			if(fis!=null) { //fis에 값이 있다면
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		Iterator iterator = properties.keySet().iterator(); //프로퍼티 객체의 키 값을 iterator 객체에 저장
		while(iterator.hasNext()) {
			String key = (String)iterator.next(); //프로퍼티 key 값
			String value = properties.getProperty(key); //프로터피 value 값
			System.out.println(key); ///LoginForm.do
			System.out.println(value); //jsp.member.action.MemberFormChangeAction
			try {
				Class commandClass = Class.forName(value); //해당 문자열을 클래스로 만들기, jsp.member.action.MemberFormChangeAction
				Action actionInstance = (Action)commandClass.getDeclaredConstructor().newInstance();
				System.out.println(actionInstance);
				
				if(value.equals("jsp.member.action.MemberFormChangeAction")) {
					MemberFormChangeAction changeAction = (MemberFormChangeAction) actionInstance;
					changeAction.setCommand(key);
				}
				
				commandMap.put(key, actionInstance); //map에 키값과 value값 객체 저장
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//post나 get요청이 들어오면 실행되는 메소드
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String URI = null;
		ActionForward forward = null;
		Action action = null;
		
		try {
			URI = request.getRequestURI(); 
			System.out.println(URI);// /JSP_BOARD/LoginForm.do
			String command = URI.substring(URI.lastIndexOf("/")+1);
			System.out.println(command);// /LoginForm.do
			action = commandMap.get(command); //command = KEY값
			System.out.println(action);
			if(action == null) {
				System.out.println("not found : "+command);
				return;
			}
			
			forward = action.execute(request, response);
			System.out.println(forward);
			
			if(forward != null) {
				if(forward.isRedirect()) {
					response.sendRedirect(forward.getPath());
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
					dispatcher.forward(request, response);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	
}
