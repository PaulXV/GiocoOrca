#include <stdio.h>
#include "stdlib.h"
#include "time.h"

#define R 4 //definisce le righe
#define C 6 //definisce le colonne
#define MAX 23 //numero dell'ultima casella
#define FALSE 0
#define TRUE 1

int main()
{
	int tasto, mod;
	
	printf("BENVENUTO AL GIOCO DELL'OCA!\n\n");
	
	printf("se vuoi vedere le regole del gioco premi 1, altrimenti premi un altro numero ");
	scanf("%d", &tasto);
	
	regole(tasto); //funzione 'regole'
	
	printf("\nOra scegli la modalita' di gioco:");
	printf("\npremi 1 se vuoi giocare in due giocatori");
	printf("\npremi 2 se vuoi giocare contro il computer\n");
	scanf("%d", &mod);
	
	if(mod == 1){ //modalità 1: con due giocatori
		dueGiocatori();
	}
	else if(mod == 2){ //modalità 2: un giocatore e il computer
		computer();
	}	
	
	return 0;
}

//funzione per le regole
void regole(int tasto)
{
	if(tasto == 1){
		printf("\nREGOLE DEL GIOCO:\n");
		printf("1. Inizia il giocatore piu' giovane\n");
		printf("2. A turno ogni giocatore tira il dado e la pedina va avanti del valore uscito sul dado\n");
		printf("3. Se un giocatore capita su una casella speciale, ricevera' un vantaggio o uno svantaggio\n\n");
	}
}

