package org.andersenlab.lesson8.book;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

  private final BookRepository repository;
  private final BookMapper mapper;

  public void save(BookRequest request) {
    var book = mapper.toEntity(request);
    repository.save(book);
  }

  public List<Book> findAll() {
    return repository.findAll();
  }
}
