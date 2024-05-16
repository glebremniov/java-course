package org.andersenlab.lesson8.book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Book {

  @Id
  @GeneratedValue
  private UUID id;
  private String author;
  private String isbn;

  @CreatedDate
  @Column(
      nullable = false,
      updatable = false
  )
  private LocalDateTime createDate;

  @LastModifiedDate
  @Column(insertable = false)
  private LocalDateTime lastModified;


  @CreatedBy
  @Column(
      nullable = false,
      updatable = false
  )
  private Integer createdBy;

  @LastModifiedBy
  @Column(insertable = false)
  private Integer lastModifiedBy;
}
