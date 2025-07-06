package com.example.quizattemptdetails.repository;

import com.example.quizattemptdetails.model.Attempt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    @Query("""
        SELECT DISTINCT a FROM Attempt a
        JOIN FETCH a.user u
        JOIN FETCH a.attemptQuestions aq
        JOIN FETCH aq.question q
        JOIN FETCH aq.attemptOptions ao
        JOIN FETCH ao.option o
        WHERE u.id = :userId AND a.id = :attemptId
    """)
    Attempt getAttempt(@Param("userId") int userId, @Param("attemptId") int attemptId);
}
