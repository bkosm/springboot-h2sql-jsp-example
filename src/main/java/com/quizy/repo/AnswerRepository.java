package com.quizy.repo;

import com.quizy.model.Answer;
import com.quizy.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
