package by.tms.observer;

import by.tms.entity.Cone;
import by.tms.entity.ConeWarehouse;
import by.tms.factory.ConeFactory;
import by.tms.service.ConeService;
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

         ConeFactory coneFactory = new ConeFactory();

         coneWarehouse.putParameters(cone.getConeId(),coneFactory);

    }
}
