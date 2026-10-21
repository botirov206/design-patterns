# Builder Pattern — PC Classwork

Advanced Programming classwork that assembles a PC with the **Builder** pattern. The same product (`PC`) can be built two ways: a director that walks a builder through a fixed recipe, or a fluent builder that sets each part in a chain.

## What it demonstrates

- **Product** — `PC` holds CPU, RAM, OS, storage, mouse, and keyboard.
- **Builder interface** — `ComputerBuilder` declares one step per part and a `getPc()` result.
- **Concrete builders** — `MacBuilder` locks the machine to an Apple M4 and macOS. `WindowsLinuxBuilder` locks it to an Intel Core i7 and the OS passed to its constructor (Windows or Linux; macOS is rejected).
- **Director** — `Director` knows the recipes. `constructOfficePC` uses 8 GB RAM and a 256 GB SSD. `constructPowerPC` uses 16 GB RAM and a 512 GB SSD. Both use a mouse and a mechanical keyboard.
- **Fluent builder** — `PC.builder()` returns a `PCBuilder` that can set parts in any order and fails if any part is missing. That style is left commented in `Main` so the director path is what runs.

## Project layout

```
src/
  Main.java                 entry point
  PC.java                   product
  PCBuilder.java            fluent builder
  ComputerBuilder.java      builder interface
  Director.java             construction recipes
  MacBuilder.java
  WindowsLinuxBuilder.java
  enums/
    cpu.java  RAM.java  OS.java
    storage.java  mouse.java  keyboard.java
```

## Requirements

Java 17 or newer (the spec printer uses a text block and `String.formatted`).

## Run

From this directory:

```bash
javac -d out src/enums/*.java src/*.java
java -cp out Main
```

`Main` asks the director for a power Mac and an office Windows PC, then prints both.

```
======== PC Specifications ========
CPU      : Apple_M4
RAM      : 16 GB
OS       : MACOS
Storage  : 512GB SSD
Mouse    : MOUSE
Keyboard : MECHANIC
===================================
======== PC Specifications ========
CPU      : Intel_Core_i7
RAM      : 8 GB
OS       : WINDOWS
Storage  : 256GB SSD
Mouse    : MOUSE
Keyboard : MECHANIC
===================================
```

## Fluent example

Uncomment the blocks in `Main` to build a machine without the director:

```java
PC macBookAir = PC.builder()
    .cpu(cpu.Apple_M1)
    .ram(RAM.RAM_16)
    .os(OS.MACOS)
    .storage(storage.SSD_512)
    .mouse(mouse.TOUCHPAD)
    .keyboard(keyboard.MECHANIC)
    .build();
```

`build()` throws `IllegalStateException` if any part was left unset.
