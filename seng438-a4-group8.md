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
**DataUtilities.java**<br>
screenshot here
<br>
**Range.java**<br>
screenshot here
<br>

### Tests Added
**DataUtilities.java**<br>

<br>

**Range.java**<br>

<br>

# Analysis drawn on the effectiveness of each of the test classes

# A discussion on the effect of equivalent mutants on mutation score accuracy
An equivalent mutant is a mutatation which did not change the expected output, yet it still differs from the orignal sourcecode of the program. Even though the mutation is different from the original source code, it is not explicitly wrong as it is mathematically equivalent to the original source code (it is effectively a synonym of the predicate). Thus, mutation scores are not completely accurate as they may understate the efficacy of the test suite and show that some mutations are not being killed, when in fact they are still behaving as the program initially intended.

# A discussion of what could have been done to improve the mutation score of the test suites


# Why do we need mutation testing? Advantages and disadvantages of mutation testing
Mutation testing is beneficial as it increases confidence in the quality of both the system under test, as well as the test suite developed to test the SUT. Mutation testing is another tool to examine the quality of our test set and how effectively it tests the SUT, even with the intentional introduction of bugs. 
An advantage to mutation testing is that it reveals weaker tests in our test suite, as it will reveal where gaps exist in our tests, and where more testing needs to be done to ensure better coverage. It is also beneficial in identifying reduncancy in testing as if mutations continue to survive despite introduction of new test cases, we learn which test cases are not positively contributing to the testing of the SUT. A disadvantage of mutation testing is its inclusion of equivalent mutations in the test set. Because of this, the calculated mutation score may not be truly reflective of the ability of the tests. Furthermore, mutation testing is a slow and resource-intensive process which takes long to test smaller code bases, and gets exponentially slower as the SUT grows in size.
# Explain your SELENUIM test case design process
Our test case design process started similar to test case design from previous labs: we started with familiarization with the SUT (in this case, samsung.com/ca). Before we can even begin to test the Samsung GUI, we needed to first familiarize ourselves with the workings of the website and what a typial task flow would look like. Afterwards, we began to list out potential task flows and separating those into smaller, testable units. After that planning phase, we began actual development of the test cases, making sure we covered every major aspect touched upon in our initial planning. Finally, we reviewed the replays of our recordings to ensure the correct data was being input and captured.
# Explain the use of assertions and checkpoints

# How did you test each functionaity with different test data

# Discuss advantages and disadvantages of Selenium vs. Sikulix

# How the team work/effort was divided and managed


# Difficulties encountered, challenges overcome, and lessons learned

# Comments/feedback on the lab itself
**Stevan**:<br>
The mutation testing was a very slow and tedious process. Not only was it somewhat difficult at first to understand the report generated by the tool, it was also difficult to make use of the generated report as we were not very familiar with how to effectively increase mutation coverage, leading to lots of time spent developing redundant tests which did not improve the mutation score, all while the each execution of Pitest took a long time. The GUI testing with Selenium was much more enjoyable, as we were able to progress much quicker and the tool itself seemed very useful and even fun to use in testing the functionality of GUIs. Overall, both tools were very useful and have their places in the testing process. 
<br>
**Rutvi**:<br>
Stuff
<br>
**Angelo**:<br>
Stuff
<br>
**Aaron**:<br>
Stuff
