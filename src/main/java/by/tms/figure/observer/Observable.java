package by.tms.figure.observer;

public interface Observable{

     void attach(ConeObserver observer);
     void detach(ConeObserver observer);
     void notifyObservers();
}
