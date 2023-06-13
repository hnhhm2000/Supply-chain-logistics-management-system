package cn.fpa.logistics.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description //TODO
 * @Date 2023/5/23 00:10
 * @Author weibin.yang
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PickupDeliveryVo {
    @ApiModelProperty("状态")
    @TableField("`status`")
    private String status;
    @ApiModelProperty("提货与送货编号")
    @TableField(exist = false)
    private String pickupDeliveryNumber;
    @ApiModelProperty("提货日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date pickupDate;
    @ApiModelProperty("客户")
    private String customer;
    @ApiModelProperty("创建者")
    private String createBy;
    private  Integer currPage; //从第一页开始
    private  Integer pageSize;
}
