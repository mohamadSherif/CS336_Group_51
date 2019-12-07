package com.cs336.pkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Aircraft{
	private String manu,num;
	
	public Aircraft(String manu, String num){
		this.manu=manu;
		this.num=num;
	}

	public String getManu() {
		return manu;
	}

	public void setManu(String manu) {
		this.manu = manu;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
}