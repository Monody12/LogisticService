package com.kwl.logisticservice.pojo

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import java.time.LocalDateTime

data class Logistic(
    @TableId(type = IdType.AUTO)
    var id: Int?,
    var sourceId: Int?,
    var createTime: LocalDateTime?,
    var updateTime: LocalDateTime?,
    var parameters: String?,
    var responseJson: String?,
    var operators: String?
)