package mx.tec.web.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

@WebMvcTest
class SitatyrChatAppBeApplicationTests {
    @Autowired
    private HttpClient client = HttpClient.newBuilder().build();

    @Test
    public void givenAUserId_1_WhenGetContacts_then2_and_4() throws Exception{
        HttpRequest req = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/api/contacts/1")).build();
        HttpResponse<String> res = client.send(req, BodyHandlers.ofString());
        System.out.println(res.body());
        assertEquals("", res.body());
    }
}
