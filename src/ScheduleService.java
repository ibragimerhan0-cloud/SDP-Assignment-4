public class ScheduleService {

    private static final int MIN_TOTAL_MINUTES = 30;
    private static final int MAX_TOTAL_MINUTES = 180;

    public int calculateTheoryMinutes(int totalMinutes) {
        validateTime(totalMinutes);
        return totalMinutes / 2;
    }

    public int calculatePracticeMinutes(int totalMinutes) {
        return totalMinutes - calculateTheoryMinutes(totalMinutes);
    }

    private void validateTime(int totalMinutes) {
        if (totalMinutes < MIN_TOTAL_MINUTES
                || totalMinutes > MAX_TOTAL_MINUTES) {
            throw new IllegalArgumentException(
                    "Study time must be between " + MIN_TOTAL_MINUTES
                            + " and " + MAX_TOTAL_MINUTES + " minutes."
            );
        }
    }
}
