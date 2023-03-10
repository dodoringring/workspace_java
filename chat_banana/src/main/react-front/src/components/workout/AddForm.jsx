import React from 'react'

const AddForm = (props) => {
  //createRef는 브라우저에서 DOM요소에 접근해서 그 요소에 값이나 클릭이벤트를 등록했던것처럼
  //리액트는 바로 Dom요소에 접근하지않고 필요할때 createREf를 이용해서
  //멤버 변수를 정의 한 다음 원하는 해당하는 컴포넌트에 ref로 연결하면 된다.
  //전변선언시 접미어에 Ref를 붙여서 표시
  const formRef=React.createRef()
  const inputRef=React.createRef()
  const onSubmit=(event)=>{
    //이벤트 버블링 이슈를 해결하기위해 반드시 추가할 것 -in
    event.preventdefault()
    const name=inputRef.current.value
    name&&props.onAdd(name)
    formRef.current.reset()
  }
  return (
    <form ref={formRef} className="add-for" onSubmit={onSubmit}>
      <input ref={inputRef} type="text" className='add-input' placeholder='Workout' />
      <button className='add-button'>Add</button>
    </form>
  )
}

export default AddForm
