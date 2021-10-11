<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cg.wbd.grandemonstration.service.CustomerService" %>
<%@ page import="cg.wbd.grandemonstration.service.CustomerServiceFactory" %>
<%@ page import="cg.wbd.grandemonstration.model.Customer" %>
<%@ page import="java.util.List" %>
<%!
    private CustomerService customerService = CustomerServiceFactory.getInstance();
%>
<%
    long count = customerService.count();
    List<Customer> customers = customerService.findAll();
%>
<style>
    table {
        border: 1px solid #000;
    }

    th, td {
        border: 1px dotted #555;
    }
</style>
There are <%= count %> customer(s) in list.
<table>
    <caption>Customers List</caption>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customerList}" var="customer">
    <tr>
        <td>
            ${customer.id}
        </td>
        <td>
            <a href="/customers/${customer.id}"> ${customer.name}</a>
        </td>
        <td>
            ${customer.email}
        </td>
        <td>
            ${customer.address}
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>