package com.quizy.repo;

import com.quizy.model.Question;
import com.quizy.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
