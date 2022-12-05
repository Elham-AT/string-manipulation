package com.revature.dao;

import com.revature.model.Superhero;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SuperHeroDaoImpl implements SuperHeroDao{

    Connection connection;

    public SuperHeroDaoImpl() {
        this.connection = ConnectionFactory.getConnectionFactory().getConnection();
    }

    @Override
    public Superhero save(Superhero superhero) {
        // Use prepared statement to prevent SQL injection
        String sql = "insert into superhero values(default, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, superhero.getSuperhero_name());
            preparedStatement.setString(2, superhero.getSuper_power());
            preparedStatement.setInt(3, superhero.getStrength());
            preparedStatement.setString(4, superhero.getWeakness());
            preparedStatement.setString(5, superhero.getFranchise());
            preparedStatement.setString(6, superhero.getWorld());

            // this will actually execute the statement
            preparedStatement.executeUpdate();

            // Alter the save method so that it retrieves the id from the database and store it in the superhero object that you return
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()) {
                superhero.setId(rs.getInt("id"));
                return superhero;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Exercise: Fill out 4 other CRUD methods (GetById, GetAll, Update, Delete)
    @Override
    public List<Superhero> findAll() {
        try (Connection conn = ConnectionFactory.getConnectionFactory().getConnection()){
            List<Superhero> superheroes = new LinkedList<>();


            String sql = "select * from superhero";


            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Superhero superhero = new Superhero();

                superhero.setSuperhero_name(rs.getString("superhero_name"));
                superhero.setSuper_power(rs.getString("super_power"));
                superhero.setStrength(rs.getInt("strength"));
                superhero.setWeakness(rs.getString("weakness"));
                superhero.setFranchise(rs.getString("franchise"));
                superhero.setWorld(rs.getString("world"));
                superheroes.add(superhero);
            }

            return superheroes;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Superhero findById(int id) {
        try(Connection conn = ConnectionFactory.getConnectionFactory().getConnection()){
            String sql = "select * from superhero where id = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(!rs.next()){
                return null;
            }

            Superhero superhero = new Superhero();

            superhero.setSuperhero_name(rs.getString("superhero_name"));
            superhero.setSuper_power(rs.getString("super_power"));
            superhero.setStrength(rs.getInt("strength"));
            superhero.setWeakness(rs.getString("weakness"));
            superhero.setFranchise(rs.getString("franchise"));
            superhero.setWorld(rs.getString("world"));


            return superhero;

        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Superhero updatedSuperhero) {

        try (Connection conn = ConnectionFactory.getConnectionFactory().getConnection()) {

            String sql = "update superhero set strength = ? where id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setFloat(1, updatedSuperhero.getStrength());
            ps.setInt(2, updatedSuperhero.getId());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try (Connection conn = ConnectionFactory.getConnectionFactory().getConnection()){

            Superhero superhero = findById(id);
            String sql = "delete from superhero where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, superhero.getId());
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    // Make some more fun queries like get by power, strength, etc.
    public Superhero findByPower(String power) {
        try(Connection conn = ConnectionFactory.getConnectionFactory().getConnection()){
            String sql = "select * from superhero where super_Power = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, power);

            ResultSet rs = ps.executeQuery();

            if(!rs.next()){
                return null;
            }

            Superhero superhero = new Superhero();

            superhero.setSuperhero_name(rs.getString("superhero_name"));
            superhero.setSuper_power(rs.getString("super_power"));
            superhero.setStrength(rs.getInt("strength"));
            superhero.setWeakness(rs.getString("weakness"));
            superhero.setFranchise(rs.getString("franchise"));
            superhero.setWorld(rs.getString("world"));


            return superhero;

        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Superhero findByStrength(String strength) {
        try(Connection conn = ConnectionFactory.getConnectionFactory().getConnection()){
            String sql = "select * from superhero where strength = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, strength);

            ResultSet rs = ps.executeQuery();

            if(!rs.next()){
                return null;
            }

            Superhero superhero = new Superhero();

            superhero.setSuperhero_name(rs.getString("superhero_name"));
            superhero.setSuper_power(rs.getString("super_power"));
            superhero.setStrength(rs.getInt("strength"));
            superhero.setWeakness(rs.getString("weakness"));
            superhero.setFranchise(rs.getString("franchise"));
            superhero.setWorld(rs.getString("world"));


            return superhero;

        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
