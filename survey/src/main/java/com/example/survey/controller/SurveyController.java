// Team members:

// Chinmaya Raz Vaiisshnav Maddi - G01504185
// Abhiram Kolisetty - G01506075
// Naga Venkata Sai Chennu - G01514409




package com.example.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.survey.model.Survey;
import com.example.survey.repository.SurveyRepository;

/**
 * REST controller for managing survey data.
 */
@RestController
@RequestMapping("/api/surveys")
@CrossOrigin(origins = "http://localhost:4200") // Allows Angular frontend calls
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepository; // Injecting the repository to interact with survey data

    /**
     * GET /api/surveys - Retrieve all surveys.
     */
    @GetMapping
    public List<Survey> getAllSurveys() {
        // Fetch and return all surveys from the database
        return surveyRepository.findAll();
    }

    /**
     * POST /api/surveys - Create a new survey.
     */
    @PostMapping
    public Survey createSurvey(@RequestBody Survey survey) {
        // Save the new survey to the database and return the saved survey object
        return surveyRepository.save(survey);
    }

    /**
     * PUT /api/surveys/{id} - Update an existing survey.
     */
    @PutMapping("/{id}")
    public Survey updateSurvey(@PathVariable Long id, @RequestBody Survey surveyDetails) {
        // Retrieve the survey by id; throw an exception if not found
        Survey survey = surveyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Survey not found with id " + id));
        // Update each field with the new values provided in surveyDetails
        survey.setFirstName(surveyDetails.getFirstName());
        survey.setLastName(surveyDetails.getLastName());
        survey.setStreetAddress(surveyDetails.getStreetAddress());
        survey.setCity(surveyDetails.getCity());
        survey.setState(surveyDetails.getState());
        survey.setZip(surveyDetails.getZip());
        survey.setTelephone(surveyDetails.getTelephone());
        survey.setEmail(surveyDetails.getEmail());
        survey.setDateOfSurvey(surveyDetails.getDateOfSurvey());
        survey.setLikedCampus(surveyDetails.getLikedCampus());
        survey.setInterestSource(surveyDetails.getInterestSource());
        survey.setRecommendation(surveyDetails.getRecommendation());
        survey.setComments(surveyDetails.getComments());
        // Save the updated survey back to the database and return it
        return surveyRepository.save(survey);
    }

    /**
     * DELETE /api/surveys/{id} - Delete a survey by ID.
     */
    @DeleteMapping("/{id}")
    public void deleteSurvey(@PathVariable Long id) {
        // Delete the survey with the specified id from the database
        surveyRepository.deleteById(id);
    }
}
