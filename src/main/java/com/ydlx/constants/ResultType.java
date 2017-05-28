package com.ydlx.constants;

/**
 * Create by ydlx on 2017/5/3.
 */
public enum ResultType {
    FAIL("99999999", "操作失败"),
    SUCCESS("00000000", "操作成功"),
    SESSIONTIMEOUT("00000001","会话超时")
    ;

    private String returnCode;

    private String returnDesc;

    ResultType(String returnCode, String returnDesc) {
        this.returnCode = returnCode;
        this.returnDesc = returnDesc;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnDesc() {
        return returnDesc;
    }

    public void setReturnDesc(String returnDesc) {
        this.returnDesc = returnDesc;
    }
}
