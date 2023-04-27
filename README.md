# shallow-copy

<div align="center">
  <a href="https://www.oracle.com/java/">
    <img
      src="https://img.shields.io/badge/Written%20in-java-%23EF4041?style=for-the-badge"
      height="30"
    />
  </a>
  <a href="https://jitpack.io/#micartey/shallow-copy/master-SNAPSHOT">
    <img
      src="https://img.shields.io/badge/shallow-copy-master-%2321f21?style=for-the-badge"
      height="30"
    />
  </a>
  <a href="https://micartey.github.io/shallow-copy/docs" target="_blank">
    <img
      src="https://img.shields.io/badge/javadoc-reference-5272B4.svg?style=for-the-badge"
      height="30"
    />
  </a>
</div>

## 📚 Introduction

`shallow-copy` is a copy library for java which copies explicid non-final fields marked with `@Expose` to a new object. To be more precise, it sets the field of the copy to the value of the parent. This means that values that are called by reference are not realy copied and the reference is the same - only primitive types that are called by value and thus copied.


**Motivation**

Copying an object with either the provided copy function or a so called "deep copy" by serializing the object into json and back to an object using e.g. gson was to slow for my needs. Therefore I investigated what types of copy could be faster and ended up implementing a short, easy to use shallow copy library.

## 📝 Getting started

Given this is you class you want to copy (often):

```java
import me.micartey.shallowcopy.Expose;

public class TestClass {
    
    @Expose private boolean isCoding, isSleeping, isDebuging, isNotEating;

}
```

You can copy it's instance by following the example:


```java
TestClass test = new TestClass(...);
TestClass copy = new ShallowCopy<>(TestClass.class).copy(test);
```