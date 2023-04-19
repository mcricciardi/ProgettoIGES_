<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 08/04/2023
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<div class="wrapper">

    <div class="form-box login">
        <h2>Cerca fornitore</h2>
        <form action="<c:url value="/fornitore" />" method="POST" >
            <div class="input-box">
                <input type="hidden" name="action" value="view" />
                <span class="icon"><ion-icon name="search-circle"></ion-icon></span>
                <input type="text" name="id_fornitore"  required>
                <label>ID fornitore</label>
            </div>
            <button type="submit" class="btn" >Invio</button>
            <div class="error">
                <span >${error}</span>
            </div>


        </form>
    </div>
</div>
