package br.com.javaspringcurso.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.javaspringcurso.data.vo.v2.PersonVOV2;
import br.com.javaspringcurso.model.Person;

@Service
public class PersonMapper {
    public PersonVOV2 convertEntityToVo(Person person) {
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setAddress(person.getAddress());
        vo.setGender(person.getGender());
        vo.setBirthDay(new Date()); // Aqui esta simulando pois o campo não será criado no banco
        return vo;
    } 
    
    public Person convertVoToEntity(PersonVOV2 person) {
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        //entity.setBirthDay(new Date()); // Aqui não existe pois o campo não será criado no banco
        return entity;
    }  
}
