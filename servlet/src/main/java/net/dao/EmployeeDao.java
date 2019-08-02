package net.dao;

import java.sql.*;

import net.model.Employee;

public class EmployeeDao implements EmployeeDaoInterface {
    public static Connection getConnection() throws ClassNotFoundException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_database?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root1999", "root1999");
        } catch (SQLException e) {
            throw new RuntimeException("Failed connection to database", e);
        }
    }

    public boolean deleteUser(String username) throws ClassNotFoundException {

        try {
            Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM employee WHERE username=" + username);
            if(i >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean updateUser(Employee employee) throws ClassNotFoundException {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE employee SET first_name=?, last_name=?, password=?, address=?, contact=? WHERE username=?");
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(6, employee.getUsername());
            preparedStatement.setString(3, employee.getPassword());
            preparedStatement.setString(4, employee.getAddress());
            preparedStatement.setString(5, employee.getContact());
            int i = preparedStatement.executeUpdate();
            if(i >= 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Employee getUserByUserNameAndPassword(String username, String password) throws ClassNotFoundException {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM employee WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                return extractUserFromResultSet(rs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Employee getEmployee(String username) throws ClassNotFoundException {
        try {
            Connection connection = getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee WHERE username=" + username);
            if (rs.next()) {
                return extractUserFromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int registerEmployee(Employee employee) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO employee" + "(first_name, last_name, username, password, address, contact) VALUES " + "(?, ?, ?, ?,?,?);";

        int result = 0;

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getUsername());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getContact());

            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }

    private Employee extractUserFromResultSet(ResultSet rs) throws SQLException {
        Employee user = new Employee();
        user.setFirstName( rs.getString("first_name") );
        user.setLastName( rs.getString("last_name") );
        user.setUsername( rs.getString("username") );
        user.setPassword( rs.getString("password") );
        user.setAddress( rs.getString("address") );
        user.setContact( rs.getString("contact") );
        return user;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
