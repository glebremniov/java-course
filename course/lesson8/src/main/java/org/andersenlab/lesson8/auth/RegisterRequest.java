package org.andersenlab.lesson8.auth;

import org.andersenlab.lesson8.user.Role;

public record RegisterRequest(
    String firstname,
    String lastname,
    String email,
    String password,
    Role role
) {

}
