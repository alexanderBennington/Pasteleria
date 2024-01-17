$(function()
{
    $('tr #eliminarcarrito').click(function(e){
        e.preventDefault();
        var elemento = $(this);
        
        var idproducto = elemento.parent().find('#idarticulo').text();
        
        $.ajax({
            url: 'deleteItem',
            type: 'post',
            data: {idproducto:idproducto},
            success: function(r){
                elemento.parent().parent().remove();
                var elementostabla = $('#shop-table tr');
                if(elementostabla.length<=1){
                    $('#cart-container').append("<h4>No hay articulos en el carro</h4>");
                }
                document.getElementById("total").value=r;
                window.location.reload(true);
            }
        });
    });
});

document.addEventListener("DOMContentLoaded", function() {
    var tabla = document.getElementById("shop-table");
    var carro = document.getElementById("cart-container");
    var mensajeNoProductos = document.getElementById("mensajeNoProductos");

    var filas = tabla.getElementsByTagName("tbody")[0].getElementsByTagName("tr");

    if (filas.length === 0) {
        carro.style.display = "none";
        mensajeNoProductos.style.display = "block";
    } else {
        tabla.style.display = "table";
        mensajeNoProductos.style.display = "none";
    }
    
    var inputPrincipal = document.getElementById("direccionenvio");
    var inputInvisible1 = document.getElementById("direccion1");
    var inputInvisible2 = document.getElementById("direccion2");

    inputPrincipal.addEventListener("input", function() {

        var valorInputPrincipal = inputPrincipal.value;
        inputInvisible1.value = valorInputPrincipal;
        inputInvisible2.value = valorInputPrincipal;
    });
    
    
});