package by.itclass.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet("/formServ")
public class FormParamServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var name = req.getParameter("userName");
        var age = req.getParameter("userAge");
        var gender = req.getParameter("userGender");
        var country = req.getParameter("userCountry");
        var courses = req.getParameterValues("courses");
        var writer = resp.getWriter();
        writer.append("<p> Name: " + name + "</p>")
                .append("<p> Age: " + age + "</p>")
                .append("<p> Gender: " + gender + "</p>")
                .append("<p> Country: " + country + "</p>")
                .append("Courses:<ol>");
        Arrays.stream(courses)
                .forEach(it -> writer.append("<li>" + it + "</li>"));
        writer.append("</ol>").flush();
    }
}
