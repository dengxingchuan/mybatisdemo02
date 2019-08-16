package com.newer.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //定义加载配置文件输入流
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            //加载配置文件，生成sqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            }catch(IOException e){
                e.printStackTrace();
            }
        }
        //获取sqlsession
     public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
     }
     //关闭sqlsession
     public static void closeSqlSession(SqlSession sqlSession){
        if(sqlSession!=null){
            sqlSession.close();
        }
     }
    }
