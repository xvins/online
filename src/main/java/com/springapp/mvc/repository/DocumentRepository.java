package com.springapp.mvc.repository;

import com.springapp.mvc.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
