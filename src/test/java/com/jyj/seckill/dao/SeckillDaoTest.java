package com.jyj.seckill.dao;

import com.jyj.seckill.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * description:
 * Created By: Jiang
 * Date: 2018/1/21 上午11:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SeckillDaoTest {

    //注入DAO实现类依赖
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void reduceNumber() {
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(1000L, killTime);
        System.out.println("updateCount=" + updateCount);
    }

    @Test
    public void queryById() {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void queryAll() {
        // List<Seckill> queryAll(int offset,int limit);
        // java没有保存形參的记录：queryAll(int offset , int limit) -> queryAll(arg0,arg1)
        //List<Seckill> queryAll(@Param("offset") int offset,@Param("limit") int limit);
        List<Seckill> seckills = seckillDao.queryAll(0, 100);
        seckills.forEach(seckill -> System.out.println(seckill));
    }
}