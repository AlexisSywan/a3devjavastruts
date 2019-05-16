<%@page pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Transfer Account</title>
</head>
<body>
<s:actionerror />
<s:actionmessage />
<s:form action="transfer_save">
    <s:select list="bankAccounts" listKey="id" listValue="%{owner.firstName+' '+owner.lastName+' '+balance}" name="debit" label="Compte à débiter"/>
    <s:select list="bankAccounts" listKey="id" listValue="%{owner.firstName+' '+owner.lastName+' '+balance}" name="credit" label="Compte à créditer"/>
    <s:textfield name="ammount" label="Montant"/>
    <s:submit />
</s:form>
<c:url var="application" value="/" />
<a href="${application}"> <input type="button" value="Accueil"></a>
<a href="${application}bankaccount_all"> <input type="button" value="Comptes Bancaires"></a>
<a href="${application}person_all"> <input type="button" value="Personnes"> </a>
</body>
</html>