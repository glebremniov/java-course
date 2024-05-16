package org.andersenlab.lesson8.book;

import org.springframework.stereotype.Component;

@Component
public class BookMapper {

  public Book toEntity(BookRequest source) {
    return Book.builder()
        .id(source.id())
        .author(source.author())
        .isbn(source.isbn())
        .build();
  }

}
