import React, { useEffect } from 'react'
import { Button } from 'react-bootstrap'
import { useNavigate } from 'react-router-dom'
const LoginPage = ({authLogic}) => {
  const navigate = useNavigate()
  // 페이지이동 함수 구현
  const moveHome = (userId) => {
    console.log(userId)
    navigate({pathname: '/home/'+userId})
  }
  const handleLogin = () => {
    //service안에 authLogic.js에 선언된 클래스->login함수 선언
    //파라미터로 넘기는 문자열에 따라서 구글 로그인 또는 깃허브 로그인
    //authLogic클래스의 getProvider함수에서 분기되어 있음
    authLogic.login("Google")
    .then(data => moveHome(data.user.uid))
  }
  useEffect(()=>{
    //사용자가 바뀌게 되면 처리하기
    authLogic.onAuthChange(user=>{
      console.log(user);
      //사용자가 있다면 로그인 거치지 않고 바로 홈페이지로 이동하기 처리
      user && moveHome(user.uid);
    })
  })
  return (
    <>
      <Button onClick={()=>{
        navigate("/")
      }}>홈페이지</Button>
      <Button onClick={handleLogin}>Google</Button>
    </>
  )
}
export default LoginPage