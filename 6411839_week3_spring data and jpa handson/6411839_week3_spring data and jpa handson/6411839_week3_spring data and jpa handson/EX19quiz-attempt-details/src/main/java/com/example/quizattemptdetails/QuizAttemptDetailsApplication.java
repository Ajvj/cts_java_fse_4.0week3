package com.example.quizattemptdetails;

import com.example.quizattemptdetails.model.*;
import com.example.quizattemptdetails.service.AttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class QuizAttemptDetailsApplication implements CommandLineRunner {

    @Autowired
    private AttemptService attemptService;

    public static void main(String[] args) {
        SpringApplication.run(QuizAttemptDetailsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        int userId = 1;     // Replace with valid user ID from your DB
        int attemptId = 1;  // Replace with valid attempt ID from your DB

        Attempt attempt = attemptService.getAttempt(userId, attemptId);

        if (attempt != null) {
            Set<AttemptQuestion> attemptQuestions = attempt.getAttemptQuestions();

            if (attemptQuestions != null && !attemptQuestions.isEmpty()) {
                for (AttemptQuestion aq : attemptQuestions) {
                    Question q = aq.getQuestion();
                    if (q != null) {
                        System.out.println("\n" + q.getText());

                        List<AttemptOption> attemptOptions = aq.getAttemptOptions();
                        if (attemptOptions != null) {
                            for (AttemptOption ao : attemptOptions) {
                                Option opt = ao.getOption();
                                if (opt != null) {
                                    System.out.printf("%d) %s\t%.1f\t%b\n",
                                            opt.getId(),
                                            opt.getText(),
                                            opt.getScore(),
                                            ao.isSelected());
                                }
                            }
                        }
                    }
                }
            } else {
                System.out.println("No questions found for this attempt.");
            }
        } else {
            System.out.println("Attempt not found for userId = " + userId + " and attemptId = " + attemptId);
        }
    }
}
