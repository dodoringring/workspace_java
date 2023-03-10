import React, { useEffect } from 'react'
import { useNavigate } from 'react-router'
import Bottom from '../include/Bottom'
import Header from '../include/Header'
const EmpPage = ({authLogic}) => {
  const navigate = useNavigate()
  const onLogout = () => {
  console.log("BoardPage onLogout 호출");
  authLogic.logout();
};

useEffect(() => {
  authLogic.onAuthChange((user) => {
    if (!user) {
      navigate("/");
    }
  });
});
  return (
    <React.Fragment>
      <Header onLogout={onLogout}/>
      사원관리시스템
      <Bottom/>
    </React.Fragment>
  )
  }

export default EmpPage
