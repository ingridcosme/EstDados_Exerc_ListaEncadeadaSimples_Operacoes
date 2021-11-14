/*
 * Considere listas implementadas por encadeamento simples, então pede-se para implementar funções que:
 * a. Concatenar/intercalar duas listas;
 * b. Dividir uma lista em várias;
 * c. Copiar uma lista;
 * d. Ordenar (sort) uma lista por ordem crescente/decrescente.
 */

package controller;

import br.edu.fateczl.ingridcosme.listaencadeadaint.ListaEncadeadaSimples;

public class OpController {

	public OpController() {
		super();
	}
	
	public void insere(int numero, ListaEncadeadaSimples l) {
		l.insertAtBack(numero);
	}
	
	public ListaEncadeadaSimples concatena(
			ListaEncadeadaSimples l1, ListaEncadeadaSimples l2) throws Exception {
		int tamanhoL2 = l2.size();
		int posicao = 0;
		while(posicao < tamanhoL2) {
			l1.insertAtBack(l2.getValue(posicao));
			posicao++;
		}
		return l1;
	}
	
	public ListaEncadeadaSimples intercala(
			ListaEncadeadaSimples l1, ListaEncadeadaSimples l2) throws Exception {
		ListaEncadeadaSimples listaRes = new ListaEncadeadaSimples();
		
		int posicao = 0;
		int tamanho = 0;
		
		//Uso como referência o tamanho da maior lista
		if(l1.size() >= l2.size()) {
			tamanho = l1.size();
		} else {
			tamanho = l2.size();
		}
		
		while(posicao < tamanho) {
			if(!l1.isEmpty()) {
				listaRes.insertAtBack(l1.getValue(posicao));
			}
			if(!l2.isEmpty()) {
				listaRes.insertAtBack(l2.getValue(posicao));
			}
			posicao++;
		}
		return listaRes;
	}
	
	public ListaEncadeadaSimples[] divide(
			ListaEncadeadaSimples l, int qtdListas) throws Exception {
		//Vetor de sublistas encadeadas
		ListaEncadeadaSimples listaRes[] = new ListaEncadeadaSimples[qtdListas];
		//Última posição
		int posicao = l.size() - 1;
		//Quantidade mínima de elementos nas sublistas
		int qtdNumeros = (posicao + 1) / qtdListas;
		//Quantidade de elementos restantes a serem distribuídos nas sublistas
		int resto = (posicao + 1) % qtdListas;
		
		//Percorrendo o vetor e criando as sublistas
		for(int k = 0; k < qtdListas; k++) {
			listaRes[k] = new ListaEncadeadaSimples();
			//Inserindo a quantidade mínima de elementos na sublista
			for(int j = 1; j <= qtdNumeros; j++) {
				if(posicao >= 0) {
					listaRes[k].insertAtFront(l.getValue(posicao));
					//Inserindo os elementos restantes
					if(resto > 0) {
						posicao--;
						listaRes[k].insertAtFront(l.getValue(posicao));
						resto--;
					}
					posicao--;
				}
			}
		}
		return listaRes;
	}
	
	public ListaEncadeadaSimples copia(ListaEncadeadaSimples l) throws Exception {
		ListaEncadeadaSimples auxiliar = new ListaEncadeadaSimples();
		
		for(int i = 0; i < l.size(); i++) {
			auxiliar.insertPosition(i, l.getValue(i));
		}
		return auxiliar;
	}
	
	public ListaEncadeadaSimples ordenaCrescente(ListaEncadeadaSimples l) throws Exception {
		int tamanho = l.size();
		
		//Ordenando baseado no Bubble Sort
		for(int i = 0; i < tamanho; i++) {
			for(int j = 0 ; j < tamanho - 1 ; j++) {
				if(l.getValue(j) > l.getValue(j + 1)) {
					int aux = l.getValue(j);
					l.removePosition(j);
					l.insertPosition(j, l.getValue(j));
					l.removePosition(j + 1);
					l.insertPosition(j + 1, aux);
				}
			}
		}
		return l;
	}
	
	public ListaEncadeadaSimples ordenaDecrescente(ListaEncadeadaSimples l) throws Exception {
		int tamanho = l.size();
		
		//Ordenando baseado no Bubble Sort
		for(int i = 0; i < tamanho; i++) {
			for(int j = 0 ; j < tamanho - 1 ; j++) {
				if(l.getValue(j) < l.getValue(j + 1)) {
					int aux = l.getValue(j);
					l.removePosition(j);
					l.insertPosition(j, l.getValue(j));
					l.removePosition(j + 1);
					l.insertPosition(j + 1, aux);
				}
			}
		}
		return l;
	}
	
}
