package br.com.javaspringcurso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.javaspringcurso.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}
