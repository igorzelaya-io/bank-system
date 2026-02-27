package com.example.bankservice.support.annotation;

import com.example.bankservice.infrastructure.web.exception.GlobalExceptionHandler;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(GlobalExceptionHandler.class)
@AutoConfigureMockMvc(addFilters = false)
public @interface BankControllerTest { }
