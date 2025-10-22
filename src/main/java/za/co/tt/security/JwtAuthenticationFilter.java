package za.co.tt.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import za.co.tt.domain.User;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final CustomUserDetailsService userDetailsService;

    @Autowired
    public JwtAuthenticationFilter(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            try {
                username = JwtUtil.getUsernameFromToken(token);
            } catch (Exception e) {
                // Invalid token
            }
        }
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Load user details using UserDetailsService
            UserDetails userDetails = null;
            try {
                userDetails = userDetailsService.loadUserByUsername(username);
            } catch (Exception e) {
                // User not found or error
            }
            if (userDetails != null && JwtUtil.validateToken(token, ((CustomUserDetails) userDetails).getUser())) {
                // Extract authorities from JWT
                java.util.List<?> authoritiesList = JwtUtil.extractClaims(token).get("authorities", java.util.List.class);
                java.util.List<org.springframework.security.core.authority.SimpleGrantedAuthority> authorities = new java.util.ArrayList<>();
                if (authoritiesList != null) {
                    for (Object auth : authoritiesList) {
                        authorities.add(new org.springframework.security.core.authority.SimpleGrantedAuthority(auth.toString()));
                    }
                }
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, authorities
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
