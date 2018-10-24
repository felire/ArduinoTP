package com.arduino.arduinoProject.controllers;

import com.arduino.arduinoProject.mapper.Mapper;
import com.arduino.arduinoProject.model.Info;
import com.arduino.arduinoProject.services.InfoServices;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
public class InfoController {

    @Autowired
    private InfoServices infoServices;

    @Autowired
    private Mapper mapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(InfoController.class);

    @RequestMapping(value = "/info", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String postInfo(@RequestParam("max") String max, @RequestParam("min") String min, @RequestParam("avg") String avg) {
        LOGGER.info("Info process begun.");
        LOGGER.info(String.format("Checking input parameters: max: %s, min: %s, avg: %s", max, min, avg));
        LOGGER.info("Input parameters checked.");
        Info info = new Info(Double.parseDouble(max), Double.parseDouble(min), Double.parseDouble(avg));
        infoServices.saveData(info);
        return mapper.mapToJson(info);
    }

    @RequestMapping(value = "/historico", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getHistorico() {
        return mapper.mapToJson(infoServices.getHistorico());
    }

    @RequestMapping(value = "/promedio", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String getPromedio() {
        return mapper.mapToJson(infoServices.getPromedio());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getData(Model model) {
        return "index";
    }

}
