package com.pietro.biblioteca.service;

import com.pietro.biblioteca.model.Autor;
import com.pietro.biblioteca.repository.AutorRepository;
import com.pietro.biblioteca.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public Autor findById(Long id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Autor não encontrado com o ID: " + id));
    }

    public Autor save(Autor autor) {
        return autorRepository.save(autor);
    }

    public Autor update(Long id, Autor autorDetails) {

        Autor existingAutor = autorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Autor não encontrado com o ID: " + id));

        existingAutor.setNome(autorDetails.getNome());
        existingAutor.setDataNascimento(autorDetails.getDataNascimento());
        existingAutor.setNacionalidade(autorDetails.getNacionalidade());
        existingAutor.setBiografia(autorDetails.getBiografia());
        existingAutor.setUrlSite(autorDetails.getUrlSite());
        existingAutor.setUrlFoto(autorDetails.getUrlFoto());

        return autorRepository.save(existingAutor);
    }

    public void deleteById(Long id) {
        if (!autorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Autor não encontrado com o ID: " + id);
        }
        autorRepository.deleteById(id);
    }
}