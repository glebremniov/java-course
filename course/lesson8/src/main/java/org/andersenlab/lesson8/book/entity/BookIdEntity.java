package org.andersenlab.lesson8.book.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class BookIdEntity {

  private String name;
  private String author;

}
