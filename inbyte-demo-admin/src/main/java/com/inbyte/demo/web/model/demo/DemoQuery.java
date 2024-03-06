package com.inbyte.demo.web.model.demo;

import com.inbyte.commons.model.dto.BasePage;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

/**
 * 演示查询
 *
 * @author chenjw
 * @date 2024-02-06 16:23:55
 **/
@Getter
@Setter
public class DemoQuery extends BasePage {

    /**
     * 查询关键字
     **/
    private String keyword;

    /**
    * 开始日期
    */
    private LocalDate startDate;

    /**
    * 截止日期
    */
    private LocalDate endDate;

    /**
     * 排序字段
     **/
    @Pattern(regexp = "createTime|viewCount|top|hidden", message = "排序字段不合法")
    private String orderColumn;

    /**
     * 升降序
     **/
    @Pattern(regexp = "asc|desc", message = "排序方式不合法")
    private String ordering;
}
