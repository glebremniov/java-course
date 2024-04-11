package examples.assertj;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.atIndex;
import static org.assertj.core.api.Assertions.tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Collection Assertions with AssertJ")
class CollectionAssertionsTest {

  @Nested
  @DisplayName("Basic Collection Assertions")
  class BasicCollectionAssertions {

    @Test
    @DisplayName("Test presence and absence of elements")
    public void whenCheckingListContent_thenCorrect() {
      List<String> actualCountries = Arrays.asList("USA", "Canada", "France", "Germany");

      assertThat(actualCountries)
          .isNotEmpty()
          .hasSize(4)
          .contains("USA", "Canada")
          .containsExactly("USA", "Canada", "France", "Germany")
          .containsExactlyInAnyOrder("Germany", "France", "USA", "Canada")
          .doesNotContain("Lithuania");
    }

    @Test
    @DisplayName("Test collection for specific conditions")
    public void whenCheckingConditionsForElements_thenCorrect() {
      List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

      assertThat(numbers)
          .allMatch(n -> n > 0, "all numbers are positive")
          .noneMatch(n -> n < 0)
          .areAtLeastOne(new Condition<>(n -> n % 2 == 0, "at least one element is even"));
    }
  }

  @Nested
  @DisplayName("Advanced Collection Assertions")
  class AdvancedCollectionAssertions {

    @Test
    @DisplayName("Test collections with special conditions")
    public void whenCheckingSpecialCollections_thenCorrect() {
      List<Object> emptyList = new ArrayList<>();
      List<Double> marks = Arrays.asList(20.0, 15.5, 18.0);

      assertThat(emptyList).isEmpty();

      assertThat(marks)
          .hasSize(3)
          .doesNotContain(10.0);
    }

    @Test
    @DisplayName("Test element presence by index and filter results")
    public void whenCheckingElementBasedOnIndex_thenCorrect() {
      List<String> techCompanies = Arrays.asList("Google", "Apple", "Microsoft", "Amazon");
      List<String> names = Arrays.asList("John", "Jane", "Tomas", "Diana");

      assertThat(techCompanies)
          .contains("Google", atIndex(0))
          .contains("Apple", atIndex(1));

      assertThat(names)
          .filteredOn(name -> name.contains("a"))
          .containsOnly("Jane", "Tomas", "Diana");
    }
  }

  @Nested
  @DisplayName("Extracting Examples")
  class ExtractingExamples {

    @Test
    @DisplayName("Use extracting to test multiple fields")
    public void whenUsingExtracting_thenCorrect() {
      class Person {

        private final String name;
        private final int age;

        Person(String name, int age) {
          this.name = name;
          this.age = age;
        }

        String getName() {
          return name;
        }

        int getAge() {
          return age;
        }
      }

      List<Person> people = Arrays.asList(
          new Person("John", 30),
          new Person("Jane", 25)
      );

      assertThat(people)
          .extracting(Person::getName)
          .containsOnly("John", "Jane");

      assertThat(people)
          .extracting("name", "age")
          .contains(
              tuple("John", 30),
              tuple("Jane", 25)
          );
    }
  }
}
