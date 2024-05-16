package org.andersenlab.lesson8.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.andersenlab.lesson8.token.Token;
import org.andersenlab.lesson8.token.TokenRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {

  private final TokenRepository tokenRepository;

  @Override
  public void logout(
      HttpServletRequest request,
      HttpServletResponse response,
      Authentication authentication
  ) {
    final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    final String jwt;

    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
      return;
    }

    jwt = authHeader.substring(7);
    tokenRepository.findByToken(jwt)
        .map(this::resetFields)
        .map(tokenRepository::save)
        .ifPresent((t) -> SecurityContextHolder.clearContext());
  }

  private Token resetFields(Token token) {
    token.setExpired(true);
    token.setRevoked(true);

    return token;
  }
}
