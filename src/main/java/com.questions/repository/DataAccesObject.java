package com.questions.repository;

import com.questions.model.Question;

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
            //Загружаем драйвер
            con = DriverManager.getConnection(URL, username, password);
            //соединяемся
            if (con != null) System.out.println("Connection Successful !\n");
            if (con == null) System.exit(0);
            Statement st = con.createStatement();
            //Statement позволяет отправлять запросы базе данных
            ResultSet rs = st.executeQuery("select * from questions");
            //ResultSet получает результирующую таблицу
            int x = rs.getMetaData().getColumnCount();
            //Resultset.getMetaData() получаем информацию
            //результирующей таблице
            while (rs.next()) {
                Question question = new Question(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(4));
                System.out.println("Adding entity to the list: " + question);
                list.add(question);
            }
            System.out.println();
            if (rs != null) rs.close();
            if (st != null) st.close();
            if (con != null) con.close();
        } catch (Exception e) {
            System.out.println("Exception happened");
        }
        System.out.println(list);
        return list;
    }

}


