# Benchmarking Processes and Threads in Java

[![Java](https://img.shields.io/badge/Java-11%2B-orange?logo=java)](https://www.oracle.com/java/technologies/javase-downloads.html)
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
![Build](https://img.shields.io/badge/build-manual-lightgrey)
[![Docs](https://img.shields.io/badge/docs-Javadoc-green)](./doc/index.html)

This benchmark measures the overhead of creating processes, child processes, and threads in Java. The goal is to demonstrate that creating threads is far more efficient than creating processes.

This project is part of the **Concurrent Programming** module at the [Federal University of Rio Grande do Norte (UFRN)](https://www.ufrn.br), Natal, Brazil.

## 📃 Description

This benchmark measures the time to create 1,000 processes, child processes, and threads. This number is currently fixed and hard-coded, but it can be adjusted and even provided as a user input to the program. All the working units execute the very same task, which does almost nothing to allow for focusing on the overhead. 

For the case of child processes, a parent process is created, and then it creates multiple child processes. Each process performs a command consisting of running either the [`Task`](src/benchmark/Task.java) or [`ParentProcess`](src/benchmark/ParentProcess.java) classes; the latter is the parent process used to create a given number of child processes. This is achieved via the facilities of the [`ProcessBuilder`](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/lang/ProcessBuilder.html) class, which is used to create operating system processes.

The benchmark currently runs for only one. Future work involves modifying the implementation of the [`Main`](src/benchmark/Main.java) class to support multiple runs (at least 20) for empirical validity, and recording the mean and standard deviation.

---

## 📂 Repository Structure

```
.
├── doc/                # Javadoc documentation
├── src/benchmark       # Source code
│   ├── Benchmark.java        # Class with the implementation of the three benchmarks
│   ├── Main.java             # Main driver class of the benchmark
│   ├── ParentProcess.java    # A process that spawns child processes
│   ├── Task.java             # Intentionally trivial task to be executed by processes and threads
└── README.md
```

---

## 🚀 Getting Started

### ✅ Prerequisites
- Java 11+ (works with any modern JDK)
- A terminal or IDE (IntelliJ, Eclipse, VS Code, etc.)

### 🔧 Compilation
Inside the project root, compile all sources:

```bash
javac src/*.java -d out
```

This will place compiled `.class` files inside the `out/` directory.

### ▶️ Running

```bash
java -cp out Main
```

Expected output:

```
Processes       | 5.3468 seconds for 1000 processes
Child Processes | 5.2727 seconds for 1000 child processes (via parent process)
Threads         | 0.0270 seconds for 1000 threads
```

The expected result is that creating multiple threads is far more efficient than creating processes.

---

## 🤝 Contributing

Contributions are welcome! Fork this repository and submit a pull request 🚀

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).
