package P1n;

import java.time.LocalDate;

public class Pessoa {
	
	private static int contPessoa = 0;
	private String nome;
	private String sobreNome;
	private LocalDate dataNasc;
	private long numCPF;
	private float peso;
	private float altura;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("O nome nao pode ser vazio");
        }
		nome = nome.trim();
		if (!nome.matches("[A-Za-zÀ-ÿ]+")) {
			throw new IllegalArgumentException("O nome deve conter apenas letras, sem numeros, caracteres especiais ou espacos.");
		}		
		this.nome = nome;
	}
	
	public String getSobreNome() {
		return sobreNome;
	}
	
	public void setSobreNome(String sobreNome) {
		if (sobreNome == null || sobreNome.trim().isEmpty()) {
			throw new IllegalArgumentException("O sobrenome nao pode ser vazio");
        }
		sobreNome = sobreNome.trim();
		if (!sobreNome.matches("[A-Za-zÀ-ÿ ]+")) {
			throw new IllegalArgumentException("O sobrenome deve conter apenas letras e espacos, sem numeros e sem caracteres especiais");
		}
		this.sobreNome = sobreNome;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		if (peso == null || peso.trim().isEmpty()) {
			throw new IllegalArgumentException("O peso nao pode ser vazio");
        }
		float pesof;
		try {
			pesof = Float.parseFloat(peso);
		}
		catch (NumberFormatException e) {
	        throw new IllegalArgumentException("Peso invalido. Digite um numero decimal.");
	    }
		if (pesof < 2 || pesof > 500) {
			throw new IllegalArgumentException("Peso invalido. O peso deve estar entre 2 e 500");
		}
		this.peso = pesof;
	}
	
	public float getAltura() {
		return altura;
	}
	
	public void setAltura(String altura) {
		if (altura == null || altura.trim().isEmpty()) {
			throw new IllegalArgumentException("A altura nao pode ser vazia");
        }
		float alturaf;
		try {
			alturaf = Float.parseFloat(altura);
		}
		catch (NumberFormatException e) {
	        throw new IllegalArgumentException("Altura invalida. Digite um numero decimal.");
	    }
		if (alturaf < 0.4 || alturaf > 3) {
			throw new IllegalArgumentException("Altura invalida. A altura deve estar entre 0.4 e 3");
		}
		this.altura = alturaf;
	}
	
	public long getNumCPF() {
		return numCPF;
	}
	
	public void setNumCPF(String numCPF) {
		long numCPFl;
		try {
			numCPFl = ValidaCPF.toLong(numCPF);
		}
		catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("CPF invalido");
		}
		this.numCPF = numCPFl;
	}
	
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	
	public void setDataNasc(String dia, String mes, String ano) {
		if (ValidaData.isDataValida(dia, mes, ano)){
			int diaI = Integer.parseInt(dia);
			mes = mes.trim();
			int mesI;
			try {
			       mesI = Integer.parseInt(mes); 
			   } catch (NumberFormatException e) {   
			       mes = mes.toUpperCase();
			       mesI = (Mes.valueOf(mes).getNumero());
			   }
			int anoI = Integer.parseInt(ano);
			this.dataNasc = LocalDate.of(anoI, mesI, diaI);
		}
		else {
			throw new IllegalArgumentException("Data invalida");
		}
	}
	
	
	
	public static int getContPessoa() {
		return contPessoa;
	}
	
	public Pessoa() {
		
	}
	
	public Pessoa(String nome, String sobreNome, String dia, String mes, String ano) {
		super();
		setNome(nome);
		setSobreNome(sobreNome);
		setDataNasc(dia, mes, ano);
		contPessoa++;
	}
	
	public Pessoa(String nome, String sobreNome, String numCPF, String peso, String altura, String dia, String mes, String ano) {
		super();
		setNome(nome);
		setSobreNome(sobreNome);
		setNumCPF(numCPF);
		setPeso(peso);
		setAltura(altura);
		setDataNasc(dia, mes, ano);
		contPessoa++;
	}
	
	@Override
	public String toString() {
	    return "Nome: " + getNome() +
	           "\nSobrenome: " + getSobreNome() +
	           "\nCPF: " + ValidaCPF.imprimeCPF(Long.toString(getNumCPF())) +
	           "\nPeso: " + getPeso() +
	           "\nAltura: " + getAltura();
	}
	
}
