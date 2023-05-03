package hw3.SurveyApp;

public class EntryNotFoundException extends RuntimeException {
    
    EntryNotFoundException(Long id) {
        super("Could not find survey entry " + id);
      }
}