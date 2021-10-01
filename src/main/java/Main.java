import controller.FareController;
import controller.OperatorController;
import model.Fare;
import model.Operator;
import service.OperatorService;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        //Inicialização das variáveis
        Scanner scanner = new Scanner(System.in);
        FareController fareController = new FareController();
        OperatorController operatorController = new OperatorController();

        Operator operator1 = new Operator(UUID.randomUUID(), "OP01");
        Operator operator2 = new Operator(UUID.randomUUID(), "OP02");
        Operator operator3 = new Operator(UUID.randomUUID(), "OP03");

        //Inserção de operadoras no fakedatabase
        operatorController.createOperator(operator1);
        operatorController.createOperator(operator2);
        operatorController.createOperator(operator3);
        operatorController.getAllOperators();

        //inserção de tarifas no fakedatabase
        Fare fare1 = new Fare();
        Fare fare2 = new Fare();
        Fare fare3 = new Fare();

        fare1.setId(UUID.randomUUID());
        fare1.setValue(2.45);
        fare1.setCreationDate(LocalDate.of(2021, 3, 2));
        fare1.setStatus(1);
        fareController.createFare(fare1, "OP01", operatorController);

        fare2.setId(UUID.randomUUID());
        fare2.setValue(2.59);
        fare2.setCreationDate(LocalDate.of(2021, 5, 6));
        fare2.setStatus(1);
        fareController.createFare(fare2, "OP02", operatorController);

        fare3.setId(UUID.randomUUID());
        fare3.setValue(2.21);
        fare3.setCreationDate(LocalDate.of(2021, 9, 6));
        fare3.setStatus(1);
        fareController.createFare(fare3, "OP03", operatorController);

        //Input de uma nova tarifa
        Fare newFare = new Fare();
        newFare.setId(UUID.randomUUID());
        newFare.setStatus(1);
        newFare.setCreationDate(LocalDate.now());

        System.out.println("Informe o valor da tarifa a ser cadastrada: ");
        String fareValueInput = scanner.next();
        newFare.setValue(Double.parseDouble(fareValueInput));

        System.out.println("Informe o código da operador para a tarifa: ");
        String operatorCodeInput = scanner.next();

        //caso a inserção cumpra todos os requisitos retorna mensagem de sucesso, caso contrário mensagem de falha
        System.out.println(fareController.createFare(newFare, operatorCodeInput, operatorController));
    }
}
