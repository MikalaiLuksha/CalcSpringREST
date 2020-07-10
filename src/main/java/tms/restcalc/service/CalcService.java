package tms.restcalc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tms.restcalc.entity.Operation;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalcService {

    private ComparatorOperation comparatorOperation;

    private final List<Operation> operationList = new ArrayList<>();

    @Autowired
    public CalcService(ComparatorOperation comparatorOperation) {
        this.comparatorOperation = comparatorOperation;
    }

    public Operation calcGo(Operation operation) {
        Operation operationCalc;
        switch (operation.getOperation()) {
            case "sum":
                operationCalc = new Operation(operation.getNum1(), operation.getNum2(), operation.getNum1() + operation.getNum2(), operation.getOperation());
                operationList.add(operationCalc);
                break;
            case "minus":
                operationCalc = new Operation(operation.getNum1(), operation.getNum2(), operation.getNum1() - operation.getNum2(), operation.getOperation());
                operationList.add(operationCalc);
                break;
            case "multi":
                operationCalc = new Operation(operation.getNum1(), operation.getNum2(), operation.getNum1() * operation.getNum2(), operation.getOperation());
                operationList.add(operationCalc);
                break;
            case "div":
                operationCalc = new Operation(operation.getNum1(), operation.getNum2(), operation.getNum1() / operation.getNum2(), operation.getOperation());
                operationList.add(operationCalc);
                break;
            default:
                operationCalc = null;
        }
        return operationCalc;
    }


    public List<Operation> sortRes (String sortList){
        List<Operation> newOperationList = new ArrayList<>(operationList);
        switch (sortList){
            case "no":
                return newOperationList;
            case "asc":
                newOperationList.sort((o1, o2) -> comparatorOperation.compare(o1, o2));
                return newOperationList;
            case "desc":
                newOperationList.sort((o1, o2) -> comparatorOperation.reverseCompare(o1, o2));
                return newOperationList;
            default:
                return null;
        }
    }
}
