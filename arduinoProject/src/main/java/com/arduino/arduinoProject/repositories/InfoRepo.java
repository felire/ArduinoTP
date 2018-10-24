package com.arduino.arduinoProject.repositories;

import com.arduino.arduinoProject.model.Info;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InfoRepo {
    private List<Info> infos;

    public InfoRepo() {
        this.infos = new ArrayList<>();
    }

    public void addInfo(Info info){
        infos.add(info);
    }

    public List<Info> getInfos() {
        return infos;
    }

    public void setInfos(List<Info> infos) {
        this.infos = infos;
    }
}
