package controller;

import br.fatec.ListObject.ListObject;
import entity.Music;

public class PlayerController implements InterfacePlayerController
{
    public PlayerController()
    {
        super();
    }

	@Override
	public void addMusic(ListObject list, String strMusic) throws Exception
	{
		String[] musicInfos = strMusic.split(";");
		Music newMusic = new Music();
		newMusic.name = musicInfos[0];
		newMusic.artistName = musicInfos[1];
		newMusic.duration = getDuration(musicInfos[2]);
		
		if (list.isEmpty())
			list.addFirst(newMusic);
		else
		{
			list.addLast(newMusic);
		}
	}

	private int getDuration(String strDuration)
	{
		int result = 0;
		int lenStrDuration = strDuration.length();
		int minute;
		int seconds;
		
		if (lenStrDuration <= 0 || lenStrDuration > 5)
			return 0;
		
		if (strDuration.contains(":"))
		{
			String[] strMinute = strDuration.split(":");
			minute = Integer.parseInt(strMinute[0]) * 60;
			seconds = Integer.parseInt(strMinute[1]);
			result = minute + seconds;
		}
		else if (strDuration.contains("m"))
			result = Integer.parseInt(strDuration.replace("m", "")) * 60;
		else
			result = Integer.parseInt(strDuration);
		
		return result;
	}

	@Override
	public void removeMusic(ListObject list, int index) throws Exception
	{
		if (list.isEmpty())
			throw new Exception("Empty PlayList!");
		list.remove(index);
	}

	@Override
	public void executePlayList(ListObject list) throws Exception
	{
		ListObject playList = list;
		if (playList.isEmpty())
			throw new Exception("Empty PlayList!");
		
		
		while (!playList.isEmpty())
		{
			Music music = (Music) playList.get(0);
			System.out.printf("[%s - %s - %ds]\n",
					music.name, music.artistName, music.duration);
			playList.removeFirst();
			Thread.sleep(music.duration * 1000);
		}
	}


}
