package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;
public class RangeTest {
    private Range exampleRange1;
    private Range exampleRange2;
    private Range exampleRange3;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { 
    	exampleRange1 = new Range(-1, 1);
    	exampleRange2 = new Range(1, 5);
    	exampleRange3 = new Range(-5, -1);
    }


    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange1.getCentralValue(), .000000001d);
    }
    
    
    /*--------------- getLowerBound() -----------------*/
	/*
	 * Testing getLowerBound function
	 * Input: range with 1 lower and 5 upper
	 * Expected result: 1.0
	 */
    @Test
    public void getLowerBoundTestWithPositiveBounds() {
    	assertEquals("The expected getLowerBound() return does not match expected. ",
    			1.0,exampleRange2.getLowerBound(),.000000001d);
    }
	/*
	 * Testing getLowerBound function with negative number
	 * Input: range with 1 lower and 5 upper
	 * Expected result: 1.0
	 */
    @Test
    public void getLowerBoundTestWithNegativeLowerBound() {
    	assertEquals("The expected getLowerBound() return does not match expected. ",
    			-1.0,exampleRange1.getLowerBound(),.000000001d);
    }
	/*
	 * Testing getLowerBound function with negative number
	 * Input: range with 0 lower and 0 upper
	 * Expected result: 0.0
	 */
    @Test
    public void getLowerBoundTestWithZeroLower() {
    	Range input1 = new Range(0,5);
    	assertEquals("The expected getLowerBound() return does not match expected. ",
    			0.0,input1.getLowerBound(),.000000001d);
    }
    
    /*--------------- getUpperBound() -----------------*/
	/*
	 * Testing getUpperBound function
	 * Input: range with 1 lower and 5 upper
	 * Expected result: 5.0
	 */
    @Test
    public void getUpperBoundTestWithPositiveBounds() {
    	assertEquals("The expected getUpperBound() return does not match expected. ",
    			5.0,exampleRange2.getUpperBound(),.000000001d);
    } 
	/*
	 * Testing getUpperBound function
	 * Input: range with -5 lower and -1.0 upper
	 * Expected result: -1.0
	 */
    @Test
    public void getUpperBoundTestWithNegativeLowerBound() {
    	assertEquals("The expected getUpperBound() return does not match expected. ",
    			-1.0,exampleRange3.getUpperBound(),.000000001d);
    } 
    
	/*
	 * Testing getUpperBound function
	 * Input: range with 0 lower and 0.0 upper
	 * Expected result: 0.0
	 */
    @Test
    public void getUpperBoundTestWithZeroUpper() {
    	Range input1 = new Range(-5,0);
    	assertEquals("The expected getUpperBound() return does not match expected. ",
    			0.0,input1.getUpperBound(),.000000001d);
    } 
    
    /*--------------- To string tests-----------------
	/*
	 * Testing toString function
	 * Input: range with 1 lower and 5 upper
	 * Expected result: Range[1.0,5.0]
	 */
    @Test
    public void toStringTestWithPositiveBounds() {
    	assertEquals("The expected toString() return does not match expected. ",
    			"Range[1.0,5.0]",exampleRange2.toString());
    }
    
	/*
	 * Testing toString function with negative range
	 * Input: range with -1 lower and 1 upper
	 * Expected result: Range[-1.0,1.0]
	 */
    
    @Test
    public void toStringTestWithNegativeLowerBound() {
    	assertEquals("The expected toString() return does not match expected. ",
    			"Range[-1.0,1.0]",exampleRange1.toString());
    }
    
	/*
	 * Testing toString function with zero range
	 * Input: range with 0 lower and 3 upper
	 * Expected result: Range[0.0,3.0]
	 */
    
    @Test
    public void toStringTestWithZeroLower() {
    	Range input1 = new Range(0,3);
    	assertEquals("The expected toString() return does not match expected. ",
    			"Range[0.0,3.0]",input1.toString());
    }
	/*
	 * Testing toString function with zero range
	 * Input: range with -3 lower and 0 upper
	 * Expected result: Range[-3.0,0.0]
	 */
    
    @Test
    public void toStringTestWithZeroUpper() {
    	Range input1 = new Range(-3,0);
    	assertEquals("The expected toString() return does not match expected. ",
    			"Range[-3.0,0.0]",input1.toString());
    }
	/*
	 * Testing toString function with negative range
	 * Input: range with -9.0 lower and -5.0 upper
	 * Expected result: Range[-9.0,-5.0]
	 */
    
    @Test
    public void toStringTestWithTwoNegative() {
    	Range input1 = new Range(-9,-5);
    	assertEquals("The expected toString() return does not match expected. ",
    			"Range[-9.0,-5.0]",input1.toString());
    }
    
    
  /*----------shift Tests--------------*/
    /*
     * Testing shift function with delta of 0 on a Range with positive bounds 
     * Input: Range[1.0,5.0]
     * Expected result: Range[1.0,5.0]
     */
    @Test
    public void shiftPositiveAndPositiveRangeWith0Test() {
    	assertEquals("The expected shift of exampleRange2 does not match expected", Range.shift(exampleRange2, 0), new Range(1.0, 5.0));
    }
    
    /*
     * Testing shift function with delta of 0 on a Range with negative bounds
     * Input: Range[-5.0,-1.0]
     * Expected result: Range[-5.0,-1.0]
     */
    @Test
    public void shiftNegativeAndNegativeRangeWith0Test() {
    	assertEquals("The expected shift of exampleRange2 does not match expected", Range.shift(exampleRange3, 0), new Range(-5.0, -1.0));
    }
    
    /*
     * Testing shift function with a positive delta on a Range with positive bounds 
     * Input: Range[1.0,5.0]
     * Expected result: Range[3.0,7.0]
     */
    @Test
    public void shiftPositiveAndPositiveRangeWithPositiveValueTest() {
    	assertEquals("The expected shift of exampleRange2 does not match expected", Range.shift(exampleRange2, 2), new Range(3.0, 7.0));
    }
    
    /*
     * Testing shift function with a negative delta on a Range with a negative bound 
     * Input: Range[1.0,5.0]
     * Expected result: Range[-1.0,3.0]
     */
    @Test
    public void shiftPositiveAndPositiveRangeWithNegativeValueTest() {
    	Range newRange = Range.shift(exampleRange2, -1);
    	assertTrue("The expected shift of exampleRange2 does not match expected", newRange.equals(new Range(0.0, 4.0)));
    }

    /*
     * Testing shift function with a positive delta on a Range with a negative bound 
     * Input: Range[-1.0,1.0]
     * Expected result: Range[1.0,3.0]
     */
    @Test
    public void shiftPositiveAndNegativeRangeWithPositiveValueTest() {
    	Range newRange = Range.shift(exampleRange1, 1);
    	assertTrue("The expected shift of exampleRange1 does not match expected", newRange.equals(new Range(0.0, 2.0)));
    }

    /*
     * Testing shift function with a negative delta on a Range with negative bounds
     * Input: Range[-1.0,-5.0]
     * Expected result: Range[-3.0,-1.0]
     */
    @Test
    public void shiftNegativeAndNegativeRangeWithNegativeValueTest() {
    	assertEquals("The expected shift of exampleRange1 does not match expected", Range.shift(exampleRange3, -2), new Range(-7.0, -3.0));
    }
    
    /*----------intersection Tests--------------*/
    /*
     * Testing intersects function on ranges that intersect within bounds
     * Input: Range[-1.0,1.0] with 0.0 and 2.0
     * Expected result: True
     */
    @Test
    public void intersectsWithinBoundsTest() {
    	assertTrue("Ranges from -1 to 1 and 0 to 2 don't intersect as expected", exampleRange1.intersects(0.0, 2.0));
    	
    }
    
    /*
     * Testing intersects function on ranges that intersect only on the bounds
     * Input: Range[-1.0,1.0] with 1.0 and 2.0
     * Expected result: True
     */
