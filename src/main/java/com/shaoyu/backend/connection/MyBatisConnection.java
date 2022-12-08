package com.shaoyu.backend.connection;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnection {
    public static SqlSession getConnection(){
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        InputStream config = MyBatisConnection.class.getClassLoader().getResourceAsStream("mybatis.xml");
        SqlSessionFactory ssf = sfb.build(config);
        SqlSession ss = ssf.openSession(true);
        return ss;
    }
}
