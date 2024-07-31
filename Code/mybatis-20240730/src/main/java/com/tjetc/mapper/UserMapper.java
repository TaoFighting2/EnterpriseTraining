package com.tjetc.mapper;

import com.tjetc.entity.User;

import java.util.List;

public interface UserMapper {
    //查询所有数据
    List<User> selectAll();
    User selectById(Long id);
    void insert(User user);
    int update(User user);
    int deleteById(Long id);

    //根据用户名或者密码来查询数据，
    //要求：用户名信息存在就用用户名查，密码信息存在就用密码查，两者均存在就两者都用
    List<User> selectByUsernameOrPassword(User user);
    List<User> selectByUsernameOrPassword2(User user);
    List<User> selectByUsernameOrPassword3(User user);

}
