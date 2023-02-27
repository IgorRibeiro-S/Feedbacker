package com.igor.feedbacker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor.feedbacker.entities.Feedbacks;

@Repository
public interface FeedbacksRepository extends JpaRepository<Feedbacks, String> {
	public List<Feedbacks> findByTypeContains(String type);
}
