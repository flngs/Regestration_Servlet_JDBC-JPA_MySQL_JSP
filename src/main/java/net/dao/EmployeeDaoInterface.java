package net.dao;


import net.model.Employee;

public interface EmployeeDaoInterface {
    Employee getUserByUserNameAndPassword(String username, String password) throws ClassNotFoundException;
    Employee getEmployee(String username);
    int registerEmployee(Employee employee);
    boolean updateUser(Employee employee);
    boolean deleteUser(String username);
}
