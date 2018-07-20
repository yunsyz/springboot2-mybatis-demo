package com.syz.dao;

import java.util.List;

import com.syz.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectAllUser();
    
    List<User> findUserByName(String userName);
    
    List<User> selectAllUserAndRole();
    
    List<User> selectAllUserAndDepartment();
    
}