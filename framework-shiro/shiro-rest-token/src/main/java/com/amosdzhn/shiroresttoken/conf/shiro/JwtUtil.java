package com.amosdzhn.shiroresttoken.conf.shiro;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public abstract class JwtUtil {
    private static final long EXPIRE_TIME = 30*60*1000;


    // 验证
    public static boolean verify(String token,String username,String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username",username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }


    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }


    public static String sign(String username, String secret) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        // 附带username信息
        return JWT.create()
                .withClaim("username", username)
                .withExpiresAt(date)
                .sign(algorithm);

    }

    public static void main(String[] args) {
        String username = "zhangsan";
        String password = "123456";

        String token = sign(username,password);
        System.out.println("token: " + token);

        String getUn = getUsername(token);
        System.out.println("getUsername : " + getUn);

        boolean verify = verify(token, "123", password);
        System.out.println("验证是否成功 = " + verify);
    }


}
