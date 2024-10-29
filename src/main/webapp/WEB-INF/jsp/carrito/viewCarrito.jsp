<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>Carrito</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.css" rel="stylesheet" />

    <style>
        .remove-arrow::-webkit-inner-spin-button,
        .remove-arrow::-webkit-outer-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }

        .remove-arrow {
            -moz-appearance: textfield;
        }
    </style>

</head>
<body>

<div class="my-8 ml-8">


<div class="flex justify-center items-center h-screen">
<div class="relative overflow-x-auto shadow-md sm:rounded-lg">

    <a href="/#work" class="text-white bg-blue-700 hover:bg-blue-800 focus:outline-none focus:ring-4 focus:ring-blue-300 font-medium rounded-full text-sm px-5 py-2.5 text-center mr-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Ir atras</a>

    <h1>Productos en el carrito de compras</h1>

    <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
        <thead class="text-xs text-gray-700 uppercase bg-gray-100 dark:bg-gray-700 dark:text-gray-400">
        <tr>
            <th scope="col" class="px-6 py-3 rounded-l-lg">
                Nombre
            </th>
            <th scope="col" class="px-6 py-3">
                Cantidad
            </th>
            <th scope="col" class="px-6 py-3 ">
                Precio unitario
            </th>
            <th scope="col" class="px-6 py-3 ">
                subtotal
            </th>
            <th scope="col" class="px-6 py-3 rounded-r-lg">
                <span class="sr-only">Eliminar</span>
            </th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cart" items="${listaCarrito}">
            <tr class="bg-white dark:bg-gray-800">
                <th scope="row" class="px-6 py-4 font-medium text-gray-900 whitespace-nowrap dark:text-white">
                    ${cart.proyecto.nombre}
                </th>
                <td class="px-6 py-4">
                    <div class="flex items-center justify-center">
                        <a href="/less/${cart.id}" class="bg-gray-200 hover:bg-gray-300 rounded-l px-4 py-2">
                            -
                        </a>
                        <input type="number" class="remove-arrow border rounded py-2 px-4 text-center outline-none text-sm bg-white w-16" value="${cart.cantidad}">
                        <a href="/more/${cart.id}" class="bg-gray-200 hover:bg-gray-300 rounded-r px-4 py-2">
                            +
                        </a>
                    </div>
                </td>
                <td class="px-6 py-4">
                    ${cart.proyecto.getPrecio()}
                </td>
                <td class="px-6 py-4">
                        ${cart.subtotal}
                </td>
                <td class="px-6 py-4">
                    <a href="/deleteFromCart/${cart.id}" class="font-medium text-blue-600 dark:text-blue-500 hover:underline">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
</div>
    <div class="pr-0">
        <a href="/addVenta" class="text-white bg-[#FF9119] hover:bg-[#FF9119]/80 focus:ring-4 focus:outline-none focus:ring-[#FF9119]/50 font-medium rounded-lg text-sm px-5 py-2.5 text-center inline-flex items-center dark:hover:bg-[#FF9119]/80 dark:focus:ring-[#FF9119]/40 mr-2 mb-2">
            <svg class="w-4 h-4 mr-2 -ml-1" aria-hidden="true" focusable="false" data-prefix="fab" data-icon="bitcoin" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path fill="currentColor" d="M504 256c0 136.1-111 248-248 248S8 392.1 8 256 119 8 256 8s248 111 248 248zm-141.7-35.33c4.937-32.1-20.19-50.74-54.55-62.57l11.15-44.7-27.21-6.781-10.85 43.52c-7.154-1.783-14.5-3.464-21.8-5.13l10.93-43.81-27.2-6.781-11.15 44.69c-5.922-1.349-11.73-2.682-17.38-4.084l.031-.14-37.53-9.37-7.239 29.06s20.19 4.627 19.76 4.913c11.02 2.751 13.01 10.04 12.68 15.82l-12.7 50.92c.76 .194 1.744 .473 2.829 .907-.907-.225-1.876-.473-2.876-.713l-17.8 71.34c-1.349 3.348-4.767 8.37-12.47 6.464 .271 .395-19.78-4.937-19.78-4.937l-13.51 31.15 35.41 8.827c6.588 1.651 13.05 3.379 19.4 5.006l-11.26 45.21 27.18 6.781 11.15-44.73a1038 1038 0 0 0 21.69 5.627l-11.11 44.52 27.21 6.781 11.26-45.13c46.4 8.781 81.3 5.239 95.99-36.73 11.84-33.79-.589-53.28-25-65.99 17.78-4.098 31.17-15.79 34.75-39.95zm-62.18 87.18c-8.41 33.79-65.31 15.52-83.75 10.94l14.94-59.9c18.45 4.603 77.6 13.72 68.81 48.96zm8.417-87.67c-7.673 30.74-55.03 15.12-70.39 11.29l13.55-54.33c15.36 3.828 64.84 10.97 56.85 43.03z"></path></svg>
            Pagar con Bitcoin
        </a>

    </div>
</div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/flowbite/1.8.1/flowbite.min.js"></script>
</body>
</html>