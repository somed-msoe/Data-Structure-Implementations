# Data Structure Implementations

Core data structures implemented from scratch in Java, with JUnit tests for each. The goal is refresh my memory how they work internally, so no class uses `java.util` collections.

## Structures

All classes use a `My` prefix (`MyArrayList`, `MyHashMap`, ...) so they never clash with the `java.util` classes of the same name.

| Structure | Status | Notes |
|---|---|---|
| `MyArrayList` | In progress | Constructors, `add`, `get`, `set`, `remove`, `grow`, `size`, `isEmpty` done. `add(index, value)`, `indexOf`, `contains`, `clear`, `toString` still stubs. |
| `MySinglyLinkedList` | Stub | |
| `MyDoublyLinkedList` | Stub | |
| `MyStack` | Stub | |
| `MyQueue` | Stub | |
| `MyBinarySearchTree` | Stub | |
| `MyHashMap` | Stub | |
| `MyMinHeap` | Stub | |
| `MyGraph` | Stub | |
| `MyTrie` | Stub | |
| `MyHashSet` | Not started | |
| AVL / Red-Black tree | Not started | |

## Project layout

```
src/main/java/com/del/ds/   implementations
src/test/java/com/del/ds/   JUnit 5 tests, one test class per structure
leetcode/                   practice problems (arrays_hashing, two_pointers)
pom.xml                     Maven build (Java 17, JUnit 5.10)
```

## Build and test

Requires JDK 17 or newer and Maven.

```
mvn test                 run all tests
mvn -Dtest=MyArrayListTest test   run one test class
```

## Docs

Public methods have Javadoc. To generate the HTML:

```
javadoc -d target/docs -sourcepath src/main/java com.del.ds
```

Then open `target/docs/index.html`.

## Conventions

- Commit messages follow [Conventional Commits](https://www.conventionalcommits.org/) (`feat:`, `fix:`, `test:`, `docs:`, `refactor:`, `chore:`).
- Bad indices throw `IndexOutOfBoundsException`; invalid arguments throw `IllegalArgumentException`.
