package com.java.backend.week1advancedjavaandcorefoundations.bankingtransactionprocessor2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransactionProcessor3 {
    private int processedCount=0;
    private List<ParseError3> errors =new ArrayList<>();
    public void processFile(String inputFile, String errorFile) {

        try (
                BufferedReader reader =
                        new BufferedReader(
                                new FileReader(inputFile)
                        )
        ) {

            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {

                lineNumber++;

                processLine(
                        line,
                        lineNumber
                );
            }

        } catch (IOException e) {

            System.out.println(
                    "File Error: "
                            + e.getMessage()
            );
        }

        writeErrors(errorFile);

        printSummary();

    }private void processLine(String line, int lineNumber) {
        try{
            String [] parts = line.split(",");
            if (parts.length != 4) {
                throw new IllegalArgumentException("Expected 4 fields in line " + lineNumber + ": " + line);
            }
            String transactionId= parts[0];
            String from = parts[1];
            String to = parts[2];
            double amount = Double.parseDouble(parts[3]);

            processedCount++;
            System.out.println("Processed transaction: " + transactionId + " | "
                    + from
                    + " -> "
                    + to
                    + " | Amount: $"
                    + amount);
        }catch (Exception e){
            errors.add(
                    new ParseError3(
                            lineNumber,line,e.getMessage()
                    )
            );
        }
    }
    private void writeErrors(String errorFile) {
        try(
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter(errorFile)
                )
                ){
            for (ParseError3 error:errors){
                writer.write(error.toString());
            }
        }catch (IOException e){
            System.out.println("Unable to write error file: " + e.getMessage());
        }
    }
    private void printSummary() {
        System.out.println("\n==PROCESSING SUMMARY==");
        System.out.println("Processed " + processedCount + " transactions.");
        if (errors.isEmpty()) {
            System.out.println("No errors found.");
        } else {
            System.out.println("Errors found. Writing to " + errors.size() + " file(s).");
        }
    }
}
