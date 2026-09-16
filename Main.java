import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException, CsvException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\og5\\IdeaProjects\\CVS\\src\\records.txt"));
        String fileName = "C:\\Users\\og5\\IdeaProjects\\CVS\\src\\Logs_moodle.csv";
        try {
            CSVReader reader = new CSVReader(new FileReader(fileName));
            List<String[]> r = reader.readAll();
            List<Person> people = PersonMapper.fromRows(r);

            for (int i = 0; i < people.size(); i++) {
                writer.write(people.get(i).toString());
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
