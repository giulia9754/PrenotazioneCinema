package primoProgramma;

import java.util.Scanner;

public class PrenotazioneCinema {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean[][] sala = new boolean[10][10];
		int scelta = -1;
		
		
		
		for(int i=0; i < sala.length; i++) {
			for(int k=0; k < sala[i].length; k++) {
				sala[i][k] = false;
			}
		}
		
		
		System.out.println("Benvenuto al Cinema Java");
		
		do {	//Visualizzazione del Menu
			System.out.println("Menù: ");
			System.out.println("1. Prenotazione");
			System.out.println("2. Cancellazione");
			System.out.println("3. Visualizzazione");
			System.out.println("4. Riepilogo");
			System.out.println("5. Visualizza Stato Sala");
			System.out.println("0. Esci");
			
			//Scelta dell'utente 
			System.out.print("Scegli l'operazione: ");
			
			if(scanner.hasNextInt()) {
				scelta = scanner.nextInt();
				
			
				switch(scelta) {
				case 1:
					System.out.println("Scegli il posto da prenotare");
					System.out.print("Scegli la fila: ");
					
					//Controllo
					if(scanner.hasNextInt()) {
						int fila = scanner.nextInt() -1;
						if(fila > 9 || fila < 0) {
							System.out.println("Il posto selezionato è inesistente.");
							break;
						}else {
							//Altrimenti scegli poltrona
							System.out.print("Scegli la poltrona: ");
						
							//Controllo poltrona esistente
							if(scanner.hasNextInt()) {
								int poltrona = scanner.nextInt() -1;
								if(poltrona > 9 || poltrona < 0) {
									System.out.println("Il posto selezionato è inesistente.");
									break;
								}else {
									//Controllo se la poltrona è occupata
									if(!(sala[fila][poltrona])) {
										System.out.println("Il posto è libero. Posto prenotato.");
										sala[fila][poltrona] = true; 
									}else {
										System.out.println("Il posto selezionato è occupato. Scegli un altro posto.");
									}
								break;
								}				
							}
						}
					}
								
				case 2:
					System.out.println("Scegli la prenotazione da cancellare");
					System.out.print("Scegli la fila: ");
					
					//Controllo numero intero e fila esistente
					if(scanner.hasNextInt()) {
						int fila = scanner.nextInt() -1;
						if(fila >= 10 || fila < 0) {
							System.out.println("Il posto selezionato è inesistente.");
							break;
						}else {
							//Altrimenti scegli poltrona
							System.out.print("Scegli la poltrona: ");
							
							//Controllo poltrona esistente
							if(scanner.hasNextInt()) {
								int poltrona = scanner.nextInt() -1;
								if(poltrona >= 10 || poltrona < 0) {
									System.out.println("Il posto selezionato è inesistente.");
									break;
								}else {
									//Controllo se il posto è prenotato
									if(sala[fila][poltrona]) {
										System.out.println("La prenotazione è stata cancellata. ");
										sala[fila][poltrona] = false; 
									}else {
										System.out.println("Il posto non è prenotato.");
									}
									break;
								}
							}
							
							
						}
					}
				
				case 3:
					int postiDisponibili2 = 0;
					int postiPrenotati2 = 0;
					
					System.out.println("Visualizza i posti");
					for(int r=0; r < sala.length; r++) {
						for(int c=0; c < sala[r].length; c++) {
							if(sala[r][c]) {
								postiPrenotati2++;
								System.out.print("X ");
							}else {
								postiDisponibili2++;
								System.out.print("O ");
							}
						}
						System.out.println();
					}
					System.out.println("Posti Disponibili: " +postiDisponibili2);
					System.out.println("Posti Prenotati: " +postiPrenotati2);

					break;
				case 4:
					int postiDisponibili = 0;
					int postiPrenotati = 0;
					System.out.println("Sala Cinema Java");
					
					for(int b=0; b < sala.length; b++) {
						for(int d=0; d < sala[b].length; d++) {
							if(sala[b][d]) {
								postiPrenotati++;
							}else {
								postiDisponibili++;
							}
						}
					}
					System.out.println("Posti Disponibili: " +postiDisponibili);
					System.out.println("Posti Prenotati: " +postiPrenotati);
					break;
				case 5:
					int postiPrenotati3 = 0;
					int incassoTotale = 0;
					int prezzo = 12;
					
					for(int b=0; b < sala.length; b++) {
						for(int d=0; d < sala[b].length; d++) {
							if(sala[b][d]) {
								postiPrenotati3++;
							}
						}
					}
					incassoTotale = postiPrenotati3 * prezzo;
					System.out.println("La sala è piena al " +postiPrenotati3 +"%");
					System.out.println("L'incasso totale è: €" +incassoTotale );
					break;
				case 0:
					System.out.println("Grazie di aver prenotato. Arrivederci");
					break;
					default:
						System.out.println("Inserimento non valido. Riprova");
				}
				
			}else {
				scanner.nextLine();
				}
			
			
		}while(scelta != 0);
		scanner.close();
		
		
	}

}
