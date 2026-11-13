# Factory — Developer Classwork

Factory Method example. `Program` asks for a language and gets a `Developer` that can write code. It never calls `new JavaDeveloper()` or `new CppDeveloper()` itself.

## Project layout

```
src/
  Developer.java
  DeveloperFactory.java
  JavaDeveloper.java
  JavaDeveloperFactory.java
  CppDeveloper.java
  CppDeveloperFactory.java
  Program.java
```

Open this folder in IntelliJ IDEA (`Classwork-1.iml`). Source lives in `src`, and compiled classes go to `out`.

## Requirements

Java 17 or newer.

## Run

From this directory:

```bash
javac -d out src/*.java
java -cp out Program
```
