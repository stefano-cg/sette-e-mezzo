import java.util.*;

public class SetteEMezzo {

	public static void main(String[] args) {

		//Creiamo il mazzo, tavolo dove metteremo i giocatori, e una lista dei valori delle mani
		Deck mazzo = new Deck();
		ArrayList<Player> table = new ArrayList<>();
		ArrayList<Double> valoriFinali = new ArrayList<>();
		
		//Chiediamo quanti giocheranno, incluso il mazziere
		System.out.println("In quanti giocano?");
		Scanner sc= new Scanner(System.in);
		int playerNum = sc.nextInt();		
		//Aggiungiamo i giocatori al tavolo		
		for(int i = 0; i < playerNum; i++){
			table.add(new Player());
		}
		
		//Diamo la possibilità di rigiocare
		boolean giochiamo = true;
		while(giochiamo){
			
			//Tutti i giocatori devono scartare le loro carte
			for(int i = 0; i < playerNum; i++){
				table.get(i).discardAll(mazzo.getDiscards());
			}
			//Mischiamo le carte
			Collections.shuffle(mazzo.getStack());
			
			//Resettiamo la lista di valori delle mani
			valoriFinali.clear();
			
			//Diamo a tutti una carta
			mazzo.deal(1, table);
			
			/*Se si vogliono vedere tutte le carte subito
			for(int i = 0; i < player_num; i++){
				//Gli ricordiamo cos'ha in mano
				if (i == (player_num - 1)){
					System.out.println("Banco: "+table.get(i).getHand());
				}
				else {
					System.out.println("Giocatore "+(i+1)+": "+table.get(i).getHand());
				}
			}
			*/
			
			//Giochiamo uno alla volta
			for(int i = 0; i < playerNum; i++){
				//Ci ricordiamo a che giocatore siamo
				if (i == (playerNum - 1)){
					System.out.println("Banco!");
				}
				else {
					System.out.println("Giocatore "+(i+1)+"!");
				}
				
				//Le condizioni per cui il gioco potrebbe continuare al prossimo giocatore
				boolean setteEMezzo = false;
				boolean sto = false;
				boolean sballato = false;
				
				double valoreTot = 0;
				
				//Aggiungiamo una variabile per il valore della matta, il RE_DI_DENARI
				double valoreReDiDenari = 0.5;
	
				while (!setteEMezzo & !sto & !sballato) {
					//Facciamo vedere al giocatore la sua mano
					ArrayList<Card> mano = table.get(i).getHand();
					System.out.println("La tua mano: "+mano);
					
					//Calcoliamo il valore della mano
					Card carta = mano.get(mano.size()-1);
					double valore = carta.getValue();
					
					if (valore > 7){
						valore = 0.5;
					}
					valoreTot += valore;
					
					//Se abbiamo il RE_DI_DENARI con almeno un'altra carta
					if (mano.contains(Card.RE_DI_DENARI) & mano.size() > 1){
						//Togliamo il valore della matta precedentemente aggiungto
						valoreTot -= valoreReDiDenari;
						//Troviamo il valore della matta che ci porta il più vicino a 7.5
						// Se le altre carte valgono 7.5 senza la matta allora la matta 
						// ci fa sballare con il suo punteggio minimo di 0.5
						valoreReDiDenari = ((7.5 - valoreTot) < 1)? 0.5 : (int) (7.5 - valoreTot);
						//Aggiungiamo il nuovo valore della matta
						valoreTot += valoreReDiDenari;
					}
					
					//Se il valore non supera il 7 e mezzo
					if (valoreTot < 7.5) {
						
						//Riportiamo il valore della mano e chiediamo se si vuole un'altra carta
						// Nel caso ci fosse la matta poniamo la domanda in modo diverso
						if (mano.contains(Card.RE_DI_DENARI) & mano.size() > 1){
							System.out.println("Il valore massimo della tua mano è "+valoreTot+". Carta? Si/No?"); 
						}
						else {
							System.out.println("La tua mano vale "+valoreTot+". Carta? Si/No?"); 
						}
						boolean continuare = (sc.next().equalsIgnoreCase("Si"))? true:false;
						
						//Se il giocatore continua, gli diamo una carta
						if (continuare) {
							mazzo.deal(1, table.get(i));
						}
						//Se il giocatore non continua, finalizziamo il suo punteggio
						else {
							sto = true;
							valoriFinali.add(valoreTot);
						}
					}
					
					//Se il valore è 7 e mezzo
					else if (valoreTot == 7.5) {
						//Controlliamo se è un 7 e mezzo reale
						if ((mano.size() == 2) & (mano.get(0).getSuit() == mano.get(1).getSuit())){
							System.out.println("Sette e mezzo reale di "+mano.get(0).getSuit());
							//Incrementiamo il valore della vittoria in base al seme
							switch (mano.get(0).getSuit()) {
								case "spade":
									valoreTot += 0.1;
								case "coppe":
									valoreTot += 0.1;
								case "denari":
									valoreTot += 0.1;
								case "bastoni":
									valoreTot += 0.1;
							}
						}
						//Se non è reale allora aggiudichiamo un 7 e mezzo normale
						else {
							System.out.println("Sette e mezzo!");
						}
						valoriFinali.add(valoreTot);
						setteEMezzo = true;
					}
					
					//Quando il giocatore sballa
					else {
						System.out.println("La tua mano vale "+valoreTot+". Hai sballato!"); 
						valoriFinali.add(0.0);
						sballato = true;
					}
				}
				
			}
			
			//Vediamo chi ha vinto contro il banco!
			// Qui calcoliamo il punteggio del banco
			double punteggioBanco = valoriFinali.get(playerNum-1);
			int vittorieBanco = 0;
			
			//Vediamo per ogni giocatore il suo punteggio contro quello del banco
			for(int i = 0; i < playerNum-1; i++){
				double punteggioGiocatore = valoriFinali.get(i);
				boolean vittoria = (punteggioGiocatore > punteggioBanco)? true : false;
				if (vittoria) {
					System.out.println("Giocatore "+(i+1)+": Hai vinto!");
				}
				else {
					System.out.println("Giocatore "+(i+1)+": Hai perso!");
					vittorieBanco++;
				}
			}
			
			//Riportiamo il numero di vittorie del banco
			String vinciteBanco = (vittorieBanco==1)? "Il banco ha vinto 1 volta!" : "Il banco ha vinto "+vittorieBanco+" volte!" ;
			System.out.println(vinciteBanco);
			
			//Chiediamo se si vuole rigiocare
			System.out.println("Rigiochiamo? Si/No?");
			giochiamo = (sc.next().equalsIgnoreCase("Si"))? true:false;
		}
		
		System.out.println("Grazie per aver giocato!");
		
	}

}
