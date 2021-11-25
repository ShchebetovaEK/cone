package by.tms.figure.factory;

import by.tms.figure.entity.Cone;

public class ConeFactory implements  EntityFactory<Cone>{

    @Override
    public Cone create() {
        return new Cone();
    }
}
