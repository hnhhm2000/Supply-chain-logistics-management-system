package cn.fpa.logistics.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description //TODO
 * @Date 2023/5/23 03:49
 * @Author weibin.yang
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AirVo {
    @ApiModelProperty("状态")
    @TableField("`status`")
    private String status;
    @ApiModelProperty("空运编号")
    @TableField(exist = false)
    private String airNumber;
    @ApiModelProperty("始发地")
    private String origin;

    @ApiModelProperty("目的地")
    private String destination;
    private Date beginDate;
    private  Date endDate;
    private  Integer currPage; //从第一页开始
    private  Integer pageSize;
}
