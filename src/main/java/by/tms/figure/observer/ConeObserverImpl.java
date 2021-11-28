package by.tms.figure.observer;

import by.tms.figure.entity.Cone;
import by.tms.figure.entity.ConeParameters;
import by.tms.figure.entity.ConeWarehouse;
import by.tms.figure.service.ConeService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class ConeObserverImpl implements ConeObserver {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void parametersChange(ConeEvent event) {
        var coneWarehouse = ConeWarehouse.getInstance();
        var coneService = new ConeService();
        Cone cone = event.getSource();
        UUID coneId = cone.getConeId();
        ConeParameters coneParameters = coneWarehouse.get(coneId);
        double coneVolume = coneService.calculateVolumeCone(cone);
        double coneSquare = coneService.calculateSquareCone(cone);
//        coneParameters.setConeVolume(coneVolume);
//        coneParameters.setConeSquare(coneSquare);
        logger.log(Level.INFO, "update cone parameters coneId- " +coneId + "new Volume " + coneVolume + "new Square" + coneSquare);
//        ConeParameters coneParameters = new ConeParameters();
//        coneParameters.setConeSquare(coneSquare);
//        coneParameters.setConeVolume(coneVolume);

        coneWarehouse.putConeParameters(cone.getConeId(),coneParameters);

    }
}
