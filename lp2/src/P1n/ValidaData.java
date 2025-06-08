package P1n;

import java.time.DateTimeException;
import java.time.LocalDate;

public class ValidaData {
		
	public static boolean isDia(String str) {
		
		if (str == null || str.trim().isEmpty()) {
            return false;
        }
		
		try {
			int dia = Integer.parseInt(str);
			return dia >= 1 && dia <= 31;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
	
	public static boolean isMes(String str) {
			
			if (str == null || str.trim().isEmpty()) {
	            return false;
	        }
			
			try {
				int mes = Integer.parseInt(str);
				return mes >= 1 && mes <= 12;
			}
			catch(NumberFormatException e) {
				try {
					String mes = str.trim().toUpperCase();
					Mes m = Mes.valueOf(mes);
					return true;
				}
				catch(IllegalArgumentException e2) {
					return false;
				}
			}
	}
	
	public static boolean isAno(String str) {
		
		if (str == null || str.trim().isEmpty()) {
            return false;
        }
		
		try {
			int ano = Integer.parseInt(str);
			int anoAtual = LocalDate.now().getYear();
			return ano >= (anoAtual - 120) && ano <= anoAtual;
		}
		catch(NumberFormatException e) {
			return false;
		}
	}
	
	public static boolean isDataValida(String diaStr, String mesStr, String anoStr) {
	    if (isDia(diaStr) && isMes(mesStr) && isAno(anoStr)) {
	        try {
	            int dia = Integer.parseInt(diaStr);
	            int ano = Integer.parseInt(anoStr);
	            int mes;

	            try {
	                mes = Integer.parseInt(mesStr);
	            } catch (NumberFormatException e) {
	                mesStr = mesStr.trim().toUpperCase();
	                mes = Mes.valueOf(mesStr).getNumero();
	            }

	            LocalDate.of(ano, mes, dia);
	            return true;
	        } catch (DateTimeException e) {
	            return false;
	        }
	    }
	    return false;
	}

		
}
