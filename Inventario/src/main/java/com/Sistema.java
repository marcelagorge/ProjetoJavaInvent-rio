package com;

import com.Menus.MenuAdministrador;
import com.Menus.MenuUsuarioComum;
import com.Modelos.Usuario;
import com.Util.JsonManager;

import java.util.List;
import java.util.Scanner;

public class Sistema {
    private static List<Usuario> usuarios = JsonManager.lerUsuarios();
    private static Usuario usuarioLogado = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void iniciarSistema() {
        System.out.println("Bem-vindo ao sistema de login.");

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Login");
            System.out.println("2. Registrar como Usuário Comum");
            System.out.println("3. Registrar como Administrador");
            System.out.println("0. Sair");

            int opcao = Console.lerInt("Opção:");

            switch (opcao) {
                case 1:
                    login();
                    break;
                case 2:
                    registrar(false);
                    break;
                case 3:
                    registrar(true);
                    break;
                case 0:
                    encerrarSistema();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void login() {
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();

        System.out.print("Password: ");
        String password = scanner.nextLine().trim();

        if (validarCredenciais(username, password)) {
            System.out.println("Login bem-sucedido!");

            if (usuarioLogado.isAdmin()) {
                MenuAdministrador.executarMenuAdministrador();
            } else {
                MenuUsuarioComum.exibirMenu();
            }
        } else {
            System.out.println("Username ou password inválidos.");
        }
    }

    private static boolean validarCredenciais(String username, String password) {
        for (Usuario user : usuarios) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                usuarioLogado = user;
                return true;
            }
        }
        return false;
    }

    private static void registrar(boolean isAdmin) {
        System.out.print("Novo Username: ");
        String username = scanner.nextLine().trim();

        // Verifica se o username já está em uso
        if (usernameExistente(username)) {
            System.out.println("Username já existe. Tente outro.");
            return;
        }

        System.out.print("Nova Password: ");
        String password = scanner.nextLine().trim();

        Usuario novoUsuario = new Usuario(username, password, isAdmin);
        JsonManager.adicionarUsuario(novoUsuario);
        System.out.println("Usuário registrado com sucesso como " + (isAdmin ? "Administrador" : "Usuário Comum") + "!");
    }

    private static boolean usernameExistente(String username) {
        for (Usuario user : usuarios) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static void encerrarSistema() {
        System.out.println("Sistema encerrado. Até mais!");
        System.exit(0);
    }
}
