package org.itis.gv404.dao;


import org.itis.gv404.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
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
        return this.jdbcTemplate.query("SELECT * FROM customer" , new CustomerMapper());
    }

    private static final class CustomerMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
            Customer customer = new Customer();

            customer.setLastName(resultSet.getString("lastname"));
            customer.setFirstName(resultSet.getString("firstname"));
            customer.setMiddleName(resultSet.getString("middlename"));
            customer.setAge(resultSet.getInt("age"));

            return customer;
        }
    }


}
