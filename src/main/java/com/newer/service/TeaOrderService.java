package com.newer.service;

import com.newer.domain.TeaOrder;
import com.newer.mapper.TeaOrderMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TeaOrderService {
    //初始化数据库映射对象
    private TeaOrderMapper teaOrderMapper;
    private SqlSession sqlSession;
    public TeaOrderService(){
        sqlSession= SqlSessionUtil.getSqlSession();
        teaOrderMapper=sqlSession.getMapper(TeaOrderMapper.class);
    }
    public int addOrder(TeaOrder teaOrder){
        //添加业务订单操作
        int rows=teaOrderMapper.addOrder(teaOrder);
        sqlSession.commit();
        return rows;
    }
    public void close(){
        if(sqlSession!=null){
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }
}
