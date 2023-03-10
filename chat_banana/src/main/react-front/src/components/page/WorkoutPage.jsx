import React, {useEffect} from 'react'
import { useNavigate, useParams } from 'react-router'
import Bottom from '../include/Bottom'
import Header from '../include/Header'
import Workouts from '../workout/Workouts'

// const WorkoutPage = (props) => { 구조분해할당 전
const WorkoutPage = ({authLogic, workouts, onIncrement, onDecrement, onDelete}) => {//미리한버전
  // const {authLogic, workouts, onIncrement}=props 구조분해할당
	const navigate = useNavigate()
	let { userId } = useParams()
	console.log(userId)
	const onLogout = () => {
		console.log('workoutPage onLogout 호출')
		authLogic.logout()
	}
  const handleIncrement=(item)=>{
    //item은 어디서 왔을까요???????
    console.log(item);
    //상위 컴포넌트(App.jsx)의 함수를 호출하는 코드임
    //WorkoutPage의 props에 App에서 선언된 workouts로 주소번지를 가지고 있는데
    //왜? 여기서는 처리를 못하고 다시 상위 컴포넌트로 미루는 걸까요?
    //setItems 훅을 사용할 수 없기 때문입니다.
    //setItems는 파라미터로 넘기지 않습니다. 왜냐하면 해당 컴포넌트가 화면 렌더링과 관련된 함수라서 그렇습니다.
    onIncrement(item);
  }
  const handleDecrement=(item)=>{
    onDecrement(item)
  }
  const handleDelete=(item)=>{
    onDelete(item)
  }
  const handleAdd=(name)=>{
    onAdd(name)
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
    <Workouts workouts={workouts} 
      onIncrement={handleIncrement}
      onDecrement={handleDecrement}
      onDelete={handleDelete}
    />{/* 자손 컴포넌트 호출 prop으로 넘겨줌*/}
    <Bottom/>
  </>
  )
}

export default WorkoutPage
