package controller;

import br.fatec.ListObject.ListObject;

public interface InterfacePlayerController
{
    public void addMusic(ListObject list, String music) throws Exception;
    public void removeMusic(ListObject list, int index) throws Exception;
    public void executePlayList(ListObject list) throws Exception;
}
