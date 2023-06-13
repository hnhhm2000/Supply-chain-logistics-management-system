package cn.fpa.logistics.controller;

import cn.fpa.logistics.config.common.R;
import cn.fpa.logistics.config.jwt.JwtTokenUtil;
import cn.fpa.logistics.entity.*;
import cn.fpa.logistics.entity.vo.LoginVo;
import cn.fpa.logistics.entity.vo.UserVo;
import cn.fpa.logistics.service.*;
import cn.hutool.core.util.ZipUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 杨维斌
 * @since 2023-05-15
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Resource
    IUserService userService;
    @Resource
    IQuoteService quoteService;
    @Resource
    IInventoryService inventoryService;
    @Resource
    IInvoiceService invoiceService;
    @Resource
    IBillService billService;

@Resource
    IFeeService feeService;
   @PostMapping("/addUser")
    public R  addUser(@RequestBody User user){
       user.setIsDeleted(0);
//       user.setIsDisabled(1);//启用
       userService.save(user);
       return  R.ok();
   }
    @GetMapping("/add")
    public R  add(){
       for(int i=1;i<=30;i++) {
           User user = new User();
           user.setAccountName("黄皓铭"+i);
           user.setAddress("湖南信息学院");
           user.setCity("长沙");
           user.setPassword("123456");
           user.setPhoneNumber("136673494"+i);
           user.setProvince("湖南");
           user.setCountry("中国");
           user.setCreateBy("管理员");
           user.setUpdateBy("管理员");
           user.setZip("415000");
           user.setEmail("986667872@qq.com");
           user.setRemarks("无其他备注");
           user.setRoles("管理员");
           user.setSex("男");
           user.setIsDeleted(0);
           user.setStatus("活跃");//启用
           userService.save(user);
       }
        return  R.ok();
    }
    @PostMapping("/updateUser")
    public R  updateUser(@RequestBody User user){
        userService.updateById(user);
        return  R.ok();
    }
    @PostMapping("/login")
    public R  login(@RequestBody LoginVo loginVo){
       if(StringUtils.isEmpty(loginVo.getPhoneNumber())||StringUtils.isEmpty(loginVo.getPassword())){
           return  R.error().message("未输入账号密码");
       }
       LambdaQueryWrapper<User> queryWrapper=new LambdaQueryWrapper<>();
       queryWrapper.eq(User::getPhoneNumber,loginVo.getPhoneNumber());
        User one = userService.getOne(queryWrapper);
        if(one==null)
            return R.error().message("用户不存在");
        if(!one.getPassword().equals(loginVo.getPassword())){
            return R.error().message("密码错误");
        }
        return  R.ok().data("token", new JwtTokenUtil().generateToken(loginVo.getPhoneNumber()));
    }
    @GetMapping("/getUserInfoByToken")
    public R  getUserInfoByToken(@RequestHeader("token") String token){
        String phoneNumberFromToken = new JwtTokenUtil().getPhoneNumberFromToken(token);
        if(StringUtils.isEmpty(phoneNumberFromToken)){
            return  R.error().message("token不存在或已过期,请重新登录");
        }
        User one = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getPhoneNumber, phoneNumberFromToken));
        return  R.ok().data("userInfo", one);
    }
    @PostMapping("/getList")
    public R  getList(@RequestBody UserVo vo){
        LambdaQueryWrapper<User> userQueryWrapper = new LambdaQueryWrapper<>();
       userQueryWrapper.eq(User::getRoles,"用户");
        userQueryWrapper.orderByDesc(User::getCreateTime);
        int total = userService.list(userQueryWrapper).size();
        String sql="limit "+(vo.getCurrPage()-1)* vo.getPageSize()+","+((vo.getCurrPage()-1)* vo.getPageSize()+vo.getPageSize());
        userQueryWrapper.last(sql);
        List<User> list = userService.list(userQueryWrapper);
        Map<String,Object> map=new HashMap<>();
        map.put("currPage",vo.getCurrPage());
        map.put("pageSize",vo.getPageSize());
        map.put("total",total);//总数量
        map.put("userList",list);
        return  R.ok().data(map);
    }
    @PostMapping("/getUserList")
    public R  getUserList(@RequestBody UserVo vo){
        LambdaQueryWrapper<User> userQueryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotEmpty(vo.getAccountName())){
            userQueryWrapper.like(User::getAccountName,vo.getAccountName());
        }
        if(StringUtils.isNotEmpty(vo.getCity())){
            userQueryWrapper.like(User::getCity,vo.getCity());
        }
        if(StringUtils.isNotEmpty(vo.getProvince())){
            userQueryWrapper.like(User::getProvince,vo.getProvince());
        }
        if(StringUtils.isNotEmpty(vo.getCountry())){
            userQueryWrapper.like(User::getCountry,vo.getCountry());
        }
        userQueryWrapper.ne(User::getRoles,"用户");
        userQueryWrapper.orderByDesc(User::getCreateTime);
        int total = userService.list(userQueryWrapper).size();
        String sql="limit "+(vo.getCurrPage()-1)* vo.getPageSize()+","+((vo.getCurrPage()-1)* vo.getPageSize()+vo.getPageSize());
        userQueryWrapper.last(sql);
        List<User> list = userService.list(userQueryWrapper);
        Map<String,Object> map=new HashMap<>();
        map.put("currPage",vo.getCurrPage());
        map.put("pageSize",vo.getPageSize());
        map.put("total",total);//总数量
        map.put("userList",list);
        return  R.ok().data(map);
    }




    @GetMapping("/getUserById")
    public R  getUserById(@RequestParam("id") String id){
        User byId = userService.getById(id);
        return  R.ok().data("userInfo",byId);
    }
    @GetMapping("/deleteUserById")
    public R  deleteUserById(@RequestParam("id") String id){
      userService.removeById(id);

        return  R.ok();
    }
    @GetMapping("/getUserListByRole")
    public R  getUserListByRole(@RequestParam("role") String role){
       LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
       lambdaQueryWrapper.eq(User::getRoles,role);
        List<User> list = userService.list(lambdaQueryWrapper);
        List<String> res=new ArrayList<>();
        list.stream().forEach(r->{
            res.add(r.getAccountName());
        });
        return  R.ok().data("userList",res);

    }
    @PostMapping("/addQuote")
    public R addQuote(@RequestBody Quote quote){
        quoteService.save(quote);
        return  R.ok();
    }
    @GetMapping("/deleteQuoteById")
    public R deleteQuoteById(@RequestParam("quoteId") String quoteId){
//        if(StringUtils.isNotEmpty(id))
//            id=id.replace("QUO","");
        quoteService.removeById(quoteId);
        return  R.ok();
    }
    @PostMapping("/updateQuote")
    public R updateQuote(@RequestBody Quote quote){
//        String id = quote.getId();
//        if(StringUtils.isNotEmpty(id))
//            id=id.replace("QUO","");
//        quote.setId(id);
        quoteService.updateById(quote);
        return  R.ok();
    }
    @GetMapping("/getQuoteList")
    public R getQuoteList(@RequestParam("userId") String userId){
//        if(StringUtils.isNotEmpty(id))
//            id=id.replace("QUO","");
        List<Quote> list = quoteService.list(new LambdaQueryWrapper<Quote>().eq(Quote::getUserId, userId));
        list.stream().forEach(r->{
            r.setQuoteNumber("QUO"+r.getId());
        });
        return  R.ok().data("quoteList",list);
    }

    @PostMapping("/addInventory")
    public R addQuote(@RequestBody Inventory inventory){
        inventoryService.save(inventory);
        return  R.ok();
    }
    @GetMapping("/deleteInventoryById")
    public R delete(@RequestParam("inventoryId") String inventoryId){
//
        inventoryService.removeById(inventoryId);
        return  R.ok();
    }
    @PostMapping("/updateInventory")
    public R updateQuote(@RequestBody Inventory inventory){
        inventoryService.updateById(inventory);
        return  R.ok();
    }
    @GetMapping("/getInventoryList")
    public R getInventoryList(@RequestParam("userId") String userId){
//        if(StringUtils.isNotEmpty(id))
//            id=id.replace("QUO","");
        List<Inventory> list = inventoryService.list(new LambdaQueryWrapper<Inventory>().eq(Inventory::getUserId, userId));
        list.stream().forEach(r->{
            r.setReceiptNumber("WRI"+r.getId());
        });
        return  R.ok().data("inventoryList",list);
    }






}
