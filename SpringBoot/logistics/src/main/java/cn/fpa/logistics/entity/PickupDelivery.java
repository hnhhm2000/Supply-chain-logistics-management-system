package cn.fpa.logistics.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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
 * @since 2023-05-22
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("pickup_delivery")
@ApiModel(value = "PickupDelivery对象", description = "")
public class PickupDelivery implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;
    @ApiModelProperty("提货与送货编号")
    @TableField(exist = false)
    private String pickupDeliveryNumber;

    @ApiModelProperty("财务")
    private String accounting;

    @ApiModelProperty("提货日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date pickupDate;

    @ApiModelProperty("发货日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date deliveryDate;

    @ApiModelProperty("利润")
    private String profit;

    @ApiModelProperty("托运人")
    private String shipper;

    @ApiModelProperty("收货人")
    private String consignee;

    @ApiModelProperty("提货人")
    private String pickupFrom;

    @ApiModelProperty("送货人")
    private String deliveryTo;

    @ApiModelProperty("承运人")
    private String carrier;

    @ApiModelProperty("客户")
    private String customer;

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

    @ApiModelProperty("价格")
    private String price;

    @ApiModelProperty("发出公司")
    private String issuingCompanyName;

    @ApiModelProperty("收货人地址")
    private String consigneeAddress;

    @ApiModelProperty("托运人地址")
    private String shipperAddress;

    @ApiModelProperty("运输方式")
    private String type;

    @ApiModelProperty("商品名称")
    private String commodity;

    @ApiModelProperty("注意事项")
    private String notes;

    @ApiModelProperty("描述")
    private String description;

    @ApiModelProperty("备注")
    private String remarks;

    @ApiModelProperty("预计到达时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date eta;

    @ApiModelProperty("预计发货时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date etd;

    @ApiModelProperty("货物签收时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date podDate;


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



}
