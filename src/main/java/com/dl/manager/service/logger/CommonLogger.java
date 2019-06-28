package com.dl.manager.service.logger;

import java.util.Arrays;
import java.util.regex.Pattern;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author duskol Jun 18, 2019
 *
 */
@Component
@Aspect
public class CommonLogger {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonLogger.class);
	
	private static final String EMPTY_STRING = "";
	
	@Before("@annotation(org.springframework.web.bind.annotation.RequestMapping) && @annotation(mapping)") 
    public void logBeforeAllContrllers(JoinPoint jp, RequestMapping mapping) { 
        //LOGGER.info("[CLIENT USERNAME]: " + headerResolver.getUsername());
        //LOGGER.info("[CLIENT IP]: " + headerResolver.getClientIp()); 
        //LOGGER.info("[URL]: " + headerResolver.getRequestURI());
        LOGGER.info("[CONTROLLER]: " + getName(jp));
        if(mapping.method().length > 0) {
        	LOGGER.info("[METHOD]: " + mapping.method()[0]);
        }
        LOGGER.info("[METHOD NAME]: " + jp.getSignature().getName());
        if(mapping.value().length > 0) {
        	 LOGGER.info("[URL]: {}", mapping.value()[0]);
        }
        String args = getArgs(jp);
        if(EMPTY_STRING != args) {
        	LOGGER.info("[ARGS]: " + args);
        }
    }
	
	@AfterThrowing(pointcut = "execution(* com.dl.manager.controller.*.*(..))", throwing = "ex")
    public void logAfterThrowingAllMethods(JoinPoint jp, Throwable ex) throws Throwable {
		LOGGER.error("[EXCEPTION METHOD SIGNATURE]: " + jp.getSignature());
        LOGGER.error("[EXCEPTION MESSAGE]: " + ex.getMessage());
        LOGGER.error("[STACK TRACE]: ",ex);
    }
	
	/**
	 * 
	 * @param jp
	 * @return
	 */
	private String getName(JoinPoint jp) {
        String signature = jp.getSignature().getDeclaringTypeName();
        String[] names = signature.split(Pattern.quote("."));
        return names[names.length-1];
    }
	
	/**
	 * 
	 * @param jp
	 * @return
	 */
	private String getArgs(JoinPoint jp) {
        
        Object[] args = jp.getArgs();
        
        if(args.length == 0) {
            return EMPTY_STRING;
        }
        
        StringBuilder sb = new StringBuilder();
        Arrays.asList(args).stream().filter(arg-> !(arg instanceof BeanPropertyBindingResult)).forEach(arg -> {
            sb.append(arg).append(";");
        });
        
        return sb.toString();
        
    }
}
