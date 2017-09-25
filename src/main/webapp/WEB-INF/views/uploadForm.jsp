<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



 <sf:form method="POST" commandName="code" enctype="multipart/form-data" >
      <sf:errors path="*" element="div" cssClass="errors" />
      <sf:label path="id" 
          cssErrorClass="error">Id</sf:label>: 
        <sf:input path="id" cssErrorClass="error" /><br/>
		
		<sf:label path="type" 
          cssErrorClass="error">Type</sf:label>: 
        <sf:input path="type" cssErrorClass="error" /><br/>
     
        <input path="codeLoc" type="file" /><br/>
     
      
      <input type="submit" value="Register" />
    </sf:form>

</body>
</html>