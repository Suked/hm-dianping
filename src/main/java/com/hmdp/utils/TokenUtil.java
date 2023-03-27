package com.hmdp.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hmdp.entity.User;

public class TokenUtil {

    public static String getToken(User user){
        String token = null;
        try {
            token = JWT.create().withAudience(String.valueOf(user.getId()))
                    .sign(Algorithm.HMAC256(user.getPassword()));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (JWTCreationException e) {
            e.printStackTrace();
        }
        return token;
    }

    public static DecodedJWT checkToken(User user, String token){
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(user.getPassword()))
                    .withAudience(String.valueOf(user.getId())).build();
            jwt = verifier.verify(token);
        } catch (JWTVerificationException e) {
            e.printStackTrace();
        }
        return jwt;
    }
}
