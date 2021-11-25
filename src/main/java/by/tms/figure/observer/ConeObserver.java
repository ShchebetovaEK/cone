package by.tms.figure.observer;

import by.tms.figure.entity.Cone;
import by.tms.figure.entity.ConeParameters;
import by.tms.figure.entity.ConeWarehouse;
import by.tms.figure.service.ConeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeObserver implements Observer {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void parametersChange(ConeEvent event) {
        var coneWarehouse = ConeWarehouse.getInstance();
        var coneService = new ConeService();
        Cone cone = event.getSource();

        double coneVolume = coneService.calculateVolumeCone(cone);
        double coneSquare = coneService.calculateSquareCone(cone);

        ConeParameters coneParameters = new ConeParameters();

        coneWarehouse.putParameters(cone.getConeId(), coneParameters);

    }
}
