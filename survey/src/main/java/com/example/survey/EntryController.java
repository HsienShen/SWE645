package com.example.survey;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntryController {

    private final EntryRepository repository;    

    EntryController(EntryRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/entries")
    List<Entry> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/entries")
    Entry newEntry(@RequestBody Entry newEntry) {
      return repository.save(newEntry);
    }

    // Single item
  
    @GetMapping("/entries/{id}")
    Entry one(@PathVariable Long id) {
        
        return repository.findById(id)
        .orElseThrow(() -> new EntryNotFoundException(id));
    }

    @PutMapping("/entries/{id}")
    Entry replaceEntry(@RequestBody Entry newEntry, @PathVariable Long id) {
      
      return repository.findById(id)
        .map(entry -> {
          entry.setFirst(newEntry.getFirst());
          entry.setLast(newEntry.getLast());
          entry.setStreet(newEntry.getStreet());
          entry.setCity(newEntry.getCity());
          entry.setState(newEntry.getState());
          entry.setZip(newEntry.getZip());
          entry.setTelephone(newEntry.getTelephone());
          entry.setEmail(newEntry.getEmail());
          entry.setDate(newEntry.getDate());
          entry.setLikes(newEntry.getLikes());
          entry.setInterest(newEntry.getInterest());
          entry.setRecommend(newEntry.getRecommend());
          return repository.save(entry);
        })
        .orElseGet(() -> {
          newEntry.setId(id);
          return repository.save(newEntry);
        });
    }

    @DeleteMapping("/entries/{id}")
    void deleteEntry(@PathVariable Long id) {
      repository.deleteById(id);
    }
}
