package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    @Autowired
    private SeckillDao seckillDao;

    @Test
    public void testQueryById(){
        long id = 1000;
        System.out.println(seckillDao);
        System.out.println(seckillDao.queryById(id));
    }

    @Test
    public void testQueryAll(){
        /**
         * org.mybatis.spring.MyBatisSystemException:
         * nested exception is org.apache.ibatis.binding.BindingException: Parameter 'offset' not found.
         * Available parameters are [arg1, arg0, param1, param2]
         */
        //java没有保存形参的记录：queryAll(int offset,int limit) -> queryAll(arg0,arg1)
        //在接口中的方法加上@Param()
        List<Seckill> seckills = seckillDao.queryAll(0,100);
        for (Seckill seckill : seckills) {
            System.out.println(seckill);
        }
    }

    @Test
    public void testReduceNumber(){
        Date killTime = new Date();
        int result = seckillDao.reduceNumber(1000L,killTime);
        System.out.println(result);
    }

}