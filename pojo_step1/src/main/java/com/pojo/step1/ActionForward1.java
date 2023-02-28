package com.pojo.step1;
//setter/getter갖는다.

public class ActionForward1 {
	private String path=null;
	private boolean isRedirect=false;
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

}
