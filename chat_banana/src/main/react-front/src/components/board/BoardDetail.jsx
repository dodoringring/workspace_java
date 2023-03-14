import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router';
import { boardListDB } from '../../service/dbLogic';
import { ContainerDiv, HeaderDiv, FormDiv } from '../styles/FormStyle';
import BoardFileDetail from './BoardFileDetail';
import BoardHeader from './BoardHeader';

const BoardDetail = () => {
  const {bm_no}=useParams()
  console.log(bm_no);

  const [pboard, setPBoard]=useState({
  bm_no:bm_no, //대소문자 구분한다!! 
  })

  const [files,setFiles]=useState([])//하나:파일명-bs_file, 둘:파일크기-bs_size

  const [board, setBoard]=useState({
    BM_NO:0,
    BM_TITLE:"",
    BM_WRITER:"",
    BM_CONTENT:"",
    BM_PW:"",
    BM_REG:"",
    BM_POS:0,
    BM_GRUOP:0,
    BM_STEP:0,
    BM_HIT:0,
    BS_FILE:"",
    BS_SIZE:""
  })
  useEffect(()=>{
    const boardDetail=async()=>{
      //비동기이면 신호가 올때까지 다른거 하고 기다림
      const res=await boardListDB(pboard)
      console.log(res);
      const result=JSON.stringify(res.data)
      const jsonDoc=JSON.parse(result)
      setBoard({BM_NO:jsonDoc[0].BM_NO,BM_TITLE:jsonDoc[0].BM_TITLE, BM_WRITER:jsonDoc[0].BM_WRITER     
                ,BM_CONTENT:jsonDoc[0].BM_CONTENT, BM_PW:jsonDoc[0].BM_PW,BM_REG:jsonDoc[0].BM_REG
                ,BM_HIT:jsonDoc[0].BM_HIT, BM_GROUP:jsonDoc[0].BM_GROUP, BM_POS:jsonDoc[0].BM_POS
                ,BM_STEP:jsonDoc[0].BM_STEP
      })
      //첨부파일, quill editor 이미지 파일
      setFiles([jsonDoc[0].BS_FILE, jsonDoc[0].BS_SIZE])
    }
    boardDetail()
  },[pboard])//의존성 배열에는 제목에 해당하는 bm_no가 변경될 때마다 새로 실행된다.
  //의존성 배열을 적지 않으면 변경될 때마다 새로 읽는다. 초기화가 된다.-유지가 안된다.
  //주의사항 : boards와 같은 n개 로우를 갖는 변수명을 사용하지 말것-무한루프(리렌더링)-getBoards를 대신쓴다.
  //빈 배열(dependency array)이면 최초App(boardDetail)이 렌더링 될 때 딱 한번만 실행이 된다.
  //[pboard] pboard가 바뀔때마다 리렌더링
  return (
    <ContainerDiv>
      <HeaderDiv>
        <h3 style={{marginLeft:"10px"}}>계층형 게시판</h3>
      </HeaderDiv>
      <FormDiv>
        <BoardHeader board={board}  bm_no={bm_no}/>
        <section style={{minHeight: '400px'}}>
          <div dangerouslySetInnerHTML={{__html:board.BM_CONTENT}}></div>
        </section>
        <BoardFileDetail files={files} />
        <hr style={{height:"2px"}}/>
      </FormDiv>
    </ContainerDiv>
  )
}

export default BoardDetail