//    @Test
//    public void intersectsOnBoundsTest() {
//    	assertTrue("Ranges from -1 to 1 and 1 to 2 don't intersect as expected", exampleRange1.intersects(1.0, 2.0));
//    }
    
    /*
     * Testing intersects function on ranges that intersect only on the bounds
     * Input: Range[-1.0,1.0] with 2.0 and 3.0
     * Expected result: False
     */
    @Test
    public void intersectOutsideBoundsTest() {
    	assertFalse("Ranges from -1 to 1 and 2 to 3 shouldn't intersect", exampleRange1.intersects(2.0, 3.0));
    }
    
    /*
     * New Tests Added
     */
    
    
    @Test(expected = IllegalArgumentException.class)
    public void constructorLowerGreaterThanUpperTest() {
    	Range example = new Range(2, 1);
    }
    
    @Test
    public void containsValueLessThanLowerTest() {
    	assertFalse(exampleRange1.contains(-2));
    }
    
    @Test
    public void containsValueGreaterThanUpperTest() {
    	assertFalse(exampleRange1.contains(2));
    }
    
    @Test
    public void containsValueBetweenBoundsTest() {
    	assertTrue(exampleRange1.contains(0));
    }
    
    
    @Test
    public void expandTest() {
    	Range newRange = Range.expand(exampleRange1, .1, .1);
        assertEquals(newRange, new Range(-1.2, 1.2));
    }
    
    @Test
    public void shiftAllowZerocrossingTest() {
        assertEquals(Range.shift(exampleRange1, 1, true), new Range(0, 2));
    }
    
    @Test
    public void shiftWithNoZeroCrossingTest() {
        assertEquals(Range.shift(new Range(0,1), 1, false), new Range(1,2));
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void scaleWithNegativeFactorTest() {
        Range test = Range.scale(exampleRange1, -2);
    }
    
    @Test
    public void scaleWithPositiveFactorTest() {
        assertEquals(Range.scale(exampleRange1, 2), new Range(-2, 2));
    }
    
    @Test
    public void equalsNotWithRangeTest() {
        assertFalse(exampleRange1.equals(new Object()));
    }
    
    @Test
    public void BothNaNRangeTest() {
        assertTrue(new Range(2.0 % 0, 2.0 % 0).isNaNRange());
    }
    
    @Test
    public void constrainWithContainTest() {
        assertTrue(exampleRange1.constrain(0) == 0.0);
    }
    
    @Test
    public void constrainCloseToUpper() {
        assertTrue(exampleRange1.constrain(2) == 1.0);
    }
    
    @Test
    public void constrainCloseToLower() {
        assertTrue(exampleRange1.constrain(-2) == -1.0);
    }
    
    @Test
    public void combineIgnoringNaNRange1NullTest() {
        assertNull(Range.combineIgnoringNaN(null, new Range(2.0 % 0, 2.0 % 0)));
    }
    
    @Test
    public void combineIgnoringNaNRange2NullTest() {
        assertNull(Range.combineIgnoringNaN(new Range(2.0 % 0, 2.0 % 0), null));
    }
    
    @Test
    public void combineIgnoringNaNBothNanNullTest() {
        assertNull(Range.combineIgnoringNaN(new Range(2.0 % 0, 2.0 % 0), new Range(2.0 % 0, 2.0 % 0)));
    }
    
    @Test
    public void maxD2NaNTest() {
    	Range newRange = Range.combineIgnoringNaN(exampleRange1, new Range(0, 2.0 % 0));
        assertTrue(newRange.intersects(exampleRange1));
    }
    
    @Test
    public void minD2NaNTest() {
    	Range newRange = Range.combineIgnoringNaN(exampleRange1, new Range(2.0 % 0, 0)); //-1 to 1
        assertTrue(newRange.intersects(exampleRange1));
    }
    
    
    
 // Test cases for contains(double value) ___________-------- aaron stuff
    @Test
    public void containsValueBelowLowerBound() {
        assertFalse("Value below lower bound should return false", exampleRange1.contains(-2.0));
    }

    @Test
    public void containsValueAboveUpperBound() {
        assertFalse("Value above upper bound should return false", exampleRange1.contains(2.0));
    }

    @Test
    public void containsValueWithinRange() {
        assertTrue("Value within range should return true", exampleRange1.contains(0.5));
    }

    @Test
    public void containsValueEqualToLowerBound() {
        assertTrue("Value equal to lower bound should return true", exampleRange1.contains(-1.0));
    }

    @Test
    public void containsValueEqualToUpperBound() {
        assertTrue("Value equal to upper bound should return true", exampleRange1.contains(1.0));
    }
    
    
    // Test for combine()
    @Test
    public void combineWithNullRanges() {
        assertNull("Combining two null ranges should return null",
                   Range.combine(null, null));
    }

    @Test
    public void combineWithOneNullRange() {
        assertEquals("Combining one null range with another should return the non-null range",
                     exampleRange1, Range.combine(exampleRange1, null));
        assertEquals("Combining one null range with another should return the non-null range",
                     exampleRange1, Range.combine(null, exampleRange1));
    }

    @Test
    public void combineWithBothNonNullRanges() {
        Range combinedRange = Range.combine(exampleRange1, exampleRange2);
        assertEquals("Combining two non-null ranges should return the combined range",
                     new Range(-1, 5), combinedRange);
    }

    // Test for combineIgnoringNaN()
    @Test
    public void combineIgnoringNaNWithNullRanges() {
        assertNull("Combining two null ranges should return null",
                   Range.combineIgnoringNaN(null, null));
    }

    @Test
    public void combineIgnoringNaNWithOneNullRange() {
        assertEquals("Combining one null range with another should return the non-null range",
                     exampleRange1, Range.combineIgnoringNaN(exampleRange1, null));
        assertEquals("Combining one null range with another should return the non-null range",
                     exampleRange1, Range.combineIgnoringNaN(null, exampleRange1));
    }

    @Test
    public void combineIgnoringNaNWithBothNonNullRanges() {
        Range combinedRange = Range.combineIgnoringNaN(exampleRange1, exampleRange2);
        assertEquals("Combining two non-null ranges should return the combined range",
                     new Range(-1, 5), combinedRange);
    }

    @Test
    public void combineIgnoringNaNWithNaNRanges() {
        Range nanRange1 = new Range(Double.NaN, Double.NaN);
        Range nanRange2 = new Range(2, 4);
        
        Range newRange = Range.combineIgnoringNaN(nanRange1, nanRange2);
        assertTrue(newRange.equals(nanRange2));
    }

    // Test for expandToInclude()
    @Test
    public void expandToIncludeWithNullRange() {
        assertEquals("Expanding a null range with a value should return a new range with that value",
                     new Range(5, 5), Range.expandToInclude(null, 5));
    }

    @Test
    public void expandToIncludeWithValueBelowLowerBound() {
        assertEquals("Expanding a range with a value below the lower bound should return a new range with the updated lower bound",
                     new Range(-2, 1), Range.expandToInclude(exampleRange1, -2));
    }

    @Test
    public void expandToIncludeWithValueAboveUpperBound() {
        assertEquals("Expanding a range with a value above the upper bound should return a new range with the updated upper bound",
                     new Range(-1, 2), Range.expandToInclude(exampleRange1, 2));
    }

    @Test
    public void expandToIncludeWithValueWithinBounds() {
        assertEquals("Expanding a range with a value within bounds should return the original range",
                     exampleRange1, Range.expandToInclude(exampleRange1, 0.5));
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void getLowerboundWithIllegalRange() {
    	Range newRange = new Range(4, 1);
    	assertEquals("Expanding a range with a value within bounds should return the original range",
                4, newRange.getLowerBound());
    }
    
    
    @Test
    public void intersectsWithIntersectingRange() {
        // Create a new Range object with bounds that intersect exampleRange1
        Range intersectingRange = new Range(0, 2);
        
        // Check if intersectingRange intersects with exampleRange1
        assertTrue("Ranges should intersect", exampleRange1.intersects(intersectingRange));
    }

    @Test
    public void intersectsWithNonIntersectingRange() {
        // Create a new Range object with bounds that don't intersect exampleRange1
        Range nonIntersectingRange = new Range(2, 3);
        
        // Check if nonIntersectingRange intersects with exampleRange1
        assertFalse("Ranges should not intersect", exampleRange1.intersects(nonIntersectingRange));
    }
    
    
    @Test
    public void hashCodeWithEqualRanges() {
        // Create another Range object with the same bounds as exampleRange1
        Range equalRange = new Range(-1, 1);
        
        // Check if the hash codes are equal
        assertEquals("Hash codes should be equal", exampleRange1.hashCode(), equalRange.hashCode());
    }

    @Test
    public void hashCodeWithDifferentRanges() {
        // Create another Range object with different bounds from exampleRange1
        Range differentRange = new Range(-2, 2);
        
        // Check if the hash codes are different
        assertNotEquals("Hash codes should not be equal", exampleRange1.hashCode(), differentRange.hashCode());
    }
    
    
    // Test case for intersects(double b0, double b1)
    @Test
    public void intersectsWhenB1GreaterThanLower() {
    	Range testingRange = new Range(5,20);
        assertFalse(testingRange.intersects(-50, -10));
    }
    
    /*
     * 
     * 
     * Tests for Assignment 4
     * 
     * 
     */
    
    //centralValue()-------------------------------------------
    @Test
    public void testCentralValuePositive() {
    	Range newRange = new Range(1, 5);
    	assertEquals("Wrong central value", 3, newRange.getCentralValue(), 0.001d);
    }
    
    //contains()-------------------------------------------
    @Test
    public void testValueOnLowerBound() {
    	Range newRange = new Range(1,5);
    	boolean result = newRange.contains(1);
    	assertTrue(result);
    }
    
    @Test
    public void testValueOnUpperBound() {
    	Range newRange = new Range(1,5);
    	boolean result = newRange.contains(5);
    	assertTrue(result);
    }
    
    @Test
    public void testContainsNarrowRange() {
    	Range newRange = new Range(4,5);
    	boolean result = newRange.contains(4);
    	assertTrue(result);
    }
    
    //shift()-------------------------------------------
    @Test
    public void shiftWithNoZeroCrossingBothZeroTest() {
    	Range newRange = new Range(0,0);
    	Range newRangeShift = Range.shift(newRange, 10, false);
        assertEquals(10, newRangeShift.getUpperBound(), .00001d);
    }
    
    @Test
    public void shiftWithNoZeroCrossingNegRangeNegDelta() {
    	Range newRange = new Range(-5, -3);
    	Range newRangeShift = Range.shift(newRange, -10, false);
    	assertEquals(-13, newRangeShift.getUpperBound(), .0001d);
    }
    
    
    //constructor-------------------------------------------
    @Test
    public void testRangeConstructor() {
    	double lower = 1.0;
    	double upper = 3.0;
    	Range newRange = new Range(lower, upper);
    	assertEquals("Lower range in constructor not equal", lower, newRange.getLowerBound(), 0.001);
    	assertEquals("Upper range in constructor not equal", upper, newRange.getUpperBound(), 0.001);
    }
    
    //intersects()-------------------------------------------
 	@Test
 	public void intersectsUpperBound() {
 		Range testRange1 = new Range(2, 6);
 		double lowerBound = 6;
 		double upperBound = 7;
 		boolean testBool = testRange1.intersects(lowerBound, upperBound); 
 		assertFalse("The expected output should be false", testBool);
 		assertEquals(2, testRange1.getLowerBound(),0.0001d);
 		assertEquals(6, testRange1.getUpperBound(),0.0001d);
 	}
 	@Test
 	public void intersectsNarrow() {
 		Range newRange = new Range(1, 2);
 		boolean returned = newRange.intersects(1, 1);
 		assertFalse(returned);
 	} 	
 	
 	@Test
 	public void testGetUpperNegative() {
 		Range newRange = new Range(-10, -2);
 		double upper = -2;
 		assertEquals(upper, newRange.getUpperBound(), 0.0001d);
 	}
 	
 	@Test
 	public void testGetUpperPositive() {
 		Range newRange = new Range(2, 10);
 		double upper = 10;
 		assertEquals(upper, newRange.getUpperBound(), 0.0001d);
 	}
 	
 	@Test
 	public void testGetLowerNegative() {
 		Range newRange = new Range(-10, -2);
 		double lower = -10;
 		assertEquals(lower, newRange.getLowerBound(), 0.0001d);
 	}
 	
 	@Test
 	public void testGetLowerPositive() {
 		Range newRange = new Range(2, 10);
 		double lower = 2;
 		assertEquals(lower, newRange.getLowerBound(), 0.0001d);
 	}
 	
 	@Test
 	public void intersectsTestMutation() {
 		Range newRange = new Range(5, 10);
 		boolean result = newRange.intersects(8, 7);
 		assertFalse(result);
 	}

 	
 	
 	
 	
 	
 	
 	@Test(expected = IllegalArgumentException.class)
    public void testConstructorWithLowerGreaterThanUpper() {
        double lower = 5.0;
        double upper = 2.0;

        Range range = new Range(lower, upper);
    }

    @Test
    public void testConstructorWithLowerEqualToUpper() {
        double value = 5.0;

        Range range = new Range(value, value);

        assertEquals(value, range.getLowerBound(), 0.0);
        assertEquals(value, range.getUpperBound(), 0.0);
    }

    @Test
    public void testConstructorWithLowerLessThanUpper() {
        double lower = 2.0;
        double upper = 5.0;

        Range range = new Range(lower, upper);

        assertEquals(lower, range.getLowerBound(), 0.0);
        assertEquals(upper, range.getUpperBound(), 0.0);
    }
 	
    
    
    
    
    @Test
    public void expandWithEqualBounds() {
    	assertEquals(Range.expand(new Range(4,4), 0, 0), new Range(4,4));
    }
    
    @Test
    public void expandWithGreaterNegativeBoundTest() {
    	assertEquals(Range.expand(exampleRange1, 0.2, 1), new Range(-1.4, 3));
    }
    
    @Test
    public void expandWithLowerNegativeBoundTest() {
    	assertEquals(Range.expand(exampleRange1, 1.0, 0.2), new Range(-3, 1.4));
    }
    
    @Test(expected= IllegalArgumentException.class)
    public void expandNullTest() {
    	Range.expand(null, 0, 0);
    }
    
    @Test
    public void shiftTwoArgNoCrossing() {
    	assertEquals(Range.shift(exampleRange1, 2), new Range(0.0, 3.0));
    }
    
    @Test
    public void shiftTwoArgTest() {
    	assertEquals(Range.shift(exampleRange2, 2), new Range(3, 7));
    }
    
    @Test
    public void shiftAttemptedWithNoCrossing() {
    	assertEquals(Range.shift(exampleRange1, 2, false), new Range(0.0, 3.0));
    }
    
    @Test
    public void shiftWithCrossing() {
    	assertEquals(Range.shift(exampleRange1, 2, true), new Range(1,3));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shiftWithNullTest() {
    	Range.shift(null, 0, false);
    }
    
    @Test
    public void scaleWithZeroTest() {
    	Range.scale(exampleRange3, 0);
    }
    
    @Test
    public void scaleWithDecimalTest() {
    	Range.scale(exampleRange1, 0.5);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void scaleWithNullTest() {
    	Range.scale(null, 2);
    }
    
    @Test
    public void equalsFalseUpperBoundGreaterTest() {
    	assertFalse(exampleRange1.equals(new Range(-1, 0)));
    }
    
    @Test
    public void equalsFalseUpperBoundLessTest() {
    	assertFalse(exampleRange1.equals(new Range(-1, 2)));
    }
    
    @Test
    public void equalsFalseLowerBoundGreaterTest() {
    	assertFalse(exampleRange1.equals(new Range(-2, 1)));
    }
    
    @Test
    public void equalsFalseLowerBoundLessTest() {
    	assertFalse(exampleRange1.equals(new Range(0, 1)));
    }
   
    @Test
    public void equalsFalseGreaterThanLowerTest() {
    	assertFalse(exampleRange1.equals(exampleRange3));
    }
    
    @Test
    public void equalsFalseLessThanLowerTest() {
    	assertFalse(exampleRange1.equals(exampleRange2));
    }
    
 	
    @Test
    public void equalsTrueTest() {
    	assertTrue(exampleRange1.equals(exampleRange1));
    }
 	
 	
 	@Test
 	public void NaNRangeTest() {
 		Range nanRange = new Range(Double.NaN, Double.NaN);
 		assertTrue(nanRange.isNaNRange());
 	}
 	
 	@Test
 	public void toStringTest() {
 		assertEquals(exampleRange1.toString(), "Range[" + -1.0 + "," + 1.0 + "]");
 	}
 	
	@Test
    public void constructorErrorTest() {
    	Range newRange;
    	try {
    		newRange = new Range(5, 2);
    		fail("Should not be reached");
    	} catch(Exception e) {
    		String expected = "Range(double, double): require lower (5.0) <= upper (2.0).";
    		assertEquals(expected, e.getMessage());
    	}
    }

	
//getLenght()-------------------------------------------

	
	// #1
 	@Test(expected = IllegalArgumentException.class)
 	public void getLengthWithLowerGreaterThanUpper() {
 	    Range range = new Range(2, 1); // Lower bound is greater than upper bound
 	    range.getLength(); // This should throw an IllegalArgumentException
 	}

 	// #2
 	@Test
 	public void getLengthWithLowerEqualToUpper() {
 	    Range range = new Range(1, 1); // Lower bound equals upper bound
 	    assertEquals(0.0, range.getLength(), 0.000001); // Expected length is 0
 	}


 	// #3
 	@Test
 	public void getLengthWithUpperEqualToLower() {
 	    Range range = new Range(1, 1); // Upper bound equals lower bound
 	    assertEquals(0.0, range.getLength(), 0.000001); // Expected length is 0
 	}


 	// #4

 	@Test
 	public void getLengthWithLowerLessThanUpper() {
 	    Range range = new Range(1, 2); // Lower bound less than upper bound
 	    assertEquals(1.0, range.getLength(), 0.000001); // Expected length is upper - lower
 	}
 	/*
     * 
     * 
     * End of Assignment 4 Tests
     * 
     * 
     */
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}
