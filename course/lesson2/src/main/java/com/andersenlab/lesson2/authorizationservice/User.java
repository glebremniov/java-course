package com.andersenlab.lesson2.authorizationservice;

import java.util.EnumSet;
import java.util.UUID;

public record User(UUID id, EnumSet<Operation> allowedOperations) {

}
