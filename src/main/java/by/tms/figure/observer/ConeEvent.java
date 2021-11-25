package by.tms.figure.observer;

import by.tms.figure.entity.Cone;

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
