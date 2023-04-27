package com.example.survey;

import org.springframework.data.jpa.repository.JpaRepository;

interface EntryRepository extends JpaRepository<Entry, Long>{
    
}
