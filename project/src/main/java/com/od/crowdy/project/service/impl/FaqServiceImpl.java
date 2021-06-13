package com.od.crowdy.project.service.impl;

import com.od.crowdy.project.domain.neo4j.model.Faq;
import com.od.crowdy.project.domain.neo4j.repository.FaqRepository;
import com.od.crowdy.project.service.FaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class FaqServiceImpl implements FaqService {
    private final FaqRepository faqRepository;

    @Override
    public Flux<Faq> getProjectFaqsByProjectId(String projectId) {
        return this.faqRepository.findFaqsByProjectId(projectId);
    }
}
