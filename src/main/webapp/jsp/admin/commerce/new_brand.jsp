<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/jsp/js/validation/brand.commerce.validation.js"></script>

<div class="new-brand">
    <form id="admin-brand-form" action="/admin.catalog.brand.do" method="post">
        <input type="hidden" name="action" value="create">
        <table class="admin-input">
            <tr>
                <td>Название бренда:</td>
                <td><input type="text" name="brandName" class="text-input"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Создать"></td>
            </tr>
        </table>
    </form>
</div>
