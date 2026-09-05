import java.util.Arrays;
import java.util.List;

public class PersonMapperTest {
    public static void main(String[] args) {
        List<String[]> rows = Arrays.asList(
                row("Date", "Full name", "Event context", "Component", "Event name", "Description", "IP"),
                row("2026-01-01", "First user", "Course A", "System", "Viewed", "First event", "192.0.2.1"),
                row("2026-01-02", "Second user", "Course B", "System", "Updated", "Second event", "192.0.2.2"));

        List<Person> people = PersonMapper.fromRows(rows);

        if (people.size() != 2) {
            throw new AssertionError(
                    "expected one Person per data row, but got " + people.size());
        }
    }

    private static String[] row(String... fields) {
        return fields;
    }
}
