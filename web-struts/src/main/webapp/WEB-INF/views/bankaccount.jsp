<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="utf-8" />
    <title></title>
</head>
<body>
<s:actionerror />
<s:actionmessage />
<s:form action="bankaccount_save">
    <s:hidden name="bankAccount.id" />
    <s:select list="persons" listKey="id" label="Propriétaire" listValue="%{firstName+' '+lastName}" name="bankAccount.owner.id" />
    <s:textfield name="bankAccount.balance" label="Solde"/>
    <s:submit />
</s:form>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Prénom</th>
        <th>Nom</th>
        <th>Solde</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="bankAccount" items="${bankAccounts}">
        <tr>
            <td>${bankAccount.id}</td>
            <td>${bankAccount.owner.firstName}</td>
            <td>${bankAccount.owner.lastName}</td>
            <td>${bankAccount.balance}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:url var="application" value="/" />
<a href="${application}"> <input type="button" value="Accueil"></a>
<a href="${application}person_all"> <input type="button" value="Personnes"></a>
<a href="${application}transfer_all"> <input type="button" value="Virement"> </a>
</body>
</html>