package ar.edu.unju.fi.Ejercicio6.main;

import ar.edu.unju.fi.Ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.Ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.Ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte) 45, 12f);
		
		//definición de expresión lambda que define el convertidor de FelinoDomestico a
		//FelinoSalvaje.

		if (Converter.isNotNull(gato)) {
      
            Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());

           
            FelinoSalvaje felinoSalvaje = converter.converter(gato);

     
            converter.mostrarObjeto(felinoSalvaje);
        }
		
		FelinoSalvaje tannerSalvaje = new FelinoSalvaje("Tanner", (byte) 20, 186f);
		
		Converter<FelinoSalvaje, FelinoDomestico> converterSalvajeDomestico = x -> new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());
		
		if (Converter.isNotNull(converterSalvajeDomestico)) {
			
			FelinoDomestico tannerDomestico = converterSalvajeDomestico.converter(tannerSalvaje);
			converterSalvajeDomestico.mostrarObjeto(tannerDomestico);
		}
		
		

	}

}
