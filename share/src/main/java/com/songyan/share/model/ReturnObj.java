package com.songyan.share.model;

/** 
* @author songyan
* @date 2020年3月22日 
* @desc: 
*/
public class ReturnObj {
	private int code;
	private String msg;
	private Object data;
	private int count;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public ReturnObj(Object data) {
		super();
		this.data = data;
		this.msg = "请求成功";
		this.code = ReturnCode.SUCCESS_CODE;
	}
	public ReturnObj(Object data, int errorCode) {
		super();
		this.data = data;
		this.code = errorCode;
	}
	public ReturnObj(Object data, int count, int code) {
		super();
		this.data = data;
		this.code = code;
		this.count = count;
	}
	
}
