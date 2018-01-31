package com.example.demo;
import org.springframework.data.repository.CrudRepository;
public interface AddressBook extends CrudRepository<People, Long>{

    //Iterable<People> findAllByNameAndEmailAndPhoneNumber(String people);

}

