package tms.restcalc.resource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tms.restcalc.entity.Operation;
import tms.restcalc.service.CalcService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/calc")
public class CalcResource {


    private final CalcService calcService;

    @Autowired
    public CalcResource(CalcService calcService) {
        this.calcService = calcService;
    }

    @PostMapping
    private ResponseEntity<Operation> calc (@RequestBody Operation operation){
        Operation calcGo = calcService.calcGo(operation);
        if (calcGo!=null){
            return new ResponseEntity<>(calcGo, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        }



    @GetMapping(path = "/{sort}")
    private ResponseEntity<List<Operation>> calcRes (@PathVariable(name = "sort") String sort){
        List<Operation> operations = calcService.sortRes(sort);
        if (operations !=null){
            return new ResponseEntity<>(operations, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
