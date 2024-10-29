<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>Ventas</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.css" rel="stylesheet" />
</head>
<body>


<div>
    <div>
        <jsp:include page="../componentes/SideBar.jsp"/>
    </div>
    <div class="p-4 sm:ml-64">


        <div class="relative overflow-x-auto shadow-md sm:rounded-lg">

            <form:form>
                <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
                    <caption class="p-5 text-lg font-semibold text-left text-gray-900 bg-white dark:text-white dark:bg-gray-800">
                        Ventas
                        <p>
                            <!-- Modal toggle
                            <button data-modal-target="registration-modal" data-modal-toggle="registration-modal" class="block text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800" type="button">
                                Agregar Usuario
                            </button>
                            -->
                        </p>
                    </caption>
                    <thead class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400">
                    <tr>
                        <th scope="col" class="px-6 py-3">
                            id
                        </th>
                        <th scope="col" class="px-6 py-3">
                            Total
                        </th>
                        <th scope="col" class="px-6 py-3">
                            Fecha
                        </th>
                        <th scope="col" class="px-6 py-3">
                            Usuario
                        </th>
                        <th scope="col" class="px-6 py-3">
                            Accion
                        </th>
                    </tr>
                    </thead>

                    <tbody>
                    <c:forEach var="venta" items="${listaVentas}">
                        <tr class="bg-white border-b dark:bg-gray-800 dark:border-gray-700 hover:bg-gray-50 dark:hover:bg-gray-600">

                            <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                                    ${venta.id}
                            </th>
                            <td class="px-6 py-4">
                                    ${venta.total}
                            </td>
                            <td class="px-6 py-4">
                                    ${venta.fechaVenta}
                            </td>
                            <td class="px-6 py-4">
                                    ${venta.usuario.getNombre()}
                            </td>
                            <td class="flex items-center px-6 py-4 space-x-3">
                                <a href="/verVenta/${venta.id}" class="font-medium text-blue-600 dark:text-blue-500 hover:underline">Ver</a>
                                <a href="/deleteVenta/${venta.id}" class="font-medium text-red-600 dark:text-red-500 hover:underline">Remove</a>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </form:form>
        </div>
    </div>
</div>


<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.js"></script>
</body>
</html>