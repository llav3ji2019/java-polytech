package lab2;

public class Methods {
    @MethodAnnotation(count = 2)
    public void printPublicMethodInfo() {
        System.out.println("Everyone can easily call me. Also I haven't got any parameter\n");
    }

    @MethodAnnotation(count = 2)
    public void printPublicMethodWithParameterInfo(String name, int age) {
        System.out.println("Everyone can easily call me. Also I have some parameters. For example: Name = " + name + " and may be his age = " + age + "\n");
    }

    @MethodAnnotation(count = 3)
    private void printPrivateMethodInfo() {
        System.out.println("Only my developer should know about me, because i am his secret. But if you call me, you know that I haven't got any parameter\n");
    }

    @MethodAnnotation(count = 3)
    private void printPrivateMethodWithParameterInfo(String name, int age) {
        System.out.println("Only my developer should know about me, because i am his secret. But if you call me, you know that I have some parameters. I shouldn't share it with you, but it is name = " + name + " age = " + age + "\n");
    }

    @MethodAnnotation(count = 4)
    protected void printProtectedMethodInfo() {
        System.out.println("Only my children and developer should know about me, because i am his secret. But if you call me, you know that I haven't got any parameter\n");
    }

    @MethodAnnotation(count = 4)
    protected void printProtectedMethodWithParameterInfo(String name, int age) {
        System.out.println("Only my children and developer should know about me, because i am our secret. But if you call me, you know that I have some parameters. it is name = " + name + " age = " + age + "\n");
    }
}
