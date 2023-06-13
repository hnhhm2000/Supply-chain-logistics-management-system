package cn.fpa.logistics.config.password;


import org.springframework.util.DigestUtils;

import java.util.Objects;
import java.util.UUID;

/**
 * <P>
 * MD5加盐加密
 * </p>

 */

public  class PasswordUtil {
    public  static String getSalt(){
        return UUID.randomUUID().toString();
    }
    public  static String getPassword(String password,String salt){
        return DigestUtils.md5DigestAsHex((password + salt).getBytes());

    }
    public static boolean verify(String password,String salt,String dbPassword){
        String encodedPassword = DigestUtils.md5DigestAsHex((password + salt).getBytes());
        return Objects.equals(encodedPassword,dbPassword);
    }
}
