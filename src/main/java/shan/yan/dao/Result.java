package shan.yan.dao;

public class Result<T> {
	private int code;
	private String msg;
	private T data;
	
	public static<T> Result<T> error(CodeMsg cmg){
		return new Result<T>(cmg);
	}
	
	public static<T> Result<T> success(T data){
		return new Result<T>(data);
	}
	
	private Result (T data){
		this.code = 0;
		this.msg = "success";
		this.data = data;
	}
	private Result (CodeMsg cm){
		if( null == cm ) {
			return;
		} else {
			this.code = cm.getCode();
			this.msg = cm.getMsg();
		}
	}
	
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
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
