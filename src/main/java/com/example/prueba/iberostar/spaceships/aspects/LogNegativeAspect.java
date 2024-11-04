package com.example.prueba.iberostar.spaceships.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogNegativeAspect {

    @Before("execution(* com.example.prueba.iberostar.spaceships.services.SpaceshipService.getSpaceshipById(..)) && args(id)")
    public void logIfNegative(Long id){
        if (id<0){
            System.out.println("Atención, Id negativo detectado: " + id);
        }
    }
}
