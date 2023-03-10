import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import {BrowserRouter} from "react-router-dom";
import AuthLogic from "./service/authLogic";
import firebaseApp from "./service/firebase";
import "bootstrap/dist/css/bootstrap.css";
import '@fortawesome/fontawesome-free/js/all.js'
//import SampleApp from "./components/SampleApp";

//공통코드->service>authLogic.js->import외부 js재사용 가능하다.->export default 클래스명->
//브라우저에서 import하려면 반드시 babel이 필요함
const authLogic=new AuthLogic(firebaseApp);//인스턴스화(파라미터가 올 수 있다.)
//왜 파라미터가 필요한가?-firebaseApp->import firebaseApp from "./service/firebase"->export default firebaseApp
//authLogic.파이어베이스에서 제공하는 함수를 호출하겠다.
//document.getElementByld("root")->index.html문서에서 DOM정보 수집하는것이다.
// const root = ReactDOM.createRoot(document.getElementById("root"));
const root = ReactDOM.createRoot(document.querySelector("#root"));
root.render(
  <>
    <BrowserRouter>{/* 얘 자체는 역할이 없다. 감싸져있는 App에서 라우터 기능을 사용한다. */}
    {/*App컴포넌트를 렌더링 할때 속성자리에 주소번지를 넘길 수 있다.-props*/}
    {/* 태그와 JS섞어쓰기가능함 */}
    <App authLogic={authLogic}/>
    {/* <SampleApp/> */}
    </BrowserRouter>
  </>
);
