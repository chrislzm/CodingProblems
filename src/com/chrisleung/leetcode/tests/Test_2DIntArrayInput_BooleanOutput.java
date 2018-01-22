/**
 * Tests a method with int[] array input and int[] array output.
 * Loads the test data from a file.
 * 
 * Please see NOTE comments and update respective code as needed. 
 */
package com.chrisleung.leetcode.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.chrisleung.leetcode.solutions.*;

@RunWith(Parameterized.class)
public class Test_2DIntArrayInput_BooleanOutput {
	
	/* NOTE: Modify path and filename here as needed */
	static private final String TEST_DATA_RELATIVE_PATH = "data/Problem_766_Toeplitz_Matrix.txt";
	
    static private int testCaseNum = 0;
    private static Scanner in = null;
    
    /* NOTE: Modify these fields as needed */
    private int[][] fInput;
    private boolean fExpected;
    
    @Parameters(name = "Test Case #{index}")
    public static Collection<Object[]> data() {
    	in = new Scanner(Test_2DIntArrayInput_BooleanOutput.class.getResourceAsStream(TEST_DATA_RELATIVE_PATH));
    	ArrayList<Object[]> testCases = new ArrayList<>();
    	while(in.hasNext()) {
    		/* NOTE: Modify file input format as needed */
			// Read test case and solution
			String inputString = in.nextLine();
			String expectedString = in.nextLine();
			// Expect array in format [[1,2,3],[4,5,6],[7,8,9]] -- remove outer "[]" square brackets
			inputString = inputString.substring(1, inputString.length()-1);
			// Split individual arrays
			String[] inputStringArray = inputString.split("\\],\\[");
			// Remove leading square bracket and trailing square bracket from first and last array
	        inputStringArray[0] = inputStringArray[0].substring(1);
	        inputStringArray[inputStringArray.length-1] = inputStringArray[inputStringArray.length-1].substring(0, inputStringArray[0].length()); 
			// Convert String arrays to integer arrays
			int[][] input = stringTo2DIntArray(inputStringArray);
			Boolean expected = expectedString.equals("true") ? true : false;
			Object[] testCase = new Object[2];
			testCase[0] = input;
			testCase[1] = expected;
			testCases.add(testCase);
    	}
    	in.close();
    	return testCases;
    }

    /* NOTE: Modify the constructor and field assignment as needed */
    public Test_2DIntArrayInput_BooleanOutput(int[][] input, boolean expected) {
    	fInput = input;
    	fExpected = expected;
    }
    
	@Test
	public void test() {
		/* NOTE: Modify the two following lines as needed */
	    Problem_766_Toeplitz_Matrix_v2 solution = new Problem_766_Toeplitz_Matrix_v2();
		boolean result  = solution.isToeplitzMatrix(fInput);
		
		String inputString = Arrays.deepToString(fInput);
		String expectedString = String.valueOf(fExpected);
		String resultString = String.valueOf(result);
		boolean passed = expectedString.equals(resultString);
		System.out.println(String.format("Test Case #%s  Passed: %s  Input: %s  Output Expected: %s  Output Actual: %s ",testCaseNum,passed,inputString,expectedString,resultString));
		testCaseNum++;
		assertEquals(fExpected,result);
	}
	
	public static int[][] stringTo2DIntArray(String[] inputStrings) {
	    int[][] output = new int[inputStrings.length][inputStrings[0].length()-(inputStrings[0].length()/2)];
	    for(int i=0; i<inputStrings.length; i++) {
	        String inputString = inputStrings[i];
	        String[] sArr = inputString.split(",");
	        for(int j=0; j<sArr.length; j++) {
	            output[i][j] = Integer.parseInt(sArr[j]);
	        }
	    }
        return output;
	}

}
