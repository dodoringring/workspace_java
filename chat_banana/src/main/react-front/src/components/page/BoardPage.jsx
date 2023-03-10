import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Bottom from "../include/Bottom";
import Header from "../include/Header";

const BoardPage  = ({authLogic}) => {
	const navigate = useNavigate()
	let { userId } = useParams()
	console.log(userId)
	const onLogout = () => {
		console.log('BoardPage onLogout 호출')
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
      <Header onLogout={onLogout} />
      BoardPage
      <Bottom />
    </>
  );
};

export default BoardPage;