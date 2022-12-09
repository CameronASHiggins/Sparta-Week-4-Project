package com.sparta.utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class CSVFileHandler {

        protected static String[] getFields(String line){
            //                    split the csv line into fields

            String[] fields = line.split(",");
//            String emp_no = fields[0];
//            String birth_date = fields[1];
//            String first_name = fields[2];
//            String last_name = fields[3];
//            String gender = fields[4];
//            String hire_date = fields[5];

            return fields;
        }
        public static String readCSV(String filename){
//            if using arraylist
            ArrayList<String> output = new ArrayList<>();
//            if using string
            String out = "";
            try(
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))
            ){
                String line;

                while((line = bufferedReader.readLine()) != null){
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
            System.out.println(output.toString());
            return out;
        }

        public static void writeCSV(String in, String out){
            String[] input = in.split(" ");
            try(
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(out))
                    ){
                for (int i = 0; i < in.split(" ").length; i++) {
                    bufferedWriter.write(input[i]+"\n");
                }

            } catch (IOException e){
                e.printStackTrace();
                throw new RuntimeException();
            }
        }

        }
