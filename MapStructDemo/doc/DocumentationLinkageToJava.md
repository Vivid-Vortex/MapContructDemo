# Link md file to Java for documentation

---

# Q&A Session: Linking Documentation to Java Files

### Question 1
**How can I link `expression.md` to `ListToListMapper_Type_3.java`?**

**Answer:**
To link the `doc/expression.md` file to the `ListToListMapper_Type_3.java` class, you can provide a reference within the Java file itself. This is typically done through comments or annotations. Here are a few options:

1. **Using Java Comments:**
   ```java
   /**
    * Mapper class for transforming data.
    * For detailed documentation, refer to:
    * docs/expression.md
    */
   ```

2. **Using JavaDoc with a Link:**
   ```java
   /**
    * Mapper class for transforming data.
    * <p>Documentation available at:
    * <a href="https://github.com/your-repo/docs/expression.md">expression.md</a>
    */
   ```

3. **Using Annotations:**
   Create a custom annotation like `@DocumentationLink` to reference the file:
   ```java
   @DocumentationLink("docs/expression.md")
   ```

---

### Question 2
**How can I use `@DocumentationLink("docs/expression.md")` to jump to the `.md` file like a link?**

**Answer:**
Java annotations themselves don't inherently support clickable links, but IDEs like IntelliJ IDEA can recognize file paths or URLs. To enable this:

1. **Define the Annotation:**
   ```java
   @Retention(RetentionPolicy.RUNTIME)
   public @interface DocumentationLink {
       String value();
   }
   ```

2. **Use the Annotation:**
   ```java
   @DocumentationLink("docs/expression.md")
   ```

3. **Make the Path Recognizable:**
   Ensure `docs/expression.md` exists in the project and is part of the file tree. Use a relative path from the Java file location or the project root.

If hosted on GitHub:
```java
@DocumentationLink("https://github.com/your-repo/docs/expression.md")
```

For raw content:
```java
@DocumentationLink("https://raw.githubusercontent.com/your-repo/main/docs/expression.md")
```

---

### Question 3
**If I keep `expression.md` in the project root, what path should I give?**

**Answer:**
If `expression.md` is in the project root, the path depends on where the annotation is being used.

- **Relative Path from Java File:**  
  If the Java file is deeply nested:
  ```java
  @DocumentationLink("../../../../../docs/expression.md")
  ```

- **Simpler Path with Root Assumption:**  
  If your IDE works relative to the project root:
  ```java
  @DocumentationLink("docs/expression.md")
  ```

- **Absolute Path (Not Recommended):**  
  Use only for testing:
  ```java
  @DocumentationLink("C:/project-root/docs/expression.md")
  ```

Best practice: Use the relative path from the project root:
```java
@DocumentationLink("docs/expression.md")
```

---

### Question 4
**Do I need to include `/blob/main/` in the URL for GitHub links?**

**Answer:**
Yes, you need to include `/blob/main/` (or the appropriate branch) to refer to a file’s contents on GitHub. For example:
```java
@DocumentationLink("https://github.com/Vivid-Vortex/MapContructDemo/blob/main/MapStructDemo/doc/expression.md")
```

Without `/blob/main/`, GitHub cannot distinguish between files and directories.

---

### Question 5
**Can I refer to a particular heading in the `.md` file like Markdown links?**

**Answer:**
Yes, you can refer to a specific heading by appending an anchor link to the URL. GitHub generates anchor links based on the heading text.

1. Convert the heading to a slug:
    - Lowercase letters.
    - Replace spaces with `-`.
    - Remove punctuation.

2. Example:
   Heading:
   ```markdown
   ## Mapping Collections
   ```
   Anchor:
   ```plaintext
   #mapping-collections
   ```

3. Full URL:
   ```java
   @DocumentationLink("https://github.com/Vivid-Vortex/MapContructDemo/blob/main/MapStructDemo/doc/expression.md#mapping-collections")
   ```

4. To verify:
    - Open the file on GitHub.
    - Hover over the heading to see its link.

### ***Project Example:*** Please refer below java file which links expression.md file in this project.
```
https://github.com/Vivid-Vortex/MapContructDemo/blob/main/MapStructDemo/src/main/java/com/demo/mapstruct/MapStructDemo/mapper/ListToListMapper_Type_3.java
```
