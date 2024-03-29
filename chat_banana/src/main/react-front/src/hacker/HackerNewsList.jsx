import React from 'react'
import Pagination from './Pagination'

/*
HackerNewsPage에서 조회된 결과를 가지고 페이징 처리에 필요한 연산을 수행하여
필요한 정보를 해커ㅗ뉴스리스트에 props로 넘겨야함
데이터셋 배열 객체이므로 배열 내장 함수들을 활용할 수 있을것임
*/
const HackerNewsList=(props)=>{
  const {newsList, newsPerPage, totalNews, paginate}=props
  console.log(newsList.length);//10
  console.log(newsPerPage);//10
  console.log(totalNews);//30
  console.log(paginate);//함수출력
  return(
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
