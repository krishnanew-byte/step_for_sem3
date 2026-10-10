# STEP SEM-3 · CodInClub | Powered by BridgeLabz
## Category C: Part B & Part C Solutions and Explanations

---

# Part B — Quiz Questions and Answers

### Q1. Consider two String objects, s1 and s2, created as follows:
```java
String s1 = new String("hello");
String s2 = new String("hello");
```
**Which of the following statements is true regarding the comparison of s1 and s2 in Java?**
- A. `s1 == s2` is true, and `s1.equals(s2)` is true.
- B. `s1 == s2` is false, and `s1.equals(s2)` is false.
- C. `s1 == s2` is true, and `s1.equals(s2)` is false.
- D. `s1 == s2` is false, and `s1.equals(s2)` is true.

**Answer:** **D. `s1 == s2` is false, and `s1.equals(s2)` is true.**
**Explanation:** The `new` keyword explicitly creates two distinct objects in the heap memory at different addresses, so reference equality `==` evaluates to `false`. However, the `String.equals()` method compares the character sequence, which is `"hello"` for both, returning `true`.

---

### Q2. Given the following sequence of operations on a StringBuilder object:
```java
StringBuilder sb = new StringBuilder();
sb.append("Java");
sb.append(" Lab");
sb.reverse();
```
**What will be the content of the StringBuilder object sb after these operations?**
- A. `"Java Lab"`
- B. `"baL avaJ"`
- C. `"Lab Java"`
- D. `"avaL baJ"`

**Answer:** **B. `"baL avaJ"`**
**Explanation:** Appending `"Java"` and `" Lab"` produces `"Java Lab"`. Calling `reverse()` reverses the entire character sequence, yielding `"baL avaJ"`.

---

### Q3. Consider a Student class with the following constructors:
```java
class Student {
    String name;
    String department;
    public Student() {
        this("Unknown", "Not assigned");
    }
    public Student(String name) {
        this(name, "Not assigned");
    }
    public Student(String name, String department) {
        this.name = name;
        this.department = department;
    }
}
```
**If the following code is executed:**
`Student s = new Student("Ravi");`
**Which constructor will be directly called by `new Student("Ravi")`?**
- A. `public Student()`
- B. `public Student(String name)`
- C. `public Student(String name, String department)`
- D. The code will result in a compile-time error due to ambiguity.

**Answer:** **B. `public Student(String name)`**
**Explanation:** Passing a single `String` argument matches the signature of `public Student(String name)` directly. Although it delegates internally to `this(name, "Not assigned")`, the directly invoked constructor is `public Student(String name)`.

---

### Q4. Consider a Wallet class with a balance field and an add(int amount) method. If w1 and w2 are Wallet reference variables, and the following operations occur:
```java
Wallet w1 = new Wallet(500);
Wallet w2 = w1;
w2.add(200);
```
**What will be the balance seen through w1 and w2 after `w2.add(200)` is executed?**
- A. w1 balance: 500, w2 balance: 700
- B. w1 balance: 700, w2 balance: 500
- C. w1 balance: 500, w2 balance: 500
- D. w1 balance: 700, w2 balance: 700

**Answer:** **D. w1 balance: 700, w2 balance: 700**
**Explanation:** `w2 = w1` copies the reference pointing to the single `Wallet` instance on the heap. Modifying the state via `w2.add(200)` alters the object that both `w1` and `w2` reference.

---

### Q5. Consider a Visitor class that tracks the total number of visitors using a static variable count:
```java
class Visitor {
    private static int count = 0;
    private String name;
    public Visitor(String name) {
        this.name = name;
        count++; // Increment the shared counter
    }
    public static int getTotalVisitors() {
        return count;
    }
}
```
**If three Visitor objects are created:**
```java
new Visitor("Asha");
new Visitor("Ravi");
new Visitor("Neha");
```
**What will be the value returned by `Visitor.getTotalVisitors()` after these objects are created?**
- A. 0
- B. 1
- C. 3
- D. Undefined, as static variables require an object instance.

