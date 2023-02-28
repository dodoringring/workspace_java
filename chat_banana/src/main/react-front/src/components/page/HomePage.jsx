import React from 'react'
import Header from '../include/Header'
import { useParams } from 'react-router-dom'

//로그아웃 처리를 위해서 props에 suthLogic에 주소번지를 받아온다.
const HomePage = ({authLogic}) => {
  let {userId}=useParams()
  console.log(userId);
  const onLogout=()=>{
    authLogic.logout()
  }
  return (
    <>
    <Header userId={userId} onLogout={onLogout} />
    <div>
      HomePage페이지
    </div>
    </>
  )
}

export default HomePage