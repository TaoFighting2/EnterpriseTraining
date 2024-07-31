package com.tjetc;

import com.tjetc.common.SqlSessionUtils;
import com.tjetc.entity.User;
import com.tjetc.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import static com.tjetc.common.SqlSessionUtils.getSqlSession;

public class MyTest1 {

    @Test //用来测试的，不写没有Run
    public void testSelectAll() throws IOException {
        SqlSession sqlSession = getSqlSession();
        //获取UserMapper接口的代理类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper的selectAll方法查询所有的用户信息，返回用户集合
        List<User> users = userMapper.selectAll();
//        Long id = new Long(1);
//        User user = userMapper.selectById(id);
        //打印user集合
        System.out.println(users);
        //关闭SqlSession对象
        sqlSession.close();
    }
    @Test
    public void testSelectById() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMaper = sqlSession.getMapper(UserMapper.class);
        User user = userMaper.selectById(2L);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void testInsert() throws IOException {
        SqlSession sqlSession = getSqlSession();
        //获取UserMapper接口的代理类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("jhljhl");
        user.setPassword("123123");
        user.setUpdateTime(LocalDateTime.now());
        user.setCreateTime(LocalDateTime.now());
        userMapper.insert(user);
        //增删改都要手动提交事务
        sqlSession.commit();
        System.out.println(user.getId());
        //关闭SqlSession对象
        sqlSession.close();
    }
    @Test
    public void testUpdate() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectById(13L);
        user.setPassword("321321");
        user.setUpdateTime(LocalDateTime.now());
        int affectedRows = userMapper.update(user);
        System.out.println(affectedRows);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testDeleteById() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int affectedRows = userMapper.deleteById(7L);
        System.out.println("affectedRows = "+affectedRows);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSelectByUsernameOrPassword() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
//        user.setUsername("jhljhl");
//        user.setPassword("987");
        List<User> arr = userMapper.selectByUsernameOrPassword(user);
        System.out.println("arr = "+arr);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSelectByUsernameOrPassword2() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
//        user.setUsername("jhljhl");
        user.setPassword("987");
        List<User> arr = userMapper.selectByUsernameOrPassword2(user);
        System.out.println("arr = "+arr);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testSelectByUsernameOrPassword3() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
//        user.setUsername("jhljhl");
        user.setPassword("987");
        List<User> arr = userMapper.selectByUsernameOrPassword3(user);
        System.out.println("arr = "+arr);
        sqlSession.commit();
        sqlSession.close();
    }
}
