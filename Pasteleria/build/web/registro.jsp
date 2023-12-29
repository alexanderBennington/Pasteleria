<%-- 
    Document   : registro
    Created on : 29 dic 2023, 0:19:14
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
                <form method="post" action="RegistroC">
                    <div class="centrado-simple cent-v titulo-registro">
                        <h2>Registro</h2>
                        <img src="img/logosinnombre.png" width="50" alt="logo">
                    </div>
                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" required>
                    </div>
                    <div class="mb-3">
                        <label for="apellidop" class="form-label">Apellido Paterno</label>
                        <input type="text" class="form-control" id="apellidop" name="apellidop" required>
                    </div>
                    <div class="mb-3">
                        <label for="apellidom" class="form-label">Apellido Materno</label>
                        <input type="text" class="form-control" id="apellidom" name="apellidom" required>
                    </div>
                    <div class="mb-3">
                        <label for="telefono" class="form-label">Telefono</label>
                        <input type="text" class="form-control" id="telefono" name="telefono" minlength="10" required>
                    </div>
                    <div class="mb-3">
                        <label for="correo" class="form-label">Correo</label>
                        <input type="email" class="form-control" id="correo" name="correo" required>
                    </div>
                    <div class="mb-3">
                        <label for="clave" class="form-label">Clave</label>
                        <input type="password" class="form-control" id="clave" name="clave" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\W).{8,}" title="Debe contener al menos 8 caracteres, una letra mayúscula, una letra minúscula, un número y un carácter especial." required>
                    </div>
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
