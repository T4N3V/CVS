import java.util.Arrays;
import java.util.List;

public class PersonMapperTest {
    public static void main(String[] args) {
        List<String[]> rows = Arrays.asList(
                row("Date", "Time", "Full name", "User", "Event context",
                        "Component", "Event name", "Description", "IP"),
                row("2026-01-01", "12:34", "First user", "-", "Course A",
                        "System", "Viewed", "First event", "192.0.2.1"),
                row("2026-01-02", "13:45", "Second user", "-", "Course B",
                        "System", "Updated", "Second event", "192.0.2.2"));

        List<Person> people = PersonMapper.fromRows(rows);

        if (people.size() != 2) {
            throw new AssertionError(
                    "expected one Person per data row, but got " + people.size());
        }

        String first = people.get(0).toString();
        assertContains(first, "date: 2026-01-01, 12:34");
        assertContains(first, "fullName='First user'");
        assertContains(first, "eventContext='Course A'");
        assertContains(first, "component='System'");
        assertContains(first, "eventName='Viewed'");
        assertContains(first, "description='First event'");
        assertContains(first, "IP='192.0.2.1'");
    }

    private static void assertContains(String value, String expected) {
        if (!value.contains(expected)) {
            throw new AssertionError(
                    "expected mapped record to contain " + expected + ", but was: " + value);
        }
    }

    private static String[] row(String... fields) {
        return fields;
    }
}
