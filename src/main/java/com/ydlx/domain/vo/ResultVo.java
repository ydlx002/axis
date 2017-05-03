package com.ydlx.domain.vo;

import java.io.Serializable;

/**
 * Created by ydlx on 2017/5/3.
 */
public class ResultVo implements Serializable{

    private String resultCode;
    private String resultDesc;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }
}
