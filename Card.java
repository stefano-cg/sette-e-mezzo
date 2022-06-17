public enum Card {
	ASSO_DI_SPADE(1, "spade"),
	DUE_DI_SPADE(2, "spade"),
	TRE_DI_SPADE(3, "spade"),
	QUATTRO_DI_SPADE(4, "spade"),
	CINQUE_DI_SPADE(5, "spade"),
	SEI_DI_SPADE(6, "spade"),
	SETTE_DI_SPADE(7, "spade"),
	FANTE_DI_SPADE(8, "spade"),
	CAVALIERE_DI_SPADE(9, "spade"),
	RE_DI_SPADE(10, "spade"),
	ASSO_DI_COPPE(1, "coppe"),
	DUE_DI_COPPE(2, "coppe"),
	TRE_DI_COPPE(3, "coppe"),
	QUATTRO_DI_COPPE(4, "coppe"),
	CINQUE_DI_COPPE(5, "coppe"),
	SEI_DI_COPPE(6, "coppe"),
	SETTE_DI_COPPE(7, "coppe"),
	FANTE_DI_COPPE(8, "coppe"),
	CAVALIERE_DI_COPPE(9, "coppe"),
	RE_DI_COPPE(10, "coppe"),
	ASSO_DI_DENARI(1, "denari"),
	DUE_DI_DENARI(2, "denari"),
	TRE_DI_DENARI(3, "denari"),
	QUATTRO_DI_DENARI(4, "denari"),
	CINQUE_DI_DENARI(5, "denari"),
	SEI_DI_DENARI(6, "denari"),
	SETTE_DI_DENARI(7, "denari"),
	FANTE_DI_DENARI(8, "denari"),
	CAVALIERE_DI_DENARI(9, "denari"),
	RE_DI_DENARI(10, "denari"),
	ASSO_DI_BASTONI(1, "bastoni"),
	DUE_DI_BASTONI(2, "bastoni"),
	TRE_DI_BASTONI(3, "bastoni"),
	QUATTRO_DI_BASTONI(4, "bastoni"),
	CINQUE_DI_BASTONI(5, "bastoni"),
	SEI_DI_BASTONI(6, "bastoni"),
	SETTE_DI_BASTONI(7, "bastoni"),
	FANTE_DI_BASTONI(8, "bastoni"),
	CAVALIERE_DI_BASTONI(9, "bastoni"),
	RE_DI_BASTONI(10, "bastoni");

	private final int value;
	private final String suit;
	
	private Card(int value, String suit){
		this.value = value;
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public String getSuit() {
		return suit;
	}

	
}
