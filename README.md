# Checkers Java

A desktop Checkers game built with Java and Swing.

This is a personal project created to practice object-oriented programming, GUI development, game logic, debugging, and version control with Git.

## 🎮 Overview

Checkers Java is a two-player desktop Checkers application played on an 8×8 board.

The game currently supports piece movement, captures, turn management, and king promotion.

![Checkers Java](screenshots/checkers-board.png)

## ✨ Features

- 8×8 Checkers board
- Two-player gameplay
- Red and blue pieces
- Piece movement
- Capture mechanics
- King promotion
- Turn management
- Java Swing graphical interface
- Separate classes for board, pieces, and game management

## 🛠️ Technologies

- **Java**
- **Java Swing**
- **NetBeans IDE**
- **Apache Ant**
- **Git**
- **GitHub**

## 📁 Project Structure

```text
Checkers-Java/
├── src/
│   └── layzeiy/
│       └── game/
│           └── checkersapp/
│               ├── CheckersApp.java
│               ├── CheckersBoard.java
│               ├── CheckersGrid.java
│               ├── CheckersPeice.java
│               └── GameManager.java
├── nbproject/
├── build.xml
├── manifest.mf
├── .gitignore
└── README.md
```

## 🧩 Main Classes

| Class | Responsibility |
|---|---|
| `CheckersApp` | Starts the application |
| `CheckersBoard` | Handles the graphical game board |
| `CheckersGrid` | Represents individual board positions |
| `CheckersPeice` | Represents the checkers pieces |
| `GameManager` | Controls game state and game logic |

## ▶️ How to Run

### Using NetBeans

1. Clone the repository.
2. Open the project in NetBeans.
3. Build the project.
4. Run `CheckersApp`.

### Using Apache Ant

If Apache Ant and a compatible JDK are installed:

```bash
ant clean
ant
```

## 🚧 Future Improvements

The following features are planned for future versions:

- Multi-jump captures
- Forced-capture logic
- Improved game-state management
- Win/game-over detection
- Additional UI improvements
- More comprehensive testing
- Easier distribution/packaging

## 🎯 Project Goals

This project is part of my journey toward becoming a stronger software developer and eventually specializing in game development and game-engine programming.

Through this project, I am developing my understanding of:

- Object-oriented programming
- Java Swing
- Game-state management
- Movement logic
- Capture logic
- Debugging
- Git and GitHub
- Structuring larger Java projects

## 👨🏾‍💻 Author

**Lesly**

GitHub: [@Layzeiy](https://github.com/Layzeiy)

---

⭐ Thanks for checking out the project!
