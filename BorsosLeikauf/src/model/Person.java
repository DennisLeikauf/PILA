package model;

import main.Main;
import utils.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Person {

    private int id;

    private String name;

    private Address address;

    public Person(int id, String name, String residence) {
        this.id = id;
        this.name = name;
        this.address = new Address(id, residence);
    }

    public Person(String name, String residence) throws SQLException {
        this.id = getNewId();
        this.name = name;
        this.address = new Address(this.id, residence);
    }

    /**
     * Get the highest id from the database and set it to the current object.
     *
     * @return the id
     */
    private int getNewId() throws SQLException {
        ResultSet rs = DBHelper.getConnection().prepareStatement("SELECT MAX(id) FROM Person").executeQuery();
        if (rs.next()) {
            id = rs.getInt(1) + 1;
        }
        return 0;
    }

    /**
     * Insert the current object into the database.
     */
    public void save() throws SQLException {
        PreparedStatement ps = DBHelper.getConnection().prepareStatement("INSERT INTO Person (id, name) VALUES (?, ?)");
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.executeUpdate();
    }
}
