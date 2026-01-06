package models;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "\nPerson [name=" + name + ", age=" + age + "]";
    }

    @Override
    public int compareTo(Person otra) {
        int resulComparacion = Integer.compare(this.age, otra.getAge());
        if (resulComparacion != 0) {
            return resulComparacion;
        }
        // comparar otro parametro
        return this.name.compareTo(otra.getName()); 
    }
    
}
