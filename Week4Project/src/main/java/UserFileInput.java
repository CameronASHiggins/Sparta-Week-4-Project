import com.sparta.CSVFileHandler;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

// TODO: Refactor into project
public class UserFileInput {

    public static void run() {
//        String to store CSV
        String getCsv = null;

//        create a CSV file handler
        CSVFileHandler csvFileHandler = new CSVFileHandler();

//        use File to check if exists
        File file = new File(userInputText());

//        loop until file found
        while (!file.isFile()){
            file = new File(userInputText());
        }

            try {
                csvFileHandler.setFileName(file.getAbsolutePath());
                getCsv = csvFileHandler.readCSV();

            } catch (IOException e) {
                e.printStackTrace();

//                throw new RuntimeException(e);
            }

        System.out.println(getCsv);

    }

//    Scanner input to return a string
    private static String userInputText(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("(Example): C:\\Users\\userName\\IdeaProjects\\Sparta-Week-4-Project\\Week4Project\\src\\main\\java\\com\\sparta\\employees01.csv");

        System.out.print("Please input the full absolute filename: ");

        String filename = scanner.next();

        return filename;


    }

}
