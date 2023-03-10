import React, { useEffect } from 'react'
import Header from '../include/Header'
import Bottom from '../include/Bottom'
import { useNavigate, useParams } from 'react-router-dom'

//로그아웃 처리를 위해서 props에 suthLogic에 주소번지를 받아온다.
  //onLogout이라는 변수가 함수객체를 가리키고 있다-주소번지
  //함수가 가리키는 주소번지가 다르면 리렌더링이 일어난다.
  //리렌더링은 언제 발생하지?
  //1)상태가 변경되었을때. 상태=데이터
  //     -useState(0); useState({}); useState([]); 원시형 객체형 *배열객체형
  //2)props가 변경되었을때
  //     -({title,onLogout,content})-speard operator
  //3)부모 컴포넌트가 바뀌었을때
  //     -Map(n건)->item별로 바꾼다. 각각의 로우가 된다. 로우에 들어오는것이 컴포넌트이다.
  //BoardList BoardRow BoardDetail 이렇게 넘어가는것

 

//import { useParams } from 'react-router-dom'
//로그아웃 처리를 위해서 props에 authLogic 주소번지를 받아온다
const HomePage = ({authLogic}) => {
	const navigate = useNavigate()
	let { userId } = useParams()
	console.log(userId)
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

  return (
	<React.Fragment>
		<Header userId={userId} onLogout={onLogout} />
		<div>
		HomePage페이지
		</div>
		<Bottom />
	</React.Fragment>
  )
}

export default HomePage