//FUNZIONE CON DUE GIOCATORI
dueGiocatori()
{
	int i, j;
	int nTot1 = 0, nTot2 = 0;
	int turno = 0;
	int finePartita = FALSE;
	char player1[20], player2[20];
	
	int tabella[4][6] = {0,1,2,3,4,5,15,16,17,18,19,6,14,23,22,21,20,7,13,12,11,10,9,8};
	
	printf("\ninserisci il nome del giocatore1 (max 20 caratteri): "); //nome del primo giocatore
	scanf("%s", player1);
	
	printf("inserisci il nome del giocatore2 (max 20 caratteri): "); //nome del secondo giocatore
	scanf("%s", player2);
	
	printf("\nil simbolo di %s e': #", player1);
	printf("\nil simbolo di %s e': @\n", player2);
	printf("\nOra iniziamo!\n");
	
	system("pause"); //attesa di inserimento di un pulsante
	
	while(finePartita == FALSE) //finchè la partita non finisce
	{
		int dado;
		     
		srand(time(NULL)); //permette di generare numeri diversi
		dado = rand() % 6 + 1; //generazione del numero del dado random
		
		system("cls"); //pulisce lo schermo
		switch(turno){ //in base al turno stabilisce chi è il giocatore che tira il dado
			
			case 0:
				printf("\ne' il turno di %s: ", player1);
				printf("\nnumero del dado: %d\n", dado);
				 
				nTot1 = nTot1 + dado; //aggiunge al totale del dado del giocatore 1 il nuovo numero del dado - serve a posizionare la pedina all'interno della tabella
				
				if(nTot1 == MAX){ //se il totale del dado del giocatore 1 é uguale a MAX (23), vince e finisce la partita
					finePartita = TRUE;
					printf("\n\n%s HA VINTO!", player1);
				}
				else if(nTot1 > MAX){ //se il totale del dado del giocatore 1 é maggiore di MAX
					nTot1 = MAX * 2 - nTot1;
				}

				break;
				
			case 1:				
				printf("\ne' il turno di %s:", player2);
				printf("\nnumero del dado: %d\n", dado);
				
				nTot2 = nTot2 + dado; //aggiunge al totale del dado del giocatore 2 il nuovo numero del dado - serve a posizionare la pedina all'interno della tabella			
				
				if(nTot2 == MAX){ //se il totale del dado del giocatore 2 é uguale a MAX (23), vince e finisce la partita
					finePartita = TRUE;
					printf("\n\n%s HA VINTO!", player2);
				}
				else if(nTot2 > MAX){ //se il totale del dado del giocatore 1 é maggiore di MAX
					nTot2 = MAX * 2 - nTot2;
				}

				break;
		}
		
		int trovato = FALSE;
		int r1 = 0, c1;
				
		while(r1 < R && trovato == FALSE){
					
			c1 = 0;
			while(c1 < C && trovato == FALSE){
				if(nTot1 == tabella[r1][c1]){
					trovato = TRUE;
				}
						
				c1++;
			}
					
			r1++;
		}	
				
		r1--;
		c1--;
		
		trovato = FALSE;
		int r2 = 0, c2;
				
		while(r2 < R && trovato == FALSE){
					
			c2 = 0;
			while(c2 < C && trovato == FALSE){
				if(nTot2 == tabella[r2][c2]){
					trovato = TRUE;
				}
						
				c2++;
			}
					
			r2++;
		}
				
		r2--;
		c2--;
		
		int i, j;
		
		//STAMPA DELLA TABELLA
		for(i = 0; i < R; i++)
		{
	    	printf("\n  __    __    __    __    __    __  ");
	        printf("\n");
	   		for(j = 0; j < C; j++)
	   		{
			    if(nTot1 == nTot2 && r1 == i && c1 == j) //se le due pedine sono sulla stessa cesella
				{
					printf("  @#  ");	
				} 
		    	else if(r1 == i && c1 == j) //stampa della pedina del giocatore 1
		    	{
		    		printf("  #   ");
				}
				else if(r2 == i && c2 == j) //stampa della pedina del giocatore 2
				{
					printf("  @   ");
				}
			    else
			    {
			    	if(tabella[i][j] == 23){ //stampa dell'ultima casella
			    		printf("|.%d.|", tabella[i][j]);
					}
			    	else if(tabella[i][j] > 9){ //stampa dei numeri maggiori di 9
			    		printf(" |%d| ", tabella[i][j]);
					}
					else{ //stampa dei numeri minori di 9
						printf(" |%d | ", tabella[i][j]);
					}	
				}
	   		}
	   
		    printf("\n");
		}
		
		//CASELLE SPECIALI GIOCATORE 1
		if(nTot1 == 6){ //se il giocatore 1 capita sulla casella 6
			printf("\n%s, sei capitato sulla casella 6, puoi ritirare il dado", player1);
			turno++;
		}
		else if(nTot1 == 12){ //se il giocatore 1 capita sulla casella 12
			printf("\n%s, sei capitato sulla casella 12, la tua pedina verra' retrocessa di 2 caselle", player1);
			nTot1 = nTot1 - 2;
			c1 = c1 - 2;
		}
		else if(nTot1 == 15){ //se il giocatore 1 capita sulla casella 15
			printf("\n%s, sei capitato sulla casella 15, la tua pedina verra' mandata avanti di una casella", player1);
			nTot1++;
			c1++;
		}
		else if(nTot1 == 17){ //se il giocatore 1 capita sulla casella 17
			printf("\n%s, sei capitato sulla casella 17, la tua pedina verra' mandata alla casella iniziale (0)", player1);
			nTot1 = 0;
			r1 = 0;
			c1 = 0;
		}
		else if(nTot1 == 21){ //se il giocatore 1 capita sulla casella 21
			printf("\n%s, sei capitato sulla casella 21, la tua pedina verra' retrocessa di 5 caselle", player1);
			nTot1 = nTot1 - 5;
			r1--;
			c1 = c1 - 2;
		}
		
		//CASELLE SPECIALI GIOCATORE 2
		if(nTot2 == 6){ //se il giocatore 2 capita sulla casella 6
			printf("\n%s, sei capitato sulla casella 6, puoi ritirare il dado", player2);
			turno++;
		}
		else if(nTot2 == 12){ //se il giocatore 2 capita sulla casella 12
			printf("\n%s, sei capitato sulla casella 12, la tua pedina verra' retrocessa di 2 caselle", player2);
			nTot2 = nTot2 - 2;
			c2 = c2 - 2;
		}
		else if(nTot2 == 15){ //se il giocatore 2 capita sulla casella 15
			printf("\n%s, sei capitato sulla casella 15, la tua pedina verra' mandata avanti di una casella", player2);
			nTot2++;
			c2++;
		}
		else if(nTot2 == 17){ //se il giocatore 2 capita sulla casella 17
			printf("\n%s, sei capitato sulla casella 17, la tua pedina verra' mandata alla casella iniziale (0)", player2);
			nTot2 = 0;
			r2 = 0;
			c2 = 0;
		}
		else if(nTot2 == 21){ //se il giocatore 2 capita sulla casella 21
			printf("\n%s, sei capitato sulla casella 21, la tua pedina verra' retrocessa di 5 caselle", player2);
			nTot2 = nTot2 - 5;
			r2--;
			c2 = c2 - 2;
		}		
		
		if(finePartita == FALSE){
			turno++; //incrementa il turno
			turno = turno % 2; //verifica se il turno è 0 o 1
			printf("\n");
			system("pause"); //attesa di inserimento di un pulsante
		}
	}
	
	printf("\n\nPARTITA TERMINATA\n");
	system("pause"); //attesa di inserimento di un pulsante
	return 0;
}

