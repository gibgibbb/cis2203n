# Custom Calculator Application
**CIS 2203N Mobile Development - Mock Midterm Examination**

## Project Overview
This is a functional calculator application

## Features & Implementation Choices

### 1. UI Grid & Styling (Milestone 1)
* The UI was constructed using a `ConstraintLayout` as the root view to handle screen scaling efficiently, paired with a `GridLayout` (5 rows, 4 columns) for the calculator buttons. This approach was chosen to structure the grid appropriately without relying on excessive nesting of linear layouts.
  To meet the custom visual aesthetic requirement and avoid standard default gray buttons, a custom retro-modern color palette was implemented utilizing `res/values/colors.xml` and custom styles in `themes.xml`.
    * Main: `#2FA4D7` (Blue)
    * Light: `#F5E9D8` (Cream)
    * Dark: `#3E2C23` (Dark Brown)
    * Accent: `#E76F2E` (Orange)

### 2. Core Logic & Edge Cases (Milestone 2)
* The application accurately captures Operand A and Operand B, evaluating standard operations (+, -, *, /) one step at a time.
*  To ensure robust edge-case handling, the app intercepts attempts to divide by zero. Instead of crashing, the logic resets the operational state and displays a custom error message: "Cannot divide by zero".
*  `Logcat` is actively utilized throughout the `MainActivity.java` file to track button clicks, state changes, and mathematical evaluations.

### 3. State Preservation & Custom Operator (Milestone 3)
* The calculator successfully survives device rotation and backgrounding without losing the current input or previous result. This was implemented using `onSaveInstanceState` and `onRestoreInstanceState` to bundle and unpack `operandA`, `operandB`, the `currentOperator`, and the display text during the Activity lifecycle destruction and recreation.
*  A custom operator button was implemented to perform a unique mathematical operation based on my Student ID. Pressing the `✦` button multiplies the current display value by **0.31** (derived from the last three digits of my studentID: 031).
