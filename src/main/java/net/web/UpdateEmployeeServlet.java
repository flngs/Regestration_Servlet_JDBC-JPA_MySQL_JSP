package net.web;

import net.dao.EmployeeDao;
import net.dao.EmployeeDaoInterface;
import net.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update")
public class UpdateEmployeeServlet extends HttpServlet {
    private EmployeeDaoInterface employeeDao;

    @Override
    public void init(){
        employeeDao = new EmployeeDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = new Employee();
        employee.setFirstName(req.getParameter("firstName"));
        employee.setLastName(req.getParameter("lastName"));
        employee.setUsername(req.getParameter("username"));
        employee.setPassword(req.getParameter("password"));
        employee.setContact(req.getParameter("contact"));
        employee.setAddress(req.getParameter("address"));
        employeeDao.updateUser(employee);
        req.getRequestDispatcher("successUpdate.jsp").forward(req,resp);


    }
}
