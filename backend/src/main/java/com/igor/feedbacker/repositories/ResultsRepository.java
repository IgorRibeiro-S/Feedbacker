package com.igor.feedbacker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor.feedbacker.entities.Results;

@Repository
public interface ResultsRepository extends JpaRepository<Results, String> {
}
