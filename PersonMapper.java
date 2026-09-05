import java.util.ArrayList;
import java.util.List;

final class PersonMapper {
    private PersonMapper() {
    }

    static List<Person> fromRows(List<String[]> rows) {
        List<Person> people = new ArrayList<>();

        // The first row contains the CSV headings.
        for (int i = 1; i < rows.size(); i++) {
            String[] row = rows.get(i);
            people.add(new Person(
                    row[0], row[1], row[2], row[3], row[4], row[5], row[6]));
        }

        return people;
    }
}
