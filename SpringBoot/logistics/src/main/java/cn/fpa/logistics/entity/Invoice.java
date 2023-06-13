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
 * @since 2023-05-29
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "Invoice对象", description = "")
public class Invoice implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("发票id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

     private  String invoiceNumber;//发表编号
    @ApiModelProperty("是否付款")
    private String payment;



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
    @ApiModelProperty("引用")
    private String reference;

    @ApiModelProperty("引用模块的数据id")
    private String referenceId;

    @ApiModelProperty("项目")
    private String project;

    @ApiModelProperty("收票人")
    private String billTo;

    @ApiModelProperty("金额")
    private String amount;

    @ApiModelProperty("税额")
    private String taxAmount;

    @ApiModelProperty("总额")
    private String totalAmount;

    @ApiModelProperty("备注")
    private String remarks;

    @ApiModelProperty("开具日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date kaiDate;

    @ApiModelProperty("截止日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date dueDate;
    private  String feeId;


}
