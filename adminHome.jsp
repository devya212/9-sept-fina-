<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <%@taglib uri="http://www.springframework.org/tags" prefix="msg"%>
<msg:url value="/resources/vg1.jpg" var="bg"/>
<jsp:include page="navbar1.jsp"/>

</head>


<body style="background-size:cover;height:100%;width:100%;background-image:url(${bg});">

</body>
</html>