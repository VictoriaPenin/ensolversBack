package com.example.backend.services;


import com.example.backend.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteService {
    List<Note> getAllNotes();
    Note geNoteById(Integer id);
    Note createNote(Note note);
    Note updateNote(Integer Id, Note existinNote);
    void deleteNote(Integer id);
    List<Note> findAll();

}
