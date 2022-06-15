package com.example.dentalOffice.dao.Impl;

import com.example.dentalOffice.dao.IDao;
import com.example.dentalOffice.model.Odontologist;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class OdontologistDaoH2 implements IDao<Odontologist> {

    final static Logger log = Logger.getLogger(OdontologistDaoH2.class);

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_dental_office;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";

    @Override
    public Odontologist set(Odontologist odontologist) {
        log.debug("Setting a new odontologist");
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO ondontologists(license, name, lastname) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, odontologist.getLicense());
            preparedStatement.setString(2, odontologist.getName());
            preparedStatement.setString(3, odontologist.getLastname());

            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next())
                odontologist.setId(keys.getLong(1));

            preparedStatement.close();
        }catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
            log.error(throwables);
        }
        return odontologist;
    }

    @Override
    public Odontologist update(Odontologist odontologist) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("UPDATE odontologists SET license = ?, name = ?, lastname = ? WHERE id = id");
            preparedStatement.setString(1, odontologist.getLicense());
            preparedStatement.setString(2, odontologist.getName());
            preparedStatement.setString(3, odontologist.getLastname());
            preparedStatement.setLong(4, odontologist.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
            log.error(throwables);
        }
        return odontologist;
    }

    @Override
    public Odontologist get(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologist odontologist = null;

        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT id, license, name, lastname FROM odontologists WHERE id = ?");
            preparedStatement.setLong(1, id);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()){
                Long idOdotologist = result.getLong("id");
                String license = result.getString("license");
                String name = result.getString("name");
                String lastname = result.getString("lastname");

                odontologist = new Odontologist(idOdotologist, license, name, lastname);
            }
            preparedStatement.close();
        }catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
            log.error(throwables);
        }
        return odontologist;
    }

    @Override
    public void delete(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("DELETE FROM odontologists WHERE id = ?");
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
            log.error(throwables);
        }
    }

    @Override
    public List<Odontologist> getAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologist> odontologists = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT * FROM odontologists");

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()){
                Long idOdontologist = result.getLong("id");
                String license = result.getString("license");
                String name = result.getString("name");
                String lastname = result.getString("lastname");

                Odontologist odontologist = new Odontologist(idOdontologist, license, name, lastname);
                odontologists.add(odontologist);
            }
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
            log.error(throwables);
        }
        return odontologists;
    }
}
