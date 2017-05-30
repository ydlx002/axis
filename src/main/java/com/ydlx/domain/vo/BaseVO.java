package com.ydlx.domain.vo;

import java.io.Serializable;

/**
 * Created by ydlx on 2017/5/30.
 */
public class BaseVO implements Serializable{
    /**操作员*/
    private String operator;

    /**更新时间*/
    private String modifyTime;

    /**创建时间*/
    private String createTime;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "BaseVO{" +
                "operator='" + operator + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
