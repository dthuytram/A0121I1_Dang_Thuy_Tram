package p7_abstract_interface.Thuchanh;

import p7_abstract_interface.Thuchanh.animal.Animal;
import p7_abstract_interface.Thuchanh.animal.Chicken;
import p7_abstract_interface.Thuchanh.animal.Tiger;
import p7_abstract_interface.Thuchanh.edible.Edible;
import p7_abstract_interface.Thuchanh.fruit.Apple;
import p7_abstract_interface.Thuchanh.fruit.Fruit;
import p7_abstract_interface.Thuchanh.fruit.Orange;

public class test {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();
        for (Animal animal : animals) {
            System.out.println(animal.makeSound());

            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                System.out.println(edibler.howtoEat());
            }
        }
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            System.out.println(fruit.howtoEat());
        }

    }
}
