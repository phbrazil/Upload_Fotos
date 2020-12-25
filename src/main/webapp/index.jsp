<%-- 
    Document   : index
    Created on : Dec 23, 2020, 8:46:47 PM
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Adicionar Foto</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width-device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

    </head>
    <body>
        <div class="container">

            <div class="d-flex p-4">
                <div class="col-md-12 mt-4">

                    <form class= 'ui-autocompletar needs-validation' enctype="multipart/form-data" name = "${pageContext.request.contextPath}/addFoto"  novalidate id = "addFoto" action="${pageContext.request.contextPath}/addFoto" method="POST">
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Nome</label>
                            <input type="text" name='name' class="form-control" id="exampleFormControlInput1" placeholder="Maria" required>
                        </div>
                        <div class="form-group">
                            <label for="exampleFormControlInput1">Email</label>
                            <input type="email" name='email' class="form-control" id="exampleFormControlInput1" placeholder="nome@exemplo.com" required>
                        </div>

                        <div class="custom-file mb-2">
                            <input type="file" onchange="ValidateSize(this)" class="custom-file-input needs-validation" name='anexo'  id = 'i_file' required>
                            <label class="custom-file-label" for="validatedCustomFile">Sua Foto...</label>
                            <div class="invalid-feedback">Foto invalida</div>
                        </div>
                        <div id="filestatus"></div>

                        <div class="form-group mt-2">
                            <label for="exampleFormControlTextarea1">Mensagem</label>
                            <textarea required name='message' class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                        </div>

                        <input type="hidden" name="token" value="9ember_2020">
                        <button type='submit' id="submit" name="submit" onclick="return confirm('Confirma os dados preenchidos?');" class="btn btn-info btn-lg mb-2 waves-effect waves-light">Enviar<i class="fas fa-send ml-1"></i></button>
                    </form>
                </div>
            </div>

            <footer class="pt-4 my-md-5 pt-md-5 border-top">
                <div class="row">
                    <div class="col-12 col-md">
                        <img class="mb-2" src="assets/logo_9ember.png" alt="" width="40" height="30">
                        <p><a href="https://www.9ember.com" target="_blank">9ember</a></p>
                        <small class="d-block mb-3 text-muted">&copy; 2020-2021</small>
                    </div>
                    <div class="col-6 col-md">
                        <h5>Features</h5>
                        <ul class="list-unstyled text-small">
                            <li><a class="text-muted" href="#">Cool stuff</a></li>
                            <li><a class="text-muted" href="#">Random feature</a></li>
                            <li><a class="text-muted" href="#">Team feature</a></li>
                            <li><a class="text-muted" href="#">Stuff for developers</a></li>
                            <li><a class="text-muted" href="#">Another one</a></li>
                            <li><a class="text-muted" href="#">Last time</a></li>
                        </ul>
                    </div>
                    <div class="col-6 col-md">
                        <h5>Recursos</h5>
                        <ul class="list-unstyled text-small">
                            <li><a class="text-muted" href="#">Resource</a></li>
                            <li><a class="text-muted" href="#">Resource name</a></li>
                            <li><a class="text-muted" href="#">Another resource</a></li>
                            <li><a class="text-muted" href="#">Final resource</a></li>
                        </ul>
                    </div>
                    <div class="col-6 col-md">
                        <h5>Nosso Time</h5>
                        <ul class="list-unstyled text-small">
                            <li><a class="text-muted" href="#">Paulo</a></li>
                            <li><a class="text-muted" href="#">Rafael</a></li>
                        </ul>
                    </div>
                </div>
            </footer>
        </div>

    </body>

    <script src="js/filtroArquivo.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>


    <script>
                        // Example starter JavaScript for disabling form submissions if there are invalid fields
                        (function () {
                            'use strict';
                            window.addEventListener('load', function () {
                                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                                var forms = document.getElementsByClassName('needs-validation');
                                // Loop over them and prevent submission
                                var validation = Array.prototype.filter.call(forms, function (form) {
                                    form.addEventListener('submit', function (event) {
                                        if (form.checkValidity() === false) {
                                            event.preventDefault();
                                            event.stopPropagation();
                                        }
                                        form.classList.add('was-validated');
                                    }, false);
                                });
                            }, false);
                        })();
    </script>
</html>

