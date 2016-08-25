<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        Authorize!
       
    </head>
    <body>
    	<p class="forgot-password">
        <%
            HttpSession se = request.getSession();
            String status = (String) se.getAttribute("pageStatus");
            se.removeAttribute("pageStatus");
            if (status != null) {
                out.println(status);
                se.removeAttribute("pageStatus");
            }
        %>
        </p>
        <form action="login" method="post" class="login">
            <p> 
                <label>Login:</label>
                <input type="text" name="userName" required>
            </p> 

            <p> 
                <label>Password:</label>
                <input type="password" name="password" required>
            </p>

            <p class="login-submit">
                <button type="submit" class="login-button">Login</button>
            </p>

            <p class="forgot-password">
                <a href="registration.jsp">Registration</a>
            </p>
            
            <p class="forgot-password">
                <a href="forgot.jsp">Forgot password?</a>
            </p> 
        </form>
    </body>
</html>