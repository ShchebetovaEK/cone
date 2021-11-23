package by.tms.entity;

import by.tms.factory.ConeFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ConeWarehouse {

    private static final Logger logger = LogManager.getLogger();
    private static ConeWarehouse instance;
    private Map<UUID, ConeFactory> coneMap = new HashMap<>();

    public ConeWarehouse() {
    }

    public static ConeWarehouse getInstance() {
        if(instance == null){
            instance = new ConeWarehouse();
        }
        return instance;
    }

    public Map<UUID, ConeFactory> getConeMap() {
        return Map.copyOf(coneMap);
    }

    public  void putParameters(UUID coneId, ConeFactory coneFactory){
        instance.coneMap.put(coneId,coneFactory);
    }

    public ConeFactory getConeFactory (UUID coneId){
        ConeFactory data = instance.coneMap.get(coneId);
        return null;
    }

}
