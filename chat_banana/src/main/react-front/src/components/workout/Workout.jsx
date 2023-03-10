import React, { useState } from 'react'

//const Workout=(props)=>{}
//const {workout, onInclement}=props->구조분해할당
const Workout = ({workout, onIncrement, onDecrement, onDelete}) => {//미리 구조분해 할당으로 받아옴
  // console.log(workout);
  // const [name, setName]=useState("default");
  // const [count, setCount]=useState(0);
  const handleIncrement=()=>{
    //이벤트 처리가 되어있지 않고 상위 컴포넌트의 함수를 호출
    //-props를 통해서 주소번지 받아옴.
    //상위 컴포넌트의 함수는 props를 통해서 접근가능함
    //리랜더링=리턴이 실행되는것이다.
    //상위 함수를 호출 할 때 파라미터도 넘어간다.
    onIncrement(workout)
  }
  const handleDecrement=()=>{
    onDecrement(workout)
  }
  const handleDelete=()=>{
    onDelete(workout)
  }
  return (
    <>
    <li className='habit' key={workout.id}>
      <span class="habit-name">{workout.name}</span>
      <span class="habit-count">{workout.count}</span>
      <button className="habit-button habit-increase" onClick={handleIncrement}>
          <i className="fas fa-plus-square"></i>
      </button>
      <button className="habit-button habit-decrease" onClick={handleDecrement}>
          <i className="fas fa-minus-square"></i>
      </button>
      <button className="habit-button habit-delete" onClick={handleDelete}>
          <i className="fas fa-trash"></i>
      </button>
      </li>
    </>
  )
}

export default Workout

