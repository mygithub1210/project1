package com.atguigu.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class MybatisTest {






    @Test
    public void test() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new  SqlSessionFactoryBuilder().build(resourceAsStream);

        System.out.println(sqlSessionFactory);


    }

    @Test
    public void test1() throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        // 从SqlSessionFactory中获取SqlSession对象（相当于之前Jdbc中的 Connection 对象）
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // getMapper() 方法会智能的帮我们创建一个UserMapper接口的实现类（Jdk动态代理）
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            User user = mapper.queryUserById(1);

            System.out.println(user);
        } finally {
            sqlSession.close();
        }

    }
    @Test
    public void test2() throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        // 从SqlSessionFactory中获取SqlSession对象（相当于之前Jdbc中的 Connection 对象）
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // getMapper() 方法会智能的帮我们创建一个UserMapper接口的实现类（Jdk动态代理）
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            System.out.println(mapper.insertUser(new User(null,"张三",1)));
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }
    @Test
    public void test3() throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        // 从SqlSessionFactory中获取SqlSession对象（相当于之前Jdbc中的 Connection 对象）
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // getMapper() 方法会智能的帮我们创建一个UserMapper接口的实现类（Jdk动态代理）
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);


            System.out.println(mapper.deleteUserById(5));
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }


    }
    @Test
    public void test4() throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        // 从SqlSessionFactory中获取SqlSession对象（相当于之前Jdbc中的 Connection 对象）
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // getMapper() 方法会智能的帮我们创建一个UserMapper接口的实现类（Jdk动态代理）
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            System.out.println(mapper.updateUser(new User(1,"admin",0)));
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }

    }
    @Test
    public void test5() throws IOException {
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));

        // 从SqlSessionFactory中获取SqlSession对象（相当于之前Jdbc中的 Connection 对象）
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // getMapper() 方法会智能的帮我们创建一个UserMapper接口的实现类（Jdk动态代理）
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            for (User user :mapper.queryUsers() ) {
                System.out.println(user);
            }
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void insertUser() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(null,"bbj168",1);
            mapper.insertUser(user);
            System.out.println(user);
            sqlSession.commit();//提交事务
        } finally {
            sqlSession.close();
        }
    }
    @Test
    public void queryUsersForMap() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {

           UserMapper mapper = sqlSession.getMapper(UserMapper.class);

           Map<Integer,User> userMap = mapper.queryUsersForMap();

           for (Map.Entry<Integer, User> entry : userMap.entrySet()) {
               System.out.println( entry );
           }

       }
           finally {
        // 关闭SqlSession
        sqlSession.close();
    }
    }






}





