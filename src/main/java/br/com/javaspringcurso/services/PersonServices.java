package br.com.javaspringcurso.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.javaspringcurso.exceptions.ResourceNotFoundException;
import br.com.javaspringcurso.mapper.DozerMapper;
import br.com.javaspringcurso.mapper.custom.PersonMapper;
import br.com.javaspringcurso.model.Person;
import br.com.javaspringcurso.data.vo.v1.PersonVO;
import br.com.javaspringcurso.data.vo.v2.PersonVOV2;
import br.com.javaspringcurso.repositories.PersonRepository;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    private PersonMapper mapper;

    public List<PersonVO> findAll() {

        logger.info("Find all people");

        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO findById(Long id) {

        logger.info("Find one person");

        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public PersonVO create(PersonVO person) {
        logger.info("Creating one person");

        Person entity = DozerMapper.parseObject(person, Person.class);
        PersonVO vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVOV2 createV2(PersonVOV2 person) {
        logger.info("Creating one person V2");

        Person entity = mapper.convertVoToEntity(person);
        PersonVOV2 vo = mapper.convertEntityToVo(repository.save(entity));
        return vo;
    }

    public PersonVO update(PersonVO person) {
        logger.info("Update one person");

        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        PersonVO vo = DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVOV2 updateV2(PersonVOV2 person) {
        logger.info("Update one person V2");

        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        //entity.setBirthDay(person.getBirthDay());

        PersonVOV2 vo = mapper.convertEntityToVo(repository.save(entity));
        return vo;
    }

    public void delete(Long id) {
        logger.info("Delete one person");

        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

        repository.delete(entity);
    }
}
