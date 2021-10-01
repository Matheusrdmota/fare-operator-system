package controller;

import model.Operator;
import service.OperatorService;
import java.util.*;

public class OperatorController {
    private OperatorService operatorService;

    public OperatorController(){
        operatorService = new OperatorService();
    }

    public Operator createOperator(Operator operator){
        return operatorService.createOperator(operator);
    }

    public List<Operator> getAllOperators(){
        return operatorService.getAllOperators();
    }

    public Operator getOperatorByCode(String code){
        return operatorService.getOperatorByCode(code);
    }

    public Operator getOperatorById(UUID id){
        return operatorService.getOperatorById(id);
    }

    public void updateOperator(UUID id, Operator operator){
        operatorService.updateOperator(id, operator);
    }

    public void deleteOperator(UUID id){
        operatorService.deleteOperator(id);
    }
}
