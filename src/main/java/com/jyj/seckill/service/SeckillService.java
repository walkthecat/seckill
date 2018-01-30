package com.jyj.seckill.service;

import com.jyj.seckill.dto.Exposer;
import com.jyj.seckill.dto.SeckillExecution;
import com.jyj.seckill.entity.Seckill;
import com.jyj.seckill.exception.RepeatKillException;
import com.jyj.seckill.exception.SeckillCloseException;
import com.jyj.seckill.exception.SeckillException;

import java.util.List;

/**
 * description: 业务接口：站在"使用者"角度设计接口
 * 三个方面：方法定义粒度，参数，返回类型（return 类型／异常）
 * Created By: Jiang
 * Date: 2018/1/28 上午10:11
 */
public interface SeckillService {

    /**
     * 查询所有秒杀记录
     *
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     *
     * @param seckillId
     * @return
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开始时输出秒杀接口地址，否则输出系统时间和秒杀时间
     *
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException;
}
