package dp.creational.prototype;

/**
 * Creating new object is time-consuming, and/or complicated, and/or resource intensive operation.
 * Without knowing its type, we can create an object.
 */
public class Laptop implements Prototype {

    String processor;
    String RAM;

    public Laptop(String processor) {
        this.processor = processor;
    }

    @Override
    public Prototype getClone() {
        Laptop clone = new Laptop(this.processor);
        clone.setRAM(this.RAM);
        return clone;
    }

    @Override
    public String toString() {
        return "Laptop with processor %s and RAM %s".formatted(this.processor, this.RAM);
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }
}
