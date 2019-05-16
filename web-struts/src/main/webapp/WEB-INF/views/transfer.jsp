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
    <s:select list="persons" listKey="id" listValue="%{firstName+' '+lastName}" name="debit" label="Compte à débiter"/>
    <s:select list="persons" listKey="id" listValue="%{firstName+' '+lastName}" name="credit" label="Compte à créditer"/>
    <s:textfield name="ammount" label="Montant"/>
    <s:submit />
</s:form>
</body>
</html>