package net.dao;


import net.model.Employee;

public interface EmployeeDaoInterface {
    Employee getUserByUserNameAndPassword(String username, String password) throws ClassNotFoundException;
    Employee getEmployee(String username) throws ClassNotFoundException;
    int registerEmployee(Employee employee) throws ClassNotFoundException;
    boolean updateUser(Employee employee) throws ClassNotFoundException;
    boolean deleteUser(String username) throws ClassNotFoundException;
}
