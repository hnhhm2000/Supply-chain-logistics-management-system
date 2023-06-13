package cn.fpa.logistics.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description //TODO
 * @Date 2023/5/15 02:28
 * @Author weibin.yang
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserVo {
    @ApiModelProperty("客户名称")
    private String accountName;
    @ApiModelProperty("市")
    private String city;

    @ApiModelProperty("省")
    private String province;

    @ApiModelProperty("国家")
    private String country;
    private  Integer currPage; //从第一页开始
    private  Integer pageSize;
}
