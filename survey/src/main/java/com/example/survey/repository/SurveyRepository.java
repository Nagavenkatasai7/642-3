// Team members:

// Chinmaya Raz Vaiisshnav Maddi - G01504185
// Abhiram Kolisetty - G01506075
// Naga Venkata Sai Chennu - G01514409 

package com.example.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.survey.model.Survey;

/**
 * Repository interface for Survey entity.
 * Inherits methods for CRUD operations from JpaRepository.
 */
@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {
    // Custom queries can be added here if necessary.
}
