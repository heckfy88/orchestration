package com.ai.sentiment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SentimentController {

    @GetMapping("/sentiment")
    public SentimentResponse sentiment(@RequestParam("text") String text) {
        String sentiment = "positive";
        if (text.length() % 2 > 0) {
            sentiment = "negative";
        }
        return new SentimentResponse(sentiment);
    }

    public record SentimentResponse(String sentiment) {}
}
