package lab3;

//Рысь
public class Lynx extends Feline {
    public Lynx(String name, int age) {
        super(name, age);
    }

    @Override
    public void voice() {
        System.out.println("I am Lynx");
    }
}
