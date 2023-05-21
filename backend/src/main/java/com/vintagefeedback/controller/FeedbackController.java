package com.vintagefeedback.controller;

import com.vintagefeedback.service.FeedbackService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vintagefeedback.entity.Feedback;
@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }
    @GetMapping
    public ResponseEntity<Page<Feedback>> getFeedbacks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int pageSize
    ) {
        Page<Feedback> feedbacks = feedbackService.getFeedbacks(page, pageSize);
        return ResponseEntity.ok(feedbacks);
    }

    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {
        Feedback createdFeedback = feedbackService.createFeedback(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFeedback);
    }

    // Other controller methods for updating and deleting feedback
}

