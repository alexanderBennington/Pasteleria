<%-- 
    Document   : footeradmin
    Created on : 29 dic 2023, 17:37:25
    Author     : keval
--%>

<%@ page import="java.time.LocalDate" %>
<%
    LocalDate currentDate = LocalDate.now();
    int year = currentDate.getYear();
%>
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
