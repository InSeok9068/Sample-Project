package playground.clone;

public class ClonePlayground {
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneClass cloneClass1 = CloneClass.builder()
                .val("값1")
                .build();

        CloneClass cloneClass2 = cloneClass1.clone();
        cloneClass2.setVal("값2");

        System.out.println(cloneClass1);
        System.out.println(cloneClass2);
    }
}
