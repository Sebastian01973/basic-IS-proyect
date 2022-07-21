package views;

import java.awt.*;

public class Constant {

    public static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

    // URLS

    public static final String IMG_ARROW_DOWN = "/arrowDown.png";
    public static final String IMG_ARROW_RIGHT = "/arrowRight.png";
    public static final String IMG_MENU = "/menu.png";
    public static final String IMG_PRODUCTS = "/product.png";
    public static final String IMG_BANNER = "/BANNER.jpeg";

    //Colors
    public static final Color COLOR_WHITE = Color.decode("#ffffff");
    public static final Color COLOR_BLACK = Color.decode("#000000");
    public static final Color COLOR_BLUE_LIGHT_1 = Color.decode("#2fb7ec");
    public static final Color COLOR_RED_LIGHT_1 = Color.decode("#FF3030");
    public static final Color COLOR_GREEN = Color.decode("#5E8A20");
    public static final Color COLOR_YELLOW_1 = Color.decode("#E6D929");
    public static final Color COLOR_ORANGE_1 = Color.decode("#ff9900");
    public static final Color COLOR_GRAY_LIGHT_1 = Color.decode("#c0c0c0");
    public static final Color COLOR_GRAY_LIGHT_2 = Color.decode("#f0f5f7");
    public static final Color COLOR_BLUE_DARK_1 = Color.decode("#131921");
    public static final Color COLOR_BLUE_DARK_2 = Color.decode("#00a64e");
    public static final Color COLOR_GREEN_DARK_2 = Color.decode("#00a64e");
    public static final Color COLOR_BLUE_DARK_3 = Color.decode("#0C1E42");

    //Fonts
    public static final Font FONT_ROCWELL = new Font("Rockwell", Font.PLAIN, 20);
    public static final Font FONT_NEW_ROMAN_25 = new Font("Times New Roman", Font.PLAIN, 25);
    public static final Font FONT_BONODI_15 = new Font("Bodoni MT", Font.PLAIN, 15);
    public static final Font FONT_ARIAL_ROUNDER_17 = new Font("Arial Rounded MT Bold", Font.PLAIN, 17);
    public static final Font FONT_ARIAL_ROUNDER_25 = new Font("Arial Rounded MT Bold", Font.PLAIN, 25);
    public static final Font FONT_ARIAL_ROUNDER_30 = new Font("Arial Rounded MT Bold", Font.PLAIN, 30);
    public static final Font FONT_ARIAL_ROUNDER_15 = new Font("Arial Rounded MT Bold", Font.PLAIN, 15);
    public static final Font FONT_HELVETICA_17 = new Font("Helvetica", Font.BOLD, 17);
    public static final Font FONT_HELVETICA_15 = new Font("Helvetica", Font.PLAIN, 15);
    public static final Font FONT_HELVETICA_13 = new Font("Helvetica", Font.PLAIN, 13);

    public static final String[] H_PRODUCTS = {"Codigo", "Nombre", "Unidades", "Precio unidad", "Tipo de Producto", "Descripcion","Precio Total"};
    public static final String M_SELECT_OPTION = "Seleccionar una opcion...";
    public static final String TXT_SIGN_OFF = "Salir";
    public static final String[] TXT_MENU = {"Agregar Producto", "Buscar Producto", "Eliminar Producto"};

    public static final String ADD_PRODUCT = "Agregar Producto";
    public static final String NAME_PRODUCT = "Nombre del producto";
    public static final String TXT_PRODUCT = "Ingresar nombre del producto:";
    public static final String TXT_PRICE = "Ingresar precio del producto:";
    public static final String TXT_UNITS = "Ingresar unidades del producto";

    public static final String[] OPTIONS = {"Concentrados", "Collares", "Productos Aseo", "Medicamentos", "Vacunas"};
    public static final String ASSIGN_OPTION = "Asignar Opcion";

    public static final String TXT_CREATE = "CREAR";
    public static final String TXT_CANCEL = "CANCELAR";
    public static final String DESCR_PRODUCT = "Describa al producto (Corto)";
    public static final String TXT_DESCR = "Ingrese la descripcion";
    public static final Object TXT_NOT_ALL_TEXT = "No ingreso los valores";

    public static final Object TXT_NOT_TYPE_PRODUCT = "No escogio el tipo de producto";
    public static final Object TXT_ADD_PRODUCT = "Producto Agregado";
    public static final String D_TXT_PRODUCT = "Peoducto";
    public static final String TXT_MODIFY = "Modificar";
    public static final String TXT_DELETE = "Eliminar";
}