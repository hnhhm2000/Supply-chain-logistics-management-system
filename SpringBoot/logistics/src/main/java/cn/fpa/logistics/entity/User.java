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
 * @since 2023-05-15
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty("客户名称")
    private String accountName;

    @ApiModelProperty("男女")
    private String sex;

    @ApiModelProperty("联系方式")
    private String phoneNumber;

    @ApiModelProperty("详细地址")
    private String address;

    @ApiModelProperty("客户密码")
    private String password;

    @ApiModelProperty("市")
    private String city;

    @ApiModelProperty("省")
    private String province;

    @ApiModelProperty("国家")
    private String country;

    @ApiModelProperty("邮编")
    private String zip;

    @ApiModelProperty("电子邮件")
    private String email;

    @ApiModelProperty("角色(0管理员 1顾客 2托运人 2发货人 3收货人)")
    private String roles;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("注释")
    private String remarks;

    @ApiModelProperty("盐")
    private String salt;

    @ApiModelProperty("是否删除 1删除 0未删除")
    @TableLogic(value="0",delval="1")
    private Integer isDeleted;

    @ApiModelProperty("是否启用 1启用 0禁用")
    @TableField("`status`")
    private String status;

    @ApiModelProperty("更新人")
    private String updateBy;


}
