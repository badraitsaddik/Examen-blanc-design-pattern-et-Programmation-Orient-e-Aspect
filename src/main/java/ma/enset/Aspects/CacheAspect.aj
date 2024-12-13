package ma.enset.Aspects;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public aspect CacheAspect {
    private final Map<String, Object> cache = new HashMap<>();

    @Around("@annotation(ma.enset.Aspects.Cachable)")
    public Object cacheMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else {
            Object result = joinPoint.proceed();
            cache.put(key, result);
            return result;
        }
    }
}