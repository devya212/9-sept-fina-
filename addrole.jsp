<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


</head>
<body>

<%@include file="navbar1.jsp" %>
<security:accesscontrollist hasPermission="" domainObject=""></security:accesscontrollist>
<div class="container">
    <div class="row">
         <div class="col-sm-6 col-md-4 col-md-offset-4"> 
            <div class="account-wall">
              ADD NEW ROLE:
                <s:form class="form-signin" method="post" action="insertRole" modelAttribute="role">
                 <s:label path="roleid">Enter Role ID:</s:label>
                <s:input path="roleid" class="form-control" id="code" placeholder="Role Id"/>
                 <br>
                 <s:label path="rolename">Enter Role Name:</s:label>
                <s:input path="rolename" class="form-control" id="code" placeholder="Role Name"/>
                 <br>
                <button class="btn btn-lg btn-primary btn-block" type="submit" name="b1" value="delete">SUBMIT</button>
                ${errmsg}
               
                </s:form>
            
    </div>
    </div>
        
    </div>
</div>

</body>
</html>