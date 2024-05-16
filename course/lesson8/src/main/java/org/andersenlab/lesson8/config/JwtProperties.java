package org.andersenlab.lesson8.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application.security.jwt")
public record JwtProperties(
    String secretKey, long expiration,
    RefreshToken refreshToken) {

  record RefreshToken(long expiration) {

  }
}
