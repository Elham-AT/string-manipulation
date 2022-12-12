package com.revature;

import com.revature.dao.SuperHeroDao;
import com.revature.dao.SuperHeroDaoImpl;
import com.revature.model.Superhero;
import com.revature.service.SuperheroService;
import com.revature.util.DaoFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // use -1 as a placeholder for id:
        Superhero superhero = new Superhero(-1, "Superman", "Flying", 20, "Kryptonite", "D", "Krypton");
        // Not good code, we should get the DAO from a factory:
        SuperheroService superheroService = new SuperheroService(DaoFactory.getSuperHeroDaoDummy());
        superheroService.save(superhero);
        System.out.println(superhero);
    }
}
