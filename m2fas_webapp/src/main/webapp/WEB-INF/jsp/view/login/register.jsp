<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 14/04/2023
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<div class="wrapper">
<div class="form-box register">
    <h2>Registrazione</h2>
    <form action="<c:url value="/register" />" method="post">
        <div class="input-box" >
            <span class="icon"><ion-icon name="person"></ion-icon></span>
            <input type="text" name="username" required>
            <label id="username">Username</label>
        </div>
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
        <div class="input-box">
            <span class="icon"><ion-icon name="school"></ion-icon></span>
            <input list="role" name="role" required >
            <datalist id="role">
                <option value="User" />
                <option value="Admin" />
                <option value="Fornitore"/>
            </datalist>
            <label for="role">Ruolo</label>
        </div>
        <!--
        <div class="remember-forgot">
            <label><input type="checkbox">I agree to the terms & conditions</label>
        </div>
        -->
        <button type="submit" class="btn">Register</button>
        <div class="login-register">
            <p>Hai già un'account? <a href="<c:url value="/login">
                                                <c:param name="action" value="login"/>
                                            </c:url>" class="login-link">Login</a></p>
        </div>
        <div class="error">
            <span >${error}</span>
        </div>
    </form>
</div>
</div>
<script>
    /*
    function changeField(field){

        switch (field){
            case "Fornitori":
                var username = document.getElementById("username");
                username.innerHTML = "P.IVA";
                break;
        }

    }*/
</script>