package incident;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadDataFromLog {
    public static final String LOG_FILE_NAME = "1form-logs.csv";

    public static String path = "/Users/zeyan_REA/WorkSpace/learn/design-pattern-demo/src/main/resources/all-logs-JSON.csv";

    // toString() will have quote，asText() will not have quote
    public static void main(String[] args) throws IOException {
        File target = new File(LOG_FILE_NAME);
        LineIterator iterator = FileUtils.lineIterator(new File(path), UTF_8.toString());

        FileUtils.writeStringToFile(target, "timestamp,ip,username", UTF_8);
        FileUtils.writeStringToFile(target, System.lineSeparator(), UTF_8.toString(), true);

        while (iterator.hasNext()) {
            final String line = iterator.nextLine();
            JsonNode jsonNodes = new ObjectMapper().readTree(line);

            String timestamp = jsonNodes.get("timestamp").toString();

            String ip = jsonNodes.get("user_ip").elements().next().get("x_forwarded_for").toString();

            String email = "";
            JsonNode customLoggingNode = jsonNodes.get("custom_logging").get("Authentication Attempt");
            if (customLoggingNode != null) {
                email = customLoggingNode.get("User Email").asText();
            } else {
                JsonNode tenantNode = jsonNodes.get("session").get("data").get("tenant___name");
                if (tenantNode != null) {
                    email = tenantNode.asText();
                } else {
                    email = jsonNodes.get("session").get("data").get("_agent__name").asText();
                }
            }

            FileUtils.writeStringToFile(target, String.format("%s,%s,%s", timestamp, ip, email), UTF_8.toString(), true);
            FileUtils.writeStringToFile(target, System.lineSeparator(), UTF_8.toString(), true);
        }
    }
}
