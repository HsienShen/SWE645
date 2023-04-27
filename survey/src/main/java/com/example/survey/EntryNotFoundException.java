package com.example.survey;

public class EntryNotFoundException extends RuntimeException {
    
    EntryNotFoundException(Long id) {
        super("Could not find survey entry " + id);
      }
}
