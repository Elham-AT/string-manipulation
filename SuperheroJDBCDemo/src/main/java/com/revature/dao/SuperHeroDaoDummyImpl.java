package com.revature.dao;

import com.revature.model.Superhero;

import java.util.List;

public class SuperHeroDaoDummyImpl implements SuperHeroDao {

    @Override
    public Superhero save(Superhero superhero) {
        // simulate the auto_increment with some arbitrary id value:
        superhero.setId(45);
        return superhero;
    }

    @Override
    public List<Superhero> findAll() {
        return null;
    }

    @Override
    public Superhero findById(int id) {
        return null;
    }

    @Override
    public boolean update(Superhero updatedObject) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}