package com.lz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author lihao
 * @since 2021-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="RResume对象", description="")
public class RResume implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "出生日期")
    private String birthday;

    @ApiModelProperty(value = "工作年限")
    private String workYear;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "目前状态")
    private String status;

    @ApiModelProperty(value = "简历名称")
    @TableField("resumeName")
    private String resumeName;

    private String name;

    @ApiModelProperty(value = "创建日期")
    @TableField("createTime")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "头像")
    @TableField("headPic")
    private String headPic;

    @ApiModelProperty(value = "是否删除 默认值0-未删除 1-已删除")
    @TableField("isDel")
    @TableLogic
    private Integer isDel;

    @ApiModelProperty(value = "简历更新时间")
    @TableField("updateTime")
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "用户ID")
    @TableField("userId")
    private Integer userId;

    @ApiModelProperty(value = "是否为默认简历 0-默认 1-非默认")
    @TableField("isDefault")
    private Integer isDefault;

    @ApiModelProperty(value = "最高学历")
    @TableField("highestEducation")
    private String highestEducation;

    @ApiModelProperty(value = "投递附件简历确认 0-需要确认 1-不需要确认")
    @TableField("deliverNearByConfirm")
    private Integer deliverNearByConfirm;

    @ApiModelProperty(value = "简历被拒绝次数")
    @TableField("refuseCount")
    private Integer refuseCount;

    @ApiModelProperty(value = "被标记为可面试次数")
    @TableField("markCanInterviewCount")
    private Integer markCanInterviewCount;

    @ApiModelProperty(value = "已通知面试次数")
    @TableField("haveNoticeInterCount")
    private Integer haveNoticeInterCount;

    @ApiModelProperty(value = "一句话介绍自己")
    @TableField("oneWord")
    private String oneWord;

    @ApiModelProperty(value = "居住城市")
    @TableField("liveCity")
    private String liveCity;

    @ApiModelProperty(value = "简历得分")
    @TableField("resumeScore")
    private Integer resumeScore;

    @ApiModelProperty(value = "用户身份1-学生 2-工人")
    @TableField("userIdentity")
    private Integer userIdentity;

    @ApiModelProperty(value = "人才搜索-开放简历 0-关闭，1-打开，2-简历未达到投放标准被动关闭 3-从未设置过开放简历")
    @TableField("isOpenResume")
    private Integer isOpenResume;


}
