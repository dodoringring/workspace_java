import React from 'react'

const SubPage = (props) => {
  const handleAdd=()=>{
    console.log('SubPage handleAdd호출');
    props.handleAdd(props.num)
  }
  const handleMinus=()=>{
    console.log('SubPage handleMinus호출');
  }
  return (
    <div style={{border:'5px solid salmon', width:'300px',height:'150px'}}>
     SubPage <br/>
     &nbsp;<button onClick={handleAdd}>+</button>&nbsp;&nbsp;
     <button onClick={handleMinus}>-</button>
    </div>
  )
}

export default SubPage

