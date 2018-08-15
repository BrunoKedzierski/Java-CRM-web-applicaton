<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bruno
  Date: 14.08.18
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../WEB-INF/fragments/header.jsp"/>
<h1 style="text-align: center;"> Add order</h1>
<hr>
<form action="/orders-add" method="post" >
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Date recieved</label>
        <input type="Date" class="form-control" placeholder="Date recieved" name="recieved" required>
        </label>

    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Planned beginnging</label>
        <input type="date" class="form-control" placeholder="Planned beginnging" name="planedBeginning" required>
        </label>
    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Begun</label>
        <input type="Date" class="form-control" placeholder="Begun" name="begun" >
        </label>
    </div>
    <div class="form-group">
        <label for="exampleFormControlSelect4">Vehicle id</label>
        <select class="form-control" id="exampleFormControlSelect4" name="id" required>
            <c:forEach var="employee" items="${employees}">
                <option value="${employee.id}">Id:${employee.id} - ${employee.name} ${employee.surname}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Problem description</label>
        <input type="text" class="form-control" placeholder="Problem Description" name="problemDescription" >
        </label>
    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Repair description</label>
        <input type="text" class="form-control" placeholder="Repair Description" name="repairDescription" required>
        </label>
    </div>
    <div class="form-group">
        <label for="exampleFormControlSelect1">Status</label>
        <select class="form-control" id="exampleFormControlSelect1" name="status" required>
            <option value="ACCEPTED">Accepted</option>
            <option value="APPROVED_EXPENSES"> Approved expenses</option>
            <option value="REPAIR_IN_PROGRESS">In progress</option>
            <option value="REPAIR_COMPLETE">Complete</option>
            <option value="RESIGNATION">Resignation</option>
        </select>
    </div>
    <div class="form-group">
        <label for="exampleFormControlSelect2">Vehicle id</label>
        <select class="form-control" id="exampleFormControlSelect2" name="id" required>
            <c:forEach var="vehicles" items="${vehicles}">
                <option value="${vehicles.id}">Id:${vehicles.id} - ${vehicles.brand} ${vehicles.model}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Price</label>
        <input type="Number" min="10" step="0,01" class="form-control" placeholder="Price" name="price" required>
        </label>
    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Expenses</label>
        <input type="Number" min="10" step="0,01" class="form-control" placeholder="expenses" name="expenses" >
        </label>
    </div>
    <div class="form-group" style="margin-left: auto;margin-right: auto;">
        <label>Manhours</label>
        <input type="Number" min="1" step="0,5" class="form-control" placeholder="manhours" name="manhours" >
        </label>
    </div>


    <button type="submit" class="btn-lg btn-primary" style="float: right" value="submit">Add       <i class="fas fa-plus"></i></button>
</form>

<jsp:include page="../WEB-INF/fragments/footer.jsp"/>
</html>