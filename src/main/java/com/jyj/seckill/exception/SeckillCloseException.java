package com.jyj.seckill.exception;

/**
 * description:秒杀关闭异常
 * Created By: Jiang
 * Date: 2018/1/28 上午10:37
 */
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
