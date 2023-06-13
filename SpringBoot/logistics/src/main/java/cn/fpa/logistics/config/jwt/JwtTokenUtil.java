package cn.fpa.logistics.config.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Component
public class JwtTokenUtil {
    private static  String tokenSignKey = "123456";
    static final String CLAIM_KEY_USERNAME = "sub";
    static final String CLAIM_KEY_AUDIENCE = "audience";
    static final String CLAIM_KEY_CREATED = "created";

    private static final String AUDIENCE_UNKNOWN = "unknown";
    private static final String AUDIENCE_WEB = "web";
    private static final String AUDIENCE_MOBILE = "mobile";
    private static final String AUDIENCE_TABLET = "tablet";

    public String getPhoneNumberFromToken(String token) {
        String phoneNumber;
        try {
            final Claims claims = getClaimsFromToken(token);
            phoneNumber = claims.getSubject();
        } catch (Exception e) {
           phoneNumber = null;
        }
        return phoneNumber;
    }

    public Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            //得到token的有效期
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    public String getAudienceFromToken(String token) {
        String audience;
        try {
            final Claims claims = getClaimsFromToken(token);
            audience = (String) claims.get(CLAIM_KEY_AUDIENCE);
        } catch (Exception e) {
            audience = null;
        }
        return audience;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(tokenSignKey)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    //设置过期时间
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() +1000*60*30);//30分钟
//        return new Date(30 * 24 * 60);
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    // Device用户检测当前用户的设备，用不到的话可以删掉（使用这个需要添加相应的依赖）
//    private String generateAudience(Device device) {
//        String audience = AUDIENCE_UNKNOWN;
//        if (device.isNormal()) {
//            audience = AUDIENCE_WEB;
//        } else if (device.isTablet()) {
//            audience = AUDIENCE_TABLET;
//        } else if (device.isMobile()) {
//            audience = AUDIENCE_MOBILE;
//        }
//        return audience;
//    }

    private Boolean ignoreTokenExpiration(String token) {
        String audience = getAudienceFromToken(token);
        return (AUDIENCE_TABLET.equals(audience) || AUDIENCE_MOBILE.equals(audience));
    }

    public String generateToken(String phoneNumber) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, phoneNumber);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    /**
     * 生成token（最关键）
     * @param claims
     * @return
     */
    String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)  //设置声明信息（用户名等）
                .setExpiration(generateExpirationDate()) //设置过期时间
                .signWith(SignatureAlgorithm.HS512, tokenSignKey) //设置签名
                .compact();
    }

    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        final Date created = getCreatedDateFromToken(token);
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
                && (!isTokenExpired(token) || ignoreTokenExpiration(token));
    }

    public String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED, new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

//    //TODO,验证当前的token是否有效
//    public Boolean validateToken(String token, UserDetails userDetails) {
//        JwtUserDetails user = (JwtUserDetails) userDetails;
//        final String phoneNumber = getPhoneNumberFromToken(token);
//        final Date created = getCreatedDateFromToken(token);
//        return (phoneNumber.equals(user.getPhoneNumber())&& !isTokenExpired(token));
//    }
}


