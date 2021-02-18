package com.exam.gira.service;

import com.exam.gira.model.entity.Classification;
import com.exam.gira.model.enums.ClassificationName;

public interface ClassificationService {

    void initClassifications();

    Classification findByName(ClassificationName classification);
}
