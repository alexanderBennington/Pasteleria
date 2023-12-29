<%-- 
    Document   : detalles_tarjeta
    Created on : 29 dic 2023, 1:50:50
    Author     : keval
--%>

<%@page import="java.time.LocalDate"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    LocalDate currentDate = LocalDate.now();
    int year = currentDate.getYear();
    
    int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cake Alchemy</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="css/pasteles.css">
    <link  href="img/logo.ico" rel="shortcut icon">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <script src="js/jquery.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
</head>
<body>
    <header><section class="centrado-simple" id="centrado-titulo"><h1>ALCHEMY</h1></section></header>
    <section class="container">
        <div class="fondosesion">
            <div class="mx-auto cajasesion">
                <form method="post" action="TarjetaC">
                    <div class="centrado-simple cent-v titulo-registro">
                        <h2>Registro Tarjeta</h2>
                        <img src="img/logosinnombre.png" width="50" alt="logo">
                    </div>
                    <div class="mb-3">
                        <label for="direccion" class="form-label">Dirección</label>
                        <input type="text" class="form-control" id="direccion" name="direccion" required>
                    </div>
                    <div class="mb-3">
                        <label for="ciudad" class="form-label">Ciudad</label>
                        <input type="text" class="form-control" id="ciudad" name="ciudad" required>
                    </div>
                    <div class="mb-3">
                        <label for="cp" class="form-label">Código Postal</label>
                        <input type="text" class="form-control" id="cp" name="cp" required>
                    </div>
                    <div class="mb-3">
                        <label for="tarjeta" class="form-label">Número de Tarjeta</label>
                        <input type="text" class="form-control" id="tarjeta" name="tarjeta" minlength="16" required>
                    </div>
                    <div class="mb-3">
                        <label for="fecha" class="form-label">Fecha de Vencimiento</label>
                        <input type="date" class="form-control" id="fecha" name="fecha" required>
                    </div>
                    <div class="mb-3">
                        <label for="cvv" class="form-label">CVV</label>
                        <input type="text" class="form-control" id="cvv" name="cvv" minlength="3" required>
                    </div>
                    <input name="id_usuario" value="<%= id_usuario %>" style="display: none;">
                    <button type="submit" class="btn btn-outline-dark">Registrar</button>
                </form>                
            </div>
        </div>
    </section>
    <footer>
        <section id="pie" class="cent-v">
            <div class="container disflex">
                <div>
                    <img src="img/nombrelogo.png" alt="name" width="100">
                </div>
                <div class="pie-der">
                    <p>
                        © <%= year %> Alchemy. Todos los derechos reservados.
                    </p>
                </div>
            </div>
        </section>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>