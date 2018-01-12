/**
 * Tests a method with String input and Integer/int output.
 * Loads the test data from a file that uses strings "\n" and "\t" as newline and tab markers, replaced below by their respective chars. 
 * 
 * Please see NOTE comments and update respective code as needed. 
 */
package com.chrisleung.leetcode.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.chrisleung.leetcode.solutions.*;

@RunWith(Parameterized.class)
public class Test_2StringInputs_IntOutput {
	
	/* NOTE: Modify path and filename here as needed */
	static private final String TEST_DATA_RELATIVE_PATH = "data/Problem_712_Minimum_ASCII_Delete_Sum.txt";
	
    static private int testCaseNum = 0;
    private static Scanner in = null;
    
    /* NOTE: Modify these fields as needed */
    private String fInput1;
    private String fInput2;
    private Integer fExpected;
    
    @Parameters(name = "Test Case #{index}")
    public static Collection<Object[]> data() {
    	in = new Scanner(Test_2StringInputs_IntOutput.class.getResourceAsStream(TEST_DATA_RELATIVE_PATH));
    	ArrayList<Object[]> testCases = new ArrayList<>();
    	while(in.hasNext()) {
    		/* NOTE: Modify file input format as needed */
			// Read test case and solution
			String inputString1 = in.next();
			String inputString2 = in.next();
			String expectedString = in.next();
			Integer expected = Integer.valueOf(expectedString);
			Object[] testCase = new Object[3];
			testCase[0] = inputString1;
			testCase[1] = inputString2;
			testCase[2] = expected;
			testCases.add(testCase);
    	}
    	in.close();
    	return testCases;
    }

    /* NOTE: Modify the constructor and field assignment as needed */
    public Test_2StringInputs_IntOutput(String input1, String input2, Integer expected) {
    	fInput1 = input1;
    	fInput2 = input2;
    	fExpected = expected;
    }
    
	@Test
	public void test() {
		/* NOTE: Modify the two following lines as needed */
		Problem_712_Minimum_ASCII_Delete_Sum solution = new Problem_712_Minimum_ASCII_Delete_Sum();
		Integer result  = solution.minimumDeleteSum(fInput1, fInput2);
		
		boolean passed = fExpected.equals(result);
		System.out.println(String.format("Test Case #%s  Passed: %s  Inputs: %s %s  Output Expected: %s  Output Actual: %s ",testCaseNum,passed,fInput1,fInput2,fExpected,result));
		testCaseNum++;
		assertEquals(fExpected,result);
	}
}
