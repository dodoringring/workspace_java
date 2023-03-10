import React from 'react'

const DeptRow = (props) => {
  // const {deptno, dname, loc} = props.dept;
  const {dept} = props;
  // console.log("props ==> " + props.getKey);
  return (
    <>{/* 엘리먼트들을 그룹핑해서 여러개 사용할 때 플래그먼트 사용 */}
      <tr>
        {/* <td>{deptno}</td>
        <td>{dname}</td>
        <td>{loc}</td> */}
        <td>{dept.deptno}</td>
        <td>{dept.name}</td>
        <td>{dept.loc}</td>
      </tr>
    </>
  )
}

export default DeptRow