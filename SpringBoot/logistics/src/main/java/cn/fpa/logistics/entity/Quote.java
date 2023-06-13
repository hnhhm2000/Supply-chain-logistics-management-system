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
 * @since 2023-05-19
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "Quote对象", description = "")
public class Quote implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
      private String id;
    @ApiModelProperty("报价编号")
    @TableField(exist = false)
    private String quoteNumber;

    @ApiModelProperty("报价状态")
    @TableField("`status`")
    private String status;
    private  String consignee;

    @ApiModelProperty("引用")
    private String reference;

    @ApiModelProperty("引用模块的数据id")
    private String referenceId;

    @ApiModelProperty("项目名")
    private String project;
    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("报价者")
    private String quoter;
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


    @ApiModelProperty("创建日期（到天）")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createdDate;

    @ApiModelProperty("截止时间（到天）")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date untilDate;

    @ApiModelProperty("客户")
    private String customer;

    @ApiModelProperty("客户地址")
    private String customerAddress;

    @ApiModelProperty("货物描述")
    private String descriptionOfGoods;

    @ApiModelProperty("始发地")
    private String origin;

    @ApiModelProperty("目的地")
    private String destination;

    @ApiModelProperty("运输方式")
    private String mode;

    @ApiModelProperty("付款方式")
    private String paymentTerm;

    @ApiModelProperty("运输天数")
    private String transitDays;

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

    @ApiModelProperty("利润")
    private String profit;

    @ApiModelProperty("托运人")
    private String shipper;

    @ApiModelProperty("承运人")
    private String carrier;

    @ApiModelProperty("备注")
    private String remarks;


}
