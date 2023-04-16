package com.techelevator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
public class SalesLog {
    // This method returns the current date and time as a formatted string
    private static String getCurrentTime(){
        SimpleDateFormat date = new SimpleDateFormat("MM/DD/yyyy HH:mm:ss");
        Date now = new Date();
        return date.format(now);
    }

    // This method logs a sales event with the starting balance, ending balance, and event name
    public static void log(String logEvent, double startingBalance, double endingBalance){
        // Create a new file object for the log file
        File file = new File("log.txt");
        try(
                // Open a PrintWriter with FileWriter to append to the log file
                PrintWriter writer = new PrintWriter(new FileWriter(file, true))){
            // Write the current time, event name, starting balance, and ending balance to the log file
            writer.println(getCurrentTime() + logEvent + " " + Item.df.format(startingBalance) + " " + Item.df.format(endingBalance));
        } catch (IOException e){
            // Print the stack trace if an exception occurs while writing to the log file
            e.printStackTrace();
        }
    }
}

