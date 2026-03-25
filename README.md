# Custom Calculator Application
**CIS 2203N Mobile Development - Mock Midterm Examination**

## Project Overview
[cite_start]This project is a robust, fully functional calculator application built entirely in Java[cite: 6]. [cite_start]It is designed to demonstrate core mobile development concepts, including complex UI grid layouts, state management, and rigorous edge-case handling[cite: 7].

## Features & Implementation Choices

### 1. UI Grid & Styling (Milestone 1)
* **Layout Architecture:** The UI was constructed using a `ConstraintLayout` as the root view to handle screen scaling efficiently, paired with a `GridLayout` (5 rows, 4 columns) for the calculator buttons. [cite_start]This approach was chosen to structure the grid appropriately without relying on excessive nesting of linear layouts[cite: 28, 50].
* [cite_start]**Originality Constraint (Theming):** To meet the custom visual aesthetic requirement and avoid standard default gray buttons[cite: 30, 31], a custom retro-modern color palette was implemented utilizing `res/values/colors.xml` and custom styles in `themes.xml`.
    * Main: `#2FA4D7` (Blue)
    * Light: `#F5E9D8` (Cream)
    * Dark: `#3E2C23` (Dark Brown)
    * Accent: `#E76F2E` (Orange)

### 2. Core Logic & Edge Cases (Milestone 2)
* [cite_start]**Standard Arithmetic:** The application accurately captures Operand A and Operand B, evaluating standard operations (+, -, *, /) one step at a time[cite: 11, 12, 50].
* [cite_start]**Zero-Division Handling:** To ensure robust edge-case handling, the app intercepts attempts to divide by zero[cite: 7, 37]. [cite_start]Instead of crashing, the logic resets the operational state and displays a custom error message: "Cannot divide by zero"[cite: 37, 50].
* **Debugging:** `Logcat` is actively utilized throughout the `MainActivity.java` file to track button clicks, state changes, and mathematical evaluations.

### 3. State Preservation & Custom Operator (Milestone 3)
* [cite_start]**State Management:** The calculator successfully survives device rotation and backgrounding without losing the current input or previous result[cite: 14]. [cite_start]This was implemented using `onSaveInstanceState` and `onRestoreInstanceState` to bundle and unpack `operandA`, `operandB`, the `currentOperator`, and the display text during the Activity lifecycle destruction and recreation[cite: 41, 50].
* [cite_start]**Custom Operator Constraint (✦):** A custom operator button was implemented to perform a unique mathematical operation based on my Student ID[cite: 43, 44, 50]. Pressing the `✦` button multiplies the current display value by **0.31** (derived from the last three digits of ID: 031).

## Git Commit History
The project was built incrementally, with specific milestones tracked in the Git history as requested:
1. [cite_start]`feat: implement UI grid and styling` [cite: 32]
2. [cite_start]`feat: implement core math logic and zero-division handling` [cite: 38]
3. [cite_start]`feat: add state preservation and custom operator` [cite: 45]
