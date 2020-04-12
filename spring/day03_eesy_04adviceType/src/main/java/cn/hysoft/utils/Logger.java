package cn.hysoft.utils;

import org.aspectj.lang.ProceedingJoinPoint;

public class Logger {

    public void beforePrintLog() {
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志了。。。");
    }


    public void afterReturningPrintLog() {
        System.out.println("后置通知Logger类中的afterReturningPrintLog方法开始记录日志了。。。");
    }

    public void afterThrowPrintLog() {
        System.out.println("异常通知Logger类中的afterThrowPrintLog方法开始记录日志了。。。");
    }


    public void afterPrintLog() {
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志了。。。");
    }

    public Object arrountPrinLog(ProceedingJoinPoint pjp){
        Object rtValue=null;
        try {
            Object[] args = pjp.getArgs();
            System.out.println("环绕通知Logger类中的arrountPrinLog方法开始记录日志了。。。前置");
            rtValue=pjp.proceed(args);
            System.out.println("环绕通知Logger类中的arrountPrinLog方法开始记录日志了。。。后置");
            return rtValue;
        } catch (Throwable t) {
            System.out.println("环绕通知Logger类中的arrountPrinLog方法开始记录日志了。。。异常");
            t.printStackTrace();
            throw  new RuntimeException(t);
        }finally {
            System.out.println("环绕通知Logger类中的arrountPrinLog方法开始记录日志了。。。最终");
        }

    }

}
