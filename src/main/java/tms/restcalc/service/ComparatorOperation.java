package tms.restcalc.service;

import org.springframework.stereotype.Service;
import tms.restcalc.entity.Operation;

import java.util.Comparator;

@Service
public class ComparatorOperation implements Comparator<Operation> {

    @Override
    public int compare(Operation res1, Operation res2) {
        return Double.compare(res1.getRes(), res2.getRes());

    }

    public int reverseCompare (Operation res1, Operation res2) {
        return Double.compare(res2.getRes(), res1.getRes());

    }

}
