import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;


public class Json {


    public void salvar_passageiros(List<Passageiros> passageiros) throws IOException {
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter("Passageiros.json");
            String ficheiro = gson.toJson(passageiros);
            writer.write(ficheiro);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ;

    public Object ler_passageiros() throws FileNotFoundException {
        try {
            Gson gson = new Gson();
            List<Passageiros> listapessoas = new ArrayList<>();
            FileReader reader = new FileReader("Passageiros.json");
            Type tipo = new TypeToken<List<Passageiros>>() {
            }.getType();
            listapessoas = gson.fromJson(reader, tipo);
            reader.close();
            File file = new File("Passageiros.json");
            return listapessoas;

        } catch (FileNotFoundException e) {
            List<Passageiros> listapessoas = new ArrayList<>();

            return listapessoas;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void salvar_voos(List<Voos> voos) throws IOException {
        try {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                    .create();

            FileWriter writer = new FileWriter("Voos.json");
            String ficheiro = gson.toJson(voos);
            writer.write(ficheiro);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Object ler_voos() throws FileNotFoundException {
        try {
            List<Voos> listavoos = new ArrayList<>();
            FileReader reader = new FileReader("Voos.json");
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                    .create();
            Type tipo = new TypeToken<List<Voos>>(){}.getType();
            listavoos = gson.fromJson(reader, tipo);
            reader.close();
            File file = new File("Voos.json");
            if(listavoos== null){
                throw new FileNotFoundException();
            }
            return listavoos;
        } catch (FileNotFoundException e) {

            return Voos.criarListaDeVoosAleatorios();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {

        @Override
        public void write(JsonWriter jsonWriter, LocalDateTime localDateTime) throws IOException {
            jsonWriter.value(localDateTime.toString());
        }

        @Override
        public LocalDateTime read(JsonReader jsonReader) throws IOException {
            return LocalDateTime.parse(jsonReader.nextString());
        }
    }

}
