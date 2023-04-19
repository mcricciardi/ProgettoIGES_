package org.m2fas;

enum MSG{
    UNKNOW(" non è stato inserito, riprovare"),
    OK_INSERT(" inserito con successo"),
    OK_UPDATE(" aggiornato con successo"),
    OK_REMOVE(" rimosso con successo"),
    WARNING(" Errore"),
    NOT_FOUND(" non è stato trovato"),
    NOT_DATE(" formato data non valido"),
    NOT_DATA("Dati non validi"),
    NOT_NUMBER(" non è un numero, riprovare");

    private final String value;
    private MSG(String value){
        this.value = value;
    }
    public String getName(){
        return value;
    }
    public String toString(){
        return this.value;
    }
}

