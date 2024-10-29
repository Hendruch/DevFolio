<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-b navbar-trans navbar-expand-md fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand js-scroll" href="#page-top">DevFolio</a>
      <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarDefault"
        aria-controls="navbarDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span></span>
        <span></span>
        <span></span>
      </button>
      <div class="navbar-collapse collapse justify-content-end" id="navbarDefault">
        <ul class="navbar-nav">
          <li class="nav-item">
            <a class="nav-link js-scroll active" href="#home">Inicio</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll" href="#about">Sobre mi</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll" href="#service">Servicios</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll" href="#work">Trabajo</a>
          </li>

          <sec:authorize access="not hasRole('ROLE_SUPERADMIN')">
            <li class="nav-item">
              <a class="nav-link js-scroll" href="/Carrito">Carrito</a>
            </li>
          </sec:authorize>

          <sec:authorize access="not hasRole('ROLE_SUPERADMIN')">
            <li class="nav-item">
              <a class="nav-link js-scroll" href="/compras">Compras</a>
            </li>
          </sec:authorize>

          <sec:authorize access="!isAuthenticated()">
            <li class="nav-item">
              <a class="nav-link js-scroll" href="/login">
                  Login
              </a>
            </li>
          </sec:authorize>

          <sec:authorize access="isAuthenticated()">
            <li class="nav-item">
              <a class="nav-link js-scroll" href="/logout">
                Logout
              </a>
            </li>
          </sec:authorize>

          <sec:authorize access="!isAuthenticated()">
            <li class="nav-item">
              <a class="nav-link js-scroll" href="/Registrar">Registrarse</a>
            </li>
          </sec:authorize>

          <sec:authorize access="hasRole('ROLE_SUPERADMIN')">
            <li class="nav-item">
              <a class="nav-link js-scroll" href="/roles">Dashboard</a>
            </li>
          </sec:authorize>


        </ul>
      </div>
    </div>
  </nav>