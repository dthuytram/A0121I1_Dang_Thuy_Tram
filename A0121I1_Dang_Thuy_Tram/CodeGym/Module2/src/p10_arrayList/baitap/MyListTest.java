package p10_arrayList.baitap;

public class MyListTest {
    public static class Person {
        private int id;
        private String name;

        public Person() {
        }

        public Person(int id, String name) {
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

    public static void main(String[] args) {
        Person a = new Person(1, "Huy");
        Person b = new Person(2, "Tram");
        Person c = new Person(3, "Loi");
        Person d = new Person(4, "Hanh");
        Person e = new Person(5, "Hai");
        Person f = new Person(6, "Hug");

        MyList<Person> person = new MyList<>();
        person.add(a);
        person.add(b);
        person.add(c);
        person.add(d);
        person.add(e);
        person.add(f);
        Person stu = null;
        for (int i = 0; i < person.size(); i++) {
            stu = (Person) person.get(i);
            System.out.println(stu.getId());
            System.out.println(stu.getName());
        }

    }
}
