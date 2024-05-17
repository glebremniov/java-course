package org.andersenlab.lesson8.book.dto;

public record BookDto(BookIdDto id, String isbn) {

  public record BookIdDto(String author, String name) {

  }
}
