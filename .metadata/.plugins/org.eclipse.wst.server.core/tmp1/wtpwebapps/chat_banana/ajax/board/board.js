//비동기통신 객체를 생성해서 단을 변수 선언
let xhrObject = null;
//비동기 통신객체 생성하는 함수 구현-단, 리턴 예약어가 없어서 반환 받을 수 없음
function createRequest2() {
  //자바스크립트에도 예외 처리가 가능하다.
  //참 거짓
  //<<<<<거짓6가지>>>>>>>>
  //1)false
  //2)0---0은 거짓이다.{}:Object=>true,[]:Array=>true
  //3)null
  //4)undefined
  //5)NaN-->not a number
  //6)"빈문자열"
  try {
    //다른 브라우저들은 여기서 컷됨
    xhrObject = new XMLHttpRequest(); //constructor
  } catch (trymicrosoft) {
    try {
      //MS의 IE사용자 위한 객체 생성
      xhrObject = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (error) {
      xhrObject = null;
    }
  }
  if (xhrObject == null) {
    alert("비동기 통신 객체 생성 에러");
  }
  return xhrObject;
} //end of createRequest

//span태그가 가지고 있는 텍스트 노드값을 읽어오기
//<td>100</td> 브라우저가 문자로판단. 태그가 없다 text node->속성을 정의 못한다. ->아이디나 클래스를 정의 못한다.
//->어떡하지->span태그 사용해라!(외적인 변화가 없으니까)
//그래서 나는 텍스트노드를 span으로 감싼다. 그리고 아이디를 준다. price, cost, cash등등
//document.querySelector("#id")
//document.querySelector(".class")
//document.querySelector("태그이름")
function getText(el) {
  let text = ""; //let-변수, const-상수 ES6문법-이런것이 적용 안되는 브라우저이면 babel(자바스크립트 컴파일러) 또는 번들러 parcel
  if (el != null) {
    if (el.childNodes) {
      //el null스킵, undefined,"",NaN
      console.log(el + "," + el.childNodes.length); //1 1
      for (let i = 0; i < el.childNodes.length; i++) {
        //costEl, priceEl
        let childNode = el.childNodes[i]; //el.childNodes[0], el.childNode[1]
        //너 텍스트 노드니?
        if (childNode.nodeValue != null) {
          text = text + childNode.nodeValue;
        }
      }
    }
  }
  return text;
}

//기존 TextNode의 값을 다른 문자열로 바꾸기
/***********************************************
	param1 :document.getElementById("boardSold")
	param1 :document.getElementById("#boardSold")
	param2 :xhrObject. 
	************************************************/
function replaceText(el, value) {//el->boardSoldEl(보드 판매량),cashEl(마진계산하는)
  if (el != null) {//span
    clearText(el); //기존에 있던 10을 지워주세요.
    //새로운 텍스트 노드 15를 생성하기
    let newNode = document.createTextNode(value); //15
    //위에서 생성한 텍스트 노드 값을 el에 붙이는 함수 호출하기
    el.appendChild(newNode);//el boardSoldEl-><span>10</span> <span id="boardSold or cash"></span> <span>20</span>
  }
}
//기존 태그안에 문자열 지우는 함수 구현
function clearText(el) {
  if (el != null) {
    //자바스크립트에서는 0이 아닌것은 모두 참이다.(6가지 제외)
    if (el.childNodes) {
      for (let i = 0; i < el.childNodes.length; i++) {
        let childNode = el.childNodes[i];
        el.removeChild(childNode);//해당 el 삭제하기-DOM API->직관적이지 않다->유지보수가 어렵다->쓰기싫다
      }
    }
  }
}
