package com.pojo.step3;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

public class Board3Logic {
	Logger logger = Logger.getLogger(Board3Logic.class);
	Board3Dao boardDao=new Board3Dao();
	public List<Map<String, Object>> boardList(Map<String, Object> pMap) {
		logger.info("boardList호출"+pMap);
		List<Map<String,Object>> bList=null;
		bList=boardDao.boardList(pMap);
		return bList;
	}
	public List<Map<String, Object>> boardDetail(Map<String, Object> pMap) {
		logger.info("boardDetail호출"+pMap);
		List<Map<String,Object>> bList=null;
		bList=boardDao.boardList(pMap);
		int bm_no=Integer.parseInt(pMap.get("bm_no").toString());
		boardDao.hitCount(bm_no);
		return bList;
	}
	
	public int boardUpdate(Map<String, Object> pMap) {
		logger.info("boardUpdate호출 : "+pMap);
		int result=0;
		result=boardDao.boardMUpdate(pMap);
		return result;
	}
	public int boardDelete(Map<String, Object> pMap) {
		logger.info("boardDelete호출 : "+pMap);
		int result=0;
		return result;
	}
	public int boardInsert(Map<String, Object> pMap) {
		logger.info("boardInsert호출"+pMap);
		int result=0;
		int bm_no=0;
		int bm_group=0;
		bm_no=boardDao.getBNo();
		pMap.put("bm_no", bm_no);
		//Map안에서 꺼내다는건 화면에서 넘어온 값이라는뜻
		if(pMap.get("bm_group")!=null) {
			bm_group=Integer.parseInt(pMap.get("bm_group").toString());
		}
		//댓글쓰기야?
		if(bm_group>0) {
			boardDao.bStepUpdate(pMap);
			pMap.put("bm_pos", Integer.parseInt(pMap.get("bm_pos").toString())+1);
			pMap.put("bm_step", Integer.parseInt(pMap.get("bm_step").toString())+1);
		}
		//새글쓰기야?
		else {
			logger.info("새글쓰기 로직 호출=>"+bm_group);
			bm_group=boardDao.getBGroup();
			pMap.put("bm_group", bm_group);
			pMap.put("bm_pos", 0);
			pMap.put("bm_step", 0);
			
		}
		result=boardDao.boardInsert(pMap);
		//첨부파일이 존재하니?
		if(pMap.get("bs_file")!=null && pMap.get("bs_file").toString().length()>1) {
			pMap.put("bm_no", bm_no);
			//현재 첨부파일은 하나만 담는것으로 가정 하고 처리함
			pMap.put("bm_seq", 1);
			int result2=0;
			result2=boardDao.boardSInsert(pMap);
			logger.info(result2);//1이면 등록 성공-첨부파일 추가 성공
		}
		return result;
	}

}
