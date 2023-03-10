import React, { useState } from 'react'
import AddForm from './AddForm';
import Workout from './Workout';
//props로 넘길때 파라미터를 따로 작성하지 않아도 넘어감-동일한 함수 선언 불가
const Workouts = ({workouts, onIncrement, onDecrement, onDelete, onAdd}) => {
  // const [name, setName]=useState("default");
  // const [count, setCount]=useState(0);
  const handleIncrement=(item)=>{
    onIncrement(item);
  }
  const handleDecrement=(item)=>{
    onDecrement(item);
  }
  const handleDelete=(item)=>{
    onDelete(item)
  }
  const handleAdd=(name)=>{
    onAdd(name)
  }
  return (
    <>
    <div className="habits">
      <AddForm onAdd={handleAdd}/>
    <ul>
  
      {workouts.map((item,index)=>(/* 맵으로 꺼낸다... 요소를 하나씩 꺼낸다.for문이라고 생각하자! 인덱스는 리액트에서 넣어줌 자동 */
        <Workout workouts={item} key={index} 
        onIncrement={handleIncrement}
        onDecrement={handleDecrement}
        onDelete={handleDelete}
        onAdd={handleAdd}
        />
      ))}
    </ul>
    </div>
    </>
  )
}

export default Workouts

