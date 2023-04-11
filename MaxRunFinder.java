import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
* This program finds the maximum run of lines in a file.
*
* @author Logan S
* @version 1.0
* @since 2023-04-10
*/

public final class MaxRunFinder {

    /**
    * For style checker.
    *
    * @exception IllegalStateException Utility class.
    * @see IllegalStateException
    */

    private MaxRunFinder() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * Print messages.
    *
    * @param args Unused
    */

    public static void main(String[] args) {

        // Declare a list to store the lines of the input file.
        final ArrayList<String> lines = new ArrayList<>();

        try {
            // Choose a file to read input from.
            final File inputFile = new File("input.txt");
            final Scanner scanner = new Scanner(inputFile);

            // Choose (or create) a file to write output to.
            final FileWriter output = new FileWriter("output.txt");

            // Read each line of the input file and add it to the list.
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }

            // Call the findMaxRun function for each line and write the result
            // to the output file.
            for (String line : lines) {
                final int maxRun = findMaxRun(line);
                System.out.println(maxRun);
                output.write(maxRun + "\n");
            }

            // Close the output writer.
            output.close();

        } catch (IOException exception) {
            // Print an error message if there is an error reading the input
            // file or writing the output file.
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
    * This function finds the maximum run for each line.
    *
    * @param line a line from the input file
    * @return the maximum run of consecutive characters in the line
    */

    public static int findMaxRun(String line) {

        // Declare variables to keep track of the current
        // run and the maximum run.
        int currentRun = 1;
        nt maxRun = 0;

        // If the line only contains one character, the maximum run is 1.
        if (line.length() == 1) {
            maxRun = 1;
        }

        // Convert the line to an array of characters and iterate through it,
        // checking whether each character is the same as the next one in the
        // array. If it is, increment the current run. If it isn't, reset the
        // current run to 1. If the current run is greater than the maximum run,
        // update the maximum run.
        final char[] lineArr = line.toCharArray();
        for (int i = 0; i < lineArr.length - 1; i++) {
            if (lineArr[i] == lineArr[i + 1]) {
                currentRun++;
            } else {
                currentRun = 1;
            }
            if (currentRun > maxRun) {
                maxRun = currentRun;
            }
        }

        // Return the maximum run for the line.
        return maxRun;
    }
}
