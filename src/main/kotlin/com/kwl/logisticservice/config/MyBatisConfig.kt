package com.kwl.logisticservice.config

import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Configuration

@Configuration
@MapperScan("com.kwl.logisticservice.mapper")
class MyBatisConfig
