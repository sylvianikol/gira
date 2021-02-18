package com.exam.gira.service.impl;

import com.exam.gira.model.entity.Classification;
import com.exam.gira.model.enums.ClassificaionName;
import com.exam.gira.repository.ClassificationRepository;
import com.exam.gira.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClassificationServiceImpl implements ClassificationService {

    private final ClassificationRepository classificationRepository;

    @Autowired
    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public void initClassifications() {
        if (this.classificationRepository.count() == 0) {
            Arrays.stream(ClassificaionName.values()).forEach(value -> {
                Classification classification = new Classification();
                classification.setName(value);
                classification.setDescription("Description for " + value.name());

                this.classificationRepository.save(classification);
            });
        }
    }
}
