<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
    <title>DevFolio Bootstrap Template</title>
    <jsp:include page="componentes/Head.jsp"/>


<body id="page-top">

<%--<%

    Usuario usuario = (Usuario)session.getAttribute("usuario");
    /*
    if(usuario == null){
        System.out.println("No existe el usuario en session");
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    } else {

     */
%>--%>

<!--/ Nav Star /-->
<jsp:include page="componentes/Nav.jsp"/>
    <%--<jsp:param value="<%=usuario.getEmail() %>" name="email"/>

</jsp:include>--%>
<!--/ Nav End /-->

<!--/ Intro Skew Star /-->
<jsp:include page="componentes/Intro.jsp"/>
<!--/ Intro Skew End /-->

<section id="about" class="about-mf sect-pt4 route">
    <div class="container">
        <div class="row">
            <div class="col-sm-12">
                <div class="box-shadow-full">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="row">
                                <div class="col-sm-6 col-md-5">
                                    <div class="about-img">
                                        <img src="img/fotoTestimonial_2.jpg" class="img-fluid rounded b-shadow-a" alt="">
                                    </div>
                                </div>
                                <div class="col-sm-6 col-md-7">
                                    <div class="about-info">
                                        <p><span class="title-s">Nombre: </span> <span>Hendrick Rasgado</span></p>
                                        <p><span class="title-s">Perfil: </span> <span>full stack developer</span></p>
                                        <p><span class="title-s">correo: </span> <span>contact@example.com</span></p>
                                        <p><span class="title-s">Telefono: </span> <span>(617) 557-0089</span></p>
                                    </div>
                                </div>
                            </div>
                            <div class="skill-mf">
                                <p class="title-s">Habilidades</p>
                                <span>HTML</span> <span class="pull-right">85%</span>
                                <div class="progress">
                                    <div class="progress-bar" role="progressbar" style="width: 85%;" aria-valuenow="85" aria-valuemin="0"
                                         aria-valuemax="100"></div>
                                </div>
                                <span>CSS3</span> <span class="pull-right">75%</span>
                                <div class="progress">
                                    <div class="progress-bar" role="progressbar" style="width: 75%" aria-valuenow="75" aria-valuemin="0"
                                         aria-valuemax="100"></div>
                                </div>
                                <span>PHP</span> <span class="pull-right">50%</span>
                                <div class="progress">
                                    <div class="progress-bar" role="progressbar" style="width: 50%" aria-valuenow="50" aria-valuemin="0"
                                         aria-valuemax="100"></div>
                                </div>
                                <span>JAVASCRIPT</span> <span class="pull-right">90%</span>
                                <div class="progress">
                                    <div class="progress-bar" role="progressbar" style="width: 90%" aria-valuenow="90" aria-valuemin="0"
                                         aria-valuemax="100"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="about-me pt-4 pt-md-0">
                                <div class="title-box-2">
                                    <h5 class="title-left">
                                        Sobre Mi
                                    </h5>
                                </div>
                                <p class="lead">
                                    ¡Hola! Soy un desarrollador de software versátil con una pasión por crear soluciones innovadoras en diversos ámbitos. Con un enfoque en desarrollo web, creación de aplicaciones móviles y análisis de seguridad, prospero en el paisaje dinámico y en constante evolución de la tecnología.
                                </p>
                                <p class="lead">
                                    Manteniéndome siempre al tanto de las últimas tendencias y tecnologías de la industria, estoy comprometido a perfeccionar mis habilidades y enfrentar nuevos desafíos. Prospéro en entornos colaborativos donde puedo aportar mis habilidades y aprender de otros profesionales, fomentando una atmósfera de crecimiento y mejora continua.
                                </p>
                                <p class="lead">
                                    Si estás buscando un desarrollador de software que pueda navegar sin problemas en los ámbitos del desarrollo web, la creación de aplicaciones móviles y el análisis de seguridad, estoy aquí para dar vida a tus proyectos con eficiencia, creatividad y una mentalidad centrada en la seguridad. ¡Construyamos algo grandioso juntos!
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!--/ Section Services Star /-->
<jsp:include page="componentes/Services.jsp"/>
<!--/ Section Services End /-->

<div class="section-counter paralax-mf bg-image" style="background-image: url(../../img/counters-bg.jpg)">
    <div class="overlay-mf"></div>
    <div class="container">
        <div class="row">
            <div class="col-sm-3 col-lg-3">
                <div class="counter-box">
                    <div class="counter-ico">
                        <span class="ico-circle"><i class="ion-checkmark-round"></i></span>
                    </div>
                    <div class="counter-num">
                        <p class="counter">450</p>
                        <span class="counter-text">TRABAJOS COMPLETADOS</span>
                    </div>
                </div>
            </div>
            <div class="col-sm-3 col-lg-3">
                <div class="counter-box pt-4 pt-md-0">
                    <div class="counter-ico">
                        <span class="ico-circle"><i class="ion-ios-calendar-outline"></i></span>
                    </div>
                    <div class="counter-num">
                        <p class="counter">15</p>
                        <span class="counter-text">AÑOS DE EXPERIENCIA</span>
                    </div>
                </div>
            </div>
            <div class="col-sm-3 col-lg-3">
                <div class="counter-box pt-4 pt-md-0">
                    <div class="counter-ico">
                        <span class="ico-circle"><i class="ion-ios-people"></i></span>
                    </div>
                    <div class="counter-num">
                        <p class="counter">550</p>
                        <span class="counter-text">CLIENTES TOTALES</span>
                    </div>
                </div>
            </div>
            <div class="col-sm-3 col-lg-3">
                <div class="counter-box pt-4 pt-md-0">
                    <div class="counter-ico">
                        <span class="ico-circle"><i class="ion-ribbon-a"></i></span>
                    </div>
                    <div class="counter-num">
                        <p class="counter">36</p>
                        <span class="counter-text">PREMIOS GANADOS</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!--/ Section Portfolio Star /-->
<jsp:include page="componentes/Portafolio.jsp"/>
<!--/ Section Portfolio End /-->

<!--/ Section Testimonials Star /-->
<jsp:include page="componentes/Testimonios.jsp"/>

<!--/ Section Blog Star /-->
<!--
<jsp:include page="componentes/Blog.jsp"/>
-->
<!--/ Section Blog End /-->

<!--/ Section Contact-Footer Star /-->
<!--
<jsp:include page="componentes/ContactoFooter.jsp"/>
-->
<!--/ Section Contact-footer End /-->

<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
<div id="preloader"></div>

<!-- JavaScript Libraries -->
<jsp:include page="componentes/JsLibraries.jsp"/>
<%//} %>

</body>
</html>
