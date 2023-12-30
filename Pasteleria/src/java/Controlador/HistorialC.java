package Controlador;

import Modelo.Historial;
import Modelo.HistorialM;

public class HistorialC {
    public String getHistorialEntregas(){
        HistorialM historial = new HistorialM();
        String htmlcode = "";
        for(Historial historialentregas : historial.getHistorialEntregados()){
            htmlcode += "<tr>\n" +
"                    <th scope=\"row\">"+historialentregas.getId_pedido()+"</th>\n" +
"                    <td>"+historialentregas.getId_usuario()+"</td>\n" +
"                    <td>"+historialentregas.getTotal()+"</td>\n" +
"                    <td>"+historialentregas.getFecha_hora_estado()+"</td>\n" +
"                </tr>";
        }
        return htmlcode;
    }
    
    public String getGananciasDia(){
        HistorialM historial = new HistorialM();
        String htmlcode = "";
        int ganancias = historial.getHistorialGanancias();
        htmlcode += "<h2>Total del dia: $"+ganancias+"</h2>";
        return htmlcode;
    }
}
