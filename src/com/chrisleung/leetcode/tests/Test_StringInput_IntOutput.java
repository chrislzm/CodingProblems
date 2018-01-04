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
public class Test_StringInput_IntOutput {
	
	/* NOTE: Modify path and filename here as needed */
	static private final String TEST_DATA_RELATIVE_PATH = "data/Problem_388_Longest_Absolute_File_Path.txt";
	
    static private int testCaseNum = 0;
    private static Scanner in = null;
    
    /* NOTE: Modify these fields as needed */
    private String fInput;
    private Integer fExpected;
    
    @Parameters(name = "Test Case #{index}")
    public static Collection<Object[]> data() {
    	in = new Scanner(Test_StringInput_IntOutput.class.getResourceAsStream(TEST_DATA_RELATIVE_PATH));
    	ArrayList<Object[]> testCases = new ArrayList<>();
    	while(in.hasNext()) {
    		/* NOTE: Modify file input format as needed */
			// Read test case and solution
			String inputString = in.next();
			inputString = inputString.replace("\\n","\n");
			inputString = inputString.replace("\\t","\t");
			String expectedString = in.next();
			Integer expected = Integer.valueOf(expectedString);
			Object[] testCase = new Object[2];
			testCase[0] = inputString;
			testCase[1] = expected;
			testCases.add(testCase);
    	}
    	in.close();
    	return testCases;
    }

    /* NOTE: Modify the constructor and field assignment as needed */
    public Test_StringInput_IntOutput(String input, Integer expected) {
    	fInput = input;
    	fExpected = expected;
    }
    
	@Test
	public void test() {
		/* NOTE: Modify the two following lines as needed */
		Problem_388_Longest_Absolute_File_Path solution = new Problem_388_Longest_Absolute_File_Path();
		Integer result  = solution.lengthLongestPath(fInput);
		
		boolean passed = fExpected.equals(result);
		System.out.println(String.format("Test Case #%s  Passed: %s  Input: %s  Output Expected: %s  Output Actual: %s ",testCaseNum,passed,fInput,fExpected,result));
		testCaseNum++;
		assertEquals(fExpected,result);
	}
}
