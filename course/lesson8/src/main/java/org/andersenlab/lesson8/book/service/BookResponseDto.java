package org.andersenlab.lesson8.book.service;

import java.time.Instant;
import java.util.UUID;
import org.andersenlab.lesson8.book.dto.BookDto.BookIdDto;

public record BookResponseDto(
    BookIdDto id,
    String isbn,
    Instant createdAt,
    UUID createdBy,
    Instant lastUpdatedAt,
    UUID lastModifiedBy
) {

}
