package com.util;

import java.io.File;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

//Model, ModelMap
//스프링 부트에서는 RequestParam대신 해줌, Model, ModelMap 귀찮거든 
//사용자가 입력한 값을 Map에 담아 준다.
//담을 맵은 컨트롤 계층에서 bind메소드 호출시 파라미터를 이용해서 원본주소를 받아온다.
//그리고 그 안에 담는다.
public class HashMapBinder {
	Logger logger = Logger.getLogger(HashMapBinder.class);
	//표준 요청 객체
	HttpServletRequest req=null;//(전변)
	//coa.jar에서 제공하는 요청 객체임-첨부파일로 post이면서 enType 속성이 적용된 경우 사용할 것
	MultipartRequest multi=null;
	//첨부파일 물리적 경로
	String realFolder=null;
	//첨부파일 최대 크기
	String encType="UTF-8";
	//첨부파일 최대 크기
	int maxSize=5*1024*1024;
	public HashMapBinder() {}
	//생성자 파라미터에 요청객체(지변)가 필요한 이유는?
	public HashMapBinder(HttpServletRequest req) {
	//전변과 지변 초기화->생성자의 제 1 역할
	this.req=req;
	realFolder="D:\\workspace_java\\chat_banana\\src\\main\\webapp\\pds\\";
	}
	public void multiBind(Map<String, Object> pMap) {
		logger.info("multiBind호출");
		// 컨트롤 계층에서 생성한 맵 객체 비우기
		pMap.clear();
		try {
			multi = new MultipartRequest(req, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		} catch (Exception e) {
			logger.info(e.toString());//발생한 예외 이름 출력하기
		}
		Enumeration<String> en = multi.getParameterNames();
		while (en.hasMoreElements()) {
			String key = en.nextElement();
			pMap.put(key, multi.getParameter(key));
		}
		//첨부파일에 대한 정보 받아오기
		Enumeration<String> files=multi.getFileNames();//n개만큼
		if(files!=null) {
			// 업로드 대상 파일을 객체로 만듦
			File file=null;//내용까지 복제되는것은 아니다.-파일명에 대해서만 객체화 해준다.
			while(files.hasMoreElements()) {//boolean값으로 반환해준다. 해즈모어엘리먼트
				String fname=files.nextElement();
				String filename=multi.getFilesystemName(fname);
				pMap.put("bs_file", filename);
				if(filename!=null&& filename.length()>1) {
					file=new File(realFolder+"\\"+filename);//특수문자는 두번씩
				}
				logger.info(file);
			}//end of while
			//첨부 파일의 크기를 담을 수 있는 변수 선언
			double size=0;//실수형으로
			if(files!=null) {
				size=file.length();//파일크기를 바이트 단위로 담음
				size=size/1024.0;//byte->kbyte바꿔줌
				pMap.put("bs_size",size);
			}
		}//end of if
	}

//어떤 페이지 어떤 상황에서 공통코드를 재사용 가능하게 할것인가?
//업무별 요청 클래스에서 주입 받을 객체를 정해서 메소드의 파라미터로 전달받음
//전달받은 주소번지 원본에 값을 담아준다.
public void bind(Map<String,Object> pMap) {//이 객체는 누가 주입해주나? 어느 위치에서 인스턴스화 되나? 왜 파라미터인가?
	logger.info("bind호출");
	pMap.clear();
	//에뉴머레이션은 리스트나 맵안에 뭐가 있는지를 체크해준다. getParameterNames는 Http가 제공. 여러개라서 에뉴머레이션으로 받음 그렇게 정해짐...
	Enumeration<String> en = req.getParameterNames();
	while(en.hasMoreElements()) {
		String key=en.nextElement();
		logger.info("key : "+key);
		pMap.put(key, req.getParameter(key));
		}
	}
}