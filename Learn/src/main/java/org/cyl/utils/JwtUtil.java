package org.cyl.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.cyl.pojo.User;

import java.util.Date;

public class JwtUtil {

    // 密钥，用于签名和解密JWT
    private static final String SECRET_KEY = "123456";

    // 生成JWT
    public static String generateToken(User user) {
        return Jwts.builder()
                .claim("username", user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 设置过期时间为1小时
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    // 解析JWT
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
