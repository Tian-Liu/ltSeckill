package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * 秒杀成功接口
 */
public interface SuccessKilledDao {
    /**
     * 插入秒杀成功记录，可过滤重复
     * @param seckillId 商品id
     * @param userPhone 用户
     * @return 表示秒杀成功的数量
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);

    /**
     * 通过商品id查找秒杀成功的信息记录
     * @param seckillId 商品id
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
}
