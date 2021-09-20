//package com.SpringPlayground_2;
//
//
//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.*;
//import java.time.format.DateTimeFormatter;
//import java.time.LocalDateTime;
//
//@RestController
//@RequestMapping("/json")
//public class JSONRseponseController {
//
//
//
//       @GetMapping("/person")
//        public Person getPerson() {
//            Person person = new Person();
//            person.firstName = "Dwayne";
//            person.lastName = "Johnson";
//            person.setPassengerID(6);
//            return person;
//        }
//
//        public static class Person {
//            private String firstName;
//            private String lastName;
//            private int passengerID;
//
//            public String getFirstName() {
//                return firstName;
//            }
//
//            public int getPassengerID(){
//                return passengerID;
//            }
//
//            public void setPassengerID(int passengerID) {
//                this.passengerID = passengerID;
//            }
//
//            public void setFirstName(String firstName) {
//                this.firstName = firstName;
//            }
//
//            public String getLastName() {
//                return lastName;
//            }
//
//            public void setLastName(String lastName) {
//                this.lastName = lastName;
//            }
//        }
//
//        @GetMapping("/people")
//        public List<Person> getPeople(){
//           Person person1 = new Person();
//           person1.setFirstName("Edward");
//           person1.setLastName("Carter");
//           person1.setPassengerID(1);
//
//           Person person2 = new Person();
//           person2.setFirstName("Kelesego");
//           person2.setLastName("Carter");
//           person2.setPassengerID(2);
//
//           Person person3 = new Person();
//           person3.setFirstName("Kenako");
//           person3.setLastName("Carter");
//           person3.setPassengerID(3);
//
//           return Arrays.asList(person1,person2,person3);
//        }
//
//        class SuitCase{
//           private final int width;
//           private final int height;
//           private final int depth;
//           private final int weight;
//
//           @JsonCreator
//            SuitCase(
//                    @JsonProperty("width") int width,
//                    @JsonProperty("height") int height,
//                    @JsonProperty("depth") int depth,
//                    @JsonProperty("weight") int weight
//           ){
//               this.width = width;
//               this.height = height;
//               this.depth = depth;
//               this.weight = weight;
//           }
//
//            public int getWidth() {
//                return width;
//            }
//
//            public int getHeight() {
//                return height;
//            }
//
//            public int getDepth() {
//                return depth;
//            }
//
//            public int getWeight() {
//                return weight;
//            }
//        }
//
//        @GetMapping("/suitcase")
//        public SuitCase getSuitcase(){
//           SuitCase a = new SuitCase(12,18,8, 35);
//
//           return a;
//        }
//
//
//
//
//}
