package com.kwl.logisticservice.pojo

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import java.time.LocalDateTime

data class Logistic(
    @TableId(type = IdType.AUTO)
    val id: Int, // 非空，因为是自动生成的
    val sourceId: Int?,
    val createTime: LocalDateTime?,
    val updateTime: LocalDateTime?,
    val parameters: String?,
    val responseJson: String?,
    val operators: String?
)