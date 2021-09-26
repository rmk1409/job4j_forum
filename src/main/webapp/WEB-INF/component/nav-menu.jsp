<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="row">
    <ul class="nav">
        <c:if test="${authUser == null}">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/login'/>">Войти</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"
                   href="<c:url value='/reg'/>">Регистрация</a>
            </li>
        </c:if>
        <c:if test="${authUser != null}">
            <li class="nav-item">
                <a class="nav-link"
                   href="<c:url value='/index'/>">Объявления</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/edit'/>">Добавить
                    объявление</a>
            </li>
        </c:if>
        <c:if test="${authUser != null}">
            <li class="nav-item">
                <c:out value="${authUser.name}"/>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/logout'/>">Выйти</a>
            </li>
        </c:if>
    </ul>
</div>
