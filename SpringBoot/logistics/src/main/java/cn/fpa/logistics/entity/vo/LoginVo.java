package cn.fpa.logistics.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description //TODO
 * @Date 2023/5/19 16:05
 * @Author weibin.yang
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginVo {
    @ApiModelProperty("联系方式")
    private String phoneNumber;


    @ApiModelProperty("客户密码")
    private String password;
}
