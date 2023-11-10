package it.betacom.model;

public enum TipoOperazione {
	PRELIEVO("Prelievo"),
	VERSAMENTO("Versamento"),
	APERTURA_CONTO("Apertura conto"),
	ESTRATTO_CONTO("Estratto conto"),
	CHIUSURA_CONTO("Chiusura conto");
	
	private String tipo;

    private TipoOperazione(String tipo) {
        this.tipo = tipo;
    }
	
    @Override
    public String toString() {
        return this.tipo;
    }
}
