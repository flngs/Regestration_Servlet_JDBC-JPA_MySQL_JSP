package net.dao;

import net.model.Employee;

import javax.persistence.*;

public class EmployeeDao implements EmployeeDaoInterface {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.tutorials");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void deleteUser(String username) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("DELETE FROM Employee WHERE username = :username");
        query.setParameter("username", username);
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();

    }

    public void updateUser(Employee employee) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("UPDATE Employee SET firstName = :newFirstName, " +
                "lastName = :newLastName, " +
                "password = :newPassword, " +
                "address = :newAddress, " +
                "contact = :newContact, " +
                "username = :newUsername WHERE username = :oldUsername"); // Тип нужно сделать что бы замена инфы шла только по юзернейму...
        query.setParameter("newFirstName", employee.getFirstName())
                .setParameter("newLastName", employee.getLastName())
                .setParameter("newAddress", employee.getAddress())
                .setParameter("newContact", employee.getContact())
                .setParameter("newUsername", employee.getUsername())
                .setParameter("oldUsername", employee.getUsername());
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();

    }

    public Employee getUserByUserNameAndPassword(String username, String password) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Employee> query = em.createQuery("SELECT employee FROM Employee employee WHERE employee.username = :receivedUsername " +
                "AND employee.password = :receivedPassword", Employee.class);
        query.setParameter("receivedUsername", username)
                .setParameter("receivedPassword", password);
        Employee employee = query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return employee;

    }

    public Employee getEmployee(String username) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        TypedQuery<Employee> query = em.createQuery(" SELECT employee FROM Employee employee WHERE username = :username ", Employee.class); // Проблема с сущностью и что по запросу???
        query.setParameter("username", username);
        Employee employee = query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return employee;

    }

    public void registerEmployee(Employee employee) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
        em.close();

    }

}
