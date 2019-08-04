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
@WebServlet("/getUser")
public class GetUserEmployeeServlet extends HttpServlet {
    private EmployeeDaoInterface employeeDao;

    @Override
    public void init(){
        employeeDao = new EmployeeDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("getUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        Employee user = employeeDao.getEmployee(username);
        req.setAttribute("getUserObject", user);
        req.getRequestDispatcher("successGettingUser.jsp").forward(req,resp);
    }
}
