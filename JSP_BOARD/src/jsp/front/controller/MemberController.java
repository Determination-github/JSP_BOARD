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

public class MemberController extends HttpServlet {
	
	private Map map = new HashMap<>();
	
	//명령어와 처리클래스가 매핑된 properties 파일을 읽어 Map객체에 저장
	public void init(ServletConfig config) throws ServletException { //서블렛 초기화
		super.init(config);
		String props = config.getInitParameter("propertyConfig");
		Properties properties = new Properties(); //명령어와 처리클래스의 매핑 정보를 저장할 프로퍼티 객체
		FileInputStream fis = null;
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
			System.out.println(key);
			System.out.println(value);
			try {
				Class commandClass = Class.forName(value); //해당 문자열을 클래스로 만들기
				Object commandInstance = commandClass.getDeclaredConstructor().newInstance(); //문자열로 만든 클래스를 객체화
				map.put(key, commandInstance); //map에 키값과 value값 객체 저장
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//post나 get요청이 들어오면 실행되는 메소드
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String URI = null;
		String view = null;
		CommandAction com = null;
		try {
			URI = request.getRequestURI();
			System.out.println(URI);
			String command = URI.substring(URI.lastIndexOf("/"));
			System.out.println(command);
			com = (CommandAction)map.get(command); //command = KEY값
			System.out.println(com);
			if(com == null) {
				System.out.println("not found : "+command);
				return;
			}
			view = com.requestPro(request, response);
			System.out.println(view);
		} catch (Throwable e) {
			throw new ServletException(e);
		}
		
		if(view == null) {
			return;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
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
