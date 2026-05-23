//Lambda Expression works only with functional interface(only 1 abstract method)

interface Multiply {
    int mul(int a, int b);
}

class Lambda {
    public static void main(String[] args) {
        Multiply m = (a,b)-> a*b;
        System.out.println(m.mul(2, 3));
    }
}
