import br.fatec.ListInt.ListInt;
import controller.Atividade04;

public class Main
{
    public static void main(String[] args)
    {
        Atividade04 ex4 = new Atividade04();
        ListInt list = new ListInt();
        String[] vetor = "18 - 42 - 39 - 19 - 49 - 25 - 15 - 33 - 10 - 30".split(" - ");

        for (String v : vetor)
        {
            int e = Integer.parseInt(v);
            list.addFirst(e);
            System.out.printf("%d - ", e);
        }
        System.out.println();

        try {
            int maior = ex4.get_maior(list);
            System.out.printf("1o Maior = %d\n\r", maior);

            int maior2 = ex4.get_nMaior(list, 2);
            System.out.printf("2o Maior = %d\n\r", maior2);

            int maior3 = ex4.get_nMaior(list, 3);
            System.out.printf("3o Maior = %d\n\r", maior3);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}