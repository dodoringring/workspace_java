import React from 'react'
import SampleBottom from './SampleBottom'
import SampleHeader from './SampleHeader'
import SubPage from './SubPage'

const SamplePage = (props) => {
  console.log(":"+props.num)
	const handleAdd = (num) => {
		console.log('SamplePage handleAdd : '+num)
		props.handleAdd(num)
	}
  return (
    <>
       <SampleHeader num={props.num}/>
       <div style={{border:'5px solid skyblue', width:'600px', height:'300px'}}>
        <SubPage handleAdd={handleAdd}/>
        </div>
       <SampleBottom/>
    </>
    )
  }
export default SamplePage
