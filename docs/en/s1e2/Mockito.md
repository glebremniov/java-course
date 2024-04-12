[..](./README.md)

Mockito is a popular Java library for creating and using mock or fake objects in automated tests. Its primary goal is to simplify test development by providing an intuitive API for simulating object interactions. Here are the main features and functions of Mockito:

### 1. Creating Mocks
- **`mock()`**: Creates a mock of the specified class or interface. For example, `List mockedList = mock(List.class);` will create a mock list.
- **`@Mock`**: Annotation for creating a mock; used with the annotation `@RunWith(MockitoJUnitRunner.class)` or `@ExtendWith(MockitoExtension.class)` for initialization in JUnit 4 and JUnit 5, respectively.

### 2. Defining Mock Behavior
- **`when()`** and **`thenReturn()`**: Define the behavior of a mock when a method is called. For example, `when(mockedList.get(0)).thenReturn("first");` specifies that `"first"` should be returned when `get(0)` is called.
- **`doReturn()`**: An alternative way to specify a return value, which can be used to avoid additional method invocation in `when()`.

### 3. Verifying Interaction with Mocks
- **`verify()`**: Checks that a method was called with specified parameters and a certain number of times. For example, `verify(mockedList).get(0);` ensures that the `get(0)` method was called at least once.
- **`times()`**, **`never()`**: With `verify()`, you can specify the number of calls: `verify(mockedList, times(1)).get(0);` checks that `get(0)` was called exactly once.

### 4. Exceptions and Their Handling
- **`when()`** and **`thenThrow()`**: Define an exception that should be thrown by a method. For example, `when(mockedList.get(0)).thenThrow(new RuntimeException());` will cause an exception when `get(0)` is called.

### 5. Parameterized Imitation
- **`any()`**, **`eq()`**, **`anyInt()`**, and others: These methods from the `Matchers` class (in Mockito 1.x and 2.x) or from `ArgumentMatchers` (in Mockito 3.x) are used to set flexible rules in `when()` and `verify()` for method parameters.

### 6. Spies
- **`spy()`**: Creates a "spy" around a real object, allowing calls to its methods to be intercepted while maintaining the default original behavior. For example, `List list = new LinkedList(); List spyList = spy(list);` creates a spy around the actual list.
- **`doReturn()`** in the context of a spy can be used to change behavior without calling the original method.

### 7. Detailed Logging and Debugging
- **`Mockito.debug()`**: Aids in debugging by providing detailed information about mocks and their calls.

### 8. Compatibility with JUnit
- Mockito is perfectly compatible with JUnit, allowing for the creation of complex test scenarios using mocks to isolate the components being tested from their dependencies.

### 9. Annotations for Simplified Testing
- **`@InjectMocks`**: Creates instances of classes, automatically injecting mocks or spies into the test object.
- **`@Captor`**: Annotation for creating an `ArgumentCaptor` instance, which captures arguments passed into methods for subsequent checks.

### 10. Enhanced Integration
- Support for built-in extensions for JUnit 5 through the `MockitoExtension` module, making Mockito annotations (`@Mock`, `@Spy`, `@Captor`, `@InjectMocks`) first-class citizens in JUnit 5 tests.

Using Mockito significantly simplifies the process of creating reliable modular tests, providing developers with flexible tools for simulating complex interactions in software.
