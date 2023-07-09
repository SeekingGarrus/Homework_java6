// 1.Создайте множество, в котором будут храниться экземпляры класса Cat - HashSet<Cat>. Поместите в него некоторое количество объектов.

// 2.Создайте 2 или более котов с одинаковыми параметрами в полях. Поместите их во множество. Убедитесь, что все они сохранились во множество.

// 3.Создайте метод public boolean equals(Object o)

// Пропишите в нём логику сравнения котов по параметрам, хранимым в полях. То есть, метод должен возвращать true, только если значения во всех полях сравниваемых объектов равны.

// 4.Создайте метод public int hashCode, который будет возвращать hash, вычисленный на основе полей класса Cat. (Можно использовать Objects.hash(...))

// 5.Выведите снова содержимое множества из пункта 2, убедитесь, что дубликаты удалились.

import java.util.*;

public class Task1 {
    class Cat {
        private String name;
        private int age;

        public Cat(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Cat cat = (Cat) o;
            return age == cat.age && Objects.equals(name, cat.name);
        }

        public int hashCode() {
            return Objects.hash(name, age);
        }
    }

    public class Main {
        public static void Main(String[] args) {
            Set<Cat> cats = new HashSet<>(); // Создание и добавление котов в множество
            Cat cat1 = new Cat("Tom", 3);
            Cat cat2 = new Cat("Garfield", 4);
            Cat cat3 = new Cat("Tom", 3); // Кот с такими же параметрами, как и cat1
            cats.add(cat1);
            cats.add(cat2);
            cats.add(cat3); // Вывод содержимого множества
            System.out.println("Исходное множество:");

            for (Cat cat : cats) {
                System.out.println(cat.getName() + " - " + cat.getAge());
            } // Проверка удаления дубликатов
            System.out.println("\nУдаление дубликатов:");
            cats.remove(cat1);
            cats.remove(cat2);
            cats.remove(cat3);
            for (Cat cat : cats) {
                System.out.println(cat.getName() + " - " + cat.getAge());
            }
        }
    }

}