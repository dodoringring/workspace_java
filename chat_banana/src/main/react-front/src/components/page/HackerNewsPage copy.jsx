import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import Bottom from '../include/Bottom'
import Header from '../include/Header'
import styled from 'styled-components'
import HackerNewsList from '../hacker/HackerNewsList'
const NewsListUL = styled.ul`
    background-color: lightgray;
    padding-top: 10px;
    padding-left: 6px;
    padding-right: 6px;
    padding-bottom: 18px;
`;
const HackerNewsPage = ({authLogic}) => {
    const [newsList, setNewsList] = useState([])
    //페이징 처리에 필요한 코드 추가
    //현재 바라보는 페이지
    const [currentPage, setCurrentPage] = useState(1)
    //한 페이지에 출력될 로우의 수
    const [newsPerPage, setNewsPerPage] = useState(5)
    //배열 객체에서 어디부터 어느 구간 까지를 잘라낼 것인가를 위한 변수 선언 및 초기화
    const indexOfLast = currentPage * newsPerPage
    const indexOfFirst = indexOfLast - newsPerPage
    const currentNews = news => {
        let currentNews = 0
        //파라미터로 받은 배열에서 잘라내기 - slice배열내장함수임
        currentNews = news.slice(indexOfFirst, indexOfLast)
        return currentNews
    }
    const NEWSURL = "https://api.hnpwa.com/v0/news/1.json"
    const navigate = useNavigate()
    const onLogout = () => {
        console.log('HomePage onLogout 호출')
        authLogic.logout()
    }
    useEffect(() => {
        authLogic.onAuthChange(user => {
            if(!user){
                navigate("/")
            }
        })
    })
    useEffect(() => {
        axios.get(NEWSURL).then(response => {
            console.log(response.data)
            console.log(response.data.length)
            setNewsList(response.data)
        })
    },[])
  return (
    <>
        <Header onLogout={onLogout} />
            <NewsListUL>
                <HackerNewsList newsList={currentNews(newsList)} newsPerPage={newsPerPage}//
                                              totalNews={newsList.length} paginate={setCurrentPage}/>
            </NewsListUL>
        <Bottom />
    </>
  )
}
export default HackerNewsPage





10:32
import React from 'react'
import Pagination from './Pagination'
/*
HackerNewsPage에서 조회된 결과를 가지고 페이징 처리에 필요한 연산을 수행하여
필요한 정보를 HackerNewsList에 props로 넘겨야 함
데이터셋이 배열 객체이므로 배열 내장 함수들을 활용할 수 있을 것임
*/
const HackerNewsList = (props) => {
    const {newsList, newsPerPage, totalNews, paginate } = props
    console.log(newsList.length) // 10
    console.log(newsPerPage) //10
    console.log(totalNews) //30
    console.log(paginate) //함수 출력
  return (
    <>
        <div>
                {newsList && Object.keys(newsList).map(key => (
                    <li key={key}>[id:{newsList[key].id}]
                    &nbsp; {newsList[key].title}
                    </li>
                ))}
        </div>
        <Pagination newsPerPage={newsPerPage} totalNews={totalNews} paginate={paginate}/>
    </>
  )
}
export default HackerNewsList


10:32
import React from 'react'
import styled from 'styled-components';
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
//css를 js문법을 사용하여 컴포넌트로 만들어주는 라이브러리 -  styled-component
//페이지 숫자에  마우스를 올리면 동그라미 처리 글자색은 흰색, 배경색은
const PageSpan = styled.span`
  &:hover::after,
  &:focus::after {
    border-radius: 100%;
    color: white;
    background-color: #263A6C;
  }
`;
const Pagination = (props) => {
    const { newsPerPage, totalNews, paginate } = props
    console.log(`newsPerPage : ${newsPerPage},
                         totalNews : ${totalNews}, paginate : ${paginate}`)
    //페이지네이션에 들어갈 숫자를 담을 배열 선언
    const pageNumbers = []
    for(let i=1;i<=Math.ceil(totalNews/newsPerPage);i++){
        //배열에 값 추가하기 - 배열 함수 - mdn push 찾아보기
        pageNumbers.push(i)
    }
  return (
    <div>
        <PageUl>
            {pageNumbers.map(number => (
                <PageLi key={number}>
                    <PageSpan>
                        {number}
                    </PageSpan>
                </PageLi>
            ))
            }
        </PageUl>
    </div>
  )
}
export default Pagination