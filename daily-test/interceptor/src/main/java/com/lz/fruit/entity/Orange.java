package com.lz.fruit.entity;

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
 * 橘子
 * </p>
 *
 * @author lihao
 * @since 2024-07-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Orange对象", description="橘子")
public class Orange implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
