package com.brown_walker.khalid.bubble;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /*
     * Input: number of circles in the puzzle
     * Output: a puzzle randomly generated with at least 1 guaranteed solution
     * Complete: Yes
     * Tested: Yes
     */

    public static int[] generatePuzzle(int numCircles) {
        int[] puzzleArray = new int[numCircles];
        for (int i = 0; i < numCircles; i++) {
            puzzleArray[i] = 0;
        }
        Random rng = new Random((new Date()).getTime());
        int currentNode = rng.nextInt(numCircles);
        while (puzzleArray[currentNode] == 0) {
            int currentNodeValue = rng.nextInt(numCircles / 2)+1;
            boolean clockwise = rng.nextBoolean();
            if (clockwise) {
                if (puzzleArray[(currentNode + currentNodeValue + numCircles) % numCircles] == 0) {
                    puzzleArray[currentNode] = currentNodeValue;
                    currentNode = (currentNode + currentNodeValue + numCircles) % numCircles;
                    continue;
                }
            }
            if (puzzleArray[(currentNode - currentNodeValue + numCircles) % numCircles] == 0) {
                puzzleArray[currentNode] = currentNodeValue;
                currentNode = (currentNode - currentNodeValue + numCircles) % numCircles;
                continue;
            }
            if (!clockwise) {
                if (puzzleArray[(currentNode + currentNodeValue + numCircles) % numCircles] == 0) {
                    puzzleArray[currentNode] = currentNodeValue;
                    currentNode = (currentNode + currentNodeValue + numCircles) % numCircles;
                    continue;
                }
            }
            //Exit criterion
            int i = currentNode + 1;
            while (i != currentNode) {
                i = (i + numCircles) % numCircles;
                if (puzzleArray[i] == 0) {
                    break;
                }
                i = (i + 1 + numCircles) % numCircles;
                if (i == currentNode) {
                    puzzleArray[currentNode] = currentNodeValue;
                }
            }
        }
        return puzzleArray;
    }
    /*
     * Input: the generated puzzle, starting node, and the decision array (1=cw, 0=ccw)
     * Output: True if the sequence ends in success
     * Complete: Yes
     * Tested: Yes
     */

    public static boolean solver(int[] puzzle, int start, int decision) {
        int puzzleSize = puzzle.length;
        //build decision array
        int[] decisionArray = new int[puzzleSize - 1];
        for (int i = 0; i < decisionArray.length; i++) {
            decisionArray[i] = 0;
        }
        int index = 0;
        for (int num = decision; num > 0; num /= 2) {
            decisionArray[index++] = num % 2;
        }
        //check solution
        boolean[] visited = new boolean[puzzleSize];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        visited[start] = true;
        int step = 0;
        int current = start;
        do {
            if (visited[decisionArray[step] == 1 ? (current + puzzle[current]) % puzzleSize : (current - puzzle[current] + puzzleSize) % puzzleSize] == true) {
                return false;
            }
            visited[decisionArray[step] == 1 ? (current + puzzle[current]) % puzzleSize : (current - puzzle[current] + puzzleSize) % puzzleSize] = true;
            current = decisionArray[step] == 1 ? (current + puzzle[current]) % puzzleSize : (current - puzzle[current] + puzzleSize) % puzzleSize;
            step++;
        } while (step < puzzleSize - 1);
        return true;
    }
    /*
     * Input: the generated puzzle
     * Output: difficulty grade where 1 = easy, 2 = standard, 3 = hard, 4 = extreme
     * Complete: No
     * Tested: No
     */

    public static int gradeDifficulty(int[] puzzle) {
        final int decisionCap = (int) Math.pow(2, puzzle.length - 1);
        int forestSize = puzzle.length * decisionCap;
        int solutionCount = 0;
        for (int start = 0; start < puzzle.length; start++) {
            for (int decision = 0; decision < decisionCap; decision++) {
                if (solver(puzzle, start, decision)) {
                    solutionCount++;
                }
            }
        }
        double ratio = (double)solutionCount / forestSize;
        //Need statistical data here!!! For now will return 0.
        return solutionCount;
    }

}
