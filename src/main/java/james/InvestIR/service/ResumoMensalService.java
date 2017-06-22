package james.InvestIR.service;

import james.InvestIR.domain.Carteira;
import org.springframework.stereotype.Service;

/**
 * Created by James on 09/06/2017.
 */

@Service
public class ResumoMensalService {

//    private final NotaService notaService;
    private final AtivoCarteiraService ativoCarteiraService;
    private final AtivosNotaService ativosNotaService;

    public ResumoMensalService(AtivoCarteiraService ativoCarteiraService, AtivosNotaService ativosNotaService) {
         this.ativoCarteiraService = ativoCarteiraService;
         this.ativosNotaService = ativosNotaService;
    }

    public double calculaImpostoMensal(Carteira carteira, String mesAno) {
    	// TODO - Implementar RNG004, RNG010, RNG011
    	double impostoAPagar = 	this.calculaImpostoNormal(carteira);
    	impostoAPagar += this.calculaImpostoDaytrade(carteira);
    	impostoAPagar += this.calculaImpostoFii(carteira);
    	// TODO - Implementar RNG003, RNG005, RNG013

    	return impostoAPagar;
    }

    private double calculaImpostoNormal(Carteira carteira){
    	// TODO - Implementar RNG006, RNG009, RNG010, RNG011, RNG012, RNG013, RNG014, RNG015
    	// TODO - Implementar atualização da carteira
    	return 0;
    }

    private double calculaImpostoDaytrade(Carteira carteira){
    	// TODO - Implementar RNG007, RNG010, RNG012, RNG013, RNG014, RNG015
    	// TODO - Implementar atualização da carteira
    	return 0;
    }

    private double calculaImpostoFii(Carteira carteira){
    	// TODO - Implementar RNG008, RNG012, RNG013, RNG015, RNG016
    	// TODO - Implementar atualização da carteira
    	return 0;
    }

}