//FUNZIONE CON UN GIOATORE E IL COMPUTER
computer()
{
	int i, j;
	int nTot1 = 0, nTot2 = 0;
	int turno = 0;
	int finePartita = FALSE;
	char player1[20];
	
	int tabella[4][6] = {0,1,2,3,4,5,15,16,17,18,19,6,14,23,22,21,20,7,13,12,11,10,9,8};
	
	printf("\ninserisci il nome del giocatore1 (max 20 caratteri): ");
	scanf("%s", player1);
	
	printf("\nil simbolo di %s e': #", player1);
	printf("\nil simbolo del PC e': @\n");
	printf("\nOra iniziamo!\n");
	
	system("pause"); //attesa di inserimento di un pulsante
	
	while(finePartita == FALSE)
	{
		int dado;
		     
		srand(time(NULL)); //permette di generare numeri diversi
		dado = rand() % 6 + 1; //generazione del numero del dado random
		
		system("cls"); //pulisce lo schermo
		switch(turno){ //in base al turno stabilisce chi è il giocatore che tira il dado		
			
			case 0:
				printf("\ne' il turno di %s: ", player1);
				printf("\nnumero del dado: %d\n", dado);
				 
				nTot1 = nTot1 + dado; //aggiunge al totale del dado del giocatore 1 il nuovo numero del dado - serve a posizionare la pedina all'interno della tabella
				
				if(nTot1 == MAX){
					finePartita = TRUE;
					printf("\n\n%s HA VINTO!", player1);
				}
				else if(nTot1 > MAX){
					nTot1 = MAX * 2 - nTot1;
				}
				break;
				
			case 1:
				
				printf("\ne' il turno del PC:");
				printf("\nnumero del dado: %d\n", dado);
				
				nTot2 = nTot2 + dado; //aggiunge al totale del dado del PC il nuovo numero del dado - serve a posizionare la pedina all'interno della tabella		
				
				if(nTot2 == MAX){ //se il totale del dado del PC é uguale a MAX (23), vince e finisce la partita
					finePartita = TRUE;
					printf("\n\nil PC HA VINTO!");
				}
				else if(nTot2 > MAX){ //se il totale del dado del PC é maggiore a MAX (23)
					nTot2 = MAX * 2 - nTot2;
				}

				break;
		}
		
		int trovato = FALSE;
		int r1 = 0, c1;
				
		while(r1 < R && trovato == FALSE){
					
			c1 = 0;
			while(c1 < C && trovato == FALSE){
				if(nTot1 == tabella[r1][c1]){
					trovato = TRUE;
				}
						
				c1++;
			}
					
			r1++;
		}	
				
		r1--;
		c1--;
		
		trovato = FALSE;
		int r2 = 0, c2;
				
		while(r2 < R && trovato == FALSE){
					
			c2 = 0;
			while(c2 < C && trovato == FALSE){
				if(nTot2 == tabella[r2][c2]){
					trovato = TRUE;
				}
						
				c2++;
			}
					
			r2++;
		}
				
		r2--;
		c2--;
		
		int i, j;
	    
	    //STAMPA DELLA TABELLA
		for(i = 0; i < R; i++)
		{
	    	printf("\n  __    __    __    __    __    __  ");
	        printf("\n");
	   		for(j = 0; j < C; j++)
	   		{
			    if(nTot1 == nTot2 && r1 == i && c1 == j) //se le due pedine sono sulla stessa cesella
				{
					printf("  @#  ");	
				} 
		    	else if(r1 == i && c1 == j) //stampa della pedina del giocatore 1
		    	{
		    		printf("  #   ");
				}
				else if(r2 == i && c2 == j) //stampa della pedina del PC
				{
					printf("  @   ");
				}
			    else
			    {
			    	if(tabella[i][j] == 23){ //stampa dell'ultima casella
			    		printf("|.%d.|", tabella[i][j]);
					}
			    	else if(tabella[i][j] > 9){ //stampa dei numeri maggiori di 9
			    		printf(" |%d| ", tabella[i][j]);
					}
					else{ //stampa dei numeri minori di 9
						printf(" |%d | ", tabella[i][j]);
					}	
				}
	   		}
	   
		    printf("\n");
		}
		
		//CASELLE SPECIALI GIOCATORE 1
		if(nTot1 == 6){ //se il giocatore 1 capita sulla casella 6
			printf("\n%s, sei capitato sulla casella 6, puoi ritirare il dado", player1);
			turno++;
		}
		else if(nTot1 == 12){ //se il giocatore 1 capita sulla casella 12
			printf("\n%s, sei capitato sulla casella 12, la tua pedina verra' retrocessa di 2 caselle", player1);
			nTot1 = nTot1 - 2;
			c1 = c1 - 2;
		}
		else if(nTot1 == 15){ //se il giocatore 1 capita sulla casella 15
			printf("\n%s, sei capitato sulla casella 15, la tua pedina verra' mandata avanti di una casella", player1);
			nTot1++;
			c1++;
		}
		else if(nTot1 == 17){ //se il giocatore 1 capita sulla casella 17
			printf("\n%s, sei capitato sulla casella 17, la tua pedina verra' mandata alla casella iniziale (0)", player1);
			nTot1 = 0;
			r1 = 0;
			c1 = 0;
		}
		else if(nTot1 == 21){ //se il giocatore 1 capita sulla casella 21
			printf("\n%s, sei capitato sulla casella 21, la tua pedina verra' retrocessa di 5 caselle", player1);
			nTot1 = nTot1 - 5;
			r1--;
			c1 = c1 - 2;
		}
		
		//CASELLE SPECIALI PC
		if(nTot2 == 6){ //se il PC capita sulla casella 6
			printf("\nil PC e' capitato sulla casella 6 e potra' ritirare il dado");
			turno++;
		}
		else if(nTot2 == 12){ //se il PC capita sulla casella 12
			printf("\nil PC e' capitato sulla casella 12, la sua pedina verra' retrocessa di 2 caselle");
			nTot2 = nTot2 - 2;
			c2 = c2 - 2;
		}
		else if(nTot2 == 15){ //se il PC capita sulla casella 15
			printf("\nil PC e' capitato sulla casella 15, la sua pedina verra' mandata avanti di una casella");
			nTot2++;
			c2++;
		}
		else if(nTot2 == 17){ //se il PC capita sulla casella 17
			printf("\nil PC e' capitato sulla casella 17, la sua pedina verra' mandata alla casella iniziale (0)");
			nTot2 = 0;
			r2 = 0;
			c2 = 0;
		}
		else if(nTot2 == 21){ //se il PC capita sulla casella 21
			printf("\nil PC e' capitato sulla casella 21, la sua pedina verra' retrocessa di 5 caselle");
			nTot2 = nTot2 - 5;
			r2--;
			c2 = c2 - 2;
		}		
		
		if(finePartita == FALSE){
			turno++; //incrementa il turno
			turno = turno % 2; //verifica se il turno è 0 o 1
			printf("\n");
			system("pause"); //attesa di inserimento di un pulsante
		}	
	}
	
	printf("\n\nPARTITA TERMINATA\n");
	system("pause"); //attesa di inserimento di un pulsante
	return 0;
}
