package lab3;

//Ёж обыкновенный
public class CommonHedgehog extends Hedgehogs {
    public CommonHedgehog(String name, int age) {
        super(name, age);
    }

    @Override
    public void voice() {
        System.out.println("I am CommonHedgehog");
    }
}
