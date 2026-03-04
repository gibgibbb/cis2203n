# Exercise 01: Mobile Context & The Activity Lifecycle

**Course:** CIS 2203N Mobile Development
**Student ID:** 22104031

## Overview
This repository contains the completed Android Studio project for Exercise 01. The app demonstrates basic UI interaction, layout manipulation, and proper handling of the Android Activity Lifecycle during configuration changes like screen rotations

## Part 2: The Interrupted Counter & State Preservation
As required by the exercise, the following "Sabotage" code was initially integrated into `onCreate` to induce an intentional crash

## Why did it crashed?
The application crashed immediately upon launch, throwing a NullPointerException. This happened because the counterDisplay object was explicitly initialized as null, meaning it had no reference to any actual UI element. When the code attempted to execute the .setText("0") method  on a non-existent object, the Java logic failed, causing the Activity to terminate before the layout could render.

