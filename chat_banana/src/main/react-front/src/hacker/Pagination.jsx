import React from 'react'
import styled from 'styled-components';
//css를 js문법을 사용하여 컴포넌트로 만들어 주는 라이브러리
const PageUl = styled.ul`
  float: center;
  list-style: none;
  text-align: center;
  border-radius: 6px;
  color: white;
  padding: 1px;
  border-top: 3px solid #FFC444;
  border-left: 3px solid #FFC444;
  border-right: 3px solid #FFC444;
  border-bottom: 3px solid #FFC444;
  background-color: rgba(78, 77, 77, 0.4);
`;
const PageLi = styled.li`
  display: inline-block;
  font-size: 17px;
  font-weight: 600;
  padding: 5px;
  border-radius: 16px;
  width: 25px;
  &:hover {
    cursor: pointer;
    color: white;
    background-color: #3DB33D;
  }
  &:focus::after {
    color: white;
    background-color: #266C3B;
  }
`;
//페이지 숫자에 마우스를 올리면 동그라미 처리-radius 글자색은 흰색 
const PageSpan = styled.span`
  &:hover::after,
  &:focus::after {
    border-radius: 100%;
    color: white;
    background-color: #263A6C;
  }
`;

const Pagination = (props) => {
  const {newsPerPage,totalNews,paginate}=props
  console.log(`newsPerPage:${newsPerPage},
                totalNews:${totalNews},paginate:${paginate}`);
                //페이지네이션에 들어갈 숫자를 담을 배열 선언
  const pageNumbers=[]
  for(let i=1; i<Math.ceil(totalNews/newsPerPage);i++){
    pageNumbers.push(i)
  }
  
  return (
    <div>
      <PageUl>
      {pageNumbers.map(number=>(
        <PageLi key={number}>
          <PageSpan onClick={()=>paginate(number)}>
            {number}  
          </PageSpan>  
        </PageLi>
      ))}
      </PageUl>
    </div>
  )
}

export default Pagination
