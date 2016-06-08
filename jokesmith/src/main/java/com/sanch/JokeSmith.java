package com.sanch;

import java.lang.String;
import java.util.Random;

public class JokeSmith{
        public String tellAJoke() {

            Random random = new Random();
            String joke;
            switch (random.nextInt(4)) {
                case 0:
                    joke = "\"I was born in California.\" \n" +
                            "\"Which part?\" \n" +
                            "\"All of me.\"";
                    break;
                case 1:
                    joke = "Why do we park our car in the driveway and drive our car on the parkway? ";
                    break;
                case 2:
                    joke = "Father: What did you do today to help your mother? \n" +
                            "Son: I dried the dishes \n" +
                            "Daughter: And I helped pick up the pieces. ";
                    break;
                default:
                    joke = "A person who speaks two languages is bilingual...A person who speaks three languages is trilingual...A person who speaks four or more languages is multilingual. \n" +
                            "What is a person who speaks one language? \n" +
                            "An American";
                    break;
            }
            return joke;
        }
    }

