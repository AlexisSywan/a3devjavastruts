<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8" />
    <title></title>
</head>
<body>
<form method="post" action="${save}">
<table>
    <thead>
    <tr>
        <th>Propriétaire</th>
        <th>Solde</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><select name="owner">
            <option></option>
            <c:forEach var="person" items="${persons}">
                <option value="${person.id}">${person.firstName} ${person.lastName}</option>
            </c:forEach>
        </select></td>
        <td><input name="balance" /></td>
        <td><input type="submit" /></td>
    </tr>
    <c:forEach var="account" items="${accounts}">
        <tr>
            <td>${account.owner.firstName} ${account.owner.lastName}</td>
            <td>${account.balance}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</form>
<a href="http://localhost:8080/Gradle___a3devjavaee___a3devjavaee_1_0_SNAPSHOT_war__exploded_/"> <input type="button" value="Accueil"></a>
<a href="http://localhost:8080/Gradle___a3devjavaee___a3devjavaee_1_0_SNAPSHOT_war__exploded_/person"> <input type="button" value="Personnes"></a>
<a href="http://localhost:8080/Gradle___a3devjavaee___a3devjavaee_1_0_SNAPSHOT_war__exploded_/transfer"> <input type="button" value="Virement"> </a>
</body>
</html>