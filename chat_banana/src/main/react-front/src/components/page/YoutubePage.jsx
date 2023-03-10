import React from 'react'
import { useNavigate } from 'react-router'
import Bottom from '../include/Bottom'
import Header from '../include/Header'

const YoutubePage = ({authLogic}) => {
	const navigate = useNavigate()
	let { userId } = useParams()
	console.log(userId)
	const onLogout = () => {
		console.log('YoutubePage onLogout 호출')
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
    YoutubePage
    <Bottom/>
    </>
  )
}

export default YoutubePage
