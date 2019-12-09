package com.lzl.platform.aop;

import com.alibaba.fastjson.JSON;
import com.lzl.platform.common.UUIDUtil;
import com.lzl.platform.exception.Message;
import com.lzl.platform.exception.PlatformException;
import com.lzl.platform.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * on 2018/2/2
 * 1.打印日志f
 * 2.统一捕获日志
 *
 * @author linggan
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    /**
     * 切面信息
     */
    private final static String POINT_CUT = "execution(* com.lzl.platform.controller..*(..))";

    @Pointcut(POINT_CUT)
    private void pointcut() {
    }

    /**
     * 方法之前
     *
     * @param joinPoint
     */
    @Before(value = "pointcut()")
    public void before(JoinPoint joinPoint) {

        String className = joinPoint.getTarget().getClass().getName();
        Object[] params = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();

        log.info("类名：{}，方法名：{}，参数：{}",className,methodName, JSON.toJSONString(params));
    }

    @AfterReturning(value = "pointcut()", returning = "result")
    public void after(JoinPoint point, Object result) {
        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        String jsonString = JSON.toJSONString(result);
        if(!StringUtils.isEmpty(jsonString)){
            if (jsonString.length() > 1600) {
                jsonString = jsonString.substring(0, 1500);
            }
        }
        log.info("类名：{}，方法名：{}，执行结果：{}",className,methodName, jsonString);
    }

    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
        long start = System.currentTimeMillis();
        Result rs = null;
        String methodName = proceedingJoinPoint.getSignature().getName();
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        try {

            ThreadContext.put("msgId", UUIDUtil.get());

            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            if (e instanceof PlatformException) {
                rs = new Result(((PlatformException) e).getCode(), e.getMessage());
            } else {
                rs = new Result(Message.E5000, e.getMessage());
            }
            log.error("【exception】类名：{}，方法名称：{}，异常信息：{}", className, methodName, e.getMessage(), e);
        }
        long end = System.currentTimeMillis();
        log.info("类名：{}，方法名称：{}，执行时间：{}（毫秒）", className, methodName, (end - start));
        if (rs != null) {
            return rs;
        }
        return result;
    }
}
