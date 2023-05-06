package controller;

import br.fatec.ListObject.ListObject;
import model.Client;

import java.io.*;

public class ModificacaoCadastroController
{
    private final String defaultPath;
    private final String defaultFilePath;

    public ModificacaoCadastroController(String defaultPath, String defaultFile)
    {
        this.defaultPath = defaultPath;
        this.defaultFilePath = defaultPath+"/"+defaultFile;
    }

    private File openFile(String filePath) throws Exception
    {
        File openFile = new File(filePath);
        if (!openFile.isFile() && !openFile.exists())
            throw new Exception("Invalid File");
        return openFile;
    }
    public void novoArquivo (ListObject data, String fileName) throws Exception
    {
        File dir = new File(defaultPath);
        if (dir.isDirectory() && dir.exists())
        {
            File file = new File(defaultPath, fileName);
            FileWriter openFile2Write = new FileWriter(file);
            PrintWriter writeFile = new PrintWriter(openFile2Write);

            String content;
            Client client;

            int size = data.size();
            while (size > 0)
            {
                client = (Client) data.get(size-1);
                content = client.toString()+"\n";
                writeFile.write(content);
                size--;
            }

            writeFile.flush();
            openFile2Write.close();
            writeFile.close();
        }
        else
            throw new Exception("ERROR");
    }

    public void novoCadastro(int idadeMin, int idadeMax, double limiteCredito) throws Exception {
        File file = openFile(defaultFilePath);
        FileReader readFile = new FileReader(file);
        BufferedReader buffer = new BufferedReader(readFile);
        String line;
        String[] lineContent;

        ListObject clientData = new ListObject();
        int age = 0;
        double limit = 0;
        String fileName, strLimit;

        line = buffer.readLine();
        while (line != null)
        {
            lineContent = line.split(";");
            age = getAge(lineContent[2]);
            limit = getLimit(lineContent[3]);
            if ((age >= idadeMin && age <= idadeMax) && (limit > limiteCredito))
            {
                Client client = new Client();
                client.cpf = lineContent[0];
                client.name = lineContent[1];
                client.age = age;
                client.creditLimit = limit;
                clientData.addFirst(client);
            }
            line = buffer.readLine();
        }

        if (!clientData.isEmpty())
        {
            strLimit = Double.toString(limiteCredito).replace(".", ",");
            fileName = "Idade:" + idadeMin + "-" + idadeMax + "__Limite:" + strLimit + ".csv";
            novoArquivo(clientData, fileName);
        }
    }

    private double getLimit(String limit) throws Exception {
        double validLimit = -1;

        try
        {
            if (limit.contains(","))
                limit = limit.replace(",", ".");
            validLimit = Double.parseDouble(limit);
        }
        catch (Exception e)
        {
            throw new Exception("Invalid limit: " + limit);
        }

        return validLimit;
    }
    private int getAge(String age) throws Exception
    {
        int validAge = -1;

        try
        {
            validAge = Integer.parseInt(age);
        }
        catch (Exception e)
        {
            throw new Exception("Invalid age: " + age);
        }

        return validAge;
    }
}
