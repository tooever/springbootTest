package com.jf.exam.vo;

public class CommResult<T> implements java.io.Serializable{

    private static final long serialVersionUID = 1L;



    private String msg = "";

    private T data = null;

    private  int code ;



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


    /**
     * 初始化实列
     *
     * @return
     */
    public static CommResult getInstance() {
        return new CommResult();
    }

    public CommResult() {
        super();
        // TODO Auto-generated constructor stub
        this.setCode(ResultCode.error);
    }

    public CommResult(int code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
