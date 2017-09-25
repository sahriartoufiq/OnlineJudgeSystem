<%--
  Created by IntelliJ IDEA.
  User: sahriar
  Date: 1/13/17
  Time: 12:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="table">


    <tr>
        <th>Submission Id</th>
        <th>User Name</th>
        <th>problem Id</th>
        <th>Result</th>

    </tr>

    <tbody>
    <c:forEach items="${sub}" var="submission">
        <tr>
            <td>${submission.id}</td>
            <td>${submission.users.userName}</td>
            <td>${submission.problems.id}</td>
            <td>${submission.judgeResult}</td>
           </tr>
    </c:forEach>
    </tbody>




</table>