import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router';
import Bottom from '../include/Bottom'
import Header from '../include/Header'

const DeptPage = ({authLogic}) => {
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


  const [depts, setDepts] = useState([
    {deptno:10, dname:"개발1팀", loc:"부산"},
    {deptno:20, dname:"개발2팀", loc:"서울"},
    {deptno:30, dname:"개발3팀", loc:"제주"}
  ]);
  useEffect(() => {
    //setDepts(depts)
    console.log(depts)
  }, []);//옵션에 별도의 값을 지정하지 않으면 최초 한번만 실행됨
  return (
    <>
      <Header onLogout={onLogout}/>
      <div>부서관리 페이지</div>
      <div>
        <table>
          <thead>
            <tr>
              <td>부서번호</td>
              <td>부서명</td>
              <td>지역</td>
            </tr>
          </thead>
          <tbody>
            {Object.keys(depts).map(key => (
              <tr key={key}>
                <td>{depts[key].deptno}</td>
                <td>{depts[key].dname}</td>
                <td>{depts[key].loc}</td>
              </tr>
            ))
            }
          </tbody>
        </table>
      </div>
      <Bottom />
    </>
  )
          }

export default DeptPage