package com.jyj.seckill.dao;

import com.jyj.seckill.entity.Seckill;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.Date;
import java.util.List;

/**
 * description:
 * Created By: Jiang
 * Date: 2018/1/20 上午11:43
 */
@CacheConfig(cacheNames = "seckill")
public interface SeckillDao {


    /**
     * 减库存
     *
     * @param seckillId
     * @param killTime
     * @return 如果影响行数>1，表示更新的记录行数
     */
    @CachePut(value = "seckillId")
    int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);

    /**
     * 根据ID查询秒杀对象
     *
     * @param seckillId
     * @return
     */
    //  @Cacheable将查询结果缓存到redis中，（key="#p0"）指定传入的第一个参数作为redis的key。
    //  @CachePut(key = "#p0")
    //  @CachePut，指定key，将更新的结果同步到redis中
    //  @CacheEvict(key ="#p0",allEntries=true)
    //  @CacheEvict，指定key，删除缓存数据，allEntries=true,方法调用后将立即清除缓存
    @Cacheable(value = "seckillId")
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset,@Param("limit") int limit);
}
