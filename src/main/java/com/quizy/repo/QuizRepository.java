package com.quizy.repo;

import com.quizy.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    List<Quiz> findAllByUserId(Integer userId);
}
