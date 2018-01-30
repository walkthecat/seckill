package com.jyj.seckill.dao;

import com.jyj.seckill.entity.SuccessKilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * description:
 * Created By: Jiang
 * Date: 2018/1/21 下午12:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() {
        long id = 1000L;
        long phone = 13501232132L;
        int insertCount = successKilledDao.insertSuccessKilled(id, phone);
        System.out.println("insertCount=" + insertCount);
    }

    @Test
    public void queryByIdWithSeckill() {
        long id = 1000L;
        long phone = 13501232132L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id , phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }
}