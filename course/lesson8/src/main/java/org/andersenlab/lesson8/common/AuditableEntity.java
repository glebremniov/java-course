package org.andersenlab.lesson8.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.time.Instant;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Getter
@Setter
@MappedSuperclass
public abstract class AuditableEntity {

  @CreatedDate
  @Column(
      name = "created_at",
      nullable = false,
      updatable = false
  )
  private Instant createdAt;

  @LastModifiedDate
  @Column(name = "last_modified_at", insertable = false)
  private Instant lastUpdatedAt;

  @CreatedBy
  @Column(
      name = "created_by",
      nullable = false,
      updatable = false
  )
  private UUID createdBy;

  @LastModifiedBy
  @Column(name = "last_modified_by", insertable = false)
  private UUID lastModifiedBy;

}
