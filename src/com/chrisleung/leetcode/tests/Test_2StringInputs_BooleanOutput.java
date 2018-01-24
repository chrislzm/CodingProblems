/**
 * Tests a method with String input and Boolean output.
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
public class Test_2StringInputs_BooleanOutput {

    /* NOTE: Modify path and filename here as needed */
    static private final String TEST_DATA_RELATIVE_PATH = "data/Problem_010_Regular_Expression_Matching.txt";

    static private int testCaseNum = 0;
    private static Scanner in = null;

    /* NOTE: Modify these fields as needed */
    private String fInput1;
    private String fInput2;
    private Boolean fExpected;

    @Parameters(name = "Test Case #{index}")
    public static Collection<Object[]> data() {
        in = new Scanner(Test_2StringInputs_BooleanOutput.class.getResourceAsStream(TEST_DATA_RELATIVE_PATH));
        ArrayList<Object[]> testCases = new ArrayList<>();
        while(in.hasNext()) {
            /* NOTE: Modify file input format as needed */
            // Read test case and solution
            String inputString1 = in.nextLine();
            String inputString2 = in.nextLine();
            String expectedString = in.nextLine();
            Boolean expected = Boolean.valueOf(expectedString);
            Object[] testCase = new Object[2];
            String[] inputs = new String[2];
            inputs[0] = inputString1;
            inputs[1] = inputString2;
            testCase[0] = inputs;
            testCase[1] = expected;
            testCases.add(testCase);
        }
        in.close();
        return testCases;
    }

    /* NOTE: Modify the constructor and field assignment as needed */
    public Test_2StringInputs_BooleanOutput(String[] input, Boolean expected) {
        fInput1 = input[0];
        fInput2 = input[1];
        fExpected = expected;
    }

    @Test
    public void test() {
        /* NOTE: Modify the two following lines as needed */
        Problem_010_Regular_Expression_Matching solution = new Problem_010_Regular_Expression_Matching();
        Boolean result  = solution.isMatch(fInput1,fInput2);

        boolean passed = fExpected.equals(result);
        System.out.println(String.format("Test Case #%s  Passed: %s  Inputs: %s %s  Output Expected: %s  Output Actual: %s ",testCaseNum,passed,fInput1,fInput2,fExpected,result));
        testCaseNum++;
        assertEquals(fExpected,result);
    }
}
