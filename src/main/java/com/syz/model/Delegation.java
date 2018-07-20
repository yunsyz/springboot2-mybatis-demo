package com.syz.model;

import java.util.Date;

public class Delegation {
    private Integer delegationId;

    private Integer delegationUserId;

    private Date startdate;

    private Date enddate;

    public Integer getDelegationId() {
        return delegationId;
    }

    public void setDelegationId(Integer delegationId) {
        this.delegationId = delegationId;
    }

    public Integer getDelegationUserId() {
        return delegationUserId;
    }

    public void setDelegationUserId(Integer delegationUserId) {
        this.delegationUserId = delegationUserId;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }
}