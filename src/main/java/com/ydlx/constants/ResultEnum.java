package com.ydlx.constants;

/**
 * Created by 廖师兄
 * 2017-01-21 14:23
 */
public enum ResultEnum {
    FAIL("99999999", "操作失败"),
    SUCCESS("00000000", "操作成功")
    ;

    private String returnCode;

    private String returnDesc;

    ResultEnum(String returnCode, String returnDesc) {
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
