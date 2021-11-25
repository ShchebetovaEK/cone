package by.tms.figure.observer;

public interface Observable{

     void attach(Observer observer);
     void detach(Observer observer);
     void notifyObserver();
}
