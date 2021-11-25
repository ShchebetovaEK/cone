package by.tms.figure.service;

import by.tms.figure.entity.Cone;


public class ConeService {

    public double calculateConeSlangHeight(Cone cone) {
        return Math.sqrt(cone.getRadius() * cone.getRadius() + cone.getHeight() * cone.getHeight());

    }

    public double calculateSquareCone(Cone cone) {
        return Math.PI * cone.getRadius() * (calculateConeSlangHeight(cone) + cone.getRadius());
    }

    public double calculateVolumeCone(Cone cone) {
        return cone.getRadius() * cone.getRadius() * cone.getHeight() * Math.PI / 3;
    }
}
