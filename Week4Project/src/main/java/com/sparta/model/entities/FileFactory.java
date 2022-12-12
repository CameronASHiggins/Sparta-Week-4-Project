package com.sparta.model.entities;

import com.sparta.utilities.WriteFile;
import com.sparta.utilities.XMLFormat;
import com.sparta.utilities.*;
import java.io.File;

public class FileFactory {

    public void storeObjToFile( String input, Employee[] employees  ) {

        // part 1 = file name , part 2 = file extension
        String[] parts = input.split(".");

        // check if the input is the file name and file extension separated by "."
        if (parts.length != 2) {
            throw new IllegalArgumentException();
        }

        WriteFile wf;
        switch (parts[1].toLowerCase()) {
            case "xml":
                wf = new XMLFormat();
                //wf.writeToFile(Employee);
            case "json":
                wf = new JSONFormat();
                //wf.writeToFile();
            case "csv":
                System.out.println("ADD LATER");
                //wf.writeToFile();
        }

        System.out.println("Employees successfully added to the new " + input + " file.");

    }
}
