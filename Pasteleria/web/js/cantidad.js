document.addEventListener("DOMContentLoaded", function () {

    var inputNumero = document.getElementById("cantidad");

    inputNumero.addEventListener("input", function () {
        validarInput(inputNumero);
    });

    function validarInput(input) {
        if (input.value < 1) {
        input.value = 1;
        }
    }
});