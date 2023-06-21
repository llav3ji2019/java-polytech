package lab3;

//манул
public class Manul extends Feline {
    public Manul(String name, int age) {
        super(name, age);
    }

    @Override
    public void voice() {
        System.out.println("I am Manul");
    }
}
