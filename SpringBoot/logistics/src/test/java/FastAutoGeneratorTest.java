import com.baomidou.mybatisplus.generator.FastAutoGenerator;

/**
 * <p>
 * 快速生成
 * </p>
 *
 * @author ZSAndroid
 * @create 2021-10-1-10:08
 */
public class FastAutoGeneratorTest {
    public static void main(String[] args) {


        FastAutoGenerator.create("jdbc:mysql://150.158.19.230:3306/save?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true&allowPublicKeyRetrieval=true", "root", "y3361303.")
                .globalConfig(builder -> {
                    builder.author("杨维斌") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("/Users/td/Desktop/logistics/src/main/java/"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("cn.fpa")// 设置父包名
                          .moduleName("logistics"); // 设置父包模块名
//                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("fee"); // 设置需要生成的表名
//                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
