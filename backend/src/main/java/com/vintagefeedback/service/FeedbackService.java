package com.vintagefeedback.service;
import com.vintagefeedback.entity.Feedback;
import com.vintagefeedback.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public Page<Feedback> getFeedbacks(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return feedbackRepository.findAll(pageable);
    }

    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

}
