package com.ydlx.domain.info;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ydlx on 2017/4/29.
 */
public class BaseInfo implements Serializable{

    private int id;
    private String operator;
    private Date createTime;
    private Date modifyTime;

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
