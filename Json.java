import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;

// A classe Json é responsável por salvar e carregar dados em formato JSON.
public class Json {

    // Método para salvar dados de passageiros em um arquivo JSON.
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

    // Método para ler dados de passageiros de um arquivo JSON.
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

    // Método para salvar dados de voos em um arquivo JSON.
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

    // Método para ler dados de voos de um arquivo JSON.
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

    // Método para salvar assentos de um voo em um arquivo JSON.
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

    // Classe interna para adaptar o formato LocalDateTime para JSON.
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

    // Método para carregar dados de assentos de um arquivo JSON.
    public List<List<String>> carregarAssentosDoArquivo(List<Assento> voo1, List<Assento> voo2, List<Assento> voo3, List<Assento> voo4) {
        Gson gson = new Gson();
        List<List<String>> dadosAssentos = new ArrayList<>();

        try {
            File file = new File("Assentos.json");

            if (file.exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                Type type = new TypeToken<List<List<String>>>(){}.getType();
                dadosAssentos = gson.fromJson(bufferedReader, type);
                bufferedReader.close();
            } else {
                dadosAssentos = salvarAssentosJSON(voo1, voo2, voo3, voo4);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dadosAssentos;
    }

    // Método para salvar dados de assentos em um arquivo JSON
    public void salvarAssentosAtualizados(List<List<String>> dadosAssentos) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("Assentos.json")) {
            gson.toJson(dadosAssentos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para salvar dados de assentos em um arquivo JSON.
    public static List<List<String>> salvarAssentosJSON(List<Assento> voo1, List<Assento> voo2, List<Assento> voo3, List<Assento> voo4) {
        List<List<String>> listaAssentos = TransformarListaAssentos(voo1, voo2, voo3, voo4);
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("Assentos.json")) {
            String json = gson.toJson(listaAssentos);
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaAssentos;
    }

    // Método para transformar lista de assentos em formato apropriado para JSON.
    public static List<List<String>> TransformarListaAssentos(List<Assento> voo1, List<Assento> voo2, List<Assento> voo3, List<Assento> voo4) {
        List<List<String>> assentosPorVoo = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            List<String> reservados;
            List<String> livres = new ArrayList<>();
            if (i == 1) {
                reservados = Voos.Reserva(voo1);
                for (Assento k : voo1) {
                    livres.add(k.getNumero());
                }
            } else if (i == 2) {
                reservados = Voos.Reserva(voo2);
                for (Assento k : voo2) {
                    livres.add(k.getNumero());
                }
            } else if (i == 3) {
                reservados = Voos.Reserva(voo3);
                for (Assento k : voo3) {
                    livres.add(k.getNumero());
                }
            } else {
                reservados = Voos.Reserva(voo4);
                for (Assento k : voo4) {
                    livres.add(k.getNumero());
                }
            }
            livres.removeAll(reservados);
            assentosPorVoo.add(reservados);
            assentosPorVoo.add(livres);
        }
        return assentosPorVoo;
    }
}

