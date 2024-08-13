package edu.school21.printer.app;

import com.beust.jcommander.JCommander;
import edu.school21.printer.logic.Args;
import edu.school21.printer.logic.Logic;

import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        try {
            Args jArgs = new Args();
            JCommander.newBuilder().addObject(jArgs).build().parse(args);


            Logic logic = new Logic(jArgs, "src/resources/image.bmp");
            logic.printImage();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
