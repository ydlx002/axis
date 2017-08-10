package com.ydlx.domain.info;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ydlx on 2017/4/29.
 */
public class BaseInfo implements Serializable{

    /**操作员ID*/
    private String operatorId;

    /**操作员*/
    private String operator;

    /**创建时间*/
    private Date createTime;

    /**更新时间*/
    private Date updateTime;


    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "BaseInfo{" +
                "operatorId='" + operatorId + '\'' +
                ", operator='" + operator + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    public BaseInfo(){
        this.createTime = new Date();
        this.updateTime = new Date();
    }
}
