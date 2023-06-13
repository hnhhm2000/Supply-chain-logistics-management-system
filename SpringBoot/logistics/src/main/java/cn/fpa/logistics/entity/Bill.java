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
@ApiModel(value = "Bill对象", description = "")
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("发票id")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
      private String id;
    private  String billNumber;


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

    @ApiModelProperty("供应商")
    private String vendor;

    @ApiModelProperty("截止日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date dueDate;
    @ApiModelProperty("截止日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date createDate;

    @ApiModelProperty("备注")
    private String remarks;

    @ApiModelProperty("总额")
    private String totalAmount;
    private  String feeId;


}
