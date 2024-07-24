package com.lz.fruit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orange implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
