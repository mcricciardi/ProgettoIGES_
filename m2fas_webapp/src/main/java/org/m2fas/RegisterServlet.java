package org.m2fas;

import entity.User;
import intermediate.UserManagement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet(
        name = "registerServlet",
        urlPatterns = {"/register"}
)
public class RegisterServlet extends HttpServlet {
    CheckUtils cu = new CheckUtils();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action){
            case "register":
                this.viewRegister(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        if(cu.isEmpty(username)){
            req.setAttribute("error", "Username"+MSG.UNKNOW.getName());
            this.viewRegister(req, resp);
        }
        String email = req.getParameter("email");
        if(cu.isEmpty(email)){
            req.setAttribute("error", "Email"+MSG.UNKNOW.getName());
            this.viewRegister(req, resp);
        }else if(!cu.isValidEmailAddress(email)){
            req.setAttribute("error", MSG.NOT_DATA.getName());
            this.viewRegister(req, resp);
        }
        String password = req.getParameter("password");
        if(cu.isEmpty(password)){
            req.setAttribute("error", "Password"+MSG.UNKNOW.getName());
            this.viewRegister(req, resp);
        }
        String role = req.getParameter("role");
        if(cu.isEmpty(role)){
            req.setAttribute("error", "Ruolo"+MSG.UNKNOW.getName());
            this.viewRegister(req, resp);
        }
        UserManagement userManagement = new UserManagement();
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        Boolean res = userManagement.insertUser(user);
        System.out.println("RES: "+res);
        if(res){
            req.setAttribute("error", "Utente " + MSG.OK_INSERT.getName());
            this.viewRegister(req, resp);
        }else{
            req.setAttribute("error", "Utente " + MSG.UNKNOW.getName());
            this.viewRegister(req, resp);
        }

    }

    private void viewRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/view/login/register.jsp").forward(request, response);
    }
}
