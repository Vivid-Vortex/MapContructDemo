### **Why Don’t We Need `MockitoAnnotations.openMocks(this);`?**
In your test class, you have the following annotation:
```java
@ExtendWith(MockitoExtension.class)
```
This **automatically initializes** all `@Mock` and `@InjectMocks` fields using Mockito's JUnit 5 support.

#### **How `@ExtendWith(MockitoExtension.class)` Works**
- This extension hooks into the JUnit 5 test lifecycle.
- Before each test runs, it **automatically initializes** mocks and injects them into `@InjectMocks` fields.
- This eliminates the need to call `MockitoAnnotations.openMocks(this);` manually.

---

### **When Do We Need `MockitoAnnotations.openMocks(this);`?**
We need to explicitly call `MockitoAnnotations.openMocks(this);` in **JUnit 4 or when not using `@ExtendWith(MockitoExtension.class)`**.

For example, if you were using **JUnit 4**, you would do:
```java
@Before
public void setUp() {
    MockitoAnnotations.openMocks(this);
}
```
But since **JUnit 5 provides `@ExtendWith(MockitoExtension.class)`**, this is unnecessary.

---

### **Key Takeaway**
If you **remove `@ExtendWith(MockitoExtension.class)`**, then you'll need:
```java
@BeforeEach
void setUp() {
    MockitoAnnotations.openMocks(this);
}
```
But since you're already using `@ExtendWith(MockitoExtension.class)`, **Mockito initializes everything for you, so `openMocks(this)` is redundant.** 🚀