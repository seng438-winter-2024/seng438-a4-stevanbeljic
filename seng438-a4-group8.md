**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group  8  |
| :--------------:|
| **Student Names**      |
|       Stevan Beljic            |
|        Aaron Giang             |
|        Angelo Troncone             |
|        Rutvi Brahmbhatt             |

# Introduction

This fourth lab is separated into two main components.
<br><br>
The first objective of the lab is to utilize mutation testing tools (such as Pitest) to assess the effectiveness of our test suites from previous labs, by creating mutants of the SUT and running tests to detect the mutants. 
<br><br>
The second objective of the lab is to learn how to perform automated GUI testing using tools such as Selenium, and how record and replay tools can be beneficial towards the development of GUIs.

# Analysis of 10 Mutants of the Range class 
### 1.getCentralValue() - Survived
In getCentralValue(), the mutation "replaced double return with 0.0d" survives because we only have a single test which tests the method, and the test expects a value of 0 to be returned. Therefore, by implementing another test wherein it expects a returned value not equal to 0, such as the central value between 1 and 3 which would be 2, we can catch and kill this mutant. This was done in ```testCentralValuePositive```.
### 2.intersects() - Survived
In intersects(), the mutation "changed conditional boundary" survives because before we did not have a test which tested an intersect which occurred precisely on the boundary condition. We had a test case, ```intersectsOnBoundsTest```, however it was impoperly written and did not actually test for intersections at the boundaries. The test's conditions have been changed to test intersections on the lower bound of the provided range (1, 2) as well as another test has been created to test intersections at the upper bound of the provided range (-3, -1).
### 3.shiftWithNoZeroCrossing() - Survived
In shiftWithNoZeroCrossing(), the mutation "changed conditional boundary" survives because we never tested that method being called where both values are negative, or where the sum of either value and the delta is still below 0. Two tests are added to the test suite, ```shiftWithNoZeroCrossingBothZeroTest``` with values 0, 0, and a delta of 1, and ```shiftWithNoZeroCrossingUpperZeroTest``` with values -5, -3, and a delta of 2 to kill these mutants.
### 4.Mutant 4
Stuff
### 5.Mutant 5
Stuff
### 6.Mutant 6
Stuff
### 7.Mutant 7
Stuff
### 8.Mutant 8
Stuff
### 9.Mutant 9
Stuff
### 10.Mutant 10
Stuff

# Report all the statistics and the mutation score for each test class

### Original Scores
**DataUtilities.java**<br>
<img width="608" alt="image" src="https://github.com/seng438-winter-2024/seng438-a4-stevanbeljic/assets/60798649/ab9f3539-0063-48e7-b232-ebc7a5f0b898">
<br>
<br>
**Range.java**<br>
<img width="607" alt="image" src="https://github.com/seng438-winter-2024/seng438-a4-stevanbeljic/assets/60798649/826b41f9-8038-460b-8750-fdc39fb2f9b3">

### Updated Scores
**DataUtilities.java**

**Range.java**


# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy

# A discussion of what could have been done to improve the mutation score of the test suites

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

# Explain your SELENUIM test case design process
Our test case design process started similar to test case design from previous labs: we started with familiarization with the SUT (in this case, samsung.com/ca). Before we can even begin to test the Samsung GUI, we needed to first familiarize ourselves with the workings of the website and what a typial task flow would look like. Afterwards, we began to list out potential task flows and separating those into smaller, testable units. After that planning phase, we began actual development of the test cases, making sure we covered every major aspect touched upon in our initial planning. Finally, we reviewed the replays of our recordings to ensure the correct data was being input and captured.
# Explain the use of assertions and checkpoints

# how did you test each functionaity with different test data

# Discuss advantages and disadvantages of Selenium vs. Sikulix

# How the team work/effort was divided and managed


# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
