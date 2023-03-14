import { Route, Routes } from 'react-router-dom';
import './App.css';
import LoginPage from './components/login/LoginPage';
import DeptPage from './components/page/DeptPage';
import EmpPage from './components/page/EmpPage';
import HackerNewsPage from './components/page/HackerNewsPage';
import HomePage from './components/page/HomePage';
import WorkoutPage from './components/page/WorkoutPage';
import YoutubePage from './components/page/YoutubePage';
import FireDeptPage from './components/page/FireDeptPage';
import { useEffect, useState, useParams} from 'react';
import BoardPage from './components/page/BoardPage';
import BoardDetail from './components/board/BoardDetail';
import BoardWriteForm from './components/board/BoardWriteForm';
//index.js에서 브라우저 라우터로 감싸진 App태그 속성값으로 넘어온 주소번지를 받는다.
const App=({authLogic})=> {
  console.log('App호출');
  //상수값->axios(노드제이에스, 리액트-모듈화), fetch(바닐라-브라우저에서 지원)로 나중에 처리할 부분
  //엑시오스 패치 둘다 비동기 처리방식이다.
  const [items,setItems]=useState([
    {id:1,name:'벤치프레스',count:0},
    {id:2,name:'밀리터리프레스',count:0},
    {id:3,name:'오버헤드스쿼트',count:0},
  ]);
 /* 첫번째 파람은 콜백함수이고 두번째는 배열
  *@param1-콜백함수-객체
  *@param2-의존성배열-Dependency Array
  의존성 배열이 비어있으면 최초 App컴포넌트가 렌더링(뭘? 어디서?)이 될 때 딱한번만 실행됨
  재 랜더링이 되는 대상은 리턴 안에 있는 코드들이다.
  만일 items가 변경되면 그때는 재 랜더링이 일어난다.
  */
 useEffect(()=>{
  console.log('effect 호출');
 },[])
  const handleIncrement=(item)=>{
    const index=items.indexOf(item);
    items[index].count+=1;
    setItems([...items])
  }
  const handleDecrement=(item)=>{
    const index=items.indexOf(item);
    const count=items[index].count-1
    items[index].count=count<0?0:count
    setItems([...items])
  }
  const handleDelete=(item)=>{
    console.log(`handleDelete ${item.name}`)
    const workouts=items.filter(workout=>workout.id!=item.id)
    setItems([...workouts])
  }
  const handleAdd=(name)=>{
    //AddForm화면에서 사용자가 입력한 운동이름을 받아온다
    //세번째 파라미터는 0으로 초기화
    //스프레드 연산자를 활용하여 기존 배열에 한개의 객체를 추가하는 코드
    const workouts=[...items, {id:Date.now(),name,count:0}]
    //상태훅에 반영-새로운 주소번지가 채번되도록 처리해야함
    setItems([...workouts])
  }
  //사용자 정의 컴포넌트에서 return다음에 오는 코드가 element의 집합이다.
  //Router이용하면 SPA(single page application)누릴 수 있다.
  return (
  <>
  <Routes>
  <Route path='/' exact={true} element={<LoginPage authLogic={authLogic}/>}/>
    <Route path='/home/:userId' exact={true} element={<HomePage authLogic={authLogic}/>}/>
    <Route path='/board' exact={true} element={<BoardPage authLogic={authLogic}/>}/>
    <Route path='/board/write/*' element={<BoardWriteForm/>}/> {/* exact는 백프로 일치할때만 사용가능 */}
    <Route path='/boarddetail/:bm_no' exact={true} element={<BoardDetail/>}/>
    <Route path='/workout' exact={true} element={<WorkoutPage authLogic={authLogic} workouts={items} onIncrement={handleIncrement} onDecrement={handleDecrement} onDelete={handleDelete} onAdd={handleAdd} />}/>
    <Route path='/hackernews' exact={true} element={<HackerNewsPage authLogic={authLogic}/>}/>
    <Route path='/youtube' exact={true} element={<YoutubePage authLogic={authLogic}/>}/>
    <Route path='/dept/:id' exact={true} element={<FireDeptPage authLogic={authLogic}/>}/>
    <Route path='/emp' exact={true} element={<EmpPage authLogic={authLogic}/>}/>
  </Routes>
  </>
  );
}
export default App;