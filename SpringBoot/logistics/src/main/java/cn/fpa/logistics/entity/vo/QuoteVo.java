package cn.fpa.logistics.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description //TODO
 * @Date 2023/5/19 14:39
 * @Author weibin.yang
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuoteVo {

    @ApiModelProperty("报价状态")
    @TableField("`status`")
    private String status;
    @ApiModelProperty("报价编号")

    private String quoteNumber ;
    @ApiModelProperty("运输方式")
    private String mode;
    @ApiModelProperty("客户")
    private String customer;
    @ApiModelProperty("始发地")
    private String origin;

    @ApiModelProperty("目的地")
    private String destination;
    @ApiModelProperty("承运人")
    private String carrier;
    @ApiModelProperty("修改者")
    private String updateBy;
    @ApiModelProperty("开始日期（到天）")
    private Date createdDate;

    @ApiModelProperty("截止时间（到天）")
    private Date untilDate;
    private  Integer currPage; //从第一页开始
    private  Integer pageSize;
}
