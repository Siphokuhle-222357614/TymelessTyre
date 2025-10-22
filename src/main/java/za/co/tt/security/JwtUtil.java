package za.co.tt.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import za.co.tt.domain.User;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.security.Key;

public class JwtUtil {
    // Use a static secret key string (should be at least 256 bits for HS256)
    private static final String SECRET = "tymeless-tyre-super-secret-key-2025-very-long-and-secure";
    private static final Key SECRET_KEY = new SecretKeySpec(
        Base64.getEncoder().encode(SECRET.getBytes()),
        SignatureAlgorithm.HS256.getJcaName()
    );
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    public static String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        String role = user.getRole();
        if (!role.startsWith("ROLE_")) {
            role = "ROLE_" + role;
        }
        claims.put("authorities", java.util.Collections.singletonList(role));
        claims.put("username", user.getUsername());
        claims.put("email", user.getEmail());
        claims.put("userId", user.getUserId());
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + EXPIRATION_TIME))
                .signWith(SECRET_KEY)
                .compact();
    }

    public static boolean validateToken(String token, User user) {
        final String username = getUsernameFromToken(token);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }

    public static String getUsernameFromToken(String token) {
        return extractClaims(token).getSubject();
    }

    public static Date getExpirationDateFromToken(String token) {
        return extractClaims(token).getExpiration();
    }

    public static boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public static io.jsonwebtoken.Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
