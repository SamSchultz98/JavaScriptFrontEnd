package com.bootcamp.Tutorial.Repository;

import org.springframework.data.repository.CrudRepository;

import com.bootcamp.Tutorial.models.Item;


public interface ItemRepository extends CrudRepository<Item,Integer>{

}
