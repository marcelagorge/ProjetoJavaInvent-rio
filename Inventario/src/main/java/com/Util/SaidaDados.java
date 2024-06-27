    package com.Util;

    import com.Modelos.Categoria;
    import com.Modelos.Comodo;
    import com.Modelos.Item;
    import com.google.gson.Gson;
    import com.google.gson.GsonBuilder;

    import java.io.FileWriter;
    import java.io.IOException;
    import java.io.Writer;
    import java.util.List;

    public class SaidaDados {

        private static final String ARQUIVO_CATEGORIAS = "src/main/resources/categorias.json";
        private static final String ARQUIVO_COMODOS = "src/main/resources/comodos.json";
        private static final String ARQUIVO_ITENS = "src/main/resources/itens.json";
        

        public void salvarCategorias(List<Categoria> categorias) throws IOException {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            try (Writer writer = new FileWriter(ARQUIVO_CATEGORIAS)) {
                gson.toJson(categorias, writer);
            }
        }

        public void salvarComodos(List<Comodo> comodos) throws IOException {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            try (Writer writer = new FileWriter(ARQUIVO_COMODOS)) {
                gson.toJson(comodos, writer);
            }
        }

        public void salvarItens(List<Item> itens) throws IOException {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            try (Writer writer = new FileWriter(ARQUIVO_ITENS)) {
                gson.toJson(itens, writer);
            }
        }
    }
