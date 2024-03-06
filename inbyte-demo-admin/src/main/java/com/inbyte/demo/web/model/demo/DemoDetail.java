package com.inbyte.demo.web.model.demo;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.alibaba.fastjson2.JSONArray;

/**
 * 演示详情
 *
 * @author chenjw
 * @date 2024-02-06 16:23:55
 **/
@Getter
@Setter
public class DemoDetail {

    /** 演示ID */
    private Integer demoId;

    /** 名字 */
    private String name;

    /** 轮播图 */
    private JSONArray banner;

    /** 简介 */
    private String brief;

    /** 标签 */
    private JSONArray tag;

    /** 敏捷开发 */
    private Integer agile;

    /** 微信 */
    private String avatar;

    /** 微信查看数 */
    private Integer wechatViewCount;

    /** 电话 */
    private String tel;

    /** 电话查看数 */
    private Integer telViewCount;

    /** 特性 */
    private JSONArray featureList;

    /** 详情 */
    private JSONArray content;

    /** 查看数 */
    private Integer viewCount;

    /** 排序 */
    private BigDecimal ordinal;

    /** 隐藏 */
    private Integer hidden;

    /** 创建时间 */
    private LocalDateTime createTime;

    /** 创建人ID */
    private Integer createUserId;

    /** 创建人名字 */
    private String createUserName;

    /** 更新时间 */
    private LocalDateTime updateTime;

}
