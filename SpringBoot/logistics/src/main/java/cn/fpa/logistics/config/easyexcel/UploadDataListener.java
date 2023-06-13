//package cn.fpa.config.easyexcel;
//
//import com.alibaba.excel.context.AnalysisContext;
//import com.alibaba.excel.event.AnalysisEventListener;
//import com.alibaba.fastjson.JSON;
//import com.hospital.entity.User;
//import com.hospital.entity.UserRole;
//import com.hospital.mapper.UserMapper;
//import com.hospital.mapper.UserRoleMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.ArrayList;
//import java.util.List;
////import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * 模板的读取类
// *
// * @author Jiaju Zhuang
// */
//// 有个很重要的点 DemoDataListener 不能被spring管理，要每次读取excel都要new,然后里面用到spring可以构造方法传进去
//@Slf4j
//public class UploadDataListener extends AnalysisEventListener<User> {
//    /**
//     * 每隔5条存储数据库，实际使用中可以100条，然后清理list ，方便内存回收
//     */
//    private static final int BATCH_COUNT = 1;
//    private List<User> cachedDataList =new ArrayList<>(BATCH_COUNT);
//    private List<UserRole> cachedDataList2 =new ArrayList<>();
//    /**
//     * 假设这个是一个DAO，当然有业务逻辑这个也可以是一个service。当然如果不用存储这个对象没用。
//     */
//
//    private  UserMapper userMapper;
//    private  UserRoleMapper userRoleMapper;
//    private  PasswordEncoder passwordEncoder;
//
//    public UploadDataListener(UserMapper userMapper, UserRoleMapper userRoleMapper, PasswordEncoder passwordEncoder) {
//        // 这里是demo，所以随便new一个。实际使用如果到了spring,请使用下面的有参构造函数
//        this.userMapper=userMapper;
//        this.userRoleMapper=userRoleMapper;
//        this.passwordEncoder=passwordEncoder;
//        System.out.println("监听器初始化.......");
//    }
//
//    /**
//     * 如果使用了spring,请使用这个构造方法。每次创建Listener的时候需要把spring管理的类传进来
//     *
//     * @param
////     */
////    public UploadDataListener(UploadDAO uploadDAO) {
////        this.uploadDAO = uploadDAO;
////    }
//
//
//
//    /**
//     * 这个每一条数据解析都会来调用
//     *
//     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
//     * @param context
//     */
//    @Override
//    public void invoke(User data, AnalysisContext context) {
//        System.out.println("invoke.....");
//        log.info("解析到一条数据:{}", JSON.toJSONString(data));
//        System.out.println(data+"........");
//        data.setPassword(passwordEncoder.encode("123456"));
//        data.setAvatar("$2a$10$cY7CaTcZ3g10pZtUeEEaE.btF7Vpu1/YGCbWk.c/xdzOOQsQ6Lrpm");
//        data.setIsEnabled(0);
//        data.setIsDeleted(0);
//        userMapper.insert(data);
//        UserRole userRole =new UserRole();
//            userRole.setUid(data.getUid());
//            userRole.setRid("2");
//            userRoleMapper.insert(userRole);
//
////        cachedDataList.add(data);
//        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
////        if (cachedDataList.size() >= BATCH_COUNT) {
////            saveData();
////            // 存储完成清理 list
////            cachedDataList = new ArrayList<>(BATCH_COUNT);
////            cachedDataList2.clear();
////        }
//    }
//
//    /**
//     * 所有数据解析完成了 都会来调用
//     *
//     * @param context
//     */
//    @Override
//    public void doAfterAllAnalysed(AnalysisContext context) {
//        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
//        saveData();
//        log.info("所有数据解析完成！");
//    }
//
//
//
//    /**
//     * 加上存储数据库
//     */
//    private void saveData() {
////        log.info("{}条数据，开始存储数据库！", cachedDataList.size());
//////        System.out.println(doctorMapper+"......");
////        UserRole userRole;
////        userMapper.saveBatch(cachedDataList);
////        for(User user:cachedDataList){
////            userRole=new UserRole();
////            userRole.setUid(user.getUid());
////            userRole.setRid("2");
////            userRoleMapper.insert(userRole);
////        }
////        log.info("存储数据库成功！");
//    }
//}
