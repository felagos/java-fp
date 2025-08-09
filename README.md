# Java FP - Vanilla Java Project

This is a simple Java project without any build tools like Gradle or Maven.

## Project Structure

```
java-fp/
├── src/
│   └── App.java
├── bin/                    (compiled classes go here)
├── compile.bat            (compile the Java files)
├── run.bat               (run the application)
├── build-and-run.bat     (compile and run in one step)
└── README.md
```

## How to Use

### Prerequisites
- Java Development Kit (JDK) installed and `javac` and `java` commands available in PATH

### Compile the Project
```
compile.bat
```

### Run the Application
```
run.bat
```

### Compile and Run in One Step
```
build-and-run.bat
```

## Adding New Classes
1. Create new `.java` files in the `src/` directory
2. No package declaration needed (using default package)
3. Run `compile.bat` to compile all Java files
4. Run `run.bat` to execute the main application

## Cleaning Up
To clean compiled classes, simply delete the contents of the `bin/` directory.
