package lab3;

//Хордовые
public abstract class Chordal {
    protected String name;
    protected int age;

    public Chordal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public abstract void voice();
}
