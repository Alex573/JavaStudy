package patterns;

import java.io.File;

public class NoObjectNull {
    public static void main(String[] args) {
        Animal animal = getAnimal();
        animal.eat();
    }

    private static Animal getAnimal() {
        try {
            if (new File("nosouchfile.exe").exists()) {
                return new Lion();
            }
        } finally {
            // return null;
            return new NoLion();

        }
    }
}

interface Animal {
    void eat();
}

class Lion implements Animal {
    @Override
    public void eat() {
        System.out.println("eat");
    }
}

class NoLion implements Animal {

    @Override
    public void eat() {

    }
}