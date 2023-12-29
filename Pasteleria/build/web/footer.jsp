<%@ page import="java.time.LocalDate" %>
<%
    LocalDate currentDate = LocalDate.now();
    int year = currentDate.getYear();
%>
<footer>
        <section class="container foot">
            <div class="row">
                <div class="col-4">
                    <img src="img/logo.jpg" alt="logo" width="400">
                </div>
                <div class="col-8">
                    <div class="row espaciocontacto">
                        <div class="col">
                            <h2 class="contactoh2">
                                Contactanos:
                            </h2>
                            <div class="disflex contacto">
                                <img src="img/correo.png" alt="" width="50">
                                <p>escom.alumno.ipn.mx</p>
                            </div>
                            <div class="disflex contacto">
                                <img src="img/tel.png" alt="" width="50">
                                <p>5512345678</p>
                            </div>
                            <div class="disflex contacto">
                                <img src="img/ubicacion.png" alt="" width="50">
                                <p>Escuela Superior de Cómputo</p>
                            </div>
                        </div>
                        <div class="col">
                            <h2 class="contactoh2">
                                Siguenos:
                            </h2>
                            <div class="disflex margenredes">
                                <img src="img/face.png" alt="face" width="60">
                                <img src="img/x.png" alt="" width="60">
                                <img src="img/youtube.png" alt="" width="60">
                                <img src="img/insta.png" alt="" width="60">
                                <img src="img/tiktok.png" alt="" width="60">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

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