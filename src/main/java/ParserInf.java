import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ParserInf {
    private String name;
    private String URL;

    public ParserInf(String name) throws FileNotFoundException {
        this.name = name;
        this.URL = formURL();
    }

    private String formURL() throws FileNotFoundException {
        File file = new File("D:/parser.txt");
        Scanner scanner = new Scanner(file);
        return scanner.nextLine();
    }

    public void contentInformation(String message) throws IOException, InterruptedException {
        String json = makeHttp();
        JsonObject root = JsonParser.parseString(json).getAsJsonObject();


    }

    private String makeHttp() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("User-Agent", "MyBot/1.0")
                .GET().build();
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        return response.body();

    }
}
