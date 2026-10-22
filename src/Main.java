public class Main {

    public static void main(String[] args) {
        StudyPlanFacade studyPlan = new StudyPlanFacade();

        printPlan(studyPlan, " java ", 60);
        printPlan(studyPlan, "Algorithms", 90);
        printPlan(studyPlan, "Biology", 60);
        printPlan(studyPlan, "Java", 10);
    }

    private static void printPlan(StudyPlanFacade studyPlan,
                                  String topic, int minutes) {
        try {
            System.out.println(studyPlan.createPlan(topic, minutes));
        } catch (IllegalArgumentException exception) {
            System.out.println(
                    "Cannot create study plan: " + exception.getMessage()
            );
        }
    }
}
