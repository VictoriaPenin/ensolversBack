package com.example.backend.implement;

import com.example.backend.model.Note;
import com.example.backend.repositories.NoteRepository;
import com.example.backend.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImp implements NoteService {
    private final NoteRepository repository;


    @Autowired
    public NoteServiceImp(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Note> getAllNotes(){
        return repository.findAll();
    }
    @Override
    public List<Note> findAll(){
        return repository.findAll();
    }



    @Override
    public Note geNoteById(Integer id) {
        return repository.findById(id).orElse(null);
    }



    @Override
    public Note createNote(Note note){
        return repository.save(note);
    }

    @Override
    public Note updateNote(Integer id, Note note){
        Note existingNote = repository.findById(id).orElse(null);

        if(existingNote != null){
            existingNote.setTitle(note.getTitle());
            existingNote.setContent(note.getContent());
            existingNote.setCreatedDate(note.getCreatedDate());
            repository.save(existingNote);
        }
        return existingNote;
    }

    @Override
    public void deleteNote(Integer id){
        repository.deleteById(id);
    }
}
