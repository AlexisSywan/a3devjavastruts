<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title></title>
    <s:head/>
</head>
<body>
<s:actionerror/>
<s:actionmessage/>
<s:form method="post" action="person_save">
    <s:hidden name="person.id"/>
    <s:textfield name="person.firstName" label="Prénom"/>
    <s:textfield name="person.lastName" label="Nom"/>
    <s:textfield name="person.email" label="Email"/>
    <s:textfield name="person.birthDate" type="date" label="Date de naissance"/>
    <s:submit />
</s:form>
    <table>
        <thead>
        <tr>
            <th>Id</th>
            <th>Prénom</th>
            <th>Nom</th>
            <th>Email</th>
            <th>Date de naissance</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="person" items="${persons}" >
            <tr>
                <td>${person.id}</td>
                <td>${person.firstName}</td>
                <td>${person.lastName}</td>
                <td>${person.email}</td>
                <td><fmt:formatDate value="${person.birthDate}" type="date" pattern="dd/MM/yyyy" /></td>
                <td>
                    <s:form action="person_edit">
                        <input type="hidden" name="id" value="${person.id}"/>
                        <s:submit value="Modifier"/>
                    </s:form>
                </td>
                <td>
                    <s:form action="person_delete">
                        <input type="hidden" name="id" value="${person.id}"/>
                        <s:submit value="Supprimer"/>
                    </s:form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
<c:url var="application" value="/" />
<a href="${application}"> <input type="button" value="Accueil"></a>
<a href="${application}bankaccount_all"> <input type="button" value="Comptes Bancaires"></a>
<a href="${application}transfer_all"> <input type="button" value="Virement"> </a>
</body>
</html>
