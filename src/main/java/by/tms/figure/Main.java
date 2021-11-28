package by.tms.figure;

import by.tms.figure.entity.ConeParameters;
import by.tms.figure.entity.ConeWarehouse;
import by.tms.figure.factory.ConeFactory;
import by.tms.figure.factory.PointFactory;
import by.tms.figure.reader.ConeReader;
import by.tms.figure.service.ConeService;
import by.tms.figure.validator.ConeInputValidator;
import by.tms.figure.mapper.ConeInputMapper;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        ConeReader reader = new ConeReader();
        ConeInputMapper coneInputMapper = new ConeInputMapper(new ConeFactory(), new PointFactory());
        ConeInputValidator coneInputValidator = new ConeInputValidator();
        ConeService coneService = new ConeService();
        ConeFactory coneFactory = new ConeFactory();
        ConeParameters coneParameters = new ConeParameters();
        ConeWarehouse coneWarehouse = new ConeWarehouse();

        reader.getLines("C:\\Users\\HP\\IdeaProjects\\cone\\src\\main\\resources\\Info.txt")
                .stream()
                .flatMap(List::stream)
                .map(coneInputMapper::mapToStringParams)
                .filter(coneInputValidator::validateParameterCount)
                .map(coneInputMapper::mapToIntParams)
                .filter(coneInputValidator::validateParameters)
                .filter(coneInputValidator::validateConeHeight)
                .filter(coneInputValidator::validateConeRadius)
                .map(coneInputMapper::mapToCone)
                .forEach(cone -> {
                    System.out.println("coneId: " + cone.getConeId());
                    System.out.println("sqr: " + coneService.calculateSquareCone(cone));
                    System.out.println("volume: " + coneService.calculateVolumeCone(cone));
                });




    }
}
