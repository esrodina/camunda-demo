package com.example.workflow;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class PrepareToBattle implements JavaDelegate {
    @Override
    public void execute(DelegateExecution var1) throws Exception{
        int countEnemy = (int)Math.random() + 100; //кол воинов противника
        String status = "undefined";
        int countOur = (int)var1.getVariable("countOur"); //кол наших воинов
        boolean isWin = false;
        if (countOur < 0) {
            throw new BpmnError("varError");
        }
        if (countOur - countEnemy > 0){
            isWin = true;
            status = "victory";
        } else {
            status = "fail";
        }
        var1.setVariable("countEnemy", countEnemy);
        var1.setVariable("status", status);
        var1.setVariable("isWin", isWin);

    }
}
