package final_exam.Commons;


import java.io.*;

public class ReadWriteFile {
    private String path;
    private BufferedWriter reader;

    public String readFile(String path)  {
        String rs = "";
        FileReader fileReader;
        try {
//            fileReader = new FileReader(path);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = null;

        while ((line = reader.readLine()) != null) {
            rs += line;
            rs += "\n";
        }
    }catch (IOException e){
            e.printStackTrace();
        }
        return rs;
    }


    public void writeFile(String path,String data,Boolean append)  {
        try {
            BufferedWriter writer;
            if(append){
                writer = new BufferedWriter(new FileWriter(path,true));
            }
            else{
                writer = new BufferedWriter(new FileWriter(path,false));
            }
            writer.write(data);
            writer.newLine();
            writer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

}
