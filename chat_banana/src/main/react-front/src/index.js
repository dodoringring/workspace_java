import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import {BrowserRouter} from "react-router-dom";
import AuthLogic from "./service/authLogic";
import firebaseApp from "./service/firebase";
import "bootstrap/dist/css/bootstrap.css";

//공통코드->service>authLogic.js->import외부 js재사용 가능하다.->export default 클래스명->
//브라우저에서 import하려면 반드시 babel이 필요함
const authLogic=new AuthLogic(firebaseApp);//인스턴스화(파라미터가 올 수 있다.)
//왜 파라미터가 필요한가?-firebaseApp->import firebaseApp from "./service/firebase"->export default firebaseApp
//authLogic.파이어베이스에서 제공하는 함수를 호출하겠다.
const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <>
    <BrowserRouter>
    {/*App컴포넌트를 렌더링 할때 속성자리에 주소번지를 넘길 수 있다.-props*/}
    {/* 태그와 JS섞어쓰기가능함 */}
    <App authLogic={authLogic}/>
    </BrowserRouter>
  </>
);
