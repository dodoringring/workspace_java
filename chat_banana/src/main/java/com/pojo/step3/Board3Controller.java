package com.pojo.step3;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.util.HashMapBinder;

public class Board3Controller implements Controller3 {
	Logger logger = Logger.getLogger(Board3Controller.class);
	Board3Logic boardLogic = new Board3Logic();
	
	//메소드
		@Override
		public ModelAndView boardList(HttpServletRequest req, HttpServletResponse res) {
			logger.info("boardList 호출");
			List<Map<String, Object>> bList = null;
			//사용자가 조건 검색을 원하는 경우 - 조건 값을 전달할 객체 생성함
			//MyBatis에서는 동적쿼리를 지원하므로 하나로 2가지 경우 사용 가능함
			Map<String, Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			bList =boardLogic.boardList(pMap);
			ModelAndView mav = new ModelAndView(req);//mav는 WEB-INF에 jsp로감. forward/redirect는 webapp안에있는것을 부른다.
			mav.setViewName("board3/boardList");
			mav.addObject("bList", bList);				
			return mav;
		}
		@Override
		public Object jsonBoardList(HttpServletRequest req, HttpServletResponse res) {
			logger.info("jsonBoardList호출");
			List<Map<String, Object>> bList = null;
			Map<String, Object> pMap = new HashMap<>();
			HashMapBinder hmb=new HashMapBinder(req);
			hmb.bind(pMap);
			bList =boardLogic.boardList(pMap);
			//오라클 연동 후에 조회 결과가 bList 에 담겨있음
			//forward할 때 그 주소번지를 저장해둠-화면(josonBoardList.jsp)에서 접근함-키값이 중요함
			req.setAttribute("bList", bList);
			return "forward:board3/jsonBoardList";
		}
		@Override
		public Object boardDetail(HttpServletRequest req, HttpServletResponse res) {
			logger.info("boardDetail호출");
			List<Map<String, Object>> bList = null;
			//전체 조회에 대한 sql문 재사용 가능함 - 1건 조회 경우
			Map<String, Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			bList =boardLogic.boardDetail(pMap);
			logger.info(bList);
			req.setAttribute("bList", bList);
			return "forward:board3/boardDetail";
		}
		/*
				INSERT INTO board_master_t(bm_no, bm_title, bm_writer, bm_reg, bm_hit
				                                              , bm_group, bm_pos, bm_step)
			    VALUES(seq_board_no.nextval, #{bm_title}, #{bm_writer}, to_char(sysdate, 'YYYY-MM-DD')
			               ,  0, #{bm_group}, #{bm_pos}, #{bm_step})
	     화면에서 받아올 값 - bm_title, bm_writer, bm_content
	     그렇지 않은 경우 - bm_group, bm_pos, bm_step, bm_reg
		 * */
		
		@Override
		public Object boardInsert(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			logger.info("boardInsert호출");
			int result = 0;
			//폼태그 안에 사용자가 입력한 정보(bm_writer, bm_title, bm_content ....)를 받아온다
			//req.getParameter("bm_writer");
			//req.getParameter("bm_title");
			//req.getParameter("bm_writer");
			//req.getParameter("bm_writer");
			Map<String, Object> pMap = new HashMap<>();
			logger.info("before ==>" + pMap);
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.multiBind(pMap);//멀티 바인드를 타게한다. 첨부파일 post방식
			logger.info("after ==>" + pMap);
			result = boardLogic.boardInsert(pMap);
			String path = "";
			 if(result==1) {
				path = "redirect:/board3/boardList.st3";
			}else {
				path ="boardInsertFail.jsp";
				res.sendRedirect(path);
			}
			return path;
		}
	
