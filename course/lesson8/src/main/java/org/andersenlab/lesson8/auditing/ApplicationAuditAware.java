package org.andersenlab.lesson8.auditing;

import java.util.Optional;
import java.util.UUID;
import org.andersenlab.lesson8.user.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

public class ApplicationAuditAware implements AuditorAware<UUID> {

  @Override
  public Optional<UUID> getCurrentAuditor() {
    var authentication =
        SecurityContextHolder
            .getContext()
            .getAuthentication();
    if (authentication == null ||
        !authentication.isAuthenticated() ||
        authentication instanceof AnonymousAuthenticationToken
    ) {
      return Optional.empty();
    }

    var userPrincipal = (User) authentication.getPrincipal();
    return Optional.ofNullable(userPrincipal.getId());
  }
}
