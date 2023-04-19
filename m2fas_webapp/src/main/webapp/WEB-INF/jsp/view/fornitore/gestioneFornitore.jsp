<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 08/04/2023
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<div class="wrapper" id="gestione_prodotto">

    <div class="form-box gestione_prodotto">
        <h2>Gestione fornitori</h2>
        <form action="<c:url value="/fornitore" />" method="POST">
            <div class="input-box">
                <input type="text" name="id_fornitore" required>
                <label>P.IVA</label>
            </div>
            <div class="input-box">
                <input type="text" name="nome_fornitore" required>
                <label>Nome</label>
            </div>
            <div class="input-box">
                <input type="text" name="cognome_fornitore" required>
                <label>Cognome</label>
            </div>
            <div class="input-box">
                <input type="text" name="telefono_fornitore" required>
                <label>Telefono</label>
            </div>
            <div class="input-box">
                <input type="text" name="fax_fornitore" required>
                <label>Fax</label>
            </div>
            <div class="input-box">
                <input type="text" name="indirizzo_fornitore" required>
                <label>Indirizzo</label>
            </div>
            <div class="input-box">
                <input type="text" name="debito_fornitore" required>
                <label>Debito</label>
            </div>
            <div class="input-box">
                <input type="text" name="pagato_fornitore" required>
                <label>Pagato</label>
            </div>

            <button id="gestione_prodotto" class=" btn" type="submit" name="action" value="inserisci" >Inserisci</button>
            <button id="gestione_prodotto" class=" btn" type="submit" name="action" value="cancella" >Cancella</button>
            <button id="gestione_prodotto" class=" btn" type="submit" name="action" value="aggiorna" >Aggiorna</button>

            <div class="error">
                <span >${error}</span>
            </div>
        </form>
    </div>

