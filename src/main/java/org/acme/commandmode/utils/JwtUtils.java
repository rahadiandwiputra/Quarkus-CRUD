//package org.acme.commandmode.utils;
//
//import io.smallrye.jwt.algorithm.SignatureAlgorithm;
//import io.smallrye.jwt.build.Jwt;
//import io.smallrye.jwt.build.JwtClaimsBuilder;
//import io.smallrye.jwt.build.impl.JwtBuildUtils;
//import org.eclipse.microprofile.jwt.Claims;
//import org.eclipse.microprofile.jwt.JsonWebToken;
//
//import javax.crypto.spec.SecretKeySpec;
//import javax.inject.Inject;
//import javax.xml.bind.DatatypeConverter;
//import java.security.Key;
//import java.util.Date;
//
//
//public class JwtUtils {
//
//    @Inject
//    public static String generateToken(String role, String username, String secretKey, String issuer){
//        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//        JwtClaimsBuilder claimsBuilder = Jwt.claims();
//
//
//        Long nowMilis = System.currentTimeMillis();
//        Date nowDate = new Date(nowMilis);
//
//        byte[] secretBytes = DatatypeConverter.parseBase64Binary(secretKey);
//        Key signKey = new SecretKeySpec(secretBytes, signatureAlgorithm.getAlgorithm());
//
//        Date exp = new Date(nowMilis + (120 * 60 * 1000));
//
//        return  Jwt.issuer(issuer)
//                .setSubject(username)
//                .setIssuedAt(nowDate)
//                .setExpiration(exp)
//                .claim("role", role)
//                .signWith(signatureAlgorithm, signKey)
//                .compact();
//    }
//
//    public static Claims verifyToken(String secretKey, String token){
//        Jws<Claims> jwsClaim = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
//                .parseClaimsJws(token);
//
//        return jwsClaim.getBody();
//    }
//
//}
