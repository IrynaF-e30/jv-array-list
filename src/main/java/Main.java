public class Main {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println(list.get(1)); // B
        list.remove("B");
        System.out.println(list.size()); // 2
        list.set(1, "Z");
        System.out.println(list.get(1)); // Z
    }
}
