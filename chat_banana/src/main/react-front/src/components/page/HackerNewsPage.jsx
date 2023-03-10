import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router'
import Bottom from '../include/Bottom'
import Header from '../include/Header'
import styled from 'styled-components'

/* 스타일은 전역변수로 반드시 */
const NewsListUL=styled.ul`
  background-color:gray;
  padding-top:10px;
  padding-left:6px;
  padding-right:6px;
  padding-bottom:18px;
`

const HackerNewsPage = ({authLogic}) => {
  const [newsList, setNewsList]=useState([])
  const NEWSURL="https:api.hnpwa.com/v0/news/1.json"
	const navigate = useNavigate()
	let { userId } = useParams()
	console.log(userId)
	const onLogout = () => {
		console.log('HomePage onLogout 호출')
		authLogic.logout()
	}
  useEffect(()=>{
    axios.get(NEWSURL).then(response=>{
      console.log(response.data);
      setNewsList(response.data)
    })
  },[])
	useEffect(() => {
		authLogic.onAuthChange(user => {
			if(!user){
				navigate("/")
			}
		})
	})
  return (
    <>
    <Header onLogout={onLogout}/>
    <NewsListUL>
      {newsList.map((news)=>(
        <li key={news.id}>{news.title}</li>
      ))}
    </NewsListUL>
    HackerNewsPage
    <Bottom/>
    </>
  )
}

export default HackerNewsPage