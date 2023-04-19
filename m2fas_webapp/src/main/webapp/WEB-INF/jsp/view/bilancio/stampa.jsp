<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 08/04/2023
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<div class="wrapper" id="gestione_prodotto">

    <div class="form-box gestione_prodotto">
        <h2>Stampa bilancio</h2>
        <form action="<c:url value="/bilancio" />" method="POST">
            <div class="input-box">
                <input type="date" name="da_date_stampa" required>
                <label>Da</label>
            </div>
            <div class="input-box">
                <input type="date" name="a_date_stampa" required>
                <label>A</label>
            </div>

            <button id="gestione_prodotto" class=" btn" type="submit" name="action" value="cerca_bilancio" >Cerca</button>
            <button id="gestione_prodotto" class=" btn" type="reset"  >Cancella</button>

            <div class="error">
                <span >${error}</span>
            </div>
        </form>
    </div>

