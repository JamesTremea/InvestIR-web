package james.InvestIR.service;

import james.InvestIR.domain.Ativo;
import james.InvestIR.repository.AtivoRepository;
import org.springframework.stereotype.Service;

/**
 * Created by James on 09/06/2017.
 */

@Service
public class AtivoService {

    private final AtivoRepository ativoRepository;

    public AtivoService(AtivoRepository ativoRepository) {
         this.ativoRepository = ativoRepository;
    }

    public Ativo save(Ativo ativo) {
    	Ativo at = new Ativo();
//        student = (Student)personService.findOne(student.getId());
//
//        if (student.getHealthRegister() == null){
//            hr.setStudent(student);
//            hr = healthRegisterRepository.save(hr);
//            student.setHealthRegister(hr);
//        } else{
//            student.getHealthRegister().setDescription(hr.getDescription());
//        }
//
//        personService.save(student);
    	return at;
    }


    public Ativo findOne(Long id){
    	return ativoRepository.findOne(id);
    }

}
