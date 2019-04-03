package generator;

import domain.User;
import domain.Pin;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
public class IdGenerator {
    private Random rnd;

    @PostConstruct
    public void init() {
        rnd = new Random(10000);
    }

    public User assignChildren(User user) {
        user.setPin(new Pin(Math.abs(rnd.nextInt())));
        return user;
    }
}
