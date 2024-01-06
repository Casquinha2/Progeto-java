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

    public List<Passageiros> ler_passageiros() throws FileNotFoundException {
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
            Type tipo = new TypeToken<List<Voos>>() {
            }.getType();
            listavoos = gson.fromJson(reader, tipo);
            reader.close();
            File file = new File("Voos.json");
            if (listavoos == null) {
                throw new FileNotFoundException();
            }
            return listavoos;
        } catch (FileNotFoundException e) {

            return Voos.criarListaDeVoosAleatorios();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void salvarAssentosDoVoo(List<Assento> assentos, String nomeArquivo) {
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter(nomeArquivo);
            String ficheiro = gson.toJson(assentos);
            writer.write(ficheiro);
            writer.close();
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

    public static void salvarAssentosJSON(List<Voos> listavoos,List<Assento>voo1,List<Assento>voo2,List<Assento>voo3,List<Assento>voo4) {
        List<List<Assento>> listaAssentos = TransformarListaAssentos(listavoos,voo1,voo2,voo3,voo4);
        Gson gson = new Gson();
        List<List<Assento>> todasListas = new ArrayList<>();

        for (List<Assento> lista : listaAssentos) {
            todasListas.add(lista);
        }

        try (FileWriter writer = new FileWriter("Assentos.json")) {
            String json = gson.toJson(todasListas);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<List<Assento>> TransformarListaAssentos(List<Voos> listavoos, List<Assento>voo1, List<Assento>voo2, List<Assento>voo3, List<Assento>voo4){
        List<List<Assento>> assentosPorVoo = new ArrayList<>();
        List<Assento> assentos = new ArrayList<>();
        for (int i = 0; i < listavoos.size(); i++) {


            switch (i) {
                case 0:
                    List<Assento> reservados1 = new ArrayList<>();
                    List<Assento> livres1;
                    reservados1 = Voos.Reserva(voo1);
                    voo1.removeAll(reservados1);
                    livres1 = new ArrayList<>(voo1);
                    assentos.addAll(reservados1);
                    assentos.addAll(livres1);
                    assentosPorVoo.add(assentos);
                    break;
                case 1:
                    List<Assento> reservados2 = new ArrayList<>();
                    List<Assento> livres2;
                    reservados2 = Voos.Reserva(voo2);
                    voo2.removeAll(reservados2);
                    livres2 = new ArrayList<>(voo2);
                    assentos.addAll(reservados2);
                    assentos.addAll(livres2);
                    assentosPorVoo.add(assentos);
                    break;
                case 2:
                    List<Assento> reservados3 = new ArrayList<>();
                    List<Assento> livres3;
                    reservados3 = Voos.Reserva(voo3);
                    voo3.removeAll(reservados3);
                    livres3 = new ArrayList<>(voo3);
                    assentos.addAll(reservados3);
                    assentos.addAll(livres3);
                    assentosPorVoo.add(assentos);
                    break;
                default:
                    List<Assento> reservados4 = new ArrayList<>();
                    List<Assento> livres4;
                    reservados4 = Voos.Reserva(voo4);
                    voo4.removeAll(reservados4);
                    livres4 = new ArrayList<>(voo4);
                    assentos.addAll(reservados4);
                    assentos.addAll(livres4);
                    assentosPorVoo.add(assentos);
                    break;
            }
        }
        return assentosPorVoo;
    }
}
