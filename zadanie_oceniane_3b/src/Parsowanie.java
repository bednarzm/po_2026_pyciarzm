import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Parsowanie {
    public static List<String> wszystkieZdarzenia(String relativePath) throws IOException {
        List<String> events = new ArrayList<>();
        Path path = Paths.get(relativePath);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        for (String line : lines) {
            validateLine(line);
            events.add(line);
        }
        return events;
    }

    public static List<String> zdublowanieZdarzenia(String relativePath) throws IOException {
        List<String> allEvents = wszystkieZdarzenia(relativePath);
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new LinkedHashSet<>();

        for (String event : allEvents) {
            if (!seen.add(event)) {
                duplicates.add(event);
            }
        }
        return new ArrayList<>(duplicates);
    }

    private static void validateLine(String line) {
        int colonIndex = line.indexOf(':');
        if (colonIndex == 0) {
            throw new IllegalArgumentException("Uszkodzone dane! Brak prefiksu w linii: " + line);
        }
    }

}
