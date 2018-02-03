package com.jyj.seckill.service;

import com.jyj.seckill.dto.Exposer;
import com.jyj.seckill.dto.SeckillExecution;
import com.jyj.seckill.entity.Seckill;
import com.jyj.seckill.exception.RepeatKillException;
import com.jyj.seckill.exception.SeckillCloseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * description:
 * Created By: Jiang
 * Date: 2018/1/28 下午12:15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SeckillServiceTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private SeckillService seckillService;

    @Test
    public void getSeckillList() {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}", list);
    }

    @Test
    public void getById() {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}", seckill);
    }

    @Test
    public void exportSeckillUrl() {
        long id = 1000;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer={}", exposer);
    }

    @Test
    public void executeSeckill() {
        long id = 1000;
        long phone = 13717774633L;
        String md5 = "67506a9702580015f9858f5ddc34f754";
        SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
        logger.info("result={}", seckillExecution);
    }

    @Test
    public void testSeckillLogic() throws Exception{
        long id = 1001;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if(exposer.isExposed()){
            logger.info("exposer={}", exposer);
            long phone = 13717774633L;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
                logger.info("result={}", seckillExecution);
            }
            catch (RepeatKillException | SeckillCloseException e){
                logger.error(e.getMessage());
            }
        } else {
            logger.warn("exposer={}", exposer);
        }
    }
}