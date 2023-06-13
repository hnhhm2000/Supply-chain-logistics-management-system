package cn.fpa.logistics.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description //TODO
 * @Date 2023/5/23 02:27
 * @Author weibin.yang
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InventoryVo {
    @ApiModelProperty("收据编号")
    private String receiptNumber;
    @ApiModelProperty("状态")
    @TableField("`status`")
    private String status;

    @ApiModelProperty("托运人")
    private String shipper;

    @ApiModelProperty("收货人")
    private String consignee;
    private  Integer currPage; //从第一页开始
    private  Integer pageSize;
}
