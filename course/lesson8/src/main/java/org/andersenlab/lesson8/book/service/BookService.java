package org.andersenlab.lesson8.book.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.andersenlab.lesson8.book.dto.BookDto;
import org.andersenlab.lesson8.book.mapper.BookIdMapper;
import org.andersenlab.lesson8.book.mapper.BookMapper;
import org.andersenlab.lesson8.book.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

  private final BookRepository repository;
  private final BookMapper bookMapper;
  private final BookIdMapper bookIdMapper;

  public void save(BookDto request) {
    var book = bookMapper.toEntity(request);
    repository.save(book);
  }

  public List<BookResponseDto> findAll() {
    return repository.findAll()
        .stream()
        .map(bookMapper::toDto)
        .toList();
  }

  public Optional<BookResponseDto> findById(BookDto.BookIdDto id) {
    Objects.requireNonNull(id);

    return Optional.of(id)
        .map(bookIdMapper::toEntity)
        .flatMap(repository::findById)
        .map(bookMapper::toDto);
  }
}
