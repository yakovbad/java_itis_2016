package org.itis.gv404.utils;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

public class CreateTable {

    public static void main(String[] args) {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:derby:db;create=true";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url);
            createTable(con);
            insertStudent(con);
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM customer");
            while (rs.next()){
                System.out.println(rs.getString("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            assert con != null;
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private static void createTable(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        String sql = "CREATE TABLE CUSTOMER " +
                "(id INTEGER not NULL GENERATED ALWAYS AS IDENTITY (START WITH  1, INCREMENT BY 1)," +
                "lastname VARCHAR(255), " +
                "firstname VARCHAR(255), " +
                "middlename VARCHAR(255), " +
                "age INTEGER, " +
                " PRIMARY KEY ( id ))";
        stmt.execute(sql);
    }

    private static void insertStudent(Connection con) {
        String sql = "INSERT INTO CUSTOMER(lastname, firstname, middlename, age) " +
                "VALUES ('Петров', 'Андрей', 'Витальевич', 18)," +
                "('Бадыгин', 'Яков', 'Васильевич', 19)," +
                "('Сидоров', 'Андрей', '�?гнатьевич', 18)," +
                "('Червяков', 'Артем', 'Сергеевич', 18)," +
                "('Гарифьянов', 'Рустем', '�?льдарович', 18)," +
                "('Козлов', 'Петр', '�?ванович', 19)," +
                "('Сидоров', 'Вася', '�?гнатьевич', 18)," +
                "('Воробьев', 'Моисей', 'Петрович', 20)," +
                "('Грачев', 'Акакий', 'Сергеевич', 18)," +
                "('Андреев', 'Владислав', 'Динарович', 19)";
        try {
            Statement stmt = con.createStatement();
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
