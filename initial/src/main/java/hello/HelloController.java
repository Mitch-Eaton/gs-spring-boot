package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

@SpringBootApplication
@Controller
public class HelloController
{
    private GreetingService greetingService;

    @ResponseBody
    @RequestMapping("/")
    public String helloWorld()
    {
        return "Hello, World!";
    }

    @ResponseBody
    @RequestMapping(value = "/", params = {"name"})
    public String helloName(@RequestParam("name") String name)
    {
        return this.greetingService.getGreeting(name);
    }

    @Inject
    public void setGreetingService(GreetingService greetingService)
    {
        this.greetingService = greetingService;
    }
    
    
    //hack discussed w/ Nick to avoid noSuchMethodError
    public static void main(String[] args) {
        SpringApplication.run(HelloController.class, args);
    }
}
