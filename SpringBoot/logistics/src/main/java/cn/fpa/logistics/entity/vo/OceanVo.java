package cn.fpa.logistics.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description //TODO
 * @Date 2023/5/23 05:26
 * @Author weibin.yang
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OceanVo {
    @ApiModelProperty("报价状态")
    @TableField("`status`")
    private String status;
    @ApiModelProperty("创建者")
    private String createBy;
    private Date beginDate;
    private  Date endDate;
    private  Integer currPage; //从第一页开始
    private  Integer pageSize;
}
