package com.votingSystem.utilities;

import com.votingSystem.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtUtil {

    @Value("${jwt.secret_key}")
    private String secretKey;


    public String generateJwtToken(User user){

        long timeout = 1000 * 60 * 60L;
        Date issuedAt = new Date();
        Date expirationAt = new Date(issuedAt.getTime() + timeout);

        String token = Jwts.builder()
                .setSubject(user.getEmail())
                .claim("userId", user.getUserId())
                .claim("name", user.getName())
                .claim("roleId", user.getRole())
                .claim("profilePicId", user.getProfilePictureId())
                .setIssuedAt(issuedAt)
                .setExpiration(expirationAt)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        System.out.println("Util Token: " + token);

        return token;
    }

    public boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }


    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)  // Use the same secret key that was used to sign the token
                .parseClaimsJws(token)
                .getBody();
    }



    public Map<String, String> extractUserDetails(String token) {

        Claims claims = extractAllClaims(token);

        Map<String, String> userDetails = new HashMap<>();

        userDetails.put("userId",  claims.get("userId").toString());
        userDetails.put("name", (String) claims.get("name"));
        userDetails.put("email", claims.getSubject());  // email is the subject
        userDetails.put("roleId", claims.get("roleId").toString());
        userDetails.put("profilePicId", claims.get("profilePicId").toString());

        return userDetails;
    }



}
