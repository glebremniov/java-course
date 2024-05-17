package org.andersenlab.lesson8.book.mapper;

import org.andersenlab.lesson8.book.dto.BookDto;
import org.andersenlab.lesson8.book.entity.BookEntity;
import org.andersenlab.lesson8.book.service.BookResponseDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = BookIdMapper.class,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface BookMapper {

  BookEntity toEntity(BookDto source);

  BookResponseDto toDto(BookEntity source);

}
