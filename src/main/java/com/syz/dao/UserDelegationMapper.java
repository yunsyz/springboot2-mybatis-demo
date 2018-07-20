package com.syz.dao;

import com.syz.model.UserDelegation;

public interface UserDelegationMapper {
    int insert(UserDelegation record);

    int insertSelective(UserDelegation record);
}