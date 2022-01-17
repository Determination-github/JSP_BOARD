package jsp.board.action;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import jsp.board.model.BoardBean;
import jsp.board.model.BoardDAO;
import jsp.common.action.Action;
import jsp.common.action.ActionForward;

public class BoardWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		//업로드 파일 사이즈
		int fileSize = 5*1024*1024;
		
		//업로드될 폴더 경로
		String uploadPath = request.getServletContext().getRealPath("/UploadFolder");
		System.out.println("uploadpath는? "+uploadPath);
		
		try {
			//파일업로드
			MultipartRequest multi = new MultipartRequest(request, uploadPath, fileSize, "UTF-8", new DefaultFileRenamePolicy());
			
			//파일 이름 초기화
			String fileName  = "";
			
			//파일 이름 가져오기
			Enumeration<String> names = multi.getFileNames();
			
			if(names.hasMoreElements()) {
				String name = names.nextElement();
				fileName = multi.getFilesystemName(name);
			}
			
			BoardDAO bDAO = BoardDAO.getInstance();
			BoardBean board = new BoardBean();
			
			board.setBoardNum(bDAO.getSeq());
			board.setBoardID(multi.getParameter("boardID"));
			board.setBoardSubject(multi.getParameter("boardSubject"));
			board.setBoardContent(multi.getParameter("boardContent"));
			board.setBoardFile(fileName);
			
			boolean result = bDAO.boardInsert(board);
			
			if(result) {
				forward.setRedirect(true);
				forward.setPath("BoardListAction.bo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}
}
