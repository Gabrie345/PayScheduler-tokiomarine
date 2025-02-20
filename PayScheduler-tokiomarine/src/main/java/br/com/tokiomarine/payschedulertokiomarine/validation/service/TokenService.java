package br.com.tokiomarine.payschedulertokiomarine.validation.service;


import br.com.tokiomarine.payschedulertokiomarine.validation.service.model.AccountUserModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static br.com.tokiomarine.payschedulertokiomarine.constants.MessageConstants.ERRO_TOKEN;

@Service
public class TokenService {

    @Value("$api.security.token.secret")
    private String secret;

    public String generateToken(AccountUserModel user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withSubject(user.getCpf())
                    .withIssuer("pay-scheduler")
                    .withExpiresAt(getExpiration())
                    .sign(algorithm);
        }catch (Exception e) {
            throw new RuntimeException(ERRO_TOKEN, e);
         }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("pay-scheduler")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){
            return "";
        }
    }

    private Instant getExpiration() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
