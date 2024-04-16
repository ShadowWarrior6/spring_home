/*
* Домашнее задание
Условие:
Создать проект с использованием Maven или Gradle, добавить в него несколько зависимостей и написать
* код, использующий эти зависимости.
Пример решения:
1. Создайте новый Maven или Gradle проект, через Intellj IDEA.
2. Добавьте зависимости org.apache.commons:commons-lang3:3.14.0 и com.google.code.gson:gson:2.10.1.
3. Создайте класс Person с полями firstName, lastName и age.
4. Используйте библиотеку commons-lang3 для генерации методов toString, equals и hashCode.
5. Используйте библиотеку gson для сериализации и десериализации объектов класса Person в формат JSON.*/

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.google.gson.Gson;


public class Person {
     String FirstName;
  String LastName;
     int age;

    public Person(String firstName, String lastName, int age) {
        FirstName = firstName;
        LastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;

    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Person person)) return false;
        if (!super.equals(object)) return false;
        return getAge() == person.getAge() && Objects.equals(getFirstName(), person.getFirstName()) && Objects.equals(getLastName(), person.getLastName());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getFirstName(), getLastName(), getAge());

    }

    public static void main(String[] args) {
    Person person=new Person();
    person.setFirstName("Alex");
    person.setLastName("Smith");
    person.setAge(45);

        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println("JSON representation: " + json);

        Person deserializedPerson = gson.fromJson(json, Person.class);
        System.out.println("Deserialized Person: " + deserializedPerson);
    }
}
