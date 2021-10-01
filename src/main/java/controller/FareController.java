package controller;

import model.Fare;
import service.FareService;
import service.OperatorService;

import java.util.*;

public class FareController {
    private FareService fareService;

    public FareController(){
        fareService = new FareService();
    }

    public String createFare(Fare fare, String code, OperatorController operatorController){
        Optional<Fare> fareToBeCreated = fareService.createFare(fare, code, operatorController);
        if(fareToBeCreated.isPresent()){
            return "Tarifa cadastrada com sucesso!";
        }
        else{
            return "Falha no cadastro da tarifa!";
        }
    }

    public List<Fare> getAll(){
        return fareService.getAllFares();
    }

    public Fare getFareById(UUID id){
        return fareService.getFareById(id);
    }

    public void updateFare(UUID id, Fare fare){
        fareService.updateFare(id, fare);
    }

    public void deleteFare(UUID id){
        fareService.deleteFare(id);
    }
}
