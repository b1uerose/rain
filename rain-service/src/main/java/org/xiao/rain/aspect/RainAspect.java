package org.xiao.rain.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Aspect表示表示当前类是个切面类
 * 切面类是给业务代码增加功能的类
 * Author: xiaojl
 * Date: 2021/7/25 15:08
 */
@Aspect
@Component
public class RainAspect {
    
    @Before("execution(* *..service.impl.*.doSome(..))")
    public void beforeExec(JoinPoint jp) {
        System.out.println("方法的定义:" + jp.getSignature());
        System.out.println("方法名:" + jp.getSignature().getName());
        Object[] arguments = jp.getArgs();
        for (Object arg : arguments) {
            System.out.println(arg);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("前置方法,在目标方法执行前的时间为" + sdf.format(new Date()));
    }

    @AfterReturning(value="execution(* *..service.impl.*.doOther(..))", returning = "res")
    public void afterExec(JoinPoint jp, Object res) {
        //res是方法的返回值
        String method = jp.getSignature().getName();
        System.out.println("方法：" + method + "执行完了, 返回值是：" + res);
        res = "abcd";
    }
    
    @Around("execution(* *..service.impl.*.doAround(..))")
    public Object aroundExec(ProceedingJoinPoint pjp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("环绕通知,在目标方法执行前的时间为" + sdf.format(new Date()));
        //执行方法
        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("这里提交事务");
        return result;
    }
    
    @AfterThrowing(value = "execution(* *..service.impl.*.doException(..))", throwing = "ex")
    public void exceptionExec(JoinPoint jp, Exception ex) {
        System.out.println(ex.getMessage());
        System.out.println("相当于try中的catch");
    }

    @After(value = "myCut()")
    public void AfterExec(JoinPoint jp) {
        System.out.println("不管怎么样，代码都会执行，相当于finally");
    }
    
    @Pointcut("execution(* *..service.impl.*.doAfter(..))")
    public void myCut() {
        
    }
}
