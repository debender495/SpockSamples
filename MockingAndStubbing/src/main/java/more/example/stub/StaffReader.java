package more.example.stub;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StaffReader {

    //add a unit test for this
    public static Map<String, Staff> getStaffMap(String staffFirstname) {
        return employMap.entrySet().stream()
                .filter(map -> staffFirstname.equals(map.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static final Map<String, Staff> employMap = Stream.of(
            new AbstractMap.SimpleEntry<>("Ram", new Staff(10, "Ram", "Rama")),
            new AbstractMap.SimpleEntry<>("Ram", new Staff(11, "Shyam", "Shyama")),
            new AbstractMap.SimpleEntry<>("Ram", new Staff(12, "Jodu", "Jodua")),
            new AbstractMap.SimpleEntry<>("Ram", new Staff(13, "Modhu", "Modhua")))
            .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));
}
