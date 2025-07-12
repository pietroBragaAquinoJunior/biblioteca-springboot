package com.pietro.biblioteca.service;

import com.pietro.biblioteca.model.Livro;
import com.pietro.biblioteca.model.Autor;
import com.pietro.biblioteca.repository.LivroRepository;
import com.pietro.biblioteca.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorService autorService;

    @Autowired
    public LivroService(LivroRepository livroRepository, AutorService autorService) {
        this.livroRepository = livroRepository;
        this.autorService = autorService;
    }

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro findById(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado com o ID: " + id));
    }

    public Livro save(Livro livro) {
        if (livro.getAutor() != null && livro.getAutor().getIdAutor() != null) {
            Autor autor = autorService.findById(livro.getAutor().getIdAutor());
            livro.setAutor(autor);
        } else {
            throw new IllegalArgumentException("Um livro deve ter um Autor associado.");
        }
        return livroRepository.save(livro);
    }

    public Livro update(Long id, Livro livroDetails) {
        Livro existingLivro = livroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado com o ID: " + id));

        existingLivro.setTitulo(livroDetails.getTitulo());
        existingLivro.setDescricao(livroDetails.getDescricao());
        existingLivro.setAnoPublicacao(livroDetails.getAnoPublicacao());
        existingLivro.setIsbn(livroDetails.getIsbn());
        existingLivro.setIdioma(livroDetails.getIdioma());
        existingLivro.setEditora(livroDetails.getEditora());
        existingLivro.setEdicao(livroDetails.getEdicao());
        existingLivro.setNumeroPaginas(livroDetails.getNumeroPaginas());
        existingLivro.setUrlCapa(livroDetails.getUrlCapa());

        if (livroDetails.getAutor() != null && livroDetails.getAutor().getIdAutor() != null) {
            Autor novoAutor = autorService.findById(livroDetails.getAutor().getIdAutor());
            existingLivro.setAutor(novoAutor);
        }

        else {
            existingLivro.setAutor(null);
        }

        return livroRepository.save(existingLivro);
    }

    public void deleteById(Long id) {
        if (!livroRepository.existsById(id)) {
            throw new ResourceNotFoundException("Livro não encontrado com o ID: " + id);
        }
        livroRepository.deleteById(id);
    }
}