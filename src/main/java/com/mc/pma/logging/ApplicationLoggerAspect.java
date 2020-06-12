package com.mc.pma.logging;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationLoggerAspect {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(com.mc.pma.controllers..*)")
	public void definePackagePointcuts() {
		// empty method just to name the location specified in the pointcut
	}
	@Before("definePackagePointcuts()")
	public void logBefore(JoinPoint jp) {
		log.debug("\n\n\n");
		log.debug("*********** Before method execution ***********m\n {}. {} () with arguments[s]={}",
				jp.getSignature().getDeclaringType(),
				jp.getSignature().getName(),Arrays.toString(jp.getArgs()));
		log.debug("-----------------------------------------------------------\n\n\n");
		
	}
}
