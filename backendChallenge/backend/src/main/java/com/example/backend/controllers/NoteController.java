package com.example.backend.controllers;

import com.example.backend.model.Note;
import com.example.backend.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "http://localhost:4200")

public class NoteController {
    private NoteService noteService;



    @Autowired
    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }
    @CrossOrigin(origins = "http://localhost:4200")

    @GetMapping("/all")
    public ResponseEntity<List<Note>>findAll(){
        List<Note> notes = noteService.findAll();
        return ResponseEntity.ok(notes);
    }
    @CrossOrigin(origins = "http://localhost:4200")

    @GetMapping("/list")
    public ResponseEntity<List<Note>>getAllNotes(){
        List<Note> notes = noteService.getAllNotes();
        return ResponseEntity.ok(notes);
    }
    @CrossOrigin(origins = "http://localhost:4200")

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Integer id){
        Note note = noteService.geNoteById(id);
        if(note != null){
            return ResponseEntity.ok(note);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")

    @PostMapping("/create")
    public ResponseEntity<Note> createNote(@RequestBody Note note){
        Note createdNote = noteService.createNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNote);
    }



    @CrossOrigin(origins = "http://localhost:4200")


    @PutMapping("/edit/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Integer id, @RequestBody Note existingNote){
        Note updatedNote = noteService.updateNote(id, existingNote);
        if(updatedNote != null){
            return ResponseEntity.ok(updatedNote);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable Integer id){
        noteService.deleteNote(id);
        return ResponseEntity.ok("Nota eliminada correctamente");
    }

  /*  @PostMapping("/add-tag/{noteId}/{tagId}")
    public ResponseEntity<Note> addTagToNote(@PathVariable Integer noteId, @PathVariable Integer tagId) {
        Note updatedNote = noteService.addTagToNote(noteId, tagId);
        if (updatedNote != null) {
            return ResponseEntity.ok(updatedNote);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/filter-by-tag/{tagId}")
    public ResponseEntity<List<Note>> filterNotesByTag(@PathVariable Integer tagId) {
        List<Note> filteredNotes = noteService.filterNotesByTag(tagId);
        return ResponseEntity.ok(filteredNotes);
    }*/
}


