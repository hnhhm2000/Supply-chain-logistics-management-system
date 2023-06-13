package cn.fpa.logistics.entity;

import java.io.Serializable;
import java.time.LocalDate;
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
 * @since 2023-05-23
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "Receipt对象", description = "")
public class Receipt implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    @ApiModelProperty("收据编号")
    @TableField(exist = false)
    private String receiptNumber;



    @ApiModelProperty("财务")
    private String accounting;
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

    @ApiModelProperty("状态")
    @TableField("`status`")
    private String status;

    @ApiModelProperty("开据时间（到天）")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date kaiDate;

    @ApiModelProperty("托运人")
    private String shipper;

    @ApiModelProperty("收货人")
    private String consignee;

    @ApiModelProperty("项目")
    private String project;

    @ApiModelProperty("利润")
    private String profit;

    @ApiModelProperty("个数/件数")
    private String pcs;

    @ApiModelProperty("重量")
    private String weight;

    @ApiModelProperty("体积")
    private String vol;

    @ApiModelProperty("收入")
    private String income;

    @ApiModelProperty("支出")
    private String expense;

    @ApiModelProperty("注意事项")
    private String notes;

    @ApiModelProperty("备注")
    private String remarks;

}
