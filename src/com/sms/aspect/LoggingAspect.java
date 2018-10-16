package com.sms.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	static Logger log = Logger.getLogger(LoggingAspect.class.getName()); 

//	@Around("execution(* com.sms.bean.StudentBean.add*(..))")
	@Around("myPointCut()")
	public Object aroundMethodInvocation(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.debug("Start of " + proceedingJoinPoint.getTarget().getClass().getSimpleName()
                + "'s "
                + proceedingJoinPoint.getSignature().getName()
                + " ");
        Object o = proceedingJoinPoint.proceed();
        log.debug("End of " + proceedingJoinPoint.getTarget().getClass().getSimpleName()
                + "'s "
                + proceedingJoinPoint.getSignature().getName()
                + " ");
        return o;
    }
	
	@Pointcut("within(com.sms.bean.*)")
	public void myPointCut() {}; 
	
//	@After("execution(* com.sms.servlets.AddStudServlet.*(..))")
//    public void afteFinallyAdvice(final JoinPoint joinPoint) {
//        System.out.println("afteFinallyAdvice");
//        System.out.println("End of " + joinPoint.getTarget().getClass().getSimpleName()
//                + "'s "
//                + joinPoint.getSignature().getName()
//                + " ");
//    }
	
//    @Pointcut("within(com.sms.servlets..*)")
//    public void myPointCut() {}

}
