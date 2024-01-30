package com.kwl.logisticservice.controller

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.google.gson.Gson
import com.kwl.logisticservice.mapper.LogisticMapper
import com.kwl.logisticservice.pojo.Logistic
import com.kwl.logisticservice.pojo.LogisticReq
import com.kwl.logisticservice.service.GetLogisticService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class LogisticController {

    @Autowired
    private lateinit var logisticService: GetLogisticService

    @Autowired
    private lateinit var logisticMapper: LogisticMapper

    private val logger = org.slf4j.LoggerFactory.getLogger(this.javaClass)

    @RequestMapping("/logistic", produces = ["application/json;charset=UTF-8"])
    fun getLogistic(@RequestParam no: String, @RequestParam(required = false) type: String?): String? {
        val logisticResult: String
        val logisticReq = LogisticReq(no = no, type = type)
        val time = LocalDateTime.now()
        val logistic = Logistic(
            id = null,
            sourceId = 1,
            createTime = time,
            updateTime = null,
            parameters = Gson().toJson(logisticReq),
            responseJson = null,
            operators = "四川涪擎大数据"
        )
        try {
            logisticResult = logisticService.get(no, type)
            logistic.responseJson = logisticResult
        } catch (e: Exception) {
            logistic.responseJson = e.message
            logger.error("获取物流信息失败，原因：${e.message}")
        }
        try {
            logisticMapper.insert(logistic)
        } catch (e: Exception) {
            logger.error("插入数据库失败，原因：${e.message}")
        }
        return logistic.responseJson
    }

}