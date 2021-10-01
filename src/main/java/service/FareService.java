package service;

import controller.OperatorController;
import model.Fare;
import repository.Repository;

import javax.swing.text.html.Option;
import java.time.Period;
import java.util.*;

public class FareService {
    private Repository<Fare> repository;
    private OperatorController operatorController;

    public FareService(){
        repository = new Repository<>();
    }

    public Optional<Fare> createFare(Fare fare, String code, OperatorController operatorController){
        this.operatorController = operatorController;
        fare.setOperatorId(operatorController.getOperatorByCode(code).getId());
        if(this.verifyIfIsValid(fare)){
            repository.insert(fare);
            return Optional.of(fare);
        }
        else {
            return Optional.empty();
        }
    }

    public List<Fare> getAllFares(){
        return repository.getAll();
    }

    public Fare getFareById(UUID id){
        return repository.getById(id)
                .orElseThrow(() -> new NoSuchElementException("Fare not found in system!"));
    }

    public void updateFare(UUID id, Fare fare){
        repository.update(id, fare);
    }

    public void deleteFare(UUID id){
        repository.deleteById(id);
    }

    private boolean verifyIfIsValid(Fare fare){
        List<Fare> faresArray = this.getAllFares();
        Optional<Fare> fareToFind = faresArray.stream()
                .filter((x) -> x.getOperatorId().equals(fare.getOperatorId()) && x.getValue().equals(fare.getValue())
                            && (Period.between(x.getCreationDate(), fare.getCreationDate()).getMonths() < 6)
                            && (x.getStatus().equals(1))
                )
                .findFirst();
        if(fareToFind.isPresent()){
            return false;
        }
        else{
            return true;
        }
    }
}
