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

public class BoardUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		String page = request.getParameter("page");
		
		//업로드 파일 사이즈
		int fileSize = 5*1024*1024;
		//업로드될 폴더 경로
		String uploadPath = request.getServletContext().getRealPath("/UploadFolder");
		System.out.println("uploadpath는? "+uploadPath);
		
		try {
			//파일업로드
			MultipartRequest multi = new MultipartRequest(request, uploadPath, fileSize, "UTF-8", new DefaultFileRenamePolicy());
			
			int num = Integer.parseInt(multi.getParameter("boardNum"));
			String subject = multi.getParameter("boardSubject");
			String content = multi.getParameter("boardContent");
			String file = multi.getParameter("boardFile");
			
			BoardBean board = new BoardBean();
			
			board.setBoardNum(num);
			board.setBoardSubject(subject);
			board.setBoardContent(content);

			Enumeration<String> files = multi.getFileNames();
			
			if(files.hasMoreElements()) {
				String name = files.nextElement();
				String newFile = multi.getFilesystemName(name);
			
				if(newFile == null) {
					board.setBoardFile(file);
				} else {
					board.setBoardFile(newFile);
				}
			}
			
			BoardDAO bDAO = BoardDAO.getInstance();
			boolean result = bDAO.updateBoard(board);
			
			if(result) {
				forward.setRedirect(true);
				forward.setPath("BoardListAction.bo?page="+page);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;

	}
}
