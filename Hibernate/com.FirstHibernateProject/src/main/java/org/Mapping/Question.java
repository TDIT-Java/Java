package org.Mapping;

import jakarta.persistence.*;

import java.util.*;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String question;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinColumn(name = "answer_Id")
    private List<Answer> answerId;

    public Question() {
    }

    public Question(int id, String question, List<Answer> answerId) {
        this.id = id;
        this.question = question;
        this.answerId = answerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answerId;
    }

    public void setAnswers(List<Answer> answerId) {
        this.answerId = answerId;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answerId=" + answerId +
                '}';
    }
}
