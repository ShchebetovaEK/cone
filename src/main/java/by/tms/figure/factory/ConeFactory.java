package by.tms.figure.factory;

import by.tms.figure.entity.Cone;

import java.util.UUID;

public class ConeFactory implements  EntityFactory<Cone>{

    @Override
    public Cone create() {
        return new Cone(UUID.randomUUID());
    }
}
