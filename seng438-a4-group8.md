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
### 1. getCentralValue() - Survived
In getCentralValue(), the mutation "replaced double return with 0.0d" survives because we only have a single test which tests the method, and the test expects a value of 0 to be returned. Therefore, by implementing another test wherein it expects a returned value not equal to 0, such as the central value between 1 and 3 which would be 2, we can catch and kill this mutant. This was done in ```testCentralValuePositive```.
### 2. intersects() - Survived
In intersects(), the mutation "changed conditional boundary" survives because before we did not have a test which tested an intersect which occurred precisely on the boundary condition. We had a test case, ```intersectsOnBoundsTest```, however it was impoperly written and did not actually test for intersections at the boundaries. The test's conditions have been changed to test intersections on the lower bound of the provided range (1, 2) as well as another test has been created to test intersections at the upper bound of the provided range (-3, -1).
### 3. shiftWithNoZeroCrossing() - Survived
In shiftWithNoZeroCrossing(), the mutation "changed conditional boundary" survives because we never tested that method being called where both values are negative, or where the sum of either value and the delta is still below 0. Two tests are added to the test suite, ```shiftWithNoZeroCrossingBothZeroTest``` with values 0, 0, and a delta of 1, and ```shiftWithNoZeroCrossingUpperZeroTest``` with values -5, -3, and a delta of 2 to kill these mutants.
### 4. Range(double lower, double upper) - Survived
In Range(double lower, double upper), the mutations "Decremented (a--) double local variable number 1" and "Incremented (a++) double local variable number 1" both survived in the instance when the lower was greater than the upper bound, causing the thrown error message to be returned improperly. The returned error message's values would have been altered from what the input truly was. For this, we implemented the test ```constructorErrorTest``` to check the message of the returned error, and ensure it matches a String correlating to the expected error message (with the correct lower and upper values). 
### 5. isNaNRange() - Survived
In isNaNRange(), multiple mutations that involved changing the values of the bounds of the Range object such as "negated double field lower" and "negated double field greater" survived because we had only one test case that had both bounds as NaN (Not a number) values, which returns the same NaN when negated. Therfore, the mutants were not detected by the single test case so we implemented additional test cases that tried for only one bound to be NaN and the other to be a number which could be negated.
### 6. equals(Object obj) - Killed
In equals, it takes any object and checks to see if it is a Range object and if it is, it returns true if it equal to another's bounds. The mutants that were introduced negated the condition checks for the bounds, made the conditions true, and changed equals to greater than or equal to and less than or equal to. The equals method did not have any test cases in the test suite and it was only ever used in assertEquals statements, meaning that the output was already intended to be true. To address this, we added test cases that had obviously unequal Range objects in the bound values that killed these mutants that changed conditions and negations.
### 7. scale(Range base, double factor) - Killed
In scale, it is given a Range object and a factor that is multiplied with the bounds to change them. A specific type of mutant that was introduced to this method was that it removed the check for a null Range object in the method, which went unnoticed as there was no test case that tried to call this method with a null object. Therefore, a test case was added that passed a null to the scale function to kill the mutant and ensuring that the null check actually worked.
### 8. getCentralValue() - Killed
In getCentralValue, the value that is returned is the middle between the upper and lower bound. A mutant that was introduced and survived was one that negated the central value before it was returned. This method was tested by one test case in the previous test suite and the expected central value was 0, which was therefore incapable of killing the mutant. We then added a new test case that expected a non-zero central value to be returned, thus killing the mutant.
### 9. Range(double lower, double upper) - Killed
In Range(double lower, double upper), the mutation "Decremented (--a) double local variable number 1" is killed by orginal test suite, ```constructorLowerGreaterThanUpperTest```. In this test case, you are intentionally passing arguments where the lower bound (2) is greater than the upper bound (1). If the mutant tries to bypass the check by decrementing these values, it should still fail this test case because the exception should still be thrown, indicating that the check was successfully bypassed. Therefore, this test case should kill the mutant. 
### 10. getLength() - Survived
In getLength(), the mutation "changed conditional boundary", "Negated double field upper", "Less or equal to less than", and "Less or equal to not equal" survives because the first mutant we create a range with a lower bound greater than the upper bound, this should lead to an IllegalArgumentException being because it violates the expected condition, and for other respective mutants, " it negated the upper bound comparison, potentially changing the logic", " it changed a less than or equal to comparison to less than. We need to ensure that the condition where lower is equal to upper is tested", "it changed a less than or equal to comparison to not equal". For this reason we implemented these test cases to Kill these mutations respectively: ```getLengthWithLowerGreaterThanUpper()```, ```getLengthWithLowerEqualToUpper()```, ```getLengthWithUpperEqualToLower()```, ```getLengthWithLowerLessThanUpper()```

