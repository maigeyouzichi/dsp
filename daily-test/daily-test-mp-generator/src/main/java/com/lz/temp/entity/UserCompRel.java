package com.lz.temp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户和挂靠公司关联表
 * </p>
 *
 * @author lihao
 * @since 2021-11-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="UserCompRel对象", description="用户和挂靠公司关联表")
public class UserCompRel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String createBy;

    private LocalDateTime createTime;

    private String updatedBy;

    private LocalDateTime updatedTime;

    private Boolean deleted;

    private String userId;

    private Long companyId;


}
