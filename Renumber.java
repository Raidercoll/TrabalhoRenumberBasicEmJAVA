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
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\"+narq; 
        Path path2 = Paths.get(nameComplete); 

        try (Scanner sc = new Scanner(Files.newBufferedReader(path2, Charset.defaultCharset()))){
            int aux = 10;
            while(sc.hasNextLine()) { 
                String line = sc.nextLine(); 
                line = Integer.toString(aux) + " " + line.substring(3,line.length());
                Writer output;
                String raux = narq.substring(0,5);
                String novoNomePath = currDir+"\\ArquivosApósRenumber\\"+raux+"-rn.bas";
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
