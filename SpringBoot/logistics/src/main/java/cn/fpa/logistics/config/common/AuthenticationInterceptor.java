package cn.fpa.logistics.config.common;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Value("${allow.path}")
    private String allowPath;
    @Resource
    RedisTemplate<String,String> redisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String[] allow = allowPath.split(" ");
        String path = request.getRequestURI();
        for(String s:allow){  //当前路径属于放行路段 就放行
          if(path.contains(s))
              return true;
        }
        //其他路径需要验证Token
        String token = request.getHeader("token");
        String userInfo = redisTemplate.opsForValue().get(token);
         if(userInfo==null) {
             res(response, "Token不存在或已过期,请重新登陆"); //拦截 返回;
             return  false;
         }
         return  true;



    }

    private void res(HttpServletResponse response, String errMsg) throws IOException {
        // 允许跨域
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json; charset=utf-8");
       response.getWriter().write(JSON.toJSONString(R.define(false,400,errMsg)));

    }
}
