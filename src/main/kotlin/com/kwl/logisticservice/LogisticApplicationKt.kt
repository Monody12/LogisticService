package com.kwl.logisticservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LogisticApplicationKt{
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<LogisticApplicationKt>(*args)
        }
    }
}

