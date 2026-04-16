package academy.devdojo.maratonajava.javacore.Minterfaces.dominio;

public interface DataRemover {

    public static final int MAX_DATA_SIZE = 10;

    public static void retrieveMaxDataSize() {
        System.out.println("Dentro do retrieveMaxDataSize na interface");
    }

    public abstract void load();

    public default void checkPermission() {
        System.out.println("Fazendo checagem de permissões");
    }

}