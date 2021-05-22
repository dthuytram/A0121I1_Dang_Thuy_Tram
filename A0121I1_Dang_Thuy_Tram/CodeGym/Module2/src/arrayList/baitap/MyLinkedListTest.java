package arrayList.baitap;

public class MyLinkedListTest {
    public static void main(String[] args) {
        class Student {
            private int id;
            private String name;

            public Student() {
            }

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
        MyLinkedList<Student> myLinkedList = new MyLinkedList<>();
        MyLinkedList<Student> myLinkedList1 = new MyLinkedList<>();
        Student student = new Student(1, "Trung");
        Student student1 = new Student(2, "Ha");
        Student student2 = new Student(3, "Nga");
        Student student3 = new Student(4, "Hanh");
        Student student4 = new Student(5, "HA");
        Student student5 = new Student(6, "AHi");

        myLinkedList.add(2,student1);
        myLinkedList.addFirst(student2);
        myLinkedList.addFirst(student3);
        myLinkedList.addLast(student4);
        myLinkedList.add(5,student5);
        myLinkedList.addFirst(student);


        myLinkedList1.add(2,student1);
        myLinkedList1.addFirst(student2);
        myLinkedList1.addFirst(student3);
        myLinkedList1.addLast(student4);
        myLinkedList1.add(5,student5);
        myLinkedList1.addFirst(student);

        System.out.println("num:" + myLinkedList1.getNumNodes());
        for (int i = 0; i < myLinkedList.getNumNodes(); i++) {
            Student p = (Student) myLinkedList1.get(i);
            System.out.println(" name:" + p.name);
        }

        System.out.println("==================");
        System.out.println("num:" + myLinkedList.getNumNodes());
        for (int i = 0; i < myLinkedList.getNumNodes(); i++) {
            Student p1 = (Student) myLinkedList.get(i);
            System.out.println(" name:" + p1.name);
        }

        System.out.println("\nCOMPARE 2 LIST");
        System.out.println(myLinkedList1.compareList(myLinkedList));

//        System.out.println(myLinkedList.getFirst() + " " + myLinkedList.getLast());
//        System.out.println("Contain: " + myLinkedList.contains(student));
//        System.out.println("Index: " + myLinkedList.indexOf(student1));
    }
}
