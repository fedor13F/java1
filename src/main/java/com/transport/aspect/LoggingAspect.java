package com.transport.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Аспект для логирования вызовов методов сервисного слоя через Spring AOP
 */
@Aspect
@Component
public class LoggingAspect {

    /**
     * Логирует вызов метода перед его выполнением.
     * Выводит информацию о классе, имени метода и параметрах.
     * Применяется ко всем методам в пакете service и его подпакетах.
     *
     * @param joinPoint точка соединения, содержащая информацию о вызываемом методе
     */
    @Before("execution(* com.transport.service..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        Object[] args = joinPoint.getArgs();

        System.out.printf("[LOG] Вызов метода: %s.%s() с параметрами: %s%n",
                className, methodName, Arrays.toString(args));
    }

    /**
     * Логирует успешное завершение метода после его выполнения.
     * Выводит информацию о классе, имени метода и возвращаемом значении.
     * Применяется ко всем методам в пакете service и его подпакетах.
     *
     * @param joinPoint точка соединения, содержащая информацию о вызываемом методе
     * @param result    возвращаемое значение метода
     */
    @AfterReturning(pointcut = "execution(* com.transport.service..*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();

        System.out.printf("[LOG] Метод %s.%s() вернул: %s%n",
                className, methodName, result);
    }

    /**
     * Логирует исключения, выброшенные во время выполнения метода.
     * Выводит информацию о классе, имени метода и сообщении об ошибке.
     * Применяется ко всем методам во всем проекте (пакет transport и его подпакеты).
     *
     * @param joinPoint точка соединения, содержащая информацию о вызываемом методе
     * @param exception исключение, выброшенное методом
     */
    @AfterThrowing(pointcut = "execution(* com.transport..*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();

        System.out.printf("[ERROR] Метод %s.%s() выбросил исключение: %s%n",
                className, methodName, exception.getMessage());
    }

    /**
     * Логирует время выполнения метода.
     * Замеряет и выводит время выполнения метода в миллисекундах.
     * Применяется ко всем методам в пакете service и его подпакетах.
     * Является around-советом, который оборачивает выполнение целевого метода.
     *
     * @param joinPoint точка соединения для управления выполнением целевого метода
     * @return результат выполнения целевого метода
     * @throws Throwable если целевой метод выбрасывает исключение
     */
    @Around("execution(* com.transport.service..*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().getName();

        System.out.printf("[LOG] Метод %s() выполнен за %d мс%n",
                methodName, (endTime - startTime));

        return result;
    }
}