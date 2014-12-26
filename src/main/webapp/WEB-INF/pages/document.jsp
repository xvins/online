<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Documents</title>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="span8 offset2">
            <h3>Documents</h3>
        </div>
    </div>
    <form:form action="document.do" method="POST" modelAttribute="document">
        <table>
            <tr>
                <td>ID</td>
                <td><form:input path="id" /></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>Type</td>
                <td><form:input path="type" /></td>
            </tr>
            <tr>
                <td>Content</td>
                <td><form:input path="content" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" name="action" value="Edit" />
                    <input type="submit" name="action" value="Delete" />
                </td>
            </tr>
        </table>
    </form:form>

    <table border="1" cellpadding="2" cellspacing="2" width="500">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Type</th>
            <th>Content</th>
        </tr>
        <c:forEach items="${documentList}" var="document"  >
            <tr>
                <td>${document.id}</td>
                <td>${document.name}</td>
                <td>${document.type}</td>
                <td>${document.content}</td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="<spring:url value="/createdocument" /> ">Add a new document</a><br>
</div>
</div>
</div>
</body>
</html>
