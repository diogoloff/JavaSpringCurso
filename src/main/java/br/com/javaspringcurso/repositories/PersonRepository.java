package br.com.javaspringcurso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.javaspringcurso.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
