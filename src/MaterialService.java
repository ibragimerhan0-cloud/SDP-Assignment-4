public class MaterialService {

    private static final int DETAILED_MATERIAL_MINUTES = 30;

    public String selectMaterial(String topic, int theoryMinutes) {
        if (theoryMinutes <= 0) {
            throw new IllegalArgumentException("Theory time must be positive.");
        }

        String basicMaterial;
        String detailedMaterial;

        if ("Java".equals(topic)) {
            basicMaterial = "Read about variables and if/else statements.";
            detailedMaterial = "Read about variables, conditions, loops, and arrays.";
        } else if ("Algorithms".equals(topic)) {
            basicMaterial = "Read about linear search.";
            detailedMaterial = "Read about linear search, binary search, and sorting.";
        } else if ("Databases".equals(topic)) {
            basicMaterial = "Read about tables and SELECT queries.";
            detailedMaterial = "Read about SELECT, WHERE, ORDER BY, and JOIN.";
        } else {
            throw new IllegalArgumentException("No materials for this topic.");
        }

        if (theoryMinutes < DETAILED_MATERIAL_MINUTES) {
            return basicMaterial;
        }

        return detailedMaterial;
    }
}
