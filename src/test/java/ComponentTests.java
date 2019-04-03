import config.Config;
import domain.Pin;
import domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Config.class})
public class ComponentTests {

    private String BASE_URL = "http://localhost:8080/";
    private String jSON_REQUEST = "[ {\"pin\":{\"value\":\"1\"}}, {\"pin\":{\"value\":\"2\"}}, {\"pin\":{\"value\":\"3\"}} ]";
    private Flux<User> users;

    @Before
    public void init() {
        createUsers();
    }

    private void createUsers() {
        users = Flux.just(new User(new Pin(122)));
    }

    @Test
    public void jsonCall() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate
                .exchange(BASE_URL + "users", POST, buildJsonRequest(), String.class);
        assertThat(response, notNullValue());
        assertEquals(response.getStatusCode(), OK);
    }

    @Test
    public void serPojoCall() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate
                .exchange(BASE_URL + "users", POST, buildSerObjectRequest(), String.class);
        assertThat(response, notNullValue());
        assertEquals(response.getStatusCode(), OK);
    }

    private HttpEntity<String> buildJsonRequest() {
        return new HttpEntity<>(jSON_REQUEST);
    }

    private HttpEntity<Flux<User>> buildSerObjectRequest() {
        return new HttpEntity<>(users);
    }

}
