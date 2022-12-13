package com.sparta.model.entities;

import com.sparta.utilities.FileType;
import com.sparta.utilities.XMLFormat;
import com.sparta.utilities.*;

public class FileFactory {

    // return: corresponding file format, null if unsupported file type
    public FileType storeToSpecifiedFile ( String outFileName ) {

        // part 1 = file name , part 2 = file extension
        String[] parts = outFileName.split("\\.");

        // check if the input is the file name and file extension separated by "."
        if (parts.length != 2) {
            throw new IllegalArgumentException("name can not consist of . and must include and extension");
        }

        switch ( parts[1].toLowerCase()  ) {
            case "xml":
                System.out.println("Employees successfully added to the new " + outFileName + " file.");
                return new XMLFormat();
                //wf.writeToFile(Employee);
            case "json":
                System.out.println("Employees successfully added to the new " + outFileName + " file.");
                return new JSONFormat();
                //wf.writeToFile();
            case "csv":
                System.out.println("ADD LATER");
                //wf.writeToFile();
        }
        return null;
    }

}
