package cn.fpa.logistics.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description //TODO
 * @Date 2023/5/23 01:51
 * @Author weibin.yang
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReceiptVo {
    @ApiModelProperty("状态")
    @TableField("`status`")
    private String status;
    @ApiModelProperty("收据编号")
    @TableField(exist = false)
    private String receiptNumber;
    @ApiModelProperty("创建者")
    private String createBy;
    private  Integer currPage; //从第一页开始
    private  Integer pageSize;
}
