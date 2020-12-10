<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.*"%>
<%@ page import ="Controller.model.Transaction"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
   		<tr>
   			<th>Transaction ID</th>
   			<th>From Account</th>
   			<th>To Account</th>
   			<th>Amount</th>
   		</tr>
   		<c:forEach items="${tlist}" var="trans">
        <tr>
        	<td><c:out value="${trans.t_id}"></c:out></td>
            <td><c:out value="${trans.from_acc}"></c:out></td>
            <td><c:out value="${trans.to_acc}" ></c:out></td>
            <td><c:out value="${trans.amt}"></c:out></td>
        </tr>
    </c:forEach>    
</table> 	
 <li><a href="welcome.jsp">Back to home Page</a></li></ul>

</body>
</html>