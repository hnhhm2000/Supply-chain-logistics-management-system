package cn.fpa.logistics.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author 杨维斌
 * @since 2023-05-29
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "Fee对象", description = "")
public class Fee implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty("费用明细状态")
    @TableField("`status`")
    private String status;
    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty("修改者")
    private String updateBy;

    @ApiModelProperty("修改时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;


    @ApiModelProperty("服务")
    private String service;

    @ApiModelProperty("服务描述")
    private String serviceDescription;

    @ApiModelProperty("收入数量")
    private String incomeQuantity;

    private String expenseQuantity;

    private String incomeUnits;

    private String expenseUnits;

    private BigDecimal incomePrice;

    private BigDecimal expensePrice;

    private String incomeTotal;

    private String expenseTotal;

    private String billToName;

    private String vendor;

    private String incomeReference;

    private String expenseReference;

    private String incomePayment;

    private String expensePayment;

    private String incomeRemarks;

    private String expenseRemarks;
private  String quoteId;
private  String userId;
}
