<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title><tiles:getAsString name="title"/></title>
</head>
<body>

<nav class="navbar navbar-inverse " th:fragment="navbartop">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">JU OJ</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li class="active"><a href="#">Volume</a></li>
            <li class="active"><a href="#">Contest</a></li>
            <li class="active"><a href="#">Contact Us</a></li>
            <li class="active"><a href="#">FAQ</a></li>

        </ul>
        <ul class="nav navbar-nav navbar-right">

            <li>
                <c:if test="${pageContext.request.userPrincipal.name == null}">
            <li>

            <a href="<c:url value="/register"/>"> Register</a>
            </li>
            <li>
                <a href="<c:url value="/login"/>"> Login</a>
            </li>
            </c:if>


            <c:if test="${pageContext.request.userPrincipal.name != null}">

                <li><a>Hi, ${pageContext.request.userPrincipal.name}</a></li>
                <li>
                    <a href="<c:url value="/logout"/>"> Logout</a>
                </li>
            </c:if>


        </ul>
    </div>
</nav>

<div class="container fill" th:fragment="header">
    <div class="row">
        <div class="col-sm-3">

            <div class="panel panel-primary">
                <div class="list-group">
                    <a href="/OnlineJudgeSystem" class="list-group-item">Home</a>
                    <a href="/OnlineJudgeSystem/submitCode" class="list-group-item">Submit Code</a>
                    <a href="/OnlineJudgeSystem/saveProblem" class="list-group-item">Submit Problem</a>
                    <a href="/OnlineJudgeSystem/viewSubmissions" class="list-group-item">View Submissions</a>
                </div>
            </div>


        </div>

        <div class="col-sm-9">

            <div class="panel panel-primary">
                <div class="panel-heading"></div>
                <div class="panel-body">
                    <tiles:insertAttribute name="custom"/>
                </div>
            </div>
        </div>
    </div>

</div>


<nav class="navbar navbar-inverse navbar-fixed-bottom  " th:fragment="navbartop">
    <p class="bg-info text-center">Copyright</p>
</nav>

</body>
</html>