# Report all the statistics and the mutation score for each test class

## Original Scores
**DataUtilities.java**<br>
<img width="607" alt="image" src="https://github.com/seng438-winter-2024/seng438-a4-stevanbeljic/assets/113965086/bb6ab415-0913-44cd-b72b-3b804e2b2b91">

<br>
<br>

**Range.java**<br>
<img width="607" alt="image" src="https://github.com/seng438-winter-2024/seng438-a4-stevanbeljic/assets/60798649/826b41f9-8038-460b-8750-fdc39fb2f9b3">

## Updated Scores
**DataUtilities.java**<br>
<img width="608" alt="image" src="https://github.com/seng438-winter-2024/seng438-a4-stevanbeljic/assets/60798649/ab9f3539-0063-48e7-b232-ebc7a5f0b898">
<br>
<br>
**Range.java**<br>
<img width="601" alt="image" src="https://github.com/seng438-winter-2024/seng438-a4-stevanbeljic/assets/60798649/c95736ef-3c25-43da-b126-00102361ae41">
<br>

## Tests Added
**DataUtilities.java**<br>

<br>

**Range.java**<br>

<br>

# Analysis drawn on the effectiveness of each of the test classes
It was ultimately quite difficult to improve the mutation score of both classes. Nontheless, we managed to improve the mutation score of Range.java by 10% (from 63% to 73%), and the score of DataUtilities.java by 12%. DataUtilities was improved through the creation of a few new test methods which were added in the Assignment 3 version but were not present in the Assignment 2 version, and by modifying existing tests to check for any changes to variables through the addition of extra assertion statements. The source code was also changed slightly to remove any dead code wherein mutations were being created but no coverage was possible, also improving the score. We had more difficulty improving Range.java, as it had many more methods with more conditional statements. Here, we primarily focused on testing code that was not tested much in previous assignments, such as the thrown error in the constructor or by checking upper and lower bound values after the calling of another method.

# A discussion on the effect of equivalent mutants on mutation score accuracy
An equivalent mutant is a mutatation which did not change the expected output, yet it still differs from the orignal sourcecode of the program. Even though the mutation is different from the original source code, it is not explicitly wrong as it is mathematically equivalent to the original source code (it is effectively a synonym of the predicate). Thus, mutation scores are not completely accurate as they may understate the efficacy of the test suite and show that some mutations are not being killed, when in fact they are still behaving as the program initially intended.

# A discussion of what could have been done to improve the mutation score of the test suites
Our plan when trying to improve the mutation score was to use the PITest summary to got through every method and identify which mutants are equivalent so as to not waste time trying to make new cases that do not matter. We then identified which mutants we would try to kill and came up with new test cases that would accomplish that and ensured that they passed with the unmutated SUT. We then would introduce the mutants to see if the new test cases would fail and run the JUnit test instead of PIT as PIT takes a long time to execute.

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
I found setting up the eclipse project pretty tedious as there were no instructions in this lab to set up the file structure so I had to go back to the previous assignment's to get it right. Following that, PIT would not work with my JDK so I had to trouble shoot and switch JRE versions until I found one that worked. This ended up taking too much time which could have been saved by specifying more clear instructions. The mutation testing part was very slow and time consuming; it really was usefull in demonstrating the pro of validating the test suite while experiencing the cons of equivalent mutants, and the amount of time and effort required to kill all the possible mutants when the codebase is very large. Using Selenium was a lot less time consuming and more intuitive when trying to test different functions of the Samsung website. I enjoyed having the flexibility of choosing what 2 functionalities I could test and learning the basics GUI testing with this loose requirement.
<br>
**Aaron**:<br>
Setting up eclipse to work with PIT took a large amount of time. Mutation testing seems useful for evaluating the quality of the test suite. Running the PIT is time consuming as well as creating enough test cases to reach an adequate coverage.   
Testing using selenium was very straightforward and was fast to learn. Creating test cases was very easy to do though the recording feature. I found it very interesting to use and I can see how it can help in the testing of websites. 
