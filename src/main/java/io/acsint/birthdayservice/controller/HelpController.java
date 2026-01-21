package io.acsint.birthdayservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/help")
public class HelpController {

    @GetMapping
    public Map<String, String> hello(@RequestParam(value = "name", required = false) String name) {
        String caller = (name == null || name.isBlank()) ? "world" : name;
        return Map.of(
                "message", "Hello " + caller,
                "name", caller
        );
    }

}
