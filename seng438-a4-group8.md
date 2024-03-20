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
<img width="607" alt="image" src="https://github.com/seng438-winter-2024/seng438-a4-stevanbeljic/assets/113965086/bb6ab415-0913-44cd-b72b-3b804e2b2b91">

<br>
<br>
**Range.java**<br>
<img width="607" alt="image" src="https://github.com/seng438-winter-2024/seng438-a4-stevanbeljic/assets/60798649/826b41f9-8038-460b-8750-fdc39fb2f9b3">

### Updated Scores
**DataUtilities.java**<br>
<img width="608" alt="image" src="https://github.com/seng438-winter-2024/seng438-a4-stevanbeljic/assets/60798649/ab9f3539-0063-48e7-b232-ebc7a5f0b898">
<br>

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
Assertions and checkpoints are used in Selenium to verify the current state of the application. The primary ones used in Selenium IDE are verification checkpoints, and assertions. Verifications differ from assertions as if a verification fails, the test case will continue to execute until the end of the script, whereas if an assertion fails the test case execution terminates immediately. These mimic the JUnit asserts, and are very important in verifying both the live environment throughout the duration of test execution, and particularly for assessing the final result and if it is displaying what is expected.
<br><br>
Accordingly, we use verification statements to verify the current presence of elements on the screen throughout execution, and we use assertions at the terminus of each script to ensure the correct screen with the correct data is displayed to the user.
# How did you test each functionaity with different test data
Non-trivial functionalities (such as sign-out) were tested with different data through the creation of nearly identical test cases, but with differing values. Using this method we could efficiently create multiple test cases testing various inputs, and accordingly adapt the assertion statements to look for different elements on the page. This was important to do as one should not only test a single, succesful solution, but also try to take into account user error when testing GUIs.
<br><br>
For example, the sign in was tested with both valid and invalid emails. Using a valid email, we check to see if the Samsung homepage is visible to the user. However when executing with an invalid email, we check to see that the error message label is visible on the screen instead. By adjusting the input values and assertions, we can consider various possible execution paths a user may take when interacting with the GUI.
# Discuss advantages and disadvantages of Selenium vs. SikuliX
SeleniumIDE and SikuliX are both testing softwares used primarily for testing GUIs. While SeleniumIDE is a Chrome browser extension and can therefore only be used to test pages loadable within Chrome, SikuliX can be used for a wider range of GUI software. Likewise, Selenium uses HTML elements whereas SikuliX uses image recognition to work with GUIs. A drawback with SikuliX is that it can be less accurate than Selenium because of its image regonition foundation, wherein it may confuse similar appearing elements on a page. It may also be slower to execute testing scripts as compared to Selenium because it needs to visually recognize and associate images appearing on the screen, while Selenium can process these tasks much quicker. Both are fairly simple to use, offer excellent integration with programming languages, and tackle the difficult task of automating GUI testing effectively. The tool to use ultimately depends on the system under test: a web-based program will have better testing results using SeleniumIDE, while a non-web-based program will only be testable with SikuliX.
# How the team work/effort was divided and managed
We initially began with the mutation testing using Pitest. The work was divided similarly to previous assignments, where Stevan and Rutvi were tasked with testing on DataUtilities, and Aaron and Angelo tested on Range. We worked in our pairs until a sufficient mutation score was reached, after which we documented our results. We also all worked together on the documentation of the ten Range mutations listed above, so we can all get an understanding of how to document the aspects of specific mutations, and how they were/weren't killed.

Afterwards, we moved onto GUI testing with Selenium on the Samsung Canada website. We simply listed out 8 basic task flows (2 each), possible inputs and expected outputs for each task flow, and then assigned two task flows to each member. Afterwards we came together for a final run through of each task flow, to ensure everything was covered and various inputs were considered in each test case.

# Difficulties encountered, challenges overcome, and lessons learned
The greatest difficulties with this lab involved Pitest. Pitest's GUI is unintuitive and lends little in the way of guidance to inexperienced users such as ourselves. It was very difficult to just learn what mutations were being done, and what the mutations actually meant (what was actually being changed in the source code). Because of this, it was also difficult to develop new test cases to eliminate mutations, as a lot of the time we did not really have an idea of what we were even looking to eliminate in the first place, or how to eliminate it. Lots of time was spent creating redundant tests, and then executing the mutation test (which has a very long execution time). 
<br><br>
On the other hand, we found Selenium a very pleasurable and intuitive experience. While there was a slight learning curve to creating scripts and recording user inputs, or manually creating commands, it was very easy to understand and was quite rewarding to see the execution of a test script run flawlessly. 
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
