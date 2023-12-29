package Controlador;

import Modelo.Sugerencias;
import Modelo.SugerenciasM;
import java.util.List;

public class SugerenciasC {
    
    public String getSugerencias(int id_usuario){
        String htmlcode = "";
        SugerenciasM sm = new SugerenciasM();
        List<String> categorias = sm.obtenerCategorias(id_usuario);
        for(Sugerencias sugerencia : sm.mostrarSugerencias(categorias)){
            htmlcode += "<div class=\"item\">\n" +
"                        <div class=\"tarjeta\">\n" +
"                            <a href=\"producto.jsp?id_producto="+sugerencia.getId_producto()+"\"><img src=\"img/productos/"+sugerencia.getImg_producto()+"\" alt=\"\"></a>\n" +
"                        </div>\n" +
"                    </div>";
        }
        return htmlcode;
    }
}
