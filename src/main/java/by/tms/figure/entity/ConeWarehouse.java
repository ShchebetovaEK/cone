package by.tms.figure.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ConeWarehouse {

    private static final Logger logger = LogManager.getLogger();
    private static ConeWarehouse instance;
    private Map<UUID, ConeParameters> coneMap = new HashMap<>();

    public ConeWarehouse() {
    }

    public static ConeWarehouse getInstance() {
        if (instance == null) {
            logger.info("create a warehouse");
            instance = new ConeWarehouse();
        }
        return instance;
    }

    public Map<UUID, ConeParameters> getConeMap() {
        return Map.copyOf(coneMap);
    }

    public ConeParameters get(UUID coneId) {
        return coneMap.get(coneId);
    }

    public ConeParameters remove(UUID coneId) {
        return coneMap.remove(coneId);
    }

    public void putParameters(UUID coneId, ConeParameters coneParameters) {
        instance.coneMap.put(coneId, coneParameters);
    }

    public ConeParameters getConeParameters(UUID coneId) {
        ConeParameters data = instance.coneMap.get(coneId);
        return null;
    }

}
