/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author Aluno
 */
public class NameGenerator {

    public String name = "a";
    public int lines = 0;

    public NameGenerator() {
    }

    public NameGenerator(String seed) {
        this.name = seed;
        this.lines = seed.length();
    }

    public String next() {
        int pos = lines - 1;
        String a = name.substring(0, lines - 1);
        String b = name.substring(lines - 1, name.length());

        if (b.equals("z")) {
            name = a + "aa";
            lines++;
        }

        switch (b) {
            case "a":
                b = "b";
                break;
            case "b":
                b = "c";
                break;
        }

        return name;
    }

    public String getName() {
        return this.name;
    }

}
