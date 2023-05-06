package control;

import br.fatec.ListInt.*;

public class Ex01
{
    public void methodA()
    {
        InterfaceListInt list = new ListInt();

        for (int i = 0; i < 10; i++)
        {
            if (i % 2 == 0)
                list.addFirst(i * i);
            if (i <= 6)
                list.addFirst(i);
            else
            {
                try
                {
                    int element = list.get(list.size() - 1);
                    System.out.println(element + " removed");
                    list.removeLast();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Final Size: " + list.size());
    }

    public void methodB()
    {
        ListInt list= new ListInt();

        for (int i = 100; i < 115; i++)
        {
            if (list.isEmpty())
                list.addFirst(i + 100);
            if (list.size() <= 4)
            {
                try {
                    list.addLast(i + 50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else
            {
                try
                {
                    int element = list.get(0);
                    System.out.println(element + " removed");
                    list.removeFirst();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Final Size: " + list.size());
    }
}
