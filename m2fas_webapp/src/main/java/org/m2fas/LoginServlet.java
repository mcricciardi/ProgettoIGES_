package org.m2fas;

import intermediate.UserManagement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(
        name="loginServlet",
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {
    CheckUtils cu = new CheckUtils();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();

        switch (action){
            case "logout":
                session.invalidate();
                response.sendRedirect("login?action=login");
                break;
            case "login":
                if(session.getAttribute("email") != null){
                    this.viewBrowse(request, response);
                }else{
                    request.getRequestDispatcher("/WEB-INF/jsp/view/login/login.jsp")
                            .forward(request, response);
                }

        }

    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("email")!=null){
            this.viewBrowse(req, resp);
            return;
        }
        String email = req.getParameter("email");
        String pws = req.getParameter("password");
        UserManagement userManagement = new UserManagement();
System.out.println("email "+ email +
        " pws "+ pws +
        " cu.isEmpty(pws) "+ cu.isEmpty(pws) +
        " cu.isEmpty(email) "+ cu.isEmpty(email) +
        " !cu.isValidEmailAddress(email) "+ !cu.isValidEmailAddress(email)+
        " !userManagement.emailAccess(email) "+ !userManagement.emailAccess(email)+
        " !userManagement.passwordAccess(pws) "+ !userManagement.passwordAccess(pws)
        );

        if(cu.isEmpty(email)
                || cu.isEmpty(pws)
                || !cu.isValidEmailAddress(email)
                || !userManagement.emailAccess(email)
                || !userManagement.passwordAccess(pws)
        ){
            req.setAttribute("loginFailed", true);
            req.setAttribute("error",   MSG.NOT_DATA.getName());
            req.getRequestDispatcher("/WEB-INF/jsp/view/login/login.jsp").forward(req, resp);

        }else {
            session.setAttribute("email", email);
            req.changeSessionId();
            this.viewBrowse(req, resp);
        }
    }

    private void viewBrowse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       new ShopServlet().browse(req, resp);
    }

}
