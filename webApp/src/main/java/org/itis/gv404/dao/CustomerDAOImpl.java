package org.itis.gv404.dao;


import org.itis.gv404.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO{

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Customer> getAll() {
        String sql = "SELECT * FROM customer";

        return this.jdbcTemplate.query(sql , new BeanPropertyRowMapper<Customer>(Customer.class));
    }

    @Override
    public void addCustomer(final Customer customer) {
        String sql = "INSERT INTO customer(lastname, firstname, middlename, age)" +
                "VALUES (?, ?, ?, ?)";

        this.jdbcTemplate.update(sql, customer.getLastName(), customer.getFirstName(), customer.getMiddleName(), customer.getAge());
    }

    @Override
    public Customer findById(Integer id) {
        String sql = "SELECT * FROM customer WHERE id = ?";

        return this.jdbcTemplate.queryForObject(sql,new Object[]{id}, new BeanPropertyRowMapper<Customer>(Customer.class));
    }

    @Override
    public void deleteCustomerById(Integer id) {
        String sql = "DELETE FROM customer WHERE id = ?";

        this.jdbcTemplate.update(sql, id);
    }
}
