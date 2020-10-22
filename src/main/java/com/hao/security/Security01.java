package com.hao.security;


import io.jsonwebtoken.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * 测试
 *
 * @author zrh
 * @version 1.0
 * @date 2020-09-24 11:07
 **/
public class Security01 {
    private final static String apiKey = "daniel#*y3a2n6yunzhiYuanETASPqaOkt40QnqOfjcQ3qwz9dvyk32OfucgXiHNI0FacidHQEunshAnkVeS8nLG0FKDhsvnzhsVWGR5kcCyxNTImwtKiWPi50LuaxpD1zNnN3RMXgmCbOtF8y1LTOWfjSLey111S6aOIif3Bb0uhh1HpiSiwONkVNKMo2gk4HUkkCv7x3AquyrjnwXyyiv5yYLCE2tHQnEVgstSPz8KI1rty8VXpsNTo00IHDCR5fVJ04m9fj2G40elTV7PQIxuPoPAkQFBbu04ZzafnHgIo4WUvNrynrzL3fdOkUEb";
    public final static Long TIME_7_DAY_MILLISECOND = 86400000 * 7L;
    public static String JWT_TOKEN_SUBJECT = "ctarkujm";

    public static void main(String[] args) {
        String str = createJWT("1", "1", JWT_TOKEN_SUBJECT, TIME_7_DAY_MILLISECOND);
        System.out.println(str);

    }

    public static String createJWT(String id, String issuer, String subject,
                                   long ttlMillis) {

        // The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        // We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(apiKey);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes,
                signatureAlgorithm.getJcaName());

        // Let"s set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now)
                .setSubject(subject).setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);

        // if it has been specified, let"s add the expiration
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        // Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    public void passwordEncoder() {
        String password = "123456";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEn = passwordEncoder.encode(password);
        System.out.println(passwordEn);
        boolean matches = new BCryptPasswordEncoder().matches(password, "$2a$10$sfWwd3NfHKMXzkFxuhhsEeaF75T8KpWpp2vJGDrDNnt.GiYylx7BS");
        System.out.println(matches);
    }
}
