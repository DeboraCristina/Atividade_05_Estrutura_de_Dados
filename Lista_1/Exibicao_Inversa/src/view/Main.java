package view;

import br.fatec.ListInt.ListInt;
import controller.InverseController;

public class Main {

	public static void main(String[] args)
	{
		ListInt list = new ListInt();
		
		list.addFirst(16);
		list.addFirst(4);
		list.addFirst(13);
		list.addFirst(2);
		list.addFirst(6);
		list.addFirst(7);
		list.addFirst(9);
		list.addFirst(12);
		list.addFirst(18);
		list.addFirst(5);
		list.addFirst(3);

		InverseController inverse = new InverseController();
		
		try {
			inverse.showInverse(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
