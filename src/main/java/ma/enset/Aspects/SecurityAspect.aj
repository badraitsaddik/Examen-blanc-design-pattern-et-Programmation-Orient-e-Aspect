package ma.enset.Aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public aspect SecurityAspect {
    private final Map<String, String> userRoles = new HashMap<>();

    public SecurityAspect() {
        // Example user roles
        userRoles.put("user1", "role1");
        userRoles.put("user2", "role2");
    }

    @Around("@annotation(securedBy)")
    public Object secureMethod(ProceedingJoinPoint joinPoint, SecuredBy securedBy) throws Throwable {
        String username = getUsername(); // Implement this method to get the current username
        String userRole = userRoles.get(username);

        for (String role : securedBy.roles()) {
            if (role.equals(userRole)) {
                return joinPoint.proceed();
            }
        }

        throw new SecurityException("User " + username + " does not have the required roles");
    }

    private String getUsername() {
        // Implement this method to retrieve the current username
        return "user1"; // Example username
    }
}