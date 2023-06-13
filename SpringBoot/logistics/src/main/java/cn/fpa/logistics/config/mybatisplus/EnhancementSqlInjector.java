package cn.fpa.logistics.config.mybatisplus;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.extension.injector.methods.InsertBatchSomeColumn;

import java.util.List;

/**
 * @author kwongting
 * @version 1.0
 * @date 2021/6/18 19:54
 * @description 增加批量更新方法
 */
public class EnhancementSqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
        //继承原有方法
        List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);
        //注入批量更新方法
        methodList.add(new InsertBatchSomeColumn());
        return methodList;
    }
}
