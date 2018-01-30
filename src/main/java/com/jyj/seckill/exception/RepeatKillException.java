package com.jyj.seckill.exception;

/**
 * description:重复秒杀异常（运行期异常）
 * Created By: Jiang
 * Date: 2018/1/28 上午10:33
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
