<%--
  Created by IntelliJ IDEA.
  User: chris
  Date: 08/04/2023
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<div class="wrapper" id="gestione_prodotto">

  <div class="form-box gestione_prodotto">
    <h2>Gestione prodotti</h2>
    <form action="<c:url value="/prodotto" />" method="POST">
      <div class="input-box">
        <input type="text" name="id_prodotto" required>
        <label>ID Prodotto</label>
      </div>
      <div class="input-box">
        <input type="text" name="marca_prodotto" required>
        <label>Marca</label>
      </div>
      <div class="input-box">
        <input type="text" name="modello_prodotto" required>
        <label>Modello</label>
      </div>
      <div class="input-box">
        <input type="text" name="categoria_prodotto" required>
        <label>Categoria</label>
      </div>
      <div class="input-box">
        <input type="text" name="prezzo_prodotto" required>
        <label>Prezzo</label>
      </div>
      <div class="input-box">
        <input type="text" name="qta_prodotto" required>
        <label>Quantita'</label>
      </div>

      <button id="gestione_prodotto" class=" btn" type="submit" name="action" value="inserisci" >Inserisci</button>
      <button id="gestione_prodotto" class=" btn" type="submit" name="action" value="cancella" >Cancella</button>
      <button id="gestione_prodotto" class=" btn" type="submit" name="action" value="aggiorna" >Aggiorna</button>

      <div class="error">
        <span >${error}</span>
      </div>
    </form>
  </div>
