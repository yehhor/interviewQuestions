package com.questions.repository;

import com.questions.model.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yehor on 29.06.2016.
 */
public class DataAccesObject {

    private static DataAccesObject dao;
    private static final Logger LOG = LoggerFactory.getLogger(DataAccesObject.class);

    private DataAccesObject() {

    }

    public static DataAccesObject getInstance() {
        if (dao == null)
            dao = new DataAccesObject();
        return dao;
    }

    private Connection con = null;
    private final String username = "postgres";
    private final String password = "";
    private final String URL = "jdbc:postgresql://localhost:5432/questions";

    public List<Question> getAll() {

        List<Question> list = new ArrayList<>();
        try {

            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(URL, username, password);
            if (con != null) LOG.debug("Connection succesfull");
            if (con == null) System.exit(0);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from questions");
            while (rs.next()) {
                Question question = new Question(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(4));
                LOG.debug("Adding entity to the list: " + question);
                list.add(question);
            }
            System.out.println();
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (con != null) con.close();
        } catch (Exception e) {
            LOG.debug(e.toString());
        }
        LOG.info(list.toString());
        return list;
    }

}


