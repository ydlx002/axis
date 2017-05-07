package com.ydlx.domain.dto;

import com.ydlx.constants.ResultEnum;

import java.io.Serializable;

/**
 * Created by ydlx on 2017/5/6.
 */
public class ReturnDTO implements Serializable {


    public ReturnDTO(){
    }

    public ReturnDTO(ResultEnum resultEnum){
        this.setResultCode(resultEnum.getReturnCode());
        this.setResultDesc(resultEnum.getReturnCode());
    }

    /***
     * 结果码
     */
    private String resultCode;

    /***
     * 结果描述
     */
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
