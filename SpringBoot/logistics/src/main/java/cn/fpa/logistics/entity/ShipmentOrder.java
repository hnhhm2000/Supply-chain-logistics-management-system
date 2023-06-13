package cn.fpa.logistics.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
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
@TableName("shipment_order")
@ApiModel(value = "ShipmentOrder对象", description = "")
public class ShipmentOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.ASSIGN_ID)
      private String id;
    @ApiModelProperty("装运单编号")
    @TableField(exist = false)
    private String shipmentOrderNumber;

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

    @ApiModelProperty("财务")
    private String accounting;

    @ApiModelProperty("运输类型")
    private String type;

    @ApiModelProperty("发货日")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date departure;

    @ApiModelProperty("收获日")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date arrival;

    @ApiModelProperty("托运人")
    private String shipper;

    @ApiModelProperty("收货人")
    private String consignee;

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

    @ApiModelProperty("始发地")
    private String origin;

    @ApiModelProperty("收货地")
    private String determine;

    @ApiModelProperty("承运人")
    private String carrier;

    @ApiModelProperty("收货人地址")
    private String consigneeAddress;

    @ApiModelProperty("托运人地址")
    private String shipperAddress;

    @ApiModelProperty("备注")
    private String remarks;

}
