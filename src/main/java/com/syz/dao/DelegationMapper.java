package com.syz.dao;

import com.syz.model.Delegation;

public interface DelegationMapper {
    int deleteByPrimaryKey(Integer delegationId);

    int insert(Delegation record);

    int insertSelective(Delegation record);

    Delegation selectByPrimaryKey(Integer delegationId);

    int updateByPrimaryKeySelective(Delegation record);

    int updateByPrimaryKey(Delegation record);
}