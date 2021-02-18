package com.exam.gira.service;

import com.exam.gira.model.entity.Classification;
import com.exam.gira.model.enums.ClassificaionName;

public interface ClassificationService {

    void initClassifications();

    Classification findByName(ClassificaionName classification);
}
