package org.andersenlab.lesson8.book.mapper;

import org.andersenlab.lesson8.book.dto.BookDto;
import org.andersenlab.lesson8.book.entity.BookIdEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookIdMapper {

  BookIdEntity toEntity(BookDto.BookIdDto source);

  BookDto.BookIdDto toDto(BookIdEntity source);

}
