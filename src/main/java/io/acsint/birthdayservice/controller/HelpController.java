package io.acsint.birthdayservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/help")
@Tag(name = "Help", description = "Help endpoint for greeting")
public class HelpController {

    @GetMapping
    @Operation(
        summary = "Get a greeting message",
        description = "Returns a greeting message with the provided name or 'world' if no name is provided",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Successfully generated greeting",
                content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(
                        example = "{\"message\": \"Hello John\", \"name\": \"John\"}"
                    )
                )
            )
        }
    )
    public Map<String, String> hello(@RequestParam(value = "name", required = false) String name) {
        String caller = (name == null || name.isBlank()) ? "world" : name;
        return Map.of(
                "message", "Hello " + caller,
                "name", caller
        );
    }

}
