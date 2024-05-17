package org.andersenlab.lesson8.book.repository;

import java.util.List;
import org.andersenlab.lesson8.book.entity.BookEntity;
import org.andersenlab.lesson8.book.entity.BookIdEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, BookIdEntity> {

  List<BookEntity> findAllByIdName(String name);

  List<BookEntity> findAllByIdAuthor(String author);

}
