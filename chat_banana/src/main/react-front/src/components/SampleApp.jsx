import React, { useState } from 'react'
import SamplePage from '../sample/SamplePage'

const SampleApp = () => {
  const [num, setNum]=useState(0)//숫자를 담을 수 있는 훅
  const handleAdd = () => {
		console.log('SampleApp  handleAdd 호출')
		setNum(num+1)
	}

  return (
    <>
      <SamplePage num={num} handleAdd={handleAdd} />
    </>
  )
}

export default SampleApp