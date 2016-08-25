<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <form action="forgot" method="post" class="login">           
            <div class="forgot">
            <p> 
                <label>Login:</label>
                <input type="text" name="userName" required>
            </p> 

          
            <p> 
                <label>New Password:</label>
                <input type="password" name="password" required>             
            </p>
            </div>

            <p> 
                 <button type="submit" class="login-button">Reset</button>  
            </p> 
        </form>
    </body>
</html>