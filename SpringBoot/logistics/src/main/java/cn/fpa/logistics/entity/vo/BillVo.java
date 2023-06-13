package cn.fpa.logistics.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description //TODO
 * @Date 2023/5/29 18:44
 * @Author weibin.yang
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BillVo {
    private  String billNumber;
    private String createBy;
    private  Integer currPage; //从第一页开始
    private  Integer pageSize;

}
