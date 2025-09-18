# AI Prompts – Assignment 3

## 🤖 Overview

This document captures selected prompts and AI responses that I used while working on Assignment 3. I used the AI assistant (ChatGPT) to help refactor my Assignment 2 ETL code into a more modular, object-oriented solution. I reviewed all suggestions carefully before incorporating them.

---

### Prompt 1: Initial Refactoring Help

**Prompt**:
> How can I refactor this ETL pipeline Java code to be more object-oriented?

**Excerpt of Response**:
> Break the monolithic class into the following:
> - A `Product` class to represent each row.
> - A `ProductTransformer` to handle business logic.
> - A `CSVReader` and `CSVWriter` for input/output.
> This way, you can apply OOP principles like encapsulation and separation of concerns.

✅ *Used this to decide on my class structure.*

---

### Prompt 2: Designing the Product Class

**Prompt**:
> How should I design a `Product` class in Java to represent a row from a product CSV?

**Excerpt of Response**:
> Create private fields: `id`, `name`, `price`, and `category`, with a constructor and getters/setters. Optionally, include a `toCSVRow()` method to convert it back into a string array.

✅ *Implemented the `Product` class with constructor, accessors, and helper methods.*

---

### Prompt 3: Handling Price Ranges

**Prompt**:
> I need to classify product prices as "Low", "Medium", "High", or "Premium" – what’s the cleanest way?

**Excerpt of Response**:
> Create a `PriceRangeCalculator` class or method that accepts a `BigDecimal` and returns a string label. This isolates the logic and makes it easier to test or change later.

✅ *Created a separate `PriceRangeCalculator` class.*

---

### Prompt 4: Dealing with CSV I/O

**Prompt**:
> Should I separate CSV reading and writing into different classes?

**Excerpt of Response**:
> Yes. Have `CSVReader` handle extraction logic and `CSVWriter` handle loading. This improves single responsibility and makes your code easier to test.

✅ *Used this guidance to write `CSVReader.java` and `CSVWriter.java`.*

---

### Prompt 5: How to write a README and Reflection

**Prompt**:
> Can you help me write a README file and a 1–2 page reflection comparing Assignment 2 and Assignment 3?

**Excerpt of Response**:
> Yes. Here's a template for a README with setup steps, and here’s how you might structure a reflection: start with a comparison, then describe OOP principles used, then explain how you confirmed correctness...

✅ *Used this structure directly for my README and Reflection documents.*

---

### Prompt 6: Final Checklist and Grading Criteria

**Prompt**:
> What do I need to submit for Assignment 3 to match the rubric?

**Excerpt of Response**:
> Ensure the following:
> - All code in `org.howard.edu.lsp.assignment3` package
> - One public class per file with Javadocs
> - `transformed_products.csv` is created correctly
> - Reflection and AI transcripts under `/doc/`
> - Program handles malformed input and missing files

✅ *Used this to confirm submission checklist before final testing.*

---

## 📌 Summary

I used the AI assistant to guide my object-oriented refactoring, class design, and documentation. All AI suggestions were reviewed, adapted, and aligned with the assignment's requirements. The AI helped accelerate the learning process while keeping me in control of the code and design decisions.

