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

    public static List<String> salvarAssentosJSON(List<Assento>voo1, List<Assento>voo2, List<Assento>voo3, List<Assento>voo4) {
        List<String> listaAssentos = TransformarListaAssentos(voo1,voo2,voo3,voo4);
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("Assentos.json")) {
            String json = gson.toJson(listaAssentos);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaAssentos;
    }
    public static List<String> TransformarListaAssentos( List<Assento>voo1, List<Assento>voo2, List<Assento>voo3, List<Assento>voo4){
        String l;
        List<String> assentosPorVoo = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {


            if (i==1) {
                List<String> reservados1;
                List<String> livres1 = new ArrayList<>();
                reservados1 = Voos.Reserva(voo1);

                for (Assento k:voo1){
                    l = k.getNumero();
                    livres1.add(l);
                }
                livres1.removeAll(reservados1);
                assentosPorVoo.add(String.valueOf(reservados1));
                assentosPorVoo.add(String.valueOf(livres1));
            }else if (i==2) {
                List<String> reservados2;
                List<String> livres2 = new ArrayList<>();
                reservados2 = Voos.Reserva(voo2);
                for (Assento k:voo2){
                    l = k.getNumero();
                    livres2.add(l);
                }
                livres2.removeAll(reservados2);
                assentosPorVoo.add(String.valueOf(reservados2));
                assentosPorVoo.add(String.valueOf(livres2));
            }else if (i==3) {
                List<String> reservados3;
                List<String> livres3 = new ArrayList<>();
                reservados3 = Voos.Reserva(voo3);
                for (Assento k:voo3){
                    l = k.getNumero();
                    livres3.add(l);
                }
                livres3.removeAll(reservados3);
                assentosPorVoo.add(String.valueOf(reservados3));
                assentosPorVoo.add(String.valueOf(livres3));
            }else {
                    List<String> reservados4;
                    List<String> livres4 = new ArrayList<>();
                    reservados4 = Voos.Reserva(voo4);
                    for (Assento k:voo4){
                        l = k.getNumero();
                        livres4.add(l);
                    }
                    livres4.removeAll(reservados4);
                    assentosPorVoo.add(String.valueOf(reservados4));
                    assentosPorVoo.add(String.valueOf(livres4));
            }
        }
        return assentosPorVoo;
    }
}
