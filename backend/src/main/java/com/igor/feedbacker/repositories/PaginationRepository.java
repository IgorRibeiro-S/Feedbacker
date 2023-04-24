package com.igor.feedbacker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igor.feedbacker.entities.Pagination;

@Repository
public interface PaginationRepository extends JpaRepository<Pagination, String> {
}
