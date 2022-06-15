package com.example.dentalOffice.dao.Impl;

import com.example.dentalOffice.dao.IDao;
import com.example.dentalOffice.model.Turn;
import org.apache.log4j.Logger;

import java.util.List;

public class TurnDaoH2 implements IDao<Turn> {

    final static Logger log = Logger.getLogger(TurnDaoH2.class);

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_dental_office;INIT=RUNSCRIPT FROM 'create.sql'";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";

    @Override
    public Turn set(Turn turn) {
        return null;
    }

    @Override
    public Turn update(Turn turn) {
        return null;
    }

    @Override
    public Turn get(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Turn> getAll() {
        return null;
    }
}
