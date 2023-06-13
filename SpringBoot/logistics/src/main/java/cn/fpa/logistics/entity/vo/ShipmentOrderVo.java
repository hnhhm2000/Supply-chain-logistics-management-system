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
 * @Date 2023/5/22 16:55
 * @Author weibin.yang
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShipmentOrderVo {
    @ApiModelProperty("状态")
    @TableField("`status`")
    private String status;
    @ApiModelProperty("装运单编号")
    @TableField(exist = false)
    private String shipmentOrderNumber;
    @ApiModelProperty("创建者")
    private String createBy;
    @ApiModelProperty("发货日")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date departure;
    @ApiModelProperty("托运人")
    private String shipper;

    @ApiModelProperty("收货人")
    private String consignee;
    private  Integer currPage; //从第一页开始
    private  Integer pageSize;
}
