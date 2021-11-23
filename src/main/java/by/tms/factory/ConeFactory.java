package by.tms.factory;

import by.tms.entity.Cone;

public class ConeFactory implements  EntityFactory<Cone>{
    @Override
    public Cone create() {
        return new Cone();
    }
}
