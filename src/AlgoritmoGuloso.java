/*
 * AEDII - Trabalho 02
 * Alunos: 
 * 	Stephanie Fonseca de Oliveira Gomes Magalhaes
 * 	Pablo Vasconcelos da Cruz
 */
public class AlgoritmoGuloso {
	
	public AlgoritmoGuloso() {}
	
	public int[] calculaRota(int tempoEstacao[][], int tempoTroca[][], int tempoEntrada[], int tempoSaida[], int nEstacoes) {
		
		int[] f1 = new int[nEstacoes];
		int[] f2 = new int[nEstacoes];
		int[] l1 = new int[nEstacoes];
		int[] l2 = new int[nEstacoes];
		f1[0] = tempoEntrada[0] + tempoEstacao[0][0];
		f2[0] = tempoEntrada[1] + tempoEstacao[1][0];
		l1[0] = 1;
		l2[0] = 2;
		
		int[] tempoTotal = new int[2];
		tempoTotal[0] = tempoEntrada[0] + tempoEstacao[0][0];
		tempoTotal[1] = tempoEntrada[1] + tempoEstacao[1][0];
				
		
		int linha = 0, contador = 0;
		
		//tempo do processo começando na linha 1
		for(int i = 0; i < nEstacoes - 1; i++) {
			if(tempoEstacao[linha][i + 1] <= tempoTroca[linha][i] + tempoEstacao[valorAbsoluto(linha - 1)][i + 1]) {
				tempoTotal[0] = tempoTotal[0] + tempoEstacao[linha][i + 1];
			}
			else if(tempoEstacao[linha][i + 1] > tempoTroca[linha][i] + tempoEstacao[valorAbsoluto(linha - 1)][i + 1]){
				tempoTotal[0] = tempoTotal[0] + tempoTroca[linha][i] + tempoEstacao[valorAbsoluto(linha - 1)][i + 1];
				contador++;
			}
			if((contador % 2) == 0) {
				linha = 0;
				l1[i + 1] = linha + 1;
			}
			else {
				linha = 1;
				l1[i + 1] = linha + 1;
			}
			l1[i + 1] = linha + 1;
		}
		tempoTotal[0] = tempoTotal[0] + tempoSaida[linha];
		
		
		//tempo do processo começando na linha 2
		linha = 1;
		contador = 1;
		for(int i = 0; i < nEstacoes - 1; i++) {
					
			if(tempoEstacao[linha][i + 1] <= tempoTroca[linha][i] + tempoEstacao[valorAbsoluto(linha - 1)][i + 1]) {
				tempoTotal[1] = tempoTotal[1] + tempoEstacao[linha][i + 1];
			}
			else {
				tempoTotal[1] = tempoTotal[1] + tempoTroca[linha][i] + tempoEstacao[valorAbsoluto(linha - 1)][i + 1];
				contador++;
			}
			if((contador % 2) == 0) {
				linha = 0;
			}
			else {
				linha = 1;
			}	
			l2[i] = linha + 1;
		}
		tempoTotal[1] = tempoTotal[1] + tempoSaida[linha];
		
		int[] resposta = new int[nEstacoes + 1];
	
		
		if(minimo(tempoTotal[0], tempoTotal[1]) == tempoTotal[0]) {
			resposta[0] = tempoTotal[0];
			for(int i = 1; i < nEstacoes + 1; i++) {
				int j = i - 1;
				resposta[i] = l1[j];				
			}
		}
		else {
			resposta[0] = tempoTotal[1];
			for(int i = 1; i < nEstacoes + 1; i++) {
				int j = i - 1;
				resposta[i] = l2[j];				
			}
		}
		
		return resposta;
	}
	
	public int valorAbsoluto(int a) {
		if(a >= 0) {
			return a;
		}
		return (a * -1);
	}
	
	public int minimo(int a, int b) {
		if(a <= b) {
			return a;
		}
		else {
			return b;
		}
		
	}

}
