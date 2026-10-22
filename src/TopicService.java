public class TopicService {

    private final String[] supportedTopics = {
            "Java", "Algorithms", "Databases"
    };

    public String validateTopic(String topic) {
        if (topic == null || topic.trim().isEmpty()) {
            throw new IllegalArgumentException("Topic must not be empty.");
        }

        String cleanedTopic = topic.trim();

        for (String supportedTopic : supportedTopics) {
            if (supportedTopic.equalsIgnoreCase(cleanedTopic)) {
                return supportedTopic;
            }
        }

        throw new IllegalArgumentException(
                "Supported topics: Java, Algorithms, Databases."
        );
    }
}
