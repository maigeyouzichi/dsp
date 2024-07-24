package com.lz.fruit.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Timestamp;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 草莓
 * </p>
 *
 * @author lihao
 * @since 2024-07-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Strawberry对象", description="草莓")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Strawberry implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private Timestamp createTime;

    private Timestamp updateTime;


}
