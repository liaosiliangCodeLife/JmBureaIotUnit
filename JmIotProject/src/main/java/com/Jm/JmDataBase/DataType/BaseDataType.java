package com.Jm.JmDataBase.DataType;

import com.Jm.JmCommon.base.JmMqttUntils;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class BaseDataType implements Serializable {
    private static final long serialVersionUID = 52013148023L;

    private String createBy = JmMqttUntils.DATA_DEFAULT_STR;
    public String getCreateBy()
    {
        return createBy;
    }
    public void setCreateBy(String createBy)
    {
        this.createBy = createBy;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    public Date getCreateTime()
    {
        return createTime;
    }
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }


    private String updateBy = JmMqttUntils.DATA_DEFAULT_STR;
    public String getUpdateBy()
    {
        return updateBy;
    }
    public void setUpdateBy(String updateBy)
    {
        this.updateBy = updateBy;
    }


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    public Date getUpdateTime()
    {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }

    private String remark = JmMqttUntils.DATA_DEFAULT_STR;
    public String getRemark()
    {
        return remark;
    }
    public void setRemark(String remark)
    {
        this.remark = remark;
    }
}