		@Override
		public Object boardUpdate(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			logger.info("boardUpdate호출");
			int result = 0;
			Map<String, Object> pMap = new HashMap<>();
			HashMapBinder hmb = new HashMapBinder(req);
			hmb.bind(pMap);
			logger.info(pMap);
			//result 값의 변화를 주는 코드 추가 => 현재는 0
			result = boardLogic.boardUpdate(pMap);
			String path = "";
			if(result==1) {
				path = "redirect:/board3/boardList.st3";
				
			}else {
				path = "boardInsertFail.jsp";
				res.sendRedirect(path);
			}
			return path;
		}
		
		
	@Override
	public Object boardDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		logger.info("boardDelete호출");
		int result = 0;		
		Map<String, Object> pMap = new HashMap<>();
		HashMapBinder hmb = new HashMapBinder(req);
		hmb.bind(pMap);
		result= boardLogic.boardDelete(pMap); //이게 없으면 안된다
		//없으면 java.lang.ArrayIndexOutOfBoundsException: Index 1 out of bounds for length 1 에러뜸
		String path = "";
		if(result==1) {
			logger.info("DB에서 삭제 성공");
			path = "redirect:/board3/boardList.st3";
		}
		else {//result =0인 경우 else 타게 되므로 redirect문장 추가안해주면 /표시 따라 잘라주는데 아무것도 안들어가게 된다\
			path="redirect:/board3/boardInsertFail.jsp";
			res.sendRedirect(path);
		}
		return path;
	}
	//quill editor에서 이미지 선택하면 업로드 처리-물리적인 위치-톰캣서버-chat221228-webapp-pds
	//첨부파일 업로드 API는 cos.jar-maven repo
	//하나. 바이너리 타입 코드 첨부할 때
		//둘. 이미지 파일 첨부할 때
		//첨부파일 처리 (application[main]/*[sub:image.png, img.gif])
		//파일크기 제한 5MB - 유효성 체크
	//editor-퀼은 이지웍 기능 첨가<p></p>피 태그로 감싸져있다. PNG, JPG, JEPG처리가능
	//일단 이미지를 선택하면 pds에 먼저 업로드 되고 그 이미지 경로를 참조해서 editor에 출력해줌
	//리턴타입이 널인 이유는 이미지 정보를 얻어오기 화면적으로 처리할 부분이 없다.
	//에디터에서 이미지를 선택 하면 bm_content컬럼에 image태그와 함께 이미지 정보에 대한 URL소스가 텍스트 형태로 저장된다
	//오라클 서버에 저장된 bm_content내용을 읽어서 브라우저에 출력 해주는 구조
	//이미지 네임 정보는 공통코드로 제공된 QuillEditor.jsx에서 파라미터로 넘어오는 값임
	@Override
	public Object imageUpload(HttpServletRequest req, HttpServletResponse res) {
		logger.info("imageUpload 호출 성공");
		//첨부파일 처리에 필요한 변수 선언
		//get방식-header에 담김-query string
		//post-encType속성-request.getParameter("")사용자가 입력한 값을 읽을 수 없음
		//post이면서 첨부파일이 있는 형태인 경우 이 클래스 반드시 필요
		MultipartRequest multi = null;
		String realFolder = "D:\\workspace_java\\chat_banana\\src\\main\\webapp\\pds";
		//첨부파일의 한글처리
		String encType = "utf-8";
		//첨부파일의 크기
		int maxSize = 50*1024*1024;//5MB
		try {
			//인스턴스화-인스턴스화가 되자마자 pds폴더에 추가됨
			//@param1-req요청-pot방식은 body에 담김-단위테스트 불가능 postman없이는 요청도 불가
			//@param2-실제 파일이 있는 물리적인 위치
			//@param3-첨부파일의 최대 크기
			//@param4-한글 인코딩 설정값
			//@param5-옵저버-같은 이름이 있을 경우 관찰하고 대응값을 반환하기
			multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
			//거의 즉시 업로드됨-파일 크기가 크면 지연상태에 빠짐-dead lock 상태 이어지지 않도록 조심
		} catch (Exception e) {
			logger.info("Exception : "+e.toString());
		}
		//String filename = boardLogic.imageUpload(multi, realFolder);
		Map<String,Object> rMap = boardLogic.imageUpload(multi, realFolder);//멀티는 다른 부가적인 정보 혹시 필요할지도...
		logger.info(rMap);
		//Gson g = new Gson();
		//String temp = g.toJson(rMap);
		//logger.info(temp);
		//logger.info(g);
		String temp = "";
		temp = rMap.get("bs_file").toString()+","+rMap.get("bs_size").toString();
		logger.info(temp);
		return temp;
	}
	//process.env.REACT_APP_PUBLIC_URL+`board3/imageGet.st3?imageName=${res.data}` -확장자 반드시 st3 뒤에는 쿼리스트링
	@Override
	public Object imageGet(HttpServletRequest req, HttpServletResponse res) {
		//imageName정보는 공통코드로 제공된 퀼에디터.jsx에서 파라미터로 넘어오는 값임
		//이미지 업로드 메소드엑서는 업로드된 파일정보(파일명, 파일크기)가 리턴됨
		String b_file = req.getParameter("imageName");//겟방식으로 넘어옴
		logger.info("imageGet 호출 성공===>"+b_file);
		//톰캣서버의 물리적인 위치
		String filePath = "D:\\workspace_java\\chat_banana\\src\\main\\webapp\\pds"; // 절대경로.	
		String fname = b_file;
		//File은 내용까지 복제되는 것은 아니고 파일명만 객체화해주는 클래스이다
		logger.info("b_file: 8->euc"+b_file);		
		File file = new File(filePath,b_file.trim());
		//실제 업로드된 파일의 마임타입을 출력해줌. 뭐가 넘어오는지 꼭 확인하기
		String mimeType = req.getServletContext().getMimeType(file.toString());
		if(mimeType == null){//마임타입이 널이면 
			//아래 속성값으로 마임타입을 설정해줌
			//왜 이렇게 하나요? 브라우저는 해석이 가능한 마임타입은 브라우저에서 보여주고, 해석이 불가능한 마임타입은 다운을 시킨다.
			//강제로 다운로드 처리를 위한 속성값 변경
			//브라우저에서 해석가능한 마임타입의 경우 화면에 그대로 출력이 되는것을 방지하기위해 추가됨.
			res.setContentType("application/octet-stream");
		}
		//다운로드되는 파일 이름 담기
		String downName = null;
		//위 파일 객체에서 생성된 객체 내용을 읽기위한 클래스 선언
		FileInputStream fis = null;
		//응답으로 나갈 정보가 웹서비스에 처리 되어야 하기 때문에 사용한 객체
		ServletOutputStream sos = null;
		try{
			if(req.getHeader("user-agent").indexOf("MSIE")==-1){
				downName = new String(b_file.getBytes("UTF-8"),"8859_1");
			}else{
				downName = new String(b_file.getBytes("EUC-KR"),"8859_1");
			}
			//응답 헤더에 다운로드될 파일명을 매핑하기
		   	res.setHeader("Content-Disposition", "attachment;filename="+downName);
		 	//위에서 생성된 파일 문자열 객체를 가지고 파일 생성에 필요한 객체의 파라미터 넘김
		   	fis = new FileInputStream(file);
			sos = res.getOutputStream();
			//파일 내용을 담을 byte배열을 선언
			byte b[] = new byte[1024*10];
			int data = 0;
			while((data=(fis.read(b,0,b.length)))!=-1){
				//파일에서 읽은 내용을 가지고 실제 파일에 쓰기처리함.
				//여기서 처리된 값은 브라우저를 통해서 내보내진다.
				sos.write(b,0,data);
			}
			//처리한 내용이 버퍼에 있는데 이것을 모두 처리요청을 하기
			//내보내고 버퍼를 비운다-버퍼는 크기가 작음-휘발성
			sos.flush();		
		}catch(Exception e){
			logger.info(e.toString());
		}finally{
			try {
				if(sos != null) sos.close();
				if(fis != null) fis.close();				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		//byte[] fileArray = boardLogic.imageDownload(imageName);
		//logger.info(fileArray.length);
		return null;
	}// end of imageGet

 
	public Map<String, Object> imageUpload(MultipartRequest multi, String realFolder) {
		Map<String, Object> pMap = new HashMap<String, Object>();
		logger.info("image:"+multi);
		String filename =  null;
		String fullPath = null;
		//첨부파일에 대한 정보를 받아오는 코드 추가
		Enumeration<String> files = multi.getFileNames();
		logger.info("files : "+files);		
		//첨부파일이 존재하나?
		if(files!=null) {
			File file = null;
			while(files.hasMoreElements()) {
				String fname = files.nextElement();
				logger.info("fname:"+fname);//bs_file
				filename = multi.getFilesystemName(fname);
				logger.info("filename:"+filename);//첨부파일이름
				pMap.put("bs_file", filename);
				//file객체 생성하기 -> 왜냐하면 첨부파일의 크기를 알고 싶어요....
				//file = multi.getFile(filename);
				if(filename !=null && filename.length()>1) {
					file = new File(realFolder+"\\"+filename);
				}
				logger.info("file:"+file);
			}//end of while
			//첨부파일의 크기를 담을 수 있는 변수
			double size = 0;
			if(file != null) {
				size = file.length();//파일 크기가 저장 5.2MB
				logger.info("size:"+size);
				size = size/(1024);
				logger.info("size/1024:"+size);
				pMap.put("bs_size", size);
			}
			//int result = boardSDao.boardSInsert(pMap);
		}//////end of if		
		//return filename;
		return pMap;
	}
	/*이미지다운로드 메소드
	 * download페이지의 내용과 같다
	 * */

public Object imageDownload(HttpServletRequest req, HttpServletResponse res) {
	logger.info("imageDownload 호출 성공");
	String b_file = req.getParameter("imageName");
	String filePath = "C:\\kh_git2022\\dev_java20220415\\dev_web\\src\\main\\webapp\\pds"; // 절대경로.	
	//가져온 파일이름을 객체화 시켜줌. - 파일이 있는 물리적인 경로가 필요함.
	String fname = b_file;
	logger.info("b_file: 8->euc"+b_file);		
	File file = new File(filePath,b_file.trim());
 	String mimeType = req.getServletContext().getMimeType(file.toString());
 	logger.info("mimeType : "+mimeType);
	if(mimeType == null){
		res.setContentType("application/octet-stream");
	}
	String downName = null;
	//해당 파일을 읽어오는 객체 생성해 줌. - 이 때 파일명을 객체화 한 주소번지가 필요함.
	FileInputStream fis = null;
	ServletOutputStream sos = null;
	try{
		if(req.getHeader("user-agent").indexOf("MSIE")==-1){
			downName = new String(b_file.getBytes("UTF-8"),"8859_1");
		}else{
			downName = new String(b_file.getBytes("EUC-KR"),"8859_1");
		}
	   	res.setHeader("Content-Disposition", "attachment;filename="+downName);
	 	fis = new FileInputStream(file);
		sos = res.getOutputStream();
		byte b[] = new byte[1024*10];
		int data = 0;
		while((data=(fis.read(b,0,b.length)))!=-1){
			sos.write(b,0,data);
		}
		sos.flush();		
	}catch(Exception e){
		logger.info(e.toString());
	}finally{
		try {
			if(sos != null) sos.close();
			if(fis != null) fis.close();				
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	return null;
}// end of imageDownload
@Override
public Object zipcodeList(HttpServletRequest req, HttpServletResponse res) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public Object login(HttpServletRequest req, HttpServletResponse res) {
	// TODO Auto-generated method stub
	return null;
}

}//end of Board3Controller