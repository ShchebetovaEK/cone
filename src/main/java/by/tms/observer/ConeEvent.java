package by.tms.observer;

import by.tms.entity.Cone;

import java.util.EventObject;

public class ConeEvent extends EventObject {

    public ConeEvent(Cone source) {
        super(source);
    }

    @Override
    public Cone getSource() {
        return (Cone) super.getSource();
    }
}
