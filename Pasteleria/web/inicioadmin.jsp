<%-- 
    Document   : inicioadmin
    Created on : 25 dic 2023, 21:31:14
    Author     : keval
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.time.LocalDate" %>
<%
    LocalDate currentDate = LocalDate.now();
    int year = currentDate.getYear();
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
                <form method="post" action="">
                    <div class="centrado-simple">
                        <h2>Inicio de Sesión</h2>
                        <h3>ADMINISTRACIÓN</h3>
                        <img src="img/logo.jpg" width="300" alt="logo">
                    </div>
                    <div class="mb-3">
                        <label for="correo" class="form-label">Correo</label>
                        <input type="email" class="form-control" id="correo" name="correo">
                    </div>
                    <div class="mb-3">
                        <label for="clave" class="form-label">Clave</label>
                        <input type="password" class="form-control" id="clave" name="clave">
                    </div>
                    <button type="submit" class="btn btn-outline-dark">Ingresar</button>
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
