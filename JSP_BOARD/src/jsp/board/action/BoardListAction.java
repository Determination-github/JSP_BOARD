package jsp.board.action;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.board.model.BoardBean;
import jsp.board.model.BoardDAO;
import jsp.common.action.Action;
import jsp.common.action.ActionForward;

public class BoardListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		int page = 1;
		String pages = request.getParameter("page");
		System.out.println("페이지는 ?"+pages);
		
		if(pages != null && !pages.equals("")) {
			page = Integer.parseInt(pages);
		}
		
		String option = request.getParameter("option");
		String condition = request.getParameter("condition");
		
		HashMap<String, Object> list = new HashMap<String, Object>();
		list.put("option", option);
		list.put("condition", condition);
		
		BoardDAO bDAO = BoardDAO.getInstance();
		int listCount = bDAO.getBoardListCount(list);
		
		//한 화면에 10개읠 게시글
		//페이지 번호는 총 5개
		//이후 다음으로 표시
		
		//전체 페이지 수
		int maxPage = (int)((listCount/10.0) + 0.9);
		
		
		//주소창에 maxPage보다 높은 값을 입력하면 maxPage를 보여줌
		if(page > maxPage) {
			page = maxPage;
		}
		
		list.put("start", (page*10)-9);
		
		//글 목록 가져오기
		ArrayList<BoardBean> arrayList = bDAO.getBoardList(list);
		
		//시작 페이지 번호
		int startPage = (((int)((page/5.0) + 0.8)) * 5)-4;
		
		//마지막 페이지 번호
		int endPage = startPage+4;
		
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		request.setAttribute("page", page);
		System.out.println("page는 ? "+page);
		request.setAttribute("startPage", startPage);
		System.out.println("Start는 ? "+startPage);
		request.setAttribute("endPage", endPage);
		System.out.println("end는 ? "+endPage);
		request.setAttribute("maxPage", maxPage);
		System.out.println("max는 ? "+maxPage);
		
		//글의 총 수와 글목록 저장
		request.setAttribute("arrayList", arrayList);
		
		forward.setRedirect(false);
		forward.setPath("BoardListForm.bo");
		
		return forward;
	}
}
