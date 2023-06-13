package cn.fpa.logistics.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description //TODO
 * @Date 2023/5/29 16:49
 * @Author weibin.yang
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvoiceVo {
    private  String invoiceNumber;//发表编号
    @ApiModelProperty("是否付款")
    private String payment;
    @ApiModelProperty("创建者")
    private String createBy;
    private Date beginDate;
    private Date endDate;
    private  Integer currPage; //从第一页开始
    private  Integer pageSize;
}
