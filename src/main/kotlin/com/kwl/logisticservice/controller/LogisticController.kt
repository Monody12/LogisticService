package com.kwl.logisticservice.controller

import com.kwl.logisticservice.service.GetLogisticService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class LogisticController {

    @Autowired
    private lateinit var logisticService: GetLogisticService

    @RequestMapping("/logistic", produces = ["application/json;charset=UTF-8"])
    fun getLogistic(@RequestParam no: String,@RequestParam(required = false) type: String?): String {
        return logisticService.get(no, type)
    }

}