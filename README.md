# Week 1 - Advanced Java and Core Foundations

This is a beginner-friendly version of the Week 1 labs. It still covers generics, collections, exceptions, files, and concurrency, but the code avoids advanced frameworks and keeps the examples easy to read.

## How to Run

```bash
mvn compile exec:java -Dexec.mainClass=com.java.backend.Main
```

If your Maven setup does not have the exec plugin, run `Main.java` from IntelliJ.

## Lab 1.1 - Generics and Collections

Files:

- `Product`
- `WarehouseStore`
- `InventoryLab`
- `GenericConstraintExample`

What it shows:

- `WarehouseStore<T extends Product>` only accepts Product objects or classes that extend Product.
- `ArrayList`, `LinkedList`, `HashSet`, and `TreeSet` are filled with 1,000 products.
- Each collection is timed for insert, lookup, and iteration.
- A comparator sorts products by category ascending, then price descending.

Generic compile-time check:

```java
WarehouseStore<Product> goodStore = new WarehouseStore<>();

// This does not compile because String is not a Product:
// WarehouseStore<String> badStore = new WarehouseStore<>();
```
### **Exercise 1.2 – Collections Comparison**

## Collections Tested

1. ArrayList
2. LinkedList
3. HashSet
4. TreeSet

## **Benchmark Operations**

1. Insertion
2. Lookup
3. Iteration
 
Collection findings:

- `ArrayList` is usually a good default when you need ordered items and fast iteration.
  
  Insertion time: 3049600 ns
  Lookup time: 30700 ns
  Iteration time: 239600 ns
- 
- `LinkedList` is not usually faster for normal product lists.
- 
-  Insertion time: 532300 ns
   Lookup time: 27400 ns
   Iteration time: 350700 ns
- 
- `HashSet` is usually best when checking if a product already exists.
- 
-  Insertion time: 385200 ns
   Lookup time: 8000 ns
   Iteration time: 49000 ns
- 
- `TreeSet` keeps products sorted, but it has extra sorting cost.
- 
-  Insertion time: 3095400 ns
   Lookup time: 11100 ns
   Iteration time: 712400 ns

For a recently viewed products feature, a `LinkedList` or `ArrayList` can work. In this beginner version, `ArrayList` is the easiest choice because recently viewed products are usually shown in order and the list is small.

## Lab 1.2 - Exception Handling

Files:

- `Account`
- `TransactionService`
- `TransactionException`
- `InsufficientFundsException`
- `FraudDetectedException`
- `DataAccessException`
- `CsvTransactionProcessor`
- `ParseError`
- `BankingLab`

What it shows:

- Checked exceptions for business problems like failed transactions.
- Exception chaining by wrapping a `SQLException` inside `DataAccessException`.
- Simple transaction ID logging with `System.out`.
- Try-with-resources when reading and writing CSV files.
- Bad CSV rows are collected instead of stopping the whole file.

Output files are written to:

```text
target/lab-output/
```

## Lab 1.3 - Java Concurrency

Files:

- `Order`
- `OrderBook`
- `MatchResult`
- `ConcurrencyLab`

What it shows:

- Buy and sell orders are stored in `ConcurrentLinkedQueue`.
- `ReentrantLock` protects the matching step.
- 10 buyer threads and 10 seller threads add orders.
- The lab checks that no orders are lost.
- `ExecutorService` runs the same idea with a fixed thread pool.
- `Future<MatchResult>` is used to collect matching results.

This version is intentionally simple. It is meant for learning the ideas before adding production tools like JUnit, SLF4J, Logback, databases, or more complex matching rules.
