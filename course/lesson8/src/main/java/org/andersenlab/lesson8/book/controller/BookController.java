package org.andersenlab.lesson8.book.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.andersenlab.lesson8.book.dto.BookDto;
import org.andersenlab.lesson8.book.service.BookResponseDto;
import org.andersenlab.lesson8.book.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

  private final BookService service;

  @PostMapping
  public ResponseEntity<?> save(@RequestBody BookDto request) {
    service.save(request);
    return ResponseEntity.accepted().build();
  }

  @GetMapping
  public ResponseEntity<List<BookResponseDto>> findAllBooks() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{author}/{name}")
  public ResponseEntity<BookResponseDto> findById(@PathVariable String author, @PathVariable String name) {
    return service
        .findById(new BookDto.BookIdDto(author, name))
        .map(ResponseEntity::ok)
        .orElseGet(this::notFound);
  }

  @GetMapping("/{author}")
  public ResponseEntity<List<BookResponseDto>> findAllByAuthor(@PathVariable String author) {
    return ResponseEntity.ok(service.findAllByAuthor(author));
  }

  private <T> ResponseEntity<T> notFound() {
    return ResponseEntity.notFound().build();
  }

}
