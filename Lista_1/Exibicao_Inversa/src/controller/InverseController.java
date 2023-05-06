package controller;

import br.fatec.ListInt.ListInt;

public class InverseController
{
	public void showInverse(ListInt list) throws Exception
	{
		ListInt temp = list;
		
		while (!temp.isEmpty())
		{
			System.out.println(temp.get(temp.size()-1));
			temp.removeLast();
		}
	}
}
