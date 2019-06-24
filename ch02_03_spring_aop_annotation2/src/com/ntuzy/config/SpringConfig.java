package com.ntuzy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.ntuzy")
@EnableAspectJAutoProxy  // 开启Aop注解功能
public class SpringConfig {

}
