package org.andersenlab.lesson8.book;

import java.util.UUID;

public record BookRequest(UUID id, String author, String isbn) {

}
