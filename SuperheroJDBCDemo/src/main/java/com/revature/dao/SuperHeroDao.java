package com.revature.dao;

import com.revature.model.Superhero;

import java.util.List;

public interface SuperHeroDao {
    // CRUD:
    Superhero save(Superhero superhero);
    List<Superhero> findAll();
    Superhero findById(int id);

    // Update
    boolean update(Superhero updatedObject);

    //Delete
    boolean delete(int id);
}
