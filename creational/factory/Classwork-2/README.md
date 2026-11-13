# Factory — Payment Classwork

Factory Method example. `Main` asks for a payment type and gets a `Payment`. `PaymeFactory` and `ClickFactory` create the concrete payments.

## Project layout

```
src/
  Payment.java
  PaymentFactory.java
  Payme.java
  PaymeFactory.java
  Click.java
  ClickFactory.java
  Main.java
```

Open this folder in IntelliJ IDEA (`Factory.iml`). Source lives in `src`, and compiled classes go to `out`.

## Requirements

Java 17 or newer.

## Run

From this directory:

```bash
javac -d out src/*.java
java -cp out Main
```
