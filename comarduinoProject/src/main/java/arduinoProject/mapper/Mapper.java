package arduinoProject.mapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class Mapper {

    private Gson gson;
    private static final Logger LOGGER = LoggerFactory.getLogger(Mapper.class);

    public Mapper() {
        GsonBuilder gsonBuilder = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new DateSerializer());
        this.gson = gsonBuilder.create();
    }

    public String mapToJson(Object object) {
        LOGGER.info("Mapping object to json.");
        return this.gson.toJson(object);
    }

}