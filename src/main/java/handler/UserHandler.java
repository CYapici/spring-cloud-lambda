package handler;

import generator.IdGenerator;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import java.util.function.Function;

@Component("users")
public class UserHandler implements Function<Flux<User>, Flux<User>> {

    @Autowired
    IdGenerator builder;

    @Override
    public Flux<User> apply(Flux<User> users) {
        return users.flatMap(input -> Flux.just(builder.assignChildren(input)));
    }

}
