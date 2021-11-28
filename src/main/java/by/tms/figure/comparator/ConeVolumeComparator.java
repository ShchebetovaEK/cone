package by.tms.figure.comparator;

import by.tms.figure.entity.Cone;
import by.tms.figure.entity.ConeWarehouse;

import java.util.Comparator;

public class ConeVolumeComparator implements Comparator<Cone> {

    @Override
    public int compare(Cone o1, Cone o2) {
        return Double.compare(ConeWarehouse.getInstance().get(o1.getConeId()).getConeVolume(), ConeWarehouse.getInstance().get(o2.getConeId()).getConeVolume());
    }
}
