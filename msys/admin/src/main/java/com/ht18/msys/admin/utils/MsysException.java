package com.ht18.msys.admin.utils;

/**
 * 自定义异常
 * @author Louis
 * @date Aug 21, 2018
 */
public class MsysException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String msg;
    private int code = 500;
    
    public MsysException(String msg) {
		super(msg);
		this.msg = msg;
	}
	
	public MsysException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}
	
	public MsysException(String msg, int code) {
		super(msg);
		this.msg = msg;
		this.code = code;
	}
	
	public MsysException(String msg, int code, Throwable e) {
		super(msg, e);
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
}
