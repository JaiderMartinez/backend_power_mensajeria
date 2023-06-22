package com.reto.twilio.infrastructure.configurations.security.jwt;

import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import com.reto.twilio.infrastructure.configurations.security.jwt.exceptions.ParseTokenException;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class JwtProvider {

    @Value("${access.token.secret}")
    private String accessTokenSecret;

    public UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            JWT jwt = JWTParser.parse(token);
            JWTClaimsSet claims = jwt.getJWTClaimsSet();
            String email = claims.getSubject();
            List<String> rol = claims.getStringListClaim("rol");
            return new UsernamePasswordAuthenticationToken(email, null,
                    rol.stream().map(SimpleGrantedAuthority::new)
                            .collect(Collectors.toList()));
        } catch (ParseException e) {
            throw new ParseTokenException();
        }
    }

    public boolean isValidToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(this.accessTokenSecret.getBytes()).build().parseClaimsJws(token );
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
