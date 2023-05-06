package model;

public class Client
{
    public String cpf;
    public String name;
    public int age;
    public double creditLimit;

    @Override
    public String toString()
    {
        return cpf + ";" +
                name + ";" +
                age + ";" +
                creditLimit;
    }
}
