package net.dao;


import net.model.Employee;

public interface EmployeeDaoInterface {
    Employee getUserByUserNameAndPassword(String username, String password) throws ClassNotFoundException;
    Employee getEmployee(String username);
    void registerEmployee(Employee employee);
    void updateUser(Employee employee);
    void deleteUser(String username);
}
