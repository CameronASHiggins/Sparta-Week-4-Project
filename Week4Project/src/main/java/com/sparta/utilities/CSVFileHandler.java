package com.sparta.utilities;

import java.io.*;
import java.util.*;

public class CSVFileHandler {

    public static String[] getFields(String line) {
        //                    split the csv line into fields

        String[] fields = line.split(",");
//            String emp_no = fields[0];
//            String birth_date = fields[1];
//            String first_name = fields[2];
//            String last_name = fields[3];
//            String gender = fields[4];
//            String hireDate = fields[5];

        return fields;
    }

    public static List<String> readCSV(String filename) {
//            if using arraylist
        ArrayList<String> output = new ArrayList<>();
//            if using string
        String out = "";
        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))
        ) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                //            if using arraylist

                output.add(line);
                //            if using string

                out = out.concat(Arrays.toString(line.split(" ")))
                        .concat("\n")
                        .replace("[", "")
                        .replace("]", "");

//                    split the csv line into fields - uncomment below
//                    getFields(out);


            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        //System.out.println(output.toString());
        return List.of(out.split("\n"));
    }

    public static void writeCSV(String in, String out) {
        String[] input = in.split(" ");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(out))) {
            for (int i = 0; i < in.split(" ").length; i++) {
                bufferedWriter.write(input[i] + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static <T> Set getDistinct(Collection<T> list) {

        final List<T> duplicatedObjects = new ArrayList<T>();
        Set<T> set = new HashSet<T>() {
            @Override
            public boolean add(T e) {
                if (contains(e)) {
                    duplicatedObjects.add(e);
                }
                return super.add(e);
            }
        };
        for (T t : list) {
            set.add(t);
        }

        return set;
    }

    public static <T> List<T> getDuplicates(Collection<T> list) {

        final List<T> duplicatedObjects = new ArrayList<T>();
        Set<T> set = new HashSet<T>() {
            @Override
            public boolean add(T e) {
                if (contains(e)) {
                    duplicatedObjects.add(e);
                }
                return super.add(e);
            }
        };
        for (T t : list) {
            set.add(t);
        }

        return duplicatedObjects;
    }


}
