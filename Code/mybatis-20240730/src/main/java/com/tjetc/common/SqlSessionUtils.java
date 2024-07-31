package com.tjetc.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

// final 用在类上表示 类不能被继承
public final class SqlSessionUtils {

    private static SqlSessionFactoryBuilder builder;
    private static SqlSessionFactory sqlSessionFactory;

    // 定义一个私有的构造方法，不让使用者去new对象
    private SqlSessionUtils(){}

    //静态代码块，执行时机：类被使用的时候而且只执行一次
    static{
        builder = new SqlSessionFactoryBuilder();
        try {
            sqlSessionFactory = builder.build(Resources.getResourceAsReader("mybatis.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    // 静态方法获取sqlsession，不需要创建对象，直接使用类的方法
    public static SqlSession getSqlSession() throws IOException {
        //创建sqlSessionFactoryBuilder对象
        //创建sqlSessionFactory对象,解析xml文件
        //创建sqlSession对象
        return sqlSessionFactory.openSession();
    }
}
