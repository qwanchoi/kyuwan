package co.qwan.home.notice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.qwan.home.notice.web.NoticeController;

@Aspect
@Component
public class NoticeAdvice {
	
	@Around("execution(* co.qwan.home.notice.web..*(..))")
	public Object noticeAroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		Object result = null;
		System.out.println("=== AROUND BEFORE ===================================");
		System.out.println("target: "+pjp.getTarget());
		System.out.println("this :"+pjp.getThis());
		System.out.println("kind :"+pjp.getKind());
		System.out.println("signature :"+pjp.getSignature());
		System.out.println("signature name :"+pjp.getSignature().getName());
		System.out.println("staticPart :"+pjp.getStaticPart());
		System.out.println("Args :"+pjp.getArgs());
		System.out.println("Hello Around AOP !!");
		
		result = pjp.proceed();
			
		System.out.println("Bye Around AOP !!");
		System.out.println("=== AROUND AFTER ===================================");
		return result;
	}
	
	@Before("execution(* co.qwan.home.notice.web..*(..))")
	public void noticeBeforeAdvice() {
		System.out.println("=== BEFORE ===============");
	}
	
	@After("execution(* co.qwan.home.notice.web..*(..))")
	public void noticeAfterAdvice() {
		System.out.println("=== AFTER ===============");
	}
	
	@AfterReturning("execution(* co.qwan.home.notice.web..*(..))")
	public void noticeAfterReturningAdvice() {
		System.out.println("=== AFTER RETURN ===============");
	}
	
	@AfterThrowing(pointcut = "execution(* co.qwan.home.notice.web..*(..))",
			throwing="e")
	public void noticeThrowingAdvice(JoinPoint joinPoint, Exception e) {
		System.out.println("=== Throwing ===================");
		System.out.println(e.getMessage());
	}
}
