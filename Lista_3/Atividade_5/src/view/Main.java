package view;


import br.fatec.ListObject.ListObject;
import controller.ModificacaoCadastroController;
import model.Client;

public class Main
{
    public static void main(String[] args)
    {
        String pathDir = "/home/debby/Testes";
        String fileName = "Cadastro.csv";

        ModificacaoCadastroController cadCtrl = new ModificacaoCadastroController(pathDir, fileName);

        ListObject dados = genData();

        try {
//            cadCtrl.novoArquivo(dados, "AAAAH.csv");
            cadCtrl.novoCadastro(41, 60, 8000);
            cadCtrl.novoCadastro(31, 40, 5000);
            cadCtrl.novoCadastro(21, 30, 3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ListObject genData()
    {
        ListObject l = new ListObject();

        for (int i = 0; i < 5; i++)
        {
            Client c = new Client();
            c.cpf = "Cpf."+i;
            c.name = "Cliente " + i;
            c.age = i + 50;
            c.creditLimit = i * 1000;
            l.addFirst(c);
        }

        return l;
    }
}