package hw3.SurveyApp;

import org.springframework.data.jpa.repository.JpaRepository;

interface EntryRepository extends JpaRepository<Entry, Long>{
    
}
