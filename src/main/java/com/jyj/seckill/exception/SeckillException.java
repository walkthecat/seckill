package com.jyj.seckill.exception;

/**
 * description:秒杀相关业务异常
 * Created By: Jiang
 * Date: 2018/1/28 上午10:38
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
