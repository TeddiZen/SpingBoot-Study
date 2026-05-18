package org.example.tliastest.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtils {

    // 密钥（和你测试类里保持一致即可，这里用示例值）
    private static final String SECRET_KEY = "m9ZpR7xQ2sL4kG6hJ8fD0bT1cV3nB5vX7aS9dF2gH4jK6lL8pP0rT2qW4eY6uI8oO0iU2eR4tF6yD7sF5gH4jK2lL1zX9cV8bN7mM6pP5oO4iU3yT2sR1eW3qW4eY6uI8oO0iU2eR4tF6yD7sF5gH4jK2lL1zX9cV8bN7mM6pP5oO4iU3yT2sR1eW3q";
    // 过期时间：12小时（单位：毫秒）
    private static final long EXPIRE_TIME = 12 * 60 * 60 * 1000;

    // 生成签名密钥
    private static SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 生成JWT令牌
     * @param claims 自定义载荷数据（比如用户id、用户名等）
     * @return JWT字符串
     */
    public static String generateToken(Map<String, Object> claims) {
        Date now = new Date();
        Date expireDate = new Date(now.getTime() + EXPIRE_TIME);

        return Jwts.builder()
                .setClaims(claims)       // 自定义数据
                .setIssuedAt(now)        // 签发时间
                .setExpiration(expireDate) // 过期时间
                .signWith(getSigningKey(), SignatureAlgorithm.HS256) // 签名算法
                .compact();
    }

    /**
     * 解析JWT令牌
     * @param token JWT字符串
     * @return 解析后的Claims（包含自定义数据）
     */
    public static Claims parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}