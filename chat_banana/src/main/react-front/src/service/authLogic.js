import { getAuth, signInWithPopup, GoogleAuthProvider } from "firebase/auth";
//import firebase from 'firebase';

class AuthLogic {
  //생성자 정의-자바와는 다르게 선언없이 초기화 가능
  //firebaseAuth변수명, googleProvider변수명-전역변수
  constructor() {
    this.firebaseAuth = getAuth();
    this.googleProvider = new GoogleAuthProvider();
  }
  //로그인 시도시 구글인증인지 아니면 깃허브 인증인지 문자열로 넘겨 받음
  //구글 인증인 경우 - Google
  //깃헙인증인경우-Github
  login(providerName) {
    console.log("providerName : " + providerName);
    //파라미터로 넘겨받은 문자열로 비교하여 각 제공자의 객체를 주입받음
    const authProvider = this.getProvider(providerName);
    //제공자의 정보가 정보이면 팝업을 띄워서 로그인을 진행하도록 유도함.

    return signInWithPopup(this.firebaseAuth, authProvider);
  }

  logout() {
    this.firebaseAuth.signOut();
  }

  onAuthChange(onUserChanged) {
    // 사용자가 바뀌었을 때 콜백함수를 받아서
    this.firebaseAuth.onAuthStateChanged((user) => {
      //사용자가 바뀔 때마다 구글에서 응답을 주는 컨셉
      onUserChanged(user);
    });
  }

  getProvider(providerName) {
    switch (providerName) {
      case "Google":
        return this.googleProvider;
      case "Github":
        return this.githubProvider;
      default:
        throw new Error(`not supported provider: ${providerName}`);
    }
  }
}
/* 외부 JS에서 사용하려면 반드시 추가할것 */
/* 왜 리덕스를 공부해야되나? 그것의 대답이 될 수 있다. */
export default AuthLogic;