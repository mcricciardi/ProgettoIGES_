<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 13/04/2023
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<!-- BOX LOGIN -->
<div class="wrapper">
    <!--
    <span class="icon-close"><ion-icon name="close"></ion-icon></span>
    -->
    <div class="form-box login">
        <h2>Login</h2>
        <form action="<c:url value="/login" />" method="post">
            <div class="input-box">
                <span class="icon"><ion-icon name="mail"></ion-icon></span>
                <input type="email" name="email" required>
                <label>Email</label>
            </div>
            <div class="input-box">
                <span class="icon"><ion-icon name="lock-closed"></ion-icon></span>
                <input type="password" name="password" required>
                <label>Password</label>
            </div>
            <!--
            <div class="remember-forgot">
                <label><input type="checkbox">Remember me</label>
                <a href="#">Forgot Password?</a>
            </div>-->
        <button type="submit" class="btn">Login</button>
        <div class="login-register">
            <p>Non hai un account? <a href="<c:url value="/register">
                                                <c:param name="action" value="register"/>
                                            </c:url>" class="register-link">Registrati</a>
            </p>
        </div>
            <div class="error">
                <span >${error}</span>
            </div>
    </form>
</div>
</div>