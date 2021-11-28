package by.tms.figure;

import by.tms.figure.entity.ConeParameters;
import by.tms.figure.entity.ConeWarehouse;
import by.tms.figure.factory.ConeFactory;
import by.tms.figure.factory.PointFactory;
import by.tms.figure.observer.ConeEvent;
import by.tms.figure.observer.ConeObserver;
import by.tms.figure.observer.impl.ConeObserverImpl;
import by.tms.figure.reader.ConeReader;
import by.tms.figure.repository.ConeRepository;
import by.tms.figure.service.ConeService;
import by.tms.figure.validator.ConeInputValidator;
import by.tms.figure.mapper.ConeInputMapper;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {


        ConeReader reader = new ConeReader();
        ConeInputMapper coneInputMapper = new ConeInputMapper(new ConeFactory(), new PointFactory());
        ConeInputValidator coneInputValidator = new ConeInputValidator();
        ConeService coneService = new ConeService();
        ConeObserver coneObserver = new ConeObserverImpl();

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
                .peek(cone -> cone.attach(coneObserver))
                .collect(Collectors.toList());






    }
}
