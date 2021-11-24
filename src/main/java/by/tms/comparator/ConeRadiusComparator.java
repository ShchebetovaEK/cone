package by.tms.comparator;

import by.tms.entity.Cone;

import java.util.Comparator;

public class ConeRadiusComparator implements Comparator<Cone> {
    @Override
    public int compare(Cone o1, Cone o2) {
        return Double.compare(o1.getRadius(),o2.getRadius());
    }
}
