<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="manage-links">
    <h3>
       <ul>
        <li><a href="/admin.settings.do?settingsMode=links">Настройка отображения ссылок</a></li>
        <li><a href="${pageContext.request.contextPath}/jsp/admin/content/new_link_content.jsp">Добавить новую ссылку</a></li>
      </ul>
    </h3>

    <c:set var="linkLength" value="${fn:length(linkList)}"/>
    <c:if test="${linkLength > 0}">
        <c:forEach items="${linkList}" var="link">
            <ul>
             <li><img src="${link.linkImagePath}"/></li>
             <li>${link.linkValue}</li>
             <li><a href="/admin.content.link.do?action=edit&contentId=${link.contentId}">Редактировать</a></li>
             <li><a href="/admin.content.link.do?action=edit&contentId=${link.contentId}&editImage=true">Изменить иконку ссылки</a></li>
             <li><a href="/admin.content.link.do?action=delete&contentId=${link.contentId}&linkImageFilePath=${link.linkImageFilePath}">Удалить</a></li>
            </ul>
            <hr/>
        </c:forEach>
    </c:if>

</div>
