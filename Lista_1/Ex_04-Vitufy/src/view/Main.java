package view;

import br.fatec.ListObject.ListObject;
import controller.InterfacePlayerController;
import controller.PlayerController;

public class Main {

	public static void main(String[] args)
	{
		InterfacePlayerController mplayer = new PlayerController();
		ListObject playList= new ListObject();
		String[] musics = {
				"Abc;Beltrano;5",
				"Def;Cicrano;1:00",
				"Ghi;Fulano;4m",
				"Jkl;Gil;02:53",
				"Mno;AAAHH;60"
		};
		
		for (String music: musics)
		{
			try 
			{
				mplayer.addMusic(playList, music);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		try 
		{
			mplayer.removeMusic(playList, 4);
			mplayer.executePlayList(playList);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
