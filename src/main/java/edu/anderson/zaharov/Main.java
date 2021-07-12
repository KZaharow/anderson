package edu.anderson.zaharov;

public class Main {

    public static void main(String[] args) throws NullPointerException {

        try {
            throw new NullPointerException();
        } catch (Error e){
        }
    }
}
