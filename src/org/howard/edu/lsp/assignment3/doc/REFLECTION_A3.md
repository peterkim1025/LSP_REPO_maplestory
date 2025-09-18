# Reflection – Assignment 3
Command to run the program:
javac -d bin src/org/howard/edu/lsp/assignment3/*.java
java -cp bin org.howard.edu.lsp.assignment3.ETLDriver 
## 🔄 Comparison: Assignment 2 vs Assignment 3

### ✅ What Is Different About the Design?

In Assignment 2, my ETL pipeline was implemented as a single monolithic `ETLPipeline.java` class. While it worked functionally, all logic — reading the file, transforming data, and writing output — was tightly coupled in the `main()` method. This made the code harder to test, debug, and extend.

In contrast, Assignment 3 breaks the code into multiple well-defined classes with **single responsibilities**:
- `CSVReader` – responsible for reading and validating input.
- `Product` – represents individual products with data encapsulation.
- `ProductTransformer` – applies transformation logic.
- `PriceRangeCalculator` – encapsulates price range logic.
- `CSVWriter` – writes the final transformed output.
- `ETLDriver` – coordinates the flow between components.

This modularity not only improves clarity and reusability, but also aligns with object-oriented design principles.

---

### 🧱 How Is Assignment 3 More Object-Oriented?

Assignment 3 adopts object-oriented design in the following key ways:

- **Decomposition into classes**: Each class has a clear role in the ETL pipeline. There is no longer a "god class".
- **Encapsulation**: Data like product attributes (`id`, `name`, `price`, `category`) are encapsulated within the `Product` class with proper constructors and getter/setter access.
- **Abstraction**: The transformation logic is hidden behind the `ProductTransformer` class, which abstracts the process of modifying product data.
- **Flexibility**: If transformation rules change (e.g., a new price rule for "Furniture"), I only need to update `ProductTransformer`, without affecting the rest of the pipeline.

---

### 🧠 Which OO Concepts Were Used?

| OO Concept       | How It Was Used                                                             |
|------------------|------------------------------------------------------------------------------|
| **Object**        | `Product` instances model individual records with fields like `price`, etc. |
| **Class**         | Each major concern is handled by a separate class.                          |
| **Encapsulation** | Product fields are private; access is through public methods.               |
| **Abstraction**   | Users of `CSVReader` and `ProductTransformer` don’t worry about internals.  |
| **Polymorphism**  | Not used in this version, but the design allows extension (e.g., different Transformers). |
| **Inheritance**   | Not explicitly used, but could be applied if we extend to multiple product types. |

---

### ✅ How I Confirmed Correctness

To confirm that Assignment 3 performs identically to Assignment 2, I followed these steps:

1. **Used the same input file** (`data/products.csv`) for both versions.
2. **Ran both programs** and compared the output CSV files byte-for-byte and content-wise.
3. **Verified edge cases**:
   - ✅ Missing input file → produces error message.
   - ✅ Empty input file → writes just the header to output.
   - ✅ Malformed/invalid lines → are skipped with a warning.
4. **Manual Testing**:
   - Verified that name capitalization, price discounts, and category reassignment match expected results.
   - Tested different price points to confirm `PriceRange` is calculated correctly.

The outputs of Assignment 3 were **identical** to Assignment 2 for all inputs, while the codebase is now modular, readable, and easier to maintain.

---

## 📌 Summary

Assignment 3 gave me hands-on experience with **refactoring procedural code into an object-oriented system**. It deepened my understanding of class design, data encapsulation, and the importance of modularity. It also made debugging and testing significantly easier, and the code is now extensible for future feature additions.

