Here are a few ideas for services with simple business logic that are suitable for demonstrating how to write tests using JUnit and Mockito. These examples cover various aspects of testing from verifying return values of methods to mocking dependencies and checking interactions between objects.

### 1. Inventory Management Service

#### Business Logic
- **Add a product to inventory**:
    - Check if the product already exists in inventory.
    - If it exists, increase the quantity.
    - If it does not exist, add a new record.
- **Remove a product from inventory**:
    - Check if enough product is available in inventory for removal.
    - If enough product is available, decrease the quantity.
    - If not enough product is available, throw an exception.

#### Test Scenarios
- Verify adding a product that already exists in inventory.
- Verify adding a new product.
- Verify removing a product when sufficient quantity is available.
- Verify exception handling when insufficient product is available for removal.

### 2. Reservation Service

#### Business Logic
- **Book a hotel room**:
    - Check room availability for the requested dates.
    - If the room is available, book it and return a successful booking status.
    - If the room is not available, return an error status.

#### Test Scenarios
- Verify successful booking of an available room.
- Verify booking attempt of an already occupied room.

### 3. Email Notification Service

#### Business Logic
- **Send an email notification**:
    - Compose the message based on the provided data.
    - Send the message through an SMTP server.
    - Log the result of the sending operation.

#### Test Scenarios
- Verify correct message composition.
- Verify successful message sending.
- Verify handling of SMTP server errors.

### 4. Authentication Service

#### Business Logic
- **Check user permissions**:
    - Retrieve user data from the database.
    - Check if the user has rights to perform the operation.
    - Return `true` or `false`.

#### Test Scenarios
- Verify access for a user with the necessary rights.
- Verify denial of access for a user without rights.

### 5. Delivery Cost Calculation Service

#### Business Logic
- **Calculate delivery cost based on distance**:
    - If the distance is up to 100 km, the cost is 500 units.
    - If the distance is between 100 to 500 km, the cost is 1000 units.
    - If the distance is over 500 km, the cost is 1500 units.

#### Test Scenarios
- Verify cost calculation for various distances.

These service ideas not only help newcomers understand how to use JUnit and Mockito for writing tests but also demonstrate the importance of automated testing in ensuring software quality. When writing tests, you can demonstrate the use of JUnit annotations (`@Test`, `@BeforeEach`, `@AfterEach`, `@Mock`, etc.), mocking dependencies, verifying method calls (using `verify()`), and using assertions to check data correctness.
