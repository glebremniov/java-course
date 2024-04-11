package examples.assertj;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Date and Time Assertions with AssertJ")
class DateTimeAssertionsTest {

  @Nested
  @DisplayName("LocalDate Assertions")
  class LocalDateAssertions {

    @Test
    @DisplayName("Assert specific LocalDate properties")
    public void testLocalDateProperties() {
      LocalDate dateOfBirth = LocalDate.of(1980, Month.MAY, 20);

      assertThat(dateOfBirth)
          .isBefore(LocalDate.now())
          .isAfter(LocalDate.of(1970, Month.JANUARY, 1))
          .isEqualTo("1980-05-20");

      assertThat(dateOfBirth.getYear()).isEqualTo(1980);
      assertThat(dateOfBirth.getMonth()).isEqualTo(Month.MAY);
      assertThat(dateOfBirth.getDayOfMonth()).isEqualTo(20);
    }
  }

  @Nested
  @DisplayName("LocalTime Assertions")
  class LocalTimeAssertions {

    @Test
    @DisplayName("Assert specific LocalTime properties")
    public void testLocalTimeProperties() {
      LocalTime meetingTime = LocalTime.of(13, 30, 15);

      assertThat(meetingTime)
          .isBefore(LocalTime.of(14, 0, 0))
          .isAfter(LocalTime.of(13, 0, 0))
          .isEqualToIgnoringSeconds(LocalTime.of(13, 30, 0));

      assertThat(meetingTime.getHour()).isEqualTo(13);
      assertThat(meetingTime.getMinute()).isEqualTo(30);
      assertThat(meetingTime.getSecond()).isEqualTo(15);
    }
  }

  @Nested
  @DisplayName("LocalDateTime Assertions")
  class LocalDateTimeAssertions {

    @Test
    @DisplayName("Assert specific LocalDateTime properties")
    void testLocalDateTimeProperties() {
      LocalDateTime firstMoment = LocalDateTime.of(2021, Month.JANUARY, 1, 0, 0, 0);

      assertThat(firstMoment)
          .isBefore(LocalDateTime.now())
          .isBetween("2020-01-01T00:00:00", "2024-01-01T00:00:00")
          .isEqualTo("2021-01-01T00:00:00");

      assertThat(firstMoment.getYear()).isEqualTo(2021);
      assertThat(firstMoment.getMonthValue()).isEqualTo(1);
      assertThat(firstMoment.getDayOfMonth()).isEqualTo(1);
      assertThat(firstMoment.getHour()).isEqualTo(0);
      assertThat(firstMoment.getMinute()).isEqualTo(0);
      assertThat(firstMoment.getSecond()).isEqualTo(0);
    }
  }

  @Nested
  @DisplayName("ZonedDateTime Assertions")
  class ZonedDateTimeAssertions {

    @Test
    @DisplayName("Assert specific ZonedDateTime properties")
    public void testZonedDateTimeProperties() {
      ZonedDateTime zonedDateTime = ZonedDateTime.of(1999, 12, 31, 23, 59, 59, 0, ZoneId.of("UTC"));

      assertThat(zonedDateTime)
          .isBefore(ZonedDateTime.now())
          .isAfter(ZonedDateTime.of(1990, 1, 1, 0, 0, 0, 0, ZoneId.of("UTC")))
          .isEqualTo("1999-12-31T23:59:59Z[UTC]");

      assertThat(zonedDateTime.getZone().getId())
          .isEqualTo("UTC");
      assertThat(zonedDateTime.getYear())
          .isEqualTo(1999);
      assertThat(zonedDateTime.getMonthValue())
          .isEqualTo(12);
      assertThat(zonedDateTime.getDayOfMonth())
          .isEqualTo(31);
      assertThat(zonedDateTime.getHour())
          .isEqualTo(23);
      assertThat(zonedDateTime.getMinute())
          .isEqualTo(59);
      assertThat(zonedDateTime.getSecond())
          .isEqualTo(59);
    }
  }
}
