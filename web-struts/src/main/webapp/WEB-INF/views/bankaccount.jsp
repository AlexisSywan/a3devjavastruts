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
    <s:textfield name="bankAccount.balance" label="Solde"/>
    <s:select list="persons" listKey="id" listValue="firstName" name="bankAccount.owner.id" />
    <%--    <s:select list="" label="Propriétaire"/>--%>
    <s:submit />
</s:form>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Solde</th>
        <th>Propriétaire</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="bankAccount" items="${bankAccounts}">
        <tr>
            <td>${bankAccount.id}</td>
            <td>${bankAccount.balance}</td>
            <td>${bankAccount.owner.id}</td>
                <%--            <td><a href="${context}delete/${person.id}" onclick="return confirm('Etes-vous sûr de vouloir supprimer cette personne ?')">Supprimer</a></td>--%>
                <%--            <td><button onclick="edit(event);">Modifier</button></td>--%>
                <%--            <td>--%>
                <%--                <s:form action="bankAccount_delete" onclick="return confirm('Etes-vous sûr de vouloir supprimer ce compte ?')">--%>
                <%--                    <input type="hidden" name="id" value="${bankAccount.id}"/>--%>
                <%--                    <s:submit value="supprimer" />--%>
                <%--                </s:form>--%>
                <%--            </td>--%>
                <%--            <td>--%>
                <%--                <s:form action="person_edit" onclick="return confirm('Etes-vous sûr de vouloir éditer cette personne ?')">--%>
                <%--                    <input type="hidden" name="id" value="${person.id}"/>--%>
                <%--                    <s:submit value="Modifier" />--%>
                <%--                </s:form>--%>
                <%--            </td>--%>
                <%--            <td><button onclick="edit(event);">Modifier</button></td>--%>
                <%--            <td><a href="${context}${person.id}">Modifier</a></td>--%>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%--<form method="post" action="${save}">--%>
<%--    <table>--%>
<%--      <thead>--%>
<%--        <tr>--%>
<%--          <th>Propriétaire</th>--%>
<%--          <th>Solde</th>--%>
<%--        </tr>--%>
<%--      </thead>--%>
<%--      <tbody>--%>
<%--        <tr>--%>
<%--            <td><select name="owner">--%>
<%--                <option></option>--%>
<%--                <c:forEach var="person" items="${persons}">--%>
<%--                    <option value="${person.id}">${person.firstName} ${person.lastName}</option>--%>
<%--                </c:forEach>--%>
<%--            </select></td>--%>
<%--          <td><input name="balance"/></td>--%>
<%--          <td><input type="submit" /></td>--%>
<%--        </tr>--%>
<%--        <c:forEach var="account" items="${accounts}">--%>
<%--          <tr>--%>
<%--            <td>${account.owner.firstName} ${account.owner.lastName}</td>--%>
<%--            <td>${account.balance}</td>--%>
<%--          </tr>--%>
<%--        </c:forEach>--%>
<%--      </tbody>--%>
<%--    </table>--%>
<%--</form>--%>
</body>
</html>