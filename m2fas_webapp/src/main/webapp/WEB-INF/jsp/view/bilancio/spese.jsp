<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 08/04/2023
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<div class="wrapper" id="gestione_prodotto">

    <div class="form-box gestione_prodotto">
        <h2>Inserisci spesa</h2>
        <form action="<c:url value="/bilancio" />" method="POST">
            <div class="input-box">
                <input type="text" name="data_pagamenti" required>
                <label>Data</label>
            </div>
            <div class="input-box">
                <input type="text" name="importo_pagamenti" required>
                <label>Importo</label>
            </div>
            <div class="input-box">
                <input type="text" name="nconto_pagamenti" required>
                <label>Numero conto</label>
            </div>
            <div class="input-box">
                <input type="text" name="desc_pagamenti" required>
                <label>Descrizione</label>
            </div>
            <button id="gestione_prodotto" class=" btn" type="submit" name="action" value="inserisci" >Inserisci</button>
            <button id="gestione_prodotto" class=" btn" type="reset"  >Cancella</button>

            <div class="error">
                <span >${error}</span>
            </div>
        </form>
    </div>
