package net.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.dao.EmployeeDao;
import net.dao.EmployeeDaoInterface;
import net.model.Employee;
import org.apache.log4j.Logger;


@WebServlet("/")
public class EmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDaoInterface employeeDao;

    public void init() {
        employeeDao = new EmployeeDao();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getServletPath();

        try {
             if ("/register".equals(action)) {
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String address = request.getParameter("address");
                String contact = request.getParameter("contact");

                Employee employee = new Employee();
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setUsername(username);
                employee.setPassword(password);
                employee.setContact(contact);
                employee.setAddress(address);
                employeeDao.registerEmployee(employee);
                response.sendRedirect("employeedetails.jsp");

            } else if ("/update".equals(action)) {
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String address = request.getParameter("address");
                String contact = request.getParameter("contact");

                Employee employee = new Employee();
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setUsername(username);
                employee.setPassword(password);
                employee.setContact(contact);
                employee.setAddress(address);
                if (employeeDao.updateUser(employee)) {
                    response.sendRedirect("successUpdate.jsp");
                }

            } else if ("/delete".equals(action)){
                String username = request.getParameter("username");
                employeeDao.deleteUser(username);
                    response.sendRedirect("successDelete.jsp");

            } else if ("/getUser".equals(action)){
                String username = request.getParameter("username");
                Employee user = employeeDao.getEmployee(username);
                request.setAttribute("getUserObject", user);
                request.getRequestDispatcher("successGettingUser.jsp").forward(request,response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
