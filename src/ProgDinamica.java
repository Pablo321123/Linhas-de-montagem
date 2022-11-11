/*
 * AEDII - Trabalho 02
 * Alunos: 
 * 	Stephanie Fonseca de Oliveira Gomes Magalhaes
 * 	Pablo Vasconcelos da Cruz
 */
public class ProgDinamica{
	
	public ProgDinamica() {}
										
	public int[] calculaRota(int tempoEstacao[][], int tempoTroca[][], int tempoEntrada[], int tempoSaida[], int nEstacoes){
		
		int[] f1 = new int[nEstacoes+1];
		int[] f2 = new int[nEstacoes+1];
		int[] l1 = new int[nEstacoes+1];
		int[] l2 = new int[nEstacoes+1];
		f1[1] = tempoEntrada[0] + tempoEstacao[0][0];
		f2[1] = tempoEntrada[1] + tempoEstacao[1][0];
		l1[1] = 1;
		l2[1] = 2;
		
		for(int k = 2; k <= nEstacoes; k++) {
			if(f1[k - 1] <= (f2[k - 1] + tempoTroca[1][k - 2])) {
				f1[k] = f1[k - 1] + tempoEstacao[0][k-1];
				l1[k] = 1;
			}
			else {
				f1[k] = f2[k - 1] + tempoTroca[1][k - 2] + tempoEstacao[0][k-1];
				l1[k] = 2;
			}
			
			if(f2[k - 1] <= (f1[k - 1] + tempoTroca[0][k - 2])) {
				f2[k] = f2[k - 1] + tempoEstacao[1][k - 1];
				l2[k] = 2;
			}
			else {
				f2[k] = f1[k - 1] + tempoTroca[0][k - 2] + tempoEstacao[1][k - 1];
				l2[k] = 1;
			}
		}
		
		int f;	
		int[] resposta = new int[nEstacoes + 2];
		if((f1[nEstacoes] + tempoSaida[0]) <= (f2[nEstacoes] + tempoSaida[1])){
			f = f1[nEstacoes] + tempoSaida[0];
			
			resposta[0] = f;
			for(int i = 1; i < nEstacoes + 1; i++) {
				int j = i - 1;
				resposta[i] = l1[j];				
			}
		}
		else {
			f = f2[nEstacoes] + tempoSaida[1];

			resposta[0] = f;
			for(int i = 1; i < nEstacoes + 1; i++) {
				int j = i - 1;
				resposta[i] = l2[j];
			}
		}	
		return resposta;
	
	}
}