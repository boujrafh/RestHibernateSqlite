package hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Hicham on 03-07-16.
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private static final String template1 = "Hello, %s!";
    private final AtomicLong counter1 = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name,
                             @RequestParam(value="surname", defaultValue="abc") String price)
    {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name),
                price
                );
    }

    @RequestMapping("/greet/{id}")
    public Greeting greet(@PathVariable long id)
    {
        return  new Greeting(id , "lala", "lala");

    }

    @RequestMapping("/options")
    public Options options (@RequestParam(value="name" , defaultValue = "Hicham") String name1)
    {
        return new Options(counter1.incrementAndGet(),
                String.format(template1,name1)
        );
    }
}