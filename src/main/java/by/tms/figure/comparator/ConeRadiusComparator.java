package by.tms.figure.comparator;

import by.tms.figure.entity.Cone;

import java.util.Comparator;

public class ConeRadiusComparator implements Comparator<Cone> {

    @Override
    public int compare(Cone o1, Cone o2) {
        return Double.compare(o1.getRadius(),o2.getRadius());
    }
}
