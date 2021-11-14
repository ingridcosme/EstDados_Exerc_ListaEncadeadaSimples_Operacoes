package view;

import javax.swing.JOptionPane;

import br.edu.fateczl.ingridcosme.listaencadeadaint.ListaEncadeadaSimples;
import controller.OpController;

public class Principal {

	public static void main(String[] args) {
		OpController opCont = new OpController();
		ListaEncadeadaSimples l1 = new ListaEncadeadaSimples();
		ListaEncadeadaSimples l2 = new ListaEncadeadaSimples();
		ListaEncadeadaSimples aux = new ListaEncadeadaSimples();
		
		int opc = 0;
		while(opc != 9) {
			String opcao = JOptionPane.showInputDialog(null, menu());
			opc = Integer.parseInt(opcao);
			switch(opc) {
			
			case 0:
				int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Lista 1\nDigite um número"));
				opCont.insere(numero, l1);
				break;
			
			case 1:
				numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Lista 2\nDigite um número"));
				opCont.insere(numero, l2);
				break;
			
			case 2:
				try {
					aux = opCont.concatena(l1, l2);
					System.out.println("Nova lista: "+aux.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 3:
				try {
					aux = opCont.intercala(l1, l2);
					System.out.println("Nova lista: "+aux.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 4:
				int lista = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual lista deseja dividir?"
						+ "\nDigite 1 ou 2"));
				numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de "
						+ "sublistas desejadas"));
				try {
					if(lista == 1) {
						ListaEncadeadaSimples[] vetor = opCont.divide(l1, numero);
						for(ListaEncadeadaSimples i: vetor) {
							System.out.println("Sublista: "+i.toString());
						}
					} else {
						ListaEncadeadaSimples[] vetor = opCont.divide(l2, numero);
						for(ListaEncadeadaSimples i: vetor) {
							System.out.println("Sublista: "+i.toString());
						}
					}					
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 5:
				lista = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual lista deseja copiar?"
						+ "\nDigite 1 ou 2"));
				try {
					if(lista == 1) {
						aux = opCont.copia(l1);
					} else {
						aux = opCont.copia(l2);
					}
					System.out.println("Nova lista: "+aux.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 6:
				lista = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual lista deseja ordenar?"
						+ "\nOrdenação Crescente\nDigite 1 ou 2"));
				try {
					if(lista == 1) {
						aux = opCont.ordenaCrescente(l1);
					} else {
						aux = opCont.ordenaCrescente(l2);
					}
					System.out.println("Lista ordenada: "+aux.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 7:
				lista = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual lista deseja ordenar?"
						+ "\\nOrdenação Decrescente\nDigite 1 ou 2"));
				try {
					if(lista == 1) {
						aux = opCont.ordenaDecrescente(l1);
					} else {
						aux = opCont.ordenaDecrescente(l2);
					}
					System.out.println("Lista ordenada: "+aux.toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 9:
				break;
			
			default:
				JOptionPane.showMessageDialog(null, "Digite uma opção válida", "ERRO", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
		
	}
	
	private static String menu() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Digite uma opção:\n");
		buffer.append("0 - Inserir um número à lista no. 1\n");
		buffer.append("1 - Inserir um número à lista no. 2\n");
		buffer.append("2 - Concatenar as duas listas\n");
		buffer.append("3 - Intercalar as duas listas\n");
		buffer.append("4 - Dividir uma lista (criar sublistas)\n");
		buffer.append("5 - Criar uma cópia\n");
		buffer.append("6 - Ordenar de forma crescente\n");
		buffer.append("7 - Ordenar de forma decrescente\n");
		buffer.append("9 - Encerra a aplicação\n");

		return buffer.toString();
	}

}
