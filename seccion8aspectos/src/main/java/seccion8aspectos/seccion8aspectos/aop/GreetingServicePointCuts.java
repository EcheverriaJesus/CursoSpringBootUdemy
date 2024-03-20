package seccion8aspectos.seccion8aspectos.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingServicePointCuts {

    @Pointcut("execution(* seccion8aspectos.seccion8aspectos.services.GreetingService.*(..))")
    public void greetingLoggerPointCut() {

    }

    @Pointcut("execution(* seccion8aspectos.seccion8aspectos.services.*.*(..))")
    public void greetingFooLoggerPointCut() {

    }
}
