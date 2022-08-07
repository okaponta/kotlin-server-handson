package com.book.manager.advice

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.*
import org.slf4j.LoggerFactory
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

private val logger = LoggerFactory.getLogger(LoggingAdvice::class.java)

@Aspect
@Component
class LoggingAdvice {
    @Before("execution(* com.book.manager.presentation.controller..*.*(..))")
    fun beforeLog(joinPoint: JoinPoint) {
        val user = SecurityContextHolder.getContext().authentication.principal as UserDetails
        logger.info("Start: ${joinPoint.signature} mail=${user.username}")
        logger.info("Class: ${joinPoint.target.javaClass}")
        logger.info("Session: ${(RequestContextHolder.getRequestAttributes() as ServletRequestAttributes).request.session.id}")
    }

    @After("execution(* com.book.manager.presentation.controller..*.*(..))")
    fun afterLog(joinPoint: JoinPoint) {
        val user = SecurityContextHolder.getContext().authentication.principal as UserDetails
        logger.info("End: ${joinPoint.signature} mail=${user.username}")
    }

    @Around("execution(* com.book.manager.presentation.controller..*.*(..))")
    fun aroundLog(joinPoint: ProceedingJoinPoint): Any? {
        // 前処理
        val user = SecurityContextHolder.getContext().authentication.principal as UserDetails
        logger.info("Start Proceed: ${joinPoint.signature} mail=${user.username}")

        // 本処理の実行
        val result = joinPoint.proceed()

        // 後処理
        logger.info("End Proceed: ${joinPoint.signature} mail=${user.username}")

        // 本処理の結果の返却
        return result
    }

    @AfterReturning("execution(* com.book.manager.presentation.controller..*.*(..))", returning = "returnValue")
    fun afterReturningLog(joinPoint: JoinPoint, returnValue: Any?) {
        logger.info("End: ${joinPoint.signature} returnValue=${returnValue}")
    }

    @AfterThrowing("execution(* com.book.manager.presentation.controller..*.*(..))", throwing = "e")
    fun afterThrowingLog(joinPoint: JoinPoint, e: Throwable) {
        logger.error("Exception: ${e.javaClass} signature=${joinPoint.signature} message=${e.message}")
    }

    @AfterThrowing("execution(* com.book.manager.presentation.controller..*.*(..))", throwing = "e")
    fun afterThrowingLog(joinPoint: JoinPoint, e: IllegalArgumentException) {
        logger.error("Exception: ${e.javaClass} signature=${joinPoint.signature} message=${e.message}")
    }
}
