package by.tms;

import by.tms.entity.ConeParameters;
import by.tms.factory.ConeFactory;
import by.tms.factory.PointFactory;
import by.tms.mapper.ConeInputMapper;
import by.tms.service.ConeService;
import by.tms.reader.Reader;
import by.tms.validator.ConeInputValidator;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        Reader reader = new Reader();
        ConeInputMapper coneInputMapper = new ConeInputMapper(new ConeFactory(), new PointFactory());
        ConeInputValidator coneInputValidator = new ConeInputValidator();
        ConeService coneService = new ConeService();
        reader.getLines("C:\\Users\\HP\\IdeaProjects\\cone\\src\\main\\resources\\Info.txt")
                .stream()
                .flatMap(List::stream)
                .map(coneInputMapper::mapToStringParams)
                .filter(coneInputValidator::validateParameterCount)
                .map(coneInputMapper::mapToIntParams)
                .filter(coneInputValidator::validateParameters)
                .map(coneInputMapper::mapToCone)
                .forEach(cone -> {
                    System.out.println("coneId: " + cone.getConeId());
                    System.out.println("sqr: " + coneService.calculateSquareCone(cone));
                    System.out.println("volume: " + coneService.calculateVolumeCone(cone));
                });

    }
}
