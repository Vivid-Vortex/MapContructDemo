The `@Mapping(expression = "...", target = "...")` in MapStruct allows you to provide a custom Java expression for mapping a source field to a target field. This is especially useful when you need more control over the mapping process or when the mapping logic cannot be directly inferred by MapStruct.

### Use of `expression`:
1. **Custom Mapping Logic**:
   You can write Java code to transform the source field into the required format or structure for the target field.

2. **Complex Mappings**:
   When a direct field-to-field mapping is not possible, such as when combining multiple fields, transforming a list, or calling a method.

3. **Access Methods or Utilities**:
   It allows you to invoke methods, utilities, or static functions that perform specific transformations.

### Example in your context:

```java
@Mapping(expression = "java(getSourcePerson().getAddresses())", target = "targetPerson.addresses")
TargetList_Type_2 sourceListToTargetList(SourceList_Type_2 sourceList);
```

- **expression**:
    - `java(getSourcePerson().getAddresses())`: This is the custom Java expression that will be executed to extract or compute the value for the `targetPerson.addresses` field.
    - In this case, it calls the `getAddresses()` method on the `SourcePerson` object.

- **target**:
    - Specifies the field in the target object (`targetPerson.addresses`) where the result of the expression will be assigned.

### How it works:
1. At runtime, MapStruct generates code that includes your custom Java expression for mapping the field.
2. This allows the generated code to handle complex transformations that MapStruct's default behavior cannot achieve.

### When to Use:
- When you need to:
    1. Perform field-specific transformations (e.g., converting units, handling date formats).
    2. Access nested or computed properties.
    3. Use external utility methods.

### Alternative:
If the logic is reusable or complex, you can use a **default method** or a **custom mapper** in the interface instead of embedding it in the `expression`. For example:

```java
default List<TargetAddress> mapAddresses(List<SourceAddress> addresses) {
    // Perform validations or transformations
    return addresses != null ? addresses.stream()
        .map(this::mapAddress)
        .collect(Collectors.toList()) : Collections.emptyList();
}
```

Then use:
```java
@Mapping(expression = "java(mapAddresses(sourceList.getSourcePerson().getAddresses()))", target = "targetPerson.addresses")
```

This keeps the code cleaner and makes the mapping logic reusable.

---
### Common Issue might encounter is "cannot find symbol sourceList" in case of below mapper method

```java
@Mapping(expression = "java(sourceList.getSourcePerson() != null && sourceList.getSourcePerson().getAddresses() != null ? mapSourceAddresses(sourceList.getSourcePerson().getAddresses()) : java.util.Collections.emptyList())",
        target = "targetPerson.addresses")
TargetList_Type_2 sourceListToTargetList(SourceList_Type_2 sourceList);
```
**Fix**

go to the implementation class of the mapper. you will see the error variable which would be used and in red.
You have to use generated method argument name in place of that error variable. In my case I was using sourceList and the impl method argument name gendered was sourceList_Type_2.
So I replaced sourceList with sourceList_Type_2 in mapper method as below. After replacing above method becomes like below.

```java
  @Mapping(expression = "java(sourceList_Type_2.getSourcePerson() != null && sourceList_Type_2.getSourcePerson().getAddresses() != null ? mapSourceAddresses(sourceList_Type_2.getSourcePerson().getAddresses()) : java.util.Collections.emptyList())",
            target = "targetPerson.addresses")
    TargetList_Type_2 sourceListToTargetList(SourceList_Type_2 sourceList);
```