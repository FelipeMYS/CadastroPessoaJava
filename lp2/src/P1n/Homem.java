package P1n;

import java.time.LocalDate;
import java.time.Period;

public class Homem extends Pessoa {

	public Homem(String nome, String sobreNome, String dia, String mes, String ano) {
		super(nome, sobreNome, dia, mes, ano);
	}

	public Homem(String nome, String sobreNome, String numCPF, String peso, String altura, String dia, String mes,
			String ano) {
		super(nome, sobreNome, numCPF, peso, altura, dia, mes, ano);
	}
	
	public int getIdade() {
        LocalDate dataNascimento = getDataNasc();
        if (dataNascimento == null) {
            throw new IllegalStateException("Data de nascimento nao definida.");
        }
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
	
	@Override
	public String toString() {
	    return super.toString() + "\nGenero: Masculino" + "\nIdade: " + getIdade();
	}
}
