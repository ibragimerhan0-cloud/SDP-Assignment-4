public class StudyPlanFacade {

    private final TopicService topics = new TopicService();
    private final ScheduleService schedule = new ScheduleService();
    private final MaterialService materials = new MaterialService();
    private final PracticeService practice = new PracticeService();

    public String createPlan(String topicName, int totalMinutes) {
        String topic = topics.validateTopic(topicName);

        int theoryMinutes = schedule.calculateTheoryMinutes(totalMinutes);
        int practiceMinutes = schedule.calculatePracticeMinutes(totalMinutes);

        String material = materials.selectMaterial(topic, theoryMinutes);
        String tasks = practice.prepareTasks(topic, practiceMinutes);

        return "=== Study Plan ===\n"
                + "Topic: " + topic + "\n"
                + "Total time: " + totalMinutes + " minutes\n"
                + "Theory: " + theoryMinutes + " minutes\n"
                + "Practice: " + practiceMinutes + " minutes\n"
                + "Material: " + material + "\n"
                + tasks;
    }
}
