<%-- 
    Document   : mensagem
    Created on : Dec 28, 2020, 2:55:30 PM
    Author     : killuminatti08
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>

        <title>Mensagens de Felicitações</title>
        <meta charset="UTF-8">
        <meta name="description" content="Mensagens de Felicitações">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- CSS
        ================================================== -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/reset.css"/>
        <link rel="stylesheet" href="css/style.css"/>

        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Google Fontes
        ================================================== -->
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,500,600,700" rel="stylesheet">

        <!--Fontes
        ================================================== -->
        <link rel="stylesheet" href="icon-fonts/etlinefont/style.css"/>

        <!-- icones -->
        <link rel="stylesheet" href="icon-fonts/fontawesome-5.0.6/css/fontawesome-all.min.css"/>


        <style>
            .transparencia {
                padding: 0px;
                border: 1px solid WindowFrame;
                background-color: Window;
                /*       color: red;*/
                overflow: hidden;
                cursor: default;
                z-index: 999999!important;
            }
        </style>
    </head>

    <body>


        <!-- Preloader 
        <div class="preloader">
            <div class="outer">
                <div class="inner">
                    <div class="percentage"></div>                          
                </div>
            </div>
        </div>
        Preloader -->  

        <!-- HEADER
        ================================================== -->
        <header>
            <div class="logo float-left">
                <img src="img/logo.png" alt="">
            </div> 
            <div class="nav-icon float-right">
                <span></span>
                <span></span>
                <span></span>
            </div>
        </header>

        <!-- Full Menu -->
        <div class="full-menu">
            <div class="fullmenu-content">
                <ul class="page-menu">
                    <li><a class="active" href="index.html">Home</a></li>
                    <li><a href="enviar-felicitacoes.html">Enviar Felicitações</a></li>
                    <li class="social">
                        <a href="#"><i class="fab fa-twitter"></i></a>
                        <a href="#"><i class="fab fa-instagram"></i></a>
                    </li>
                </ul>
            </div>
            <a href="#0" class="modal-close"></a>
        </div>
        <div class="cd-transition-layer visible opening"> 
            <div class="bg-layer"></div>
        </div><!-- Ink Transition -->

        <div id='alert'></div>

        <div class='d-flex justify-content-md-end'>
            <div style="position: fixed" class="toast transparencia" role="alert" aria-live="assertive" aria-atomic="true">
                <div class="toast-header">
                    <strong class="mr-auto">Alerta!</strong>
                    <small>Agora</small>
                    <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="toast-body">
                    Novas fotos adicionadas
                </div>
            </div>
        </div>

        <div class="wrapper">

            <!-- PAGE CONTENT
            ================================================== -->
            <div class="container">
                <div class="page-content about-page">
                    <div class="page-title top_90 bottom_60">
                        <h1 class="title">Felicitações</h1>
                        <div class="zigzag">
                            <svg viewBox="0 0 69.172 14.975" width="37" height="28" y="0px" x="0px" xmlns="http://www.w3.org/2000/svg">
                            <path d="M1.357,12.26 10.807,2.81 20.328,12.332
                                  29.781,2.879 39.223,12.321 48.754,2.79  58.286,12.321"/>
                            </svg>
                        </div>
                    </div>
                </div>

                <c:forEach items="${fotos}" var="element" varStatus="loop"> 

                    <!-- blog posts -->
                    <div class="col-lg-8 offset-lg-2">
                        <!-- Mensagem -->
                        <div class="blog-post bottom_120">
                            <a class="blog-link" href="#">
                                <figure class="bottom_60">
                                    <img src="${pageContext.request.contextPath}/${element.path}" alt="">
                                </figure>
                            </a>
                            <div class="col-lg-10 offset-lg-1 content-outter">
                                <div class="blog-categories bottom_15">
                                </div>
                                <h2 class="blog-title bottom_15" id="nome">${element.name}</h2>

                                <p class="blog-text" id="txt">${element.message}</p>



                            </div>
                        </div>
                    </div>

                </c:forEach>

                <div id='messages'></div>


            </div>

        </div>

        <!-- FOOTER
        ================================================== -->
        <footer>
            <div class="container padding_90">
                <div class="row">
                    <div class="col-lg-9">
                        <div class="social">
                            <a href="#"><i class="fab fa-twitter"></i></a>
                            <a href="#"><i class="fab fa-instagram"></i></a>
                        </div><br>
                        <p>© <a target="_blank" href='https://www.9ember.com'>9ember</a></p>
                    </div>
                    <div class="col-lg-3">
                        <div class="uptotop">topo</div>
                    </div>
                </div>
            </div>
        </footer>

        <!-- Javascripts -->
        <script src="js/jquery-2.1.4.min.js"></script>
        <script src="js/isotope.pkgd.min.js"></script>
        <script src="js/packery-mode.pkgd.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/modernizr.js"></script>   
        <script src="js/main.js"></script>
        <script src="js/fotosList.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>    <!-- Icons -->

        <script>

            var current = JSON.parse('${current}');

            //window.onload = (event) => {
            var i = 1;                  //  set your counter to 1

            function myLoop() {         //  create a loop function
                setTimeout(function () {   //  call a 10s setTimeout when the loop is called
                    current = GetFotos(current);   //  your code here
                    i++;                    //  increment the counter
                    if (i < 10000000000) {           //  if the counter < 10, call the loop function
                        myLoop();             //  ..  again which will trigger another 
                    }                       //  ..  setTimeout()
                }, 10000)
            }

            myLoop();
            //}
        </script>

        <!--script>

            //https://www.w3schools.com/bootstrap4/bootstrap_ref_js_toasts.asp

            $(document).ready(function () {
                $('.toast').toast({delay: 20000});
                $('.toast').toast('show');
            });
        </script-->

    </body>
</html>
