package com.inbyte.demo.web.model.demo;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.alibaba.fastjson2.JSONArray;
import org.hibernate.validator.constraints.Length;


/**
 * 演示修改
 *
 * @author chenjw
 * @date 2024-02-06 16:23:55
 **/
@Getter
@Setter
public class DemoUpdate {

    /** 演示ID */
    private Integer demoId;

    /** 名字 */
    @Length(max = 16, message = "名字长度不能超过16位")
    private String name;

    /** 轮播图 */
    private JSONArray banner;

    /** 简介 */
    @Length(max = 255, message = "简介长度不能超过255位")
    private String brief;

    /** 标签 */
    private JSONArray tag;

    /** 敏捷开发 */
    private Integer agile;

    /** 微信 */
    @Length(max = 255, message = "微信长度不能超过255位")
    private String avatar;

    /** 微信查看数 */
    private Integer wechatViewCount;

    /** 电话 */
    @Length(max = 11, message = "电话长度不能超过11位")
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

}
