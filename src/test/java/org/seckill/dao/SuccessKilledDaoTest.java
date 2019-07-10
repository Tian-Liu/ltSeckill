package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

    @Autowired
    private SuccessKilledDao successKilledDao;

    @Test
    public void testInsertSuccessKilled(){
        /**
         * 第一次：insertCount=1
         * 第二次：insertCount=0
         * seckillId和userPhone是联合主键，防止多次秒杀
         */
        int insertCount = successKilledDao.insertSuccessKilled(1001L,13798765432L);
        System.out.println(insertCount);
    }

    @Test
    public void testQueryByIdWithSeckill(){
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(1001L,13798765432L);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckillId());
    }

}