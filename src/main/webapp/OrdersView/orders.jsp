<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: bruno
  Date: 13.08.18
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<jsp:include page="../WEB-INF/fragments/header.jsp"/>


<!-- Page Content -->
<div class="card mb-3">
    <div class="card-header">
        <i class="fas  fa-users"></i>
        Clients</div>
    <div class="card-body">
        <div class="table-responsive">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead>
                <tr>
                    <th>Recieved</th>
                    <th>Planned beginning</th>
                    <th>Begun</th>
                    <th>Worker</th>
                    <th>Problems note</th>
                    <th>Repair description</th>
                    <th>Repair description</th>
                    <th>Status</th>
                    <th>Vehicle</th>
                    <th>Price</th>
                    <th>Manhour</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
                </thead>
                <tfoot>
                <tr>
                    <th>Recieved</th>
                    <th>Planned beginning</th>
                    <th>Begun</th>
                    <th>Worker</th>
                    <th>Problems note</th>
                    <th>Repair description</th>
                    <th>Repair description</th>
                    <th>Status</th>
                    <th>Vehicle</th>
                    <th>Price</th>
                    <th>Manhour</th>
                    <th>Delete</th>
                    <th>Edit</th>
                </tr>
                </tfoot>
                <tbody>
                <c:forEach var="order" items="${orders}">
                    <tr>
                        <td>${order.received}</td>
                        <td>${order.planedBeginning}</td>
                        <td>${order.begun}</td>
                        <td>${order.employee.surname}</td>
                        <td>${order.problemDescription}</td>
                        <td>${order.repairDescription}</td>
                        <td>${order.status.description}</td>
                        <td>#${order.vehicle.id} ${order.vehicle.model}</td>
                        <td>${order.price}</td>
                        <td>${order.expense}</td>
                        <td>${order.manhours}</td>
                        <td><a href="/orders-del?id=${order.id}">Delete <i class="fas fa-trash-alt"></i></a>  </td>
                        <td><a href="/customer-edit?id=${order.id}">Edit <i class="fas fa-edit"></i></a> </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
        <a href="/orders-add" class="btn btn-primary" style="float: right" ole="button">Add </a>
    </div>
    <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
</div>

</div>
<jsp:include page="../WEB-INF/fragments/footer.jsp"/>

</html>
