import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Renumber {
    public  void loadProgram(String narq) {
        /*
        Pega o nome do caminho aonde esta o arquivo java
        */
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\"+narq; 
        Path path2 = Paths.get(nameComplete); 

        /*
        Pega o nome do arquivo em basic passado por parametro e  
        modifica ele, em uma variavel auxiliar, para poder pegar o caminho 
        da pasta, para aonde os arquivos irão depois de passarem pelo renumber
        */
        String raux = narq.substring(0,5);
        String novoNomePath = currDir+"\\ArquivosApósRenumber\\"+raux+"-rn.bas";

        try{
            /*
            Apaga os arquivos existentes nos arquivos Prog1-rn e Prog2-rn
            para que o renumber ocorra sem problemas
            */
            Writer out = new FileWriter(novoNomePath);
            out.write("");
            out.flush();
            out.close();
        }catch(IOException x){
            System.err.format("Erro de E/S: %s%n", x);
        }

        try (Scanner sc = new Scanner(Files.newBufferedReader(path2, Charset.defaultCharset()))){
            int aux = 10;
            while(sc.hasNextLine()) { 
                /*
                Pega as linhas do arquivo e muda o numero da linha
                */
                String line = sc.nextLine(); 
                line = Integer.toString(aux) + " " + line.substring(3,line.length());

                /*
                Escreve no novo arquivo as linhas alteradas  
                */
                Writer output;
                output = new BufferedWriter(new FileWriter(novoNomePath, true));
                output.append(line + "\n");    
                output.close();
                
                aux +=10;
            }    
            System.out.println("Aplicado o Renumber com sucesso!!!");
        }catch (IOException x){
            System.err.format("Erro de E/S: %s%n", x);
        }
    }
}
