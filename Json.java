import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;


public class Json {
    Gson gson = new Gson();
    public void salvar(List<Passageiros> passageiros) throws IOException {
        try(FileWriter writer = new FileWriter("Passageiros.json")){
            String ficheiro = gson.toJson(passageiros);
            writer.write(ficheiro);
            writer.close();
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    };
    public Object ler() throws FileNotFoundException {
        try {
            List<Passageiros> listapessoas = new ArrayList<>();
            FileReader reader = new FileReader("Passageiros.json");
            Type tipo = new TypeToken<List<Passageiros>>(){}.getType();
            listapessoas = gson.fromJson(reader, tipo);
            reader.close();
            File file = new File("Passageiros.json");
            file.delete();
            wait(5000);
            return listapessoas;

        } catch (FileNotFoundException e) {
            List<Passageiros> listapessoas = new ArrayList<>();

            return listapessoas;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
