<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    
    <body>
        <%
            HttpSession se = request.getSession();
            String status = (String) se.getAttribute("pageStatus");
            se.removeAttribute("pageStatus");
            if (status != null) {
                out.println(status);
                se.removeAttribute("pageStatus");
            }
        %>
        <form action="registrate" method="post" class="login">
        
                <p>
                    <label>Login:</label>
                    <input type="text" name="userName" required>
                </p>

                <p>
                    <label> Password:</label>
                    <input type="password" name="password" required>
                </p>

                <p> 
                    <button type="submit" class="login-button">Registration</button>  
                </p>
        </form>
    </body>
</html>