**Answer:** **C. 3**
**Explanation:** Static fields are shared across all instances of a class. Each constructor execution increments `count` by 1. Three objects result in `count = 3`.

---

### Q6. Consider an integer array named scores with elements [45, 78, 92, 60, 85]. If you iterate through this array using a standard for loop from index 0 to scores.length - 1 and print each element:
```java
int[] scores = {45, 78, 92, 60, 85};
for (int i = 0; i < scores.length; i++) {
    System.out.print(scores[i] + " ");
}
```
**What will be the output?**
- A. 45 78 92 60 85
- B. 85 60 92 78 45
- C. 45 78 92 60
- D. Error: Index out of bounds.

**Answer:** **A. 45 78 92 60 85**
**Explanation:** The loop iterates sequentially from index 0 to 4 (`scores.length - 1`), printing each element followed by a space in original order.

---

### Q7. Analyze the following for loop in Java:
```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue;
    }
    System.out.print(i + " ");
}
```
**What will be the output when this code segment is executed?**
- A. 1 2 3 4 5
- B. 1 2 4 5
- C. 3
- D. 1 2

**Answer:** **B. 1 2 4 5**
**Explanation:** When `i == 3`, the `continue` statement skips the rest of the loop body for that iteration and proceeds directly to `i++`.

---

### Q8. Consider the following Java code snippet:
```java
class MyClass {
    public static void change(int n) {
        n = 10;
    }
    public static void main(String[] args) {
        int x = 5;
        change(x);
        System.out.println(x);
    }
}
```
**What will be printed to the console when the main method is executed?**
- A. 5
- B. 10
- C. 0
- D. An error will occur because n is not initialized.

**Answer:** **A. 5**
**Explanation:** Java is strictly pass-by-value. The primitive value `5` is copied into parameter `n`. Changing `n = 10` inside the method does not affect the caller's variable `x`.

---

### Q9. Consider the following Java code:
```java
int total = 250;
double count = 3;
double avg = total / count;
System.out.println(avg);
```
**What will be the output when this code is executed?**
- A. 83
- B. 83.0
- C. 83.33333333333333
- D. 83.33

**Answer:** **C. 83.33333333333333**
**Explanation:** In `total / count`, since `count` is a `double`, numeric promotion promotes `total` to `double` (`250.0 / 3.0`), resulting in standard floating-point division `83.33333333333333`.

---

### Q10. Consider a Payment abstract class with an abstract method pay() and a Card subclass that extends Payment and overrides the pay() method to include a 2% fee.
```java
abstract class Payment {
    abstract void pay(double amount);
}
class Card extends Payment {
    @Override
    void pay(double amount) {
        double fee = amount * 0.02;
        System.out.println("Paid " + (amount + fee) + " by card");
    }
}
// If executed:
Payment p = new Card();
p.pay(500);
```
**What will be the output?**
- A. Paid 500.0 by card
- B. Paid 510.0 by card
- C. Error: Cannot instantiate abstract class Payment.
- D. Error: Payment class does not have a concrete pay method.

**Answer:** **B. Paid 510.0 by card**
**Explanation:** Polymorphism dynamically dispatches `pay(500)` to `Card.pay()`. The fee is `500 * 0.02 = 10.0`, resulting in `510.0`.

---

### Q11. Consider the following Java code snippet:
```java
String name = "java";
String upperName = name.toUpperCase();
```
**Which of the following statements accurately describes the state of the name object after the toUpperCase() method call, based on Java's String immutability?**
- A. The name object's value changes to "JAVA".
- B. The name object's value remains "java", and a new String object "JAVA" is created for upperName.
- C. Both name and upperName refer to the same new String object "JAVA".
- D. The original name object is destroyed, and a new one is created.

