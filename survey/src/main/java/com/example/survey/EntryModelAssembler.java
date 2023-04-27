package com.example.survey;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
class EntryModelAssembler implements RepresentationModelAssembler<Entry, EntityModel<Entry>> {

  @Override
  public EntityModel<Entry> toModel(Entry entry) {

    return EntityModel.of(entry, //
        linkTo(methodOn(EntryController.class).one(entry.getId())).withSelfRel(),
        linkTo(methodOn(EntryController.class).all()).withRel("entries"));
  }
}