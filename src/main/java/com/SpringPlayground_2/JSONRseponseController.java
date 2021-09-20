package com.SpringPlayground_2;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/json")
public class JSONRseponseController {

       @GetMapping("/person")
        public Person getPerson() {
            Person person = new Person();
            person.firstName = "Dwayne";
            person.lastName = "Johnson";
            return person;
        }

        public static class Person {
            private String firstName;
            private String lastName;

            public String getFirstName() {
                return firstName;
            }

            public void setFirstName(String firstName) {
                this.firstName = firstName;
            }

            public String getLastName() {
                return lastName;
            }

            public void setLastName(String lastName) {
                this.lastName = lastName;
            }
        }

        @GetMapping("/people")
        public List<Person> getPeople(){
           Person person1 = new Person();
           person1.setFirstName("Edward");
           person1.setLastName("Carter");

           Person person2 = new Person();
           person2.setFirstName("Kelesego");
           person2.setLastName("Carter");

           Person person3 = new Person();
           person3.setFirstName("Kenako");
           person3.setLastName("Carter");

           return Arrays.asList(person1,person2,person3);
        }

}
