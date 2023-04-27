package com.example.survey;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.CollectionModel;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.hateoas.IanaLinkRelations;


@RestController
public class EntryController {

    private final EntryRepository repository; 
    private final EntryModelAssembler assembler;   

    EntryController(EntryRepository repository, EntryModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    CollectionModel<EntityModel<Entry>> all() {

      List<EntityModel<Entry>> entries = repository.findAll().stream()
          .map(assembler::toModel) //
          .collect(Collectors.toList());
    
      return CollectionModel.of(entries, linkTo(methodOn(EntryController.class).all()).withSelfRel());
    }
    // end::get-aggregate-root[]

    @PostMapping("/entries")
    ResponseEntity<?> newEntry(@RequestBody Entry newEntry) {

      EntityModel<Entry> entityModel = assembler.toModel(repository.save(newEntry));
    
      return ResponseEntity //
          .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
          .body(entityModel);
    }

    // Single item
  
    @GetMapping("/entries/{id}")
    EntityModel<Entry> one(@PathVariable Long id) {
        
        Entry entry = repository.findById(id) //
          .orElseThrow(() -> new EntryNotFoundException(id));

        return assembler.toModel(entry);
    }

    @PutMapping("/entries/{id}")
    ResponseEntity<?> replaceEntry(@RequestBody Entry newEntry, @PathVariable Long id) {
      
      Entry updatedEntry = repository.findById(id) //
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

        EntityModel<Entry> entityModel = assembler.toModel(updatedEntry);

        return ResponseEntity //
            .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
            .body(entityModel);
    }

    @DeleteMapping("/entries/{id}")
    ResponseEntity<?> deleteEntry(@PathVariable Long id) {
      repository.deleteById(id);
      return ResponseEntity.noContent().build();
    }
}
