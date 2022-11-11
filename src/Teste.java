/*
 * AEDII - Trabalho 02
 * Alunos: 
 * 	Stephanie Fonseca de Oliveira Gomes Magalhaes
 * 	Pablo Vasconcelos da Cruz
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Teste {
	
	public static void main(String[] args) {
		
		ProgDinamica linhaPD = new ProgDinamica();
		AlgoritmoGuloso linhaAG = new AlgoritmoGuloso();
		
		/*Scanner myObj = new Scanner(System.in);
		ArrayList<Integer> tempos = new ArrayList<>();
		boolean continua = true;
		
		System.out.println("Insira os tempos de processamento da linha 1, e digite 0 para finalizar:");
		while(continua) {
			int aux = myObj.nextInt();
			if(aux == 0) {
				break;
			}
			tempos.add(aux);
		}
		

		int[] tempoEntrada = new int[2];
		int[] tempoSaida = new int[2];
		int nEstacoes = tempos.size() - 2;
		int[][] tempoEstacao = new int[2][nEstacoes];
		int[][] tempoTroca = new int[2][nEstacoes];*/
		
		int[] tempoEntrada = {3, 2};
		int[] tempoSaida = {6, 5};
		int nEstacoes = 9;
		int[][] tempoEstacao = { {5, 7, 10, 5, 9, 11, 9, 5, 2}, {6, 3, 9, 11, 4, 9, 3, 12, 4} };
		int[][] tempoTroca = { {3, 5, 4, 2, 7, 5, 8, 1}, {5, 3, 7, 5, 6, 2, 5, 2} };
		
		/*int[] tempoEntrada = {5, 7};
		int[] tempoSaida = {8, 9};
		int nEstacoes = 8;
		int[][] tempoEstacao = { {10, 6, 3, 8, 5, 3, 7, 12}, {3, 5, 3, 7, 6, 4, 9, 10} };
		int[][] tempoTroca = { {4, 2, 7, 2, 5, 8, 2}, {6, 1, 7, 3, 6, 4, 5} };*/
		
		
		
		
		/*tempoEntrada[0] = tempos.get(0);
		tempoSaida[0] = tempos.get(nEstacoes + 1);
		for(int i = 0; i < nEstacoes; i++) {
			tempoEstacao[0][i] = tempos.get(i + 1);
		}
		tempos.clear();
		
		System.out.println("Insira os tempos de processamento da linha 2:");
		int contador = 1;
		while(continua) {
			int aux = myObj.nextInt();
			if(contador == nEstacoes + 2) {
				break;
			}
			tempos.add(aux);
			contador++;
		}
		tempoEntrada[1] = tempos.get(0);
		tempoSaida[1] = tempos.get(nEstacoes);
		for(int i = 0; i < nEstacoes; i++) {
			tempoEstacao[1][i] = tempos.get(i + 1);
		}
		tempos.clear();
		contador = 0;
		
		System.out.println("Insira os tempos de troca de estacao da linha 1 para a linha 2:");
		while(continua) {
			if(contador == nEstacoes - 1) {
				break;
			}
			int aux = myObj.nextInt();
			tempos.add(aux);
			contador++;
		}
		for(int i = 1; i < nEstacoes; i++) {
			tempoTroca[0][i] = tempos.get(i-1);
		}
		tempos.clear();
		
		contador = 0;
		
		System.out.println("Insira os tempos de troca de estacao da linha 2 para a linha 1:");
		while(continua) {
			if(contador == nEstacoes - 1) {
				break;
			}
			int aux = myObj.nextInt();
			tempos.add(aux);
			contador++;
		}
		for(int i = 1; i < nEstacoes; i++) {
			tempoTroca[1][i] = tempos.get(i-1);
		}
		tempos.clear();*/
		
		
		int resposta[];
		System.out.println("Resultado por programacao dinamica:");
		resposta = linhaPD.calculaRota(tempoEstacao, tempoTroca, tempoEntrada, tempoSaida, nEstacoes).clone();
		
		System.out.println("Menor tempo gasto: " + resposta[0]);
		System.out.println("Caminho percorrido: ");
		for(int i = 1; i < nEstacoes; i++) {
			System.out.println(resposta[i + 1]);
		}
		
		
		System.out.println("Resultado por algoritmo guloso:");
		resposta = linhaAG.calculaRota(tempoEstacao, tempoTroca, tempoEntrada, tempoSaida, nEstacoes).clone();

		System.out.println("Menor tempo gasto: " + resposta[0]);
		System.out.println("Caminho percorrido: ");
		for(int i = 1; i < nEstacoes; i++) {
			System.out.println(resposta[i]);
		}
	}

}
