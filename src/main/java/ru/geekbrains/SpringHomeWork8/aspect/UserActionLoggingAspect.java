package ru.geekbrains.SpringHomeWork8.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import ru.geekbrains.SpringHomeWork8.loger.Loger;

import java.util.Arrays;

@Aspect
@Component
public class UserActionLoggingAspect {

    @Pointcut("@annotation(ru.geekbrains.SpringHomeWork8.loger.TrackUserAction)")
    public void trackUserAction() {
    }

    @Around("trackUserAction()")
    public Object logUserAction(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        Object[] args = joinPoint.getArgs();

        if (args.length != 0) {
            Loger.writeToFile(String.format("Пользователь использовал метод %s класса %s передав в аргументы %s\n", methodName, className, Arrays.toString(args)));
        } else {
            Loger.writeToFile(String.format("Пользователь использовал метод %s класса %s без аргументов\n", methodName, className));
        }

        return joinPoint.proceed();
    }
}
