package br.com.javaspringcurso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.javaspringcurso.data.vo.v2.PersonVOV2;
import br.com.javaspringcurso.services.PersonServices;
import br.com.javaspringcurso.util.MediaType;

@RestController
@RequestMapping("/api/person/v2")
public class PersonControllerV2 {

    @Autowired
    private PersonServices service;
    // private PersonServices service = new PersonServices(); o Autowired cuida disto automaticamente para a variavel declarada a baixo
    // basta para isto que na classe em questão ela tenha a notação Service

    @PostMapping(
        consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }, 
        produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })    
    public PersonVOV2 createV2(@RequestBody PersonVOV2 person) {
        return service.createV2(person);
    }

    @PutMapping(
        consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }, 
        produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })    
    public PersonVOV2 updateV2(@RequestBody PersonVOV2 person) {
        return service.updateV2(person);
    }
}
