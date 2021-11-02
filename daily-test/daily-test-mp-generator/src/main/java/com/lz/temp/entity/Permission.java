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
 * 权限表
 * </p>
 *
 * @author lihao
 * @since 2021-11-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Permission对象", description="权限表")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String createBy;

    private LocalDateTime createTime;

    private String updatedBy;

    private LocalDateTime updatedTime;

    private Boolean deleted;

    @ApiModelProperty(value = "权限类型")
    private String type;

    @ApiModelProperty(value = "权限代码")
    private String code;

    @ApiModelProperty(value = "权限名称")
    private String name;

    @ApiModelProperty(value = "父级权限id")
    private Long supId;

    @ApiModelProperty(value = "路由")
    private String path;


}
