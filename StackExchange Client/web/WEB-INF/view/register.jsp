<%-- 
    Document   : register
    Created on : Nov 22, 2015, 6:32:31 PM
    Author     : Acer
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="header.jsp" flush="true"/>

<div class="container">
        <h3>Register</h3>
        <hr class="heading">  
        
        <div class="inner-container">
            <!-- <div class="register-wrapper"> -->
                <c:choose>
                    <c:when test="${not empty error}"> <!-- error message -->
                        <div class="alert alert-danger" role="alert">
                            <c:out value="${error}" />
                        </div>
                    </c:when>
                    <c:when test="${not empty success}"> <!-- success message -->
                        <div class="alert alert-success" role="alert">
                            <c:out value="${success}" />
                        </div>
                    </c:when>
                </c:choose>
                
                <form class="register-wrapper form-horizontal" method="POST">
                    <div class="form-group">
                        <label for="inputName" class="col-sm-2 control-label">Name</label>
                        <div class="col-sm-10">
                            <input type="text" name="name" class="form-control" id="inputName" placeholder="Name" required autofocus>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputEmail" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-10">
                            <input type="email" name="email" class="form-control" id="inputEmail" placeholder="Email" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword" class="col-sm-2 control-label">Password</label>
                        <div class="col-sm-10">
                            <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Register</button>
                        </div>
                    </div>
                </form>
                
                
            <!-- </div> -->
        </div>
        
    </div>

<jsp:include page="footer.jsp" flush="true"/>
