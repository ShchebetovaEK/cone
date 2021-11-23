package by.tms.entity;

import java.util.Objects;
import java.util.UUID;

public class Cone implements Figure {

     private UUID coneId;
     private Point center;
     private double radius;
     private double height ;

     public Cone() {
     }

     public Cone(UUID coneId, Point center, double radius, double height) {
          this.coneId = coneId;
          this.center = center;
          this.radius = radius;
          this.height = height;
     }

     public UUID getConeId() {
          return coneId;
     }

     public void setConeId(UUID coneId) {
          this.coneId = coneId;
     }

     public Point getCenter() {
          return center;
     }

     public void setCenter(Point center) {
          this.center = center;
     }

     public double getRadius() {
          return radius;
     }

     public void setRadius(double radius) {
          this.radius = radius;
     }

     public double getHeight() {
          return height;
     }

     public void setHeight(double height) {
          this.height = height;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          Cone cone = (Cone) o;
          return coneId == cone.coneId && Double.compare(cone.radius, radius) == 0 &&
                  Double.compare(cone.height, height) == 0 &&
                  Objects.equals(center, cone.center);
     }

     @Override
     public int hashCode() {
          int result;
          long temp;
          result = coneId != null ? coneId.hashCode() : 0;
          result = 31 * result + (center != null ? center.hashCode() : 0);
          temp = Double.doubleToLongBits(radius);
          result = 31 * result + (int) (temp ^ (temp >>> 32));
          temp = Double.doubleToLongBits(height);
          result = 31 * result + (int) (temp ^ (temp >>> 32));
          return result;
     }

     @Override
     public String toString() {
          final StringBuilder sb = new StringBuilder("Cone{");
          sb.append("coneId=").append(coneId);
          sb.append(", center=").append(center);
          sb.append(", radius=").append(radius);
          sb.append(", height=").append(height);
          sb.append('}');
          return sb.toString();
     }
}