**Answer:** **B. The name object's value remains "java", and a new String object "JAVA" is created for upperName.**
**Explanation:** Strings in Java are immutable; their internal character data cannot be altered after creation. Any method modifying a String produces and returns a brand-new String object.

---

### Q12. Given the Java code snippet and the conceptual object diagram, how many String objects are created in memory, considering the String pool?
```java
String s1 = "hello";
String s2 = "hello";
String s3 = new String("hello");
```
- A. 1
- B. 2
- C. 3
- D. 0

**Answer:** **B. 2**
**Explanation:** 
1. `s1` references the literal `"hello"` created in the String Constant Pool (1 object).
2. `s2` reuses the pooled `"hello"` (0 new objects).
3. `new String("hello")` explicitly allocates a distinct new object in standard heap memory (1 object).
Total = 2 String objects.

---

### Q13. Consider the Word class and the code snippet. What will be the output of the following Java code?
```java
class Word {
    private String text = "Campus";
    public char letterAt(int i) { return text.charAt(i); }
    public int getTextLength() { return text.length(); }
}
Word myWord = new Word();
System.out.println(myWord.getTextLength());
System.out.println(myWord.letterAt(2));
```
- A. 6 / m
- B. 6 / p
- C. 5 / m
- D. 7 / p

**Answer:** **A. 6 / m**
**Explanation:** The length of `"Campus"` is 6. Index 0 is 'C', 1 is 'a', 2 is 'm'.

---

### Q14. Given the Java code snippet, what will be the output?
```java
String email = "user@domain.com";
int index = email.indexOf("@");
System.out.println(index);
```
- A. 4
- B. 0
- C. 5
- D. -1

**Answer:** **A. 4**
**Explanation:** Indexing is 0-based: `u` (0), `s` (1), `e` (2), `r` (3), `@` (4).

---

### Q15. Consider the Book class with a default constructor and the code snippet. What will be the output?
```java
class Book {
    private String title;
    private double price;
    public Book() {
        this.title = "Unknown";
        this.price = 0.0;
    }
    public String getDetails() {
        return "Title: " + title + ", Price: " + price;
    }
}
Book b = new Book();
System.out.println(b.getDetails());
```
- A. Title: null, Price: 0.0
- B. Title: Unknown, Price: 0.0
- C. Title: , Price: 0.0
- D. Compilation Error

**Answer:** **B. Title: Unknown, Price: 0.0**
**Explanation:** The default no-arg constructor assigns `"Unknown"` to `title` and `0.0` to `price`.

---

### Q16. Consider the Book class with a parameterized constructor and the code snippet. What will be the output?
```java
class Book {
    private String title;
    private double price;
    public Book(String title, double price) {
        this.title = title;
        this.price = price;
    }
    public String getDetails() {
        return "Title: " + title + ", Price: " + price;
    }
}
Book b = new Book("Java Programming", 450.0);
System.out.println(b.getDetails());
```
- A. Title: Java Programming, Price: 450.0
- B. Title: null, Price: 0.0
- C. Title: , Price: 0.0
- D. Compilation Error

**Answer:** **A. Title: Java Programming, Price: 450.0**
**Explanation:** The constructor parameters are assigned to the instance fields `this.title` and `this.price`.

---

### Q17. Given the Wallet class and the code snippet, how many Wallet objects exist in memory after the execution of these lines?
```java
class Wallet {
    int balance;
    public Wallet(int amount) { this.balance = amount; }
}
Wallet w1 = new Wallet(500);
Wallet w2 = w1; // w2 now refers to the same object as w1
Wallet w3 = new Wallet(500); // w3 refers to a new object
```
- A. 1
- B. 2
- C. 3
- D. 0

**Answer:** **B. 2**
**Explanation:** The `new` keyword is invoked exactly twice (`new Wallet(500)` for `w1`, and `new Wallet(500)` for `w3`). `w2 = w1` copies a reference, not creating a new object.

---

