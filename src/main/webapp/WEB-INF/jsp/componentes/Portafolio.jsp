<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
%>


<section id="work" class="portfolio-mf sect-pt4 route">
    <div class="container">
      <div class="row">
        <div class="col-sm-12">
          <div class="title-box text-center">
            <h3 class="title-a">
              Portfolio
            </h3>
            <p class="subtitle-a">
              Los proyectos en los que he sido parte
            </p>
            <div class="line-mf"></div>
          </div>
        </div>
      </div>
      <div class="row">
        <c:forEach var="proyecto" items="${listaProyectos}">
        <div class="col-md-4">
          <div class="work-box">
              <div class="work-img">
                <img src="../../../images/${proyecto.foto}" alt="" class="img-fluid">
              </div>
              <div class="work-content">
                <div class="row">
                  <div class="col-sm-8">
                    <h2 class="w-title">${proyecto.nombre}</h2>
                    <div class="w-more">
                      <span class="w-ctegory">${proyecto.categoria}</span> / <span class="w-date">${proyecto.fecha}</span>
                    </div>
                  </div>
                  <div class="col-sm-4">
                    <div class="w-like">
                      <!--
                      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalLong${proyecto.id}" onclick="setFormAction(${proyecto.id})">
                        <span class="ion-ios-plus-outline"></span>
                      </button>
                      -->
                      <a href="/viewProyecto/${proyecto.id}" class="btn btn-primary text-white">
                        <span class="ion-ios-plus-outline"></span>
                      </a>

                    </div>
                  </div>
                </div>
              </div>
          </div>
        </div>

        </c:forEach>
      </div>
    </div>
  </section>

<form:form id="addToCartForm" action="/addToCart" method="post" name="theForm">
<!-- Modal -->
  <c:forEach var="proyecto" items="${listaProyectos}">
<div class="modal fade" id="exampleModalLong${proyecto.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Agregar al carrito</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Agregar ${proyecto.nombre} al carrito
        <!-- Hidden input for proyecto id -->
        <input type="hidden" name="proyectoId" id="proyectoIdInput" value="">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" onclick="postForm()">Agregar</button>
      </div>
    </div>
  </div>
</div>
  </c:forEach>
</form:form>

<script>
  var id

  function setFormAction(proyectoId) {
    document.getElementById('proyectoIdInput').value = proyectoId;
    id = proyectoId;
  }

  function postForm(){
    var form = document.getElementById('addToCartForm');
    form.action = '/addToCart/' + id;
    form.submit(); // Submit the form
  }
</script>