package domain;

abstract public class OrderProcessorTemplate {
    final void process() {
        initialize();
        pay();
        finish();
    }

    void initialize() {System.out.println("Initializing order");}
    abstract void pay();
    void finish() {System.out.println("Ordered successfully");}
}
