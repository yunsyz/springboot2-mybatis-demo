package com.syz.dao;

import com.syz.model.DepartmentPermission;

public interface DepartmentPermissionMapper {
    int insert(DepartmentPermission record);

    int insertSelective(DepartmentPermission record);
}