### Q18. Consider the Wallet class and the code snippet. What will be the output after the add() method is called through w2?
```java
class Wallet {
    int balance;
    public Wallet(int amount) { this.balance = amount; }
    public void add(int amount) { this.balance += amount; }
}
Wallet w1 = new Wallet(500);
Wallet w2 = w1;
w2.add(200);
System.out.println("w1 balance: " + w1.balance);
System.out.println("w2 balance: " + w2.balance);
```
- A. w1 balance: 500 / w2 balance: 700
- B. w1 balance: 700 / w2 balance: 500
- C. w1 balance: 700 / w2 balance: 700
- D. w1 balance: 500 / w2 balance: 500

**Answer:** **C. w1 balance: 700 / w2 balance: 700**
**Explanation:** `w1` and `w2` refer to the same object. Modifying the state via `w2` reflects when accessed through `w1`.

---

### Q19. Consider the Student class and the code snippet. What will be the output after s1.setName("Anu") is called?
```java
class Student {
    String name;
    public Student(String name) { this.name = name; }
    public void setName(String newName) { this.name = newName; }
}
Student s1 = new Student("Asha");
Student s2 = new Student("Ravi");
s1.setName("Anu");
System.out.println("s1 name: " + s1.name);
System.out.println("s2 name: " + s2.name);
```
- A. s1 name: Asha / s2 name: Ravi
- B. s1 name: Anu / s2 name: Anu
- C. s1 name: Anu / s2 name: Ravi
- D. s1 name: Asha / s2 name: Anu

**Answer:** **C. s1 name: Anu / s2 name: Ravi**
**Explanation:** `s1` and `s2` refer to distinct objects. Updating `s1`'s name only affects `s1`.

---

### Q20. Consider the Visitor class with a static visitorCount variable and the code snippet. What will be the output?
```java
class Visitor {
    static int visitorCount = 0; // Shared by all visitors
    public Visitor() { visitorCount++; }
}
Visitor v1 = new Visitor();
Visitor v2 = new Visitor();
Visitor v3 = new Visitor();
System.out.println("Total visitors: " + Visitor.visitorCount);
```
- A. Total visitors: 0
- B. Total visitors: 1
- C. Total visitors: 3
- D. Total visitors: Error

**Answer:** **C. Total visitors: 3**
**Explanation:** `visitorCount` is a static class variable shared across all instances. Each constructor invocation increments it by 1, totaling 3.

---
---

# Part C — Concept Questions and In-Depth Answers

### Question 1
**Explain the concept of String immutability in Java and discuss its impact on performance when a String object undergoes repeated modifications. How can this performance impact be mitigated?**

**Answer:**
In Java, `String` objects are **immutable**, meaning their content cannot be modified once created in memory. If any string manipulation method (such as concatenation with `+`, `replace()`, or `substring()`) is performed, a brand-new `String` object is allocated on the heap, copying the characters and discarding the previous intermediate object.

**Impact on Performance:**
When a `String` is repeatedly modified in loops (e.g., concatenating $N$ strings of length $L$), each step allocates a new array and copies prior characters, resulting in an $O(N^2 \cdot L)$ time complexity and generating significant garbage collection overhead.

**Mitigation:**
To mitigate this performance issue, Java provides mutable string builder classes:
1. `StringBuilder`: High-performance, unsynchronized mutable sequence of characters (recommended for single-threaded usage).
2. `StringBuffer`: Thread-safe, synchronized mutable sequence of characters.
Using `StringBuilder.append()` operates in amortized $O(1)$ time per append, reducing overall time to $O(N \cdot L)$ with minimal memory churn.

---

### Question 2
**In a Java class constructor, when both an instance variable and a constructor parameter share the same name, how does the 'this' keyword resolve this ambiguity? Provide an example scenario to illustrate its use.**

**Answer:**
In Java, local variables and constructor parameters shadow instance fields with the same name within their scope. The keyword `this` is a reference to the current invoking instance. By qualifying the variable with `this.variableName`, the compiler distinguishes the instance variable from the local parameter.

**Example Scenario:**
```java
public class Student {
    private String name;
    private int rollNumber;

    public Student(String name, int rollNumber) {
        // Without 'this', 'name = name' assigns parameter to itself (no effect on field)
        this.name = name;             // 'this.name' is the instance field
        this.rollNumber = rollNumber; // 'this.rollNumber' is the instance field
    }
}
```

---

### Question 3
**Differentiate between an object and a reference variable in Java. Explain what occurs in memory when one reference variable is assigned the value of another, detailing the implications for object manipulation.**

**Answer:**
- **Object:** An actual instance of a class allocated on the **Heap**, holding state (instance variables) and methods.
- **Reference Variable:** A variable typically allocated on the **Stack** (or within another object) that holds the memory address (pointer) of an object in the heap, not the object itself.

**Memory Assignment Behavior (`ref2 = ref1`):**
When `ref2 = ref1` executes, Java copies the memory address stored in `ref1` into `ref2`. No duplicate object is created. Both reference variables now point to the exact same heap memory location (aliasing).

**Implications:**
Any change made to the object's mutable state via `ref2` (e.g., `ref2.setScore(95)`) is immediately visible when accessed through `ref1`, because both refer to the single underlying object.

---

### Question 4
**Discuss the appropriate use cases for static variables and instance variables in Java. Provide a scenario where a static member would be preferred and another where an instance member is more suitable, justifying your choices.**

**Answer:**
- **Static Variables:** Belong to the class itself, shared among all instances, and loaded once when the class is initialized.
  - *Use Case:* Shared configuration, constants (`Math.PI`), global counters, connection pools.
  - *Scenario:* Tracking total registered users across a banking system (`static int totalAccountsCreated`). Every new account increments the single shared counter.
- **Instance Variables:** Belong to individual objects, allocated anew in heap memory every time `new` is called.
  - *Use Case:* Entity-specific attributes that vary between instances.
  - *Scenario:* An account holder's balance (`private double balance`) or account number (`private String accountNumber`). Each customer must have their own independent balance.

---

### Question 5
**Compare and contrast the for, while, and do-while loops in Java. Describe specific programming scenarios where each type of loop would be the most suitable choice, explaining your reasoning.**

**Answer:**
| Loop Type | Condition Check Point | Minimum Iterations | Best Suited For |
|---|---|---|---|
| **for** | Pre-test (before each iteration) | 0 | Known / fixed number of iterations (counter-driven). |
| **while** | Pre-test (before each iteration) | 0 | Indeterminate iterations depending on a dynamic condition. |
| **do-while** | Post-test (after execution) | 1 | Scenarios requiring execution at least once before testing condition. |

**Scenarios:**
1. **for loop:** Iterating through elements of an array or range `0` to `n-1` (e.g., iterating a list of exam scores).
2. **while loop:** Reading lines from a file or network stream until `readLine() == null` or waiting for a task flag to change.
3. **do-while loop:** Console menu interactions or PIN prompt where the user must be prompted at least once before verifying whether to exit or repeat.

---

### Question 6
**Explain the concept of pass-by-value in Java. Differentiate its behavior and implications when a method receives a primitive data type as an argument versus when it receives an object reference.**

**Answer:**
Java is strictly **pass-by-value** in all cases. The actual parameter's value is copied into the method's formal parameter variable.

- **Primitive Data Types (`int`, `double`, `boolean`, etc.):**
  The binary bits representing the literal value are copied. Modifying the formal parameter inside the method changes only the local stack copy; the caller's original variable remains completely untouched.
- **Object References (`Student`, `int[]`, etc.):**
  The value that is copied is the **memory reference address**. Because both the caller's reference and the method parameter hold copies of the same address, calling mutating methods (e.g., `arr[0] = 99` or `student.setName("Alex")`) modifies the actual heap object. However, reassigning the reference itself inside the method (`student = new Student()`) only reassigns the local reference copy and does not alter the caller's reference.

---

### Question 7
**Describe how integer division operates in Java, specifically how it handles fractional results. Explain why an explicit type cast might be necessary to obtain a precise floating-point result from an arithmetic expression involving integers.**

**Answer:**
In Java, when both operands of the division operator `/` are integers (`byte`, `short`, `char`, `int`, `long`), Java performs **integer division**. Any fractional/decimal remainder is truncated (rounded towards zero), discarding the fractional component entirely (e.g., `5 / 2` yields `2`, not `2.5`).

**Why Explicit Type Cast is Necessary:**
If you assign the result of integer division to a `double`:
```java
int a = 5, b = 2;
double result = a / b; // Evaluates to 2 first, then widens to 2.0
```
Because the division happens before the widening assignment, the precision is already lost. An explicit cast `(double) a / b` forces Java's numeric promotion rules to promote `b` to `double`, computing `5.0 / 2.0 = 2.5`.

---

### Question 8
**Elaborate on the principle of encapsulation in Object-Oriented Programming. Discuss how Java's access modifiers (e.g., private) combined with getter and setter methods contribute to enforcing encapsulation and ensuring data integrity.**

**Answer:**
**Encapsulation** is the bundling of data (attributes) and methods that operate on that data into a single unit (class), while restricting direct access to the internal representation from outside components.

**How Java Enforces Encapsulation:**
1. **Private Access Modifiers (`private`):** Declaring fields `private` prevents external classes from modifying or reading them directly, shielding them from improper tampering.
2. **Getter and Setter Methods:** Public getters allow controlled read access, while public setters provide write access where business validation rules can be enforced before committing changes:
```java
public void setAge(int age) {
    if (age < 0 || age > 130) {
        throw new IllegalArgumentException("Invalid age value.");
    }
    this.age = age;
}
```
This guarantees data integrity and allows internal implementation changes without breaking external consumer contracts.

---

### Question 9
**Explain the fundamental distinction between using the == operator and the equals() method when comparing two objects in Java. Illustrate how overriding the equals() method affects object comparison.**

**Answer:**
- **`==` Operator:** Performs **reference comparison (shallow equality)**. It checks whether two reference variables point to the exact same memory address on the heap.
- **`equals()` Method:** Inherited from `java.lang.Object`, where its default implementation also checks `this == obj`. However, it is designed to be **overridden** by classes to perform **logical/value equality** (comparing the actual state or fields of the objects).

**Illustrating Override:**
```java
class Point {
    int x, y;
    Point(int x, int y) { this.x = x; this.y = y; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Point)) return false;
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }
}

Point p1 = new Point(2, 3);
Point p2 = new Point(2, 3);
p1 == p2;      // false (different heap objects)
p1.equals(p2); // true (same coordinates due to overridden equals)
```

---

### Question 10
**Differentiate between method overloading and method overriding in Java, both of which are forms of polymorphism. Explain when each is resolved (compile-time vs. run-time) and provide a concise example for each concept.**

**Answer:**
| Feature | Method Overloading (Compile-Time / Static) | Method Overriding (Run-Time / Dynamic) |
|---|---|---|
| **Scope** | Within the same class (or inherited). | Between a Subclass and its Superclass. |
| **Method Signature** | Same method name, **different parameter list** (type, number, or order). | Same method name, **identical parameters and return type**. |
| **Resolution** | Resolved at **Compile-time** based on reference type and argument types. | Resolved at **Run-time** based on the actual object instance (Virtual Method Dispatch). |

**Concise Examples:**
```java
// Method Overloading
class Calculator {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; } // Overloaded
}

// Method Overriding
class Animal {
    void makeSound() { System.out.println("Animal sound"); }
}
class Dog extends Animal {
    @Override
    void makeSound() { System.out.println("Bark"); } // Overridden
}
```
