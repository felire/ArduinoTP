package com.arduino.arduinoProject.services;

import com.arduino.arduinoProject.model.Info;
import com.arduino.arduinoProject.repositories.InfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServices {

    @Autowired
    private InfoRepo infoRepo;

    public void saveData(Info info){
        infoRepo.addInfo(info);
    }

    public List<Info> getHistorico(){
        return infoRepo.getInfos();
    }

    public Info getPromedio(){
        Info promedio = new Info();
        promedio.setMax(infoRepo.getInfos().stream().mapToDouble(info -> info.getMax()).sum() / infoRepo.getInfos().size());
        promedio.setMin(infoRepo.getInfos().stream().mapToDouble(info -> info.getMin()).sum() / infoRepo.getInfos().size());
        promedio.setAvg(infoRepo.getInfos().stream().mapToDouble(info -> info.getAvg()).sum() / infoRepo.getInfos().size());
        return promedio;
    }
}
