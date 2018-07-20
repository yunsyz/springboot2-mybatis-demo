package com.syz.dao;

import com.syz.model.UserDepartment;

public interface UserDepartmentMapper {
    int insert(UserDepartment record);

    int insertSelective(UserDepartment record);
}