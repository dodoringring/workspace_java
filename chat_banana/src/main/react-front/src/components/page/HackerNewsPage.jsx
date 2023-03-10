import React, { useEffect } from 'react'
import { useNavigate } from 'react-router'
import Bottom from '../include/Bottom'
import Header from '../include/Header'

const HackerNewsPage = ({authLogic}) => {
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
    <>
    <Header onLogout={onLogout}/>
    HackerNewsPage
    <Bottom/>
    </>
  )
}

export default HackerNewsPage
HackerNewsPage