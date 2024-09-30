package com.votingSystem.service;

import com.votingSystem.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Service class for generating and validating JWT tokens.
 * Provides methods to generate tokens and extract claims such as user details from tokens.
 *
 * @author Anand Raj
 */
@Service
public class JwtService {

    private final Environment env;

    /**
     * Constructor that initializes JwtService with environment variables.
     *
     * @param env Environment object to access properties like secret keys.
     */
    public JwtService(Environment env) {
        this.env = env;
    }

    /**
     * Generates a JWT token for a user with claims such as email, userId, name, roleId, and profilePicId.
     * The token is signed using the secret key from application properties.
     *
     * @param user The user object containing information for claims.
     * @return The generated JWT token as a String.
     */
    public String generateJwtToken(User user) {

        System.out.println("Jwt Key " + env.getProperty("jwt.secret_key"));

        long timeout = 1000 * 60 * 60L; // 1 hour
        Date issuedAt = new Date();
        Date expirationAt = new Date(issuedAt.getTime() + timeout);

        // Building and signing the JWT token
        String token = Jwts.builder()
                .setSubject(user.getEmail())
                .claim("userId", user.getUserId())
                .claim("name", user.getName())
                .claim("roleId", user.getRole())
                .claim("profilePicId", user.getProfilePictureId())
                .setIssuedAt(issuedAt)
                .setExpiration(expirationAt)
                .signWith(SignatureAlgorithm.HS256, env.getProperty("jwt.secret_key")) // Signing the token
                .compact();

        System.out.println("Generated Token: " + token);
        return token;
    }

    /**
     * Checks if the given JWT token is expired.
     *
     * @param token The JWT token to check.
     * @return true if the token is expired, false otherwise.
     */
    public boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    /**
     * Extracts all claims from a JWT token.
     *
     * @param token The JWT token to extract claims from.
     * @return Claims object containing the extracted claims.
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(env.getProperty("jwt.secret_key"))  // Using the secret key to validate the token
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * Extracts user details from the JWT token, including userId, name, email, roleId, and profilePicId.
     *
     * @param token The JWT token to extract user details from.
     * @return A map containing user details as key-value pairs.
     */
    public Map<String, String> extractUserDetails(String token) {
        Claims claims = extractAllClaims(token);

        Map<String, String> userDetails = new HashMap<>();
        userDetails.put("userId", claims.get("userId").toString());
        userDetails.put("name", (String) claims.get("name"));
        userDetails.put("email", claims.getSubject());  // Email is the subject
        userDetails.put("roleId", claims.get("roleId").toString());
        userDetails.put("profilePicId", claims.get("profilePicId").toString());

        return userDetails;
    }
}
