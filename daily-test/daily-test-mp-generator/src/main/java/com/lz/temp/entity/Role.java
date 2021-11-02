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
 * 角色表
 * </p>
 *
 * @author lihao
 * @since 2021-11-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Role对象", description="角色表")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String createBy;

    private LocalDateTime createTime;

    private String updatedBy;

    private LocalDateTime updatedTime;

    private Boolean deleted;

    @ApiModelProperty(value = "角色代码")
    private String roleCode;

    @ApiModelProperty(value = "角色名称")
    private String roleName;


}
