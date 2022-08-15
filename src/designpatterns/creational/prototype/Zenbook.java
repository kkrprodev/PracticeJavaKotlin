package designpatterns.creational.prototype;

public class Zenbook implements Prototype {

    String processor;
    String RAM;

    public Zenbook(String processor) {
        this.processor = processor;
    }

    @Override
    public Prototype getClone() {
        return new Zenbook(this.processor);
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
