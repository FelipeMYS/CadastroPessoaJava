package P1n;

import java.util.Locale;
import java.util.Scanner;

public class P1nX {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		if (args.length != 9) {
            System.out.println("Sintaxe correta: java P1nX <genero> <nome> <sobre> <dia> <mes> <ano> <CPF> <peso> <altura>");
            System.out.println();
            System.out.println("O genero deve ser escrito com H para homem e M para mulher");
        }
		else {
	        String genero = args[0];
	        String nome = args[1];
	        String sobreNome = args[2];
	        String dia = args[3];
	        String mes = args[4];
	        String ano = args[5];
	        String numCPF = args[6];
	        String peso = args[7];
	        String altura = args[8];
	
	        pessoaComando(genero, nome, sobreNome, dia, mes, ano, numCPF, peso, altura);
		}
		System.out.println();
        System.out.print("Quantas pessoas a mais deseja inserir? ");
        
        int n = 0;
        while (true) {
            try {
                System.out.print("Informe a quantidade de pessoas: ");
                n = Integer.parseInt(sc.nextLine());
                if (n <= 0) {
                	System.out.println();
                    System.out.println("A quantidade deve ser maior que zero. Tente novamente.");
                    System.out.println();
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
            	System.out.println();
                System.out.println("Entrada invalida. Digite um numero inteiro.");
                System.out.println();
            }
        }
        
        Pessoa[] array = new Pessoa[n];
        
        int i = 0;
        while (i < n) {
        	System.out.println();
            int resultado = addPessoa(array, i, sc);
            if (resultado == -1) {
                System.out.println("Leitura encerrada pelo usuario.");
                break;
            } else if (resultado == 1) {
                i++;
            }
        }
        
        System.out.println();
        System.out.println("Informaçoes inseridas: ");
        printArray(array);
        
        System.out.println();
        System.out.println("Total de pessoas: " + Pessoa.getContPessoa());
		System.out.println("Total de homens: " + contaHomem(array));
		System.out.print("Total de mulheres: " + contaMulher(array));
        
		sc.close();
	}
	
	public static void pessoaComando(String genero, String nome, String sobreNome, String dia, String mes, String ano, String numCPF, String peso, String altura) {
		if (genero.equalsIgnoreCase("H")) {
        	try {
                Homem homem = new Homem(nome, sobreNome, numCPF, peso, altura, dia, mes, ano);
                System.out.println(homem);
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        else if (genero.equalsIgnoreCase("M")) {
        	try {
                Mulher mulher = new Mulher(nome, sobreNome, numCPF, peso, altura, dia, mes, ano);
                System.out.println(mulher);
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        else {
        	System.out.println("Genero invalido");
        }
	}
	
	public static int addPessoa(Pessoa[] array, int i, Scanner sc) {	
		 String nome = "", sobreNome = "", dia = "", mes = "", ano = "", numCPF = "", peso = "", altura = "", genero = "";

		    while (true) {
		        try {
		            System.out.print("Insira o nome: ");
		            nome = sc.nextLine().trim();
		            if (nome.isEmpty()) {
		            	return -1;
		            }
		            Pessoa pessoaTemp = new Pessoa();
		            pessoaTemp.setNome(nome);
		            break;
		        }
		        catch (IllegalArgumentException e) {
		            System.out.println(e.getMessage() + " Tente novamente.");
		        }
		    }

		    while (true) {
		        try {
		            System.out.print("Insira o sobrenome: ");
		            sobreNome = sc.nextLine().trim();
		            if (sobreNome.isEmpty()) {
		            	return -1;
		            }
		            Pessoa pessoaTemp = new Pessoa();
		            pessoaTemp.setSobreNome(sobreNome);
		            break;
		        }
		        catch (IllegalArgumentException e) {
		            System.out.println(e.getMessage() + " Tente novamente.");
		        }
		    }

		    while (true) {
		        try {
		            System.out.print("Dia de nascimento: ");
		            dia = sc.nextLine().trim();
		            if (dia.isEmpty()) {
		            	return -1;
		            }
		            System.out.print("Mes de nascimento: ");
		            mes = sc.nextLine().trim();
		            if (mes.isEmpty()) {
		            	return -1;
		            }
		            System.out.print("Ano de nascimento: ");
		            ano = sc.nextLine().trim();
		            if (ano.isEmpty()) {
		            	return -1;
		            }
		            if (!ValidaData.isDataValida(dia, mes, ano)) {
		                throw new IllegalArgumentException("Data invalida. Tente novamente.");
		            }
		            break;
		        }
		        catch (IllegalArgumentException e) {
		            System.out.println(e.getMessage() + " Tente novamente.");
		        }
		    }

		    while (true) {
		        try {
		            System.out.print("Insira o CPF: ");
		            numCPF = sc.nextLine().trim();
		            if (numCPF.isEmpty()) {
		            	return -1;
		            }
		            if (!ValidaCPF.isCPF(numCPF)) {
		                throw new IllegalArgumentException("CPF invalido. Tente novamente.");
		            }
		            break;
		        } 
		        catch (IllegalArgumentException e) {
		            System.out.println(e.getMessage() + " Tente novamente.");
		        }
		    }

		    while (true) {
		        try {
		            System.out.print("Insira o peso: ");
		            peso = sc.nextLine().trim();
		            if (peso.isEmpty()) {
		            	return -1;
		            }
		            Pessoa pessoaTemp = new Pessoa();
		            pessoaTemp.setPeso(peso);
		            break;
		        } 
		        catch (IllegalArgumentException e) {
		            System.out.println(e.getMessage() + " Tente novamente.");
		        }
		    }

		    while (true) {
		        try {
		            System.out.print("Insira a altura: ");
		            altura = sc.nextLine().trim();
		            if (altura.isEmpty()) {
		            	return -1;
		            }
		            Pessoa pessoaTemp = new Pessoa();
		            pessoaTemp.setAltura(altura);
		            break;
		        } 
		        catch (IllegalArgumentException e) {
		            System.out.println(e.getMessage() + " Tente novamente.");
		        }
		    }

		    while (true) {
		        try {
		            System.out.print("Esta pessoa e homem ou mulher? (H/M): ");
		            genero = sc.nextLine().trim().toUpperCase();
		            if (genero.isEmpty()) {
		            	return -1;
		            }
		            if (genero.equals("H")) {
		                Homem homem = new Homem(nome, sobreNome, numCPF, peso, altura, dia, mes, ano);
		                array[i] = homem;
		            } 
		            else if (genero.equals("M")) {
		                Mulher mulher = new Mulher(nome, sobreNome, numCPF, peso, altura, dia, mes, ano);
		                array[i] = mulher;
		            } 
		            else {
		                System.out.println("Genero invalido. Por favor, insira 'H' para homem ou 'M' para mulher.");
		                continue;
		            }
		            break;
		        } 
		        catch (Exception e) {
		            System.out.println("Erro: " + e.getMessage());
		        }
		    }

		    return 1;
	}
	
	public static void printArray(Pessoa[] array) {
		for (Pessoa p : array) {
		    if (p != null) {
		        System.out.println(p);
		        System.out.println();
		    }
		}
	}
	
	public static int contaHomem(Pessoa[] array) {
		int count = 0;
		for (Pessoa p: array) {
			if (p instanceof Homem) {
	            count++;
	        }
		}
		return count;
	}
	
	public static int contaMulher(Pessoa[] array) {
		int count = 0;
		for (Pessoa p: array) {
			if (p instanceof Mulher) {
	            count++;
	        }
		}
		return count;
	}
}
