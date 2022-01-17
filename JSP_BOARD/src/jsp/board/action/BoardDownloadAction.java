package jsp.board.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import jsp.common.action.Action;
import jsp.common.action.ActionForward;

public class BoardDownloadAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 다운로드할 파일명을 가져온다.
		String fileName = request.getParameter("boardFile");

		// 파일이 있는 절대경로를 가져온다.
		// 현재 업로드된 파일은 UploadFolder 폴더에 있다.
		String folder = request.getServletContext().getRealPath("UploadFolder");
		// 파일의 절대경로를 만든다.
		String filePath = folder + "/" + fileName;

		try {
			File file = new File(filePath);
			byte b[] = new byte[(int) file.length()];
			
			// page의 ContentType등을 동적으로 바꾸기 위해 초기화
			response.reset();
			
			// 한글 인코딩
			String encoding = new String(fileName.getBytes("utf-8"),"iso-8859-1");
			
			// 파일 링크를 클릭했을 때 다운로드 저장 화면이 출력되게 처리하는 부분
			response.setHeader("Content-Disposition", "attachment;filename="+ encoding);
			response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
			response.setHeader("Content-Length", String.valueOf(file.length()));

			if (file.isFile()) // 파일이 있을경우
			{
				FileInputStream fileInputStream = new FileInputStream(file);
				ServletOutputStream servletOutputStream = response.getOutputStream();
				
				//  파일을 읽어서 클라이언트쪽으로 저장한다.
				int readNum = 0;
				// byte 배열의 모든 바이트를 읽어들이기
				while ( (readNum = fileInputStream.read(b)) != -1) {
					//다 읽어들이면 버퍼를 0부터 byte의 길이만큼 출력
					servletOutputStream.write(b, 0, readNum);
				}
				
				//stream 객체 닫기
				servletOutputStream.close();
				fileInputStream.close();
			}
			
		} catch (Exception e) {
			System.out.println("Download Exception : " + e.getMessage());
		}

		return null;
	}
}
