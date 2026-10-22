public class PracticeService {

    private static final int MINUTES_PER_TASK = 15;

    public String prepareTasks(String topic, int practiceMinutes) {
        if (practiceMinutes < MINUTES_PER_TASK) {
            throw new IllegalArgumentException(
                    "Practice needs at least " + MINUTES_PER_TASK + " minutes."
            );
        }

        String[] tasks = getTasks(topic);
        int taskCount = Math.min(
                practiceMinutes / MINUTES_PER_TASK, tasks.length
        );

        StringBuilder result = new StringBuilder(
                "Tasks (" + MINUTES_PER_TASK + " minutes each):\n"
        );

        for (int i = 0; i < taskCount; i++) {
            result.append(i + 1)
                    .append(". ")
                    .append(tasks[i])
                    .append("\n");
        }

        int reviewMinutes = practiceMinutes - taskCount * MINUTES_PER_TASK;

        if (reviewMinutes > 0) {
            result.append("Review your solutions for ")
                    .append(reviewMinutes)
                    .append(" min.\n");
        }

        return result.toString();
    }

    private String[] getTasks(String topic) {
        if ("Java".equals(topic)) {
            return new String[] {
                    "Check if a number is even or odd.",
                    "Find the largest number in an array.",
                    "Calculate the sum of all numbers in an array."
            };
        }

        if ("Algorithms".equals(topic)) {
            return new String[] {
                    "Implement linear search.",
                    "Implement binary search in a sorted array.",
                    "Sort an array using bubble sort."
            };
        }

        if ("Databases".equals(topic)) {
            return new String[] {
                    "Write a SELECT query for a Students table.",
                    "Filter students by grade and sort the results.",
                    "Join Students and Courses using an enrollment table."
            };
        }

        throw new IllegalArgumentException("No tasks for this topic.");
    }
}
