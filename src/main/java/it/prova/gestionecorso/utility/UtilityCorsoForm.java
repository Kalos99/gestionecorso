package it.prova.gestionecorso.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import it.prova.gestionecorso.model.Corso;

//nel nome della classe vi è Corso in quanto è una classe specifica
public class UtilityCorsoForm {

	public static Corso createCorsoFromParams(String nomeInputParam, String docenteInputParam,
			String numIscrittiInputParam, String dataInizioStringParam, String dataFineStringParam) {

		Corso result = new Corso(nomeInputParam, docenteInputParam);

		if (NumberUtils.isCreatable(numIscrittiInputParam)) {
			result.setNumeroIscritti(Integer.parseInt(numIscrittiInputParam));
		}
		result.setDataInizio(parseDateFromString(dataInizioStringParam));
		result.setDataFine(parseDateFromString(dataFineStringParam));

		return result;
	}

	public static boolean validateCorsoBean(Corso corsoToBeValidated) {
		// prima controlliamo che non siano vuoti i parametri
		if (StringUtils.isBlank(corsoToBeValidated.getNome())
				|| StringUtils.isBlank(corsoToBeValidated.getDocente())
				|| corsoToBeValidated.getNumeroIscritti() == null 
				|| corsoToBeValidated.getNumeroIscritti() < 1
				|| corsoToBeValidated.getDataInizio() == null
				|| corsoToBeValidated.getDataFine() == null
				|| corsoToBeValidated.getDataFine().before(corsoToBeValidated.getDataInizio())
				|| corsoToBeValidated.getDataFine().equals(corsoToBeValidated.getDataInizio())) {
			return false;
		}
		return true;
	}

	public static Date parseDateFromString(String dataStringParam) {
		if (StringUtils.isBlank(dataStringParam))
			return null;

		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(dataStringParam);
		} catch (ParseException e) {
			return null;
		}
	}

}
