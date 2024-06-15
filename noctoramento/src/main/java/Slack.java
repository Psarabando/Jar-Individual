import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public abstract class Slack {
    public static void EnviarAlertaSlack(String mensagemErro){
        // URL do webhook do Slack
        final String slackWebhookUrl = "https://hooks.slack.com/services/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";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest requestSlack = HttpRequest.newBuilder()
                .uri(URI.create(slackWebhookUrl))
                .setHeader("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString("{\"text\":\""+mensagemErro+"\"}"))
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(requestSlack, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
