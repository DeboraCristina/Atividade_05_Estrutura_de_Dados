package controller;

import br.fatec.ListInt.ListInt;

public class Atividade04
{
    public int get_maior (ListInt list) throws Exception
    {
        int maior = 0;
        int no, size;

        size = list.size();
        while (size > 0)
        {
            no = list.get(size - 1);

            if (no > maior)
                maior = no;
            size--;
        }
        return maior;
    }

    public int get_nMaior (ListInt list, int n) throws Exception
    {
        int nMaior = 0;
        int no, size, index;
        ListInt cpyList = cpyList(list);

        for (int i = 0; i < n; i++)
        {
            nMaior = 0;
            size = cpyList.size();
            index = 0;
            while (size > 0)
            {
                no = cpyList.get(size - 1);

                if (no > nMaior)
                {
                    nMaior = no;
                    index = size - 1;
                }
                size--;
            }
            cpyList.remove(index);
        }
        return nMaior;
    }

    private ListInt cpyList(ListInt srcList) throws Exception
    {
        ListInt newList = new ListInt();
        int size = srcList.size();

        while (size > 0)
        {
            newList.addFirst(srcList.get(size-1));
            size--;
        }
        return newList;
    }
}
