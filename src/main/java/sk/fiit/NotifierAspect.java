package sk.fiit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NotifierAspect {

    @Pointcut(value = "execution(* sk.fiit.*.notify(..))")
    public void messageNotify() {}

    @Around(value = "messageNotify()", argNames = "pjp")
    public Object specifyServis(ProceedingJoinPoint pjp) throws Throwable {
        String originalMessage = (String) pjp.getArgs()[0];

        String notifierType = null;
        if (pjp.getTarget() instanceof SMSNotifier) {
            notifierType = "SMS";
        } else if (pjp.getTarget() instanceof SlackNotifier) {
            notifierType = "Slack";
        }

        String modifiedMessage = String.format("[%s] %s", notifierType, originalMessage);
        return pjp.proceed(new Object[]{modifiedMessage});
    }
}
