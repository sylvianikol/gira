package com.exam.gira.repository;

import com.exam.gira.model.entity.Classification;
import com.exam.gira.model.enums.ClassificaionName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Long> {

    Classification findByName(ClassificaionName name);
}
