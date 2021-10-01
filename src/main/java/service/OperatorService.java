package service;

import model.Operator;
import repository.Repository;
import java.util.*;

public class OperatorService {
    private Repository<Operator> repository;

    public OperatorService() {
        repository = new Repository<>();
    }

    public Operator createOperator(Operator operator){
        repository.insert(operator);
        return operator;
    }

    public List<Operator> getAllOperators(){
        return repository.getAll();
    }

    public Operator getOperatorById(UUID id){
        return repository.getById(id)
                .orElseThrow(() -> new NoSuchElementException("Operator not found in system!"));
    }

    public Operator getOperatorByCode(String code){
        List<Operator> operators = repository.getAll();
        return operators.stream()
                .filter(x -> x.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Operator not found in system!"));
    }

    public void updateOperator(UUID id, Operator operator){
        repository.update(id, operator);
    }

    public void deleteOperator(UUID id){
        repository.deleteById(id);
    }

}
