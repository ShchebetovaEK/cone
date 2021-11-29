package by.tms.figure.observer.impl;

import by.tms.figure.entity.Cone;
import by.tms.figure.entity.ConeParameters;
import by.tms.figure.entity.ConeWarehouse;
import by.tms.figure.observer.ConeEvent;
import by.tms.figure.observer.ConeObserver;
import by.tms.figure.service.ConeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class ConeObserverImpl implements ConeObserver {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void parametersChange(ConeEvent event) {

        ConeWarehouse coneWarehouse = ConeWarehouse.getInstance();
        ConeService coneService = new ConeService();
        Cone cone = event.getSource();
        UUID coneId = cone.getConeId();
        double coneSquare = coneService.calculateSquareCone(cone);
        double coneVolume = coneService.calculateVolumeCone(cone);
        ConeParameters coneParameters = new ConeParameters(coneSquare, coneVolume);
        coneWarehouse.put(cone.getConeId(), coneParameters);
        logger.info("update cone parameters coneId = {} new Volume {} new Square {}" ,coneId,coneVolume,coneSquare );
    }
}
