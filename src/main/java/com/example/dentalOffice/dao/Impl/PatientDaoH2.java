package com.example.dentalOffice.dao.Impl;

import com.example.dentalOffice.dao.IDao;
import com.example.dentalOffice.model.Patient;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDaoH2 implements IDao<Patient> {

    final static Logger log = Logger.getLogger(PatientDaoH2.class);

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_dental_office;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";

    @Override
    public Patient set(Patient patient) {
        log.debug("Setting new patient");
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO patients(dni, name, lastname, address, discharge_date) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, patient.getDni());
            preparedStatement.setString(2, patient.getName());
            preparedStatement.setString(3, patient.getLastname());
            preparedStatement.setString(4, patient.getAddress());
            preparedStatement.setDate(5, patient.getDischargeDate());

            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next())
                patient.setId(keys.getLong(1));

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
            log.error(throwables);
        }
        return patient;
    }

    @Override
    public void delete(Long id) {
        log.debug("Deleting patient with id: "+id);
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("DELETE FROM patients where id = ?");
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
            log.error(throwables);
        }
    }

    @Override
    public Patient get(Long id) {
        log.debug("Getting patient with id: "+id);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Patient patient = null;

        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT id, dni, name, lastname, address, discharge_date FROM patients WHERE id = ?");
            preparedStatement.setLong(1, id);

            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Long idPatient = result.getLong("id");
                String dni = result.getString("dni");
                String name = result.getString("name");
                String lastname = result.getString("lastname");
                String address = result.getString("address");
                java.sql.Date dischargeDate = result.getDate("discharge_date");

                patient = new Patient(idPatient, dni, name, lastname, address, dischargeDate);
            }
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
            log.error(throwables);
        }
        return patient;
    }

    @Override
    public List<Patient> getAll() {
        log.debug("Getting all patients");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Patient> patients = new ArrayList<>();

        try{
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("SELECT * FROM patients");

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()){
                Long idPatient = result.getLong("id");
                String dni = result.getString("dni");
                String name = result.getString("name");
                String lastname = result.getString("lastname");
                String address = result.getString("address");
                java.sql.Date dischargeDate = result.getDate("discharge_date");

                Patient patient = new Patient(idPatient, dni, name, lastname, address, dischargeDate);
                patients.add(patient);
            }
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            log.error(throwables);
        }
        return patients;
    }

    @Override
    public Patient update(Patient patient) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection. prepareStatement("UPDATE patients SET  dni = ?, name = ?, lastname = ?, address = ?, discharge_date = ? WHERE id = ?");

            preparedStatement.setString(1, patient.getDni());
            preparedStatement.setString(2, patient.getName());
            preparedStatement.setString(3, patient.getLastname());
            preparedStatement.setString(4, patient.getAddress());
            preparedStatement.setDate(5, patient.getDischargeDate());
            preparedStatement.setLong(6, patient.getId());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables){
            throwables.printStackTrace();
            log.error(throwables);
        }
        return patient;
    }
}
