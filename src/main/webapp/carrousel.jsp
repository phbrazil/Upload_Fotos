<%-- 
    Document   : index
    Created on : Dec 23, 2020, 8:46:47 PM
    Author     : Leonardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Fotos</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width-device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

        <style>

            .background{
                color: black; background-color: whitesmoke;
                padding-top: 2px; padding-bottom: 4px;
                padding-left: 4px; padding-right: 4px
            }
            html {
                scroll-behavior: smooth;
            }
            header {
                position: relative;
                background-color: black;
                height: 100vh;
                min-height: 25rem;
                width: 100%;
                overflow: hidden;
            }

            header video {
                position: absolute;
                top: 50%;
                left: 50%;
                min-width: 120%;
                min-height: 100%;
                width: auto;
                height: auto;
                z-index: 0;
                -ms-transform: translateX(-50%) translateY(-50%);
                -moz-transform: translateX(-50%) translateY(-50%);
                -webkit-transform: translateX(-50%) translateY(-50%);
                transform: translateX(-50%) translateY(-50%);
            }

            header .container {
                position: relative;
                z-index: 2;
            }

            header .overlay {
                position: absolute;
                top: 0;
                left: 0;
                height: 100%;
                width: 100%;
                background-color: black;
                opacity: 0.5;
                z-index: 1;
            }

            #myVideo {
                position: absolute;
                right: 0;
                bottom: 0;
                min-width: 100%;
                min-height: 100%;
            }


            .box
            {
                border: 2px solid #ff0080;
            }
            .box:hover
            {
                -moz-box-shadow: 0 0 10px #ccc;
                -webkit-box-shadow: 0 0 10px #ccc;
                box-shadow: 0 0 10px #ccc;
            }

            /* Style the button used to pause/play the video */

        </style>
    </head>
    <body style="background-color: black">

        <div class="container">

            <div id="carouselExampleControls" class="carousel slide mt-4 ml-4 mr-4" data-ride="carousel">
                <div class="carousel-inner">

                    <div class="container h-100 mb-4">
                        <div class="d-flex h-100 text-center align-items-center">
                            <div class="w-100 text-white">
                                <div id="carouselExampleIndicators" class="carousel slide font-weight-bold"  data-interval="false">
                                    <div class="carousel-inner">
                                        <c:forEach items="${fotos}" var="element" varStatus="loop"> 


                                            <c:choose>
                                                <c:when test = "${loop.index == 0}">
                                                    <div class="carousel-item active">
                                                    </c:when>    
                                                    <c:otherwise>
                                                        <div class="carousel-item ">
                                                        </c:otherwise>
                                                    </c:choose>

                                                    <div class="d-flex h-100 d-flex justify-content-center">
                                                        <div class="text-white">
                                                            <h1>Bem-vindo à <strong style="color: lightseagreen">Festa sei la man</strong></h1>
                                                            <img class="d-block w-100" style="width: 150px; height: auto" src="${pageContext.request.contextPath}/${element.path}" alt="First slide">
                                                            <div class="carousel-caption d-none d-md-block">
                                                                <h1>${element.name}</h1>
                                                                <h4>${element.message}</h4>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>   
                                            </c:forEach>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Voltar</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Avançar</span>
                    </a>
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
                            <h5>Resources</h5>
                            <ul class="list-unstyled text-small">
                                <li><a class="text-muted" href="#">Resource</a></li>
                                <li><a class="text-muted" href="#">Resource name</a></li>
                                <li><a class="text-muted" href="#">Another resource</a></li>
                                <li><a class="text-muted" href="#">Final resource</a></li>
                            </ul>
                        </div>
                        <div class="col-6 col-md">
                            <h5>About</h5>
                            <ul class="list-unstyled text-small">
                                <li><a class="text-muted" href="#">Team</a></li>
                                <li><a class="text-muted" href="#">Locations</a></li>
                                <li><a class="text-muted" href="#">Privacy</a></li>
                                <li><a class="text-muted" href="#">Terms</a></li>
                            </ul>
                        </div>
                    </div>
                </footer>
            </div>
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

