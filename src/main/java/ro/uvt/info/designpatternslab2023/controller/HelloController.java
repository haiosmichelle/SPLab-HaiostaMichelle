package ro.uvt.info.designpatternslab2023.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.uvt.info.designpatternslab2023.difexample.ClientComponent;

@RestController
public class HelloController {
    private final ClientComponent clientComponent;

    @Autowired
    public HelloController(ClientComponent clientComponent) {
        this.clientComponent =  clientComponent;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello from ClientComponent = " + clientComponent.toString();
    }
}
