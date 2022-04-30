public class App {
    public static void main(String[] args) throws Exception {
        SeriesDatabase bbdd = new SeriesDatabase();
        // bbdd.openConnection();
        // bbdd.closeConnection();
        // bbdd.createTableCapitulo();
        // bbdd.createTableValora();
        // bbdd.loadCapitulos("capitulos.csv");
        // bbdd.loadValoraciones("valoraciones.csv");
        // System.out.println(bbdd.catalogo());
        // System.out.println(bbdd.mediaGenero("Terror"));  
        // bbdd.mediaGenero("Drama");
        // System.out.println(bbdd.noHanComentado());        
        // System.out.println(bbdd.setFoto("HomerSimpson.jpg"));
        System.out.println(bbdd.duracionMedia("1234123412"));
       
                
    }
}
