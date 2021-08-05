package com.fightbook.commonManager.dto;

import java.io.Serializable;

public class JsonResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private Object data;
	private String global;
	private String inLine;
	
	public JsonResponse(String message, Object data, String inLine) {
		super();
		this.global = message;
		this.data = data;
		this.inLine=inLine;
	}

	public JsonResponse() {
		super();
	}

	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getGlobal() {
		return global;
	}
	public void setGlobal(String global) {
		this.global = global;
	}

	public String getInLine() {
		return inLine;
	}


	public void setInLine(String inLine) {
		this.inLine = inLine;
	}

	@Override
	public String toString() {
		return "JsonResponse [data=" + data + ", global=" + global + ", inLine=" + inLine + "]";
	}	

}
