import axios from 'axios';
import React from 'react'

export const dbLogic = () => {
  return new Promise((resolve, reject)=>{
    try {
      const response=axios({
        method:"get",
        url:process.env.React_APP_CHAT221228_IP+"dept/jasonDeptList.st1",
        params:params,
      })
      resolve(response)
    } catch (error) {
      reject(error);
    }
  });
}
/* rafce단축키 에로우펑션만들어줌 */
