
<%@page import="Dto.Student"%>
<%@page import="java.util.List"%>
<%@page import="Dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg text-light bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand text-light" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active text-light" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-light" href="register.jsp">Register</a>
        </li>
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-light text-light" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
<!-- Navbar -->
	<% 
        StudentDao dao = new StudentDao();
        List<Student> students = dao.viewAll();
    %>
<h1 class="text-center p-2 text-secondary">School Admission Record</h1>
<table class="table table-striped table-hover table-bordered align-middle text-center table-sm">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Date of Birth</th>
      <th scope="col">Class</th>
      <th scope="col">Edit</th>
      <th scope="col">Delete</th>
    </tr>
  </thead>
        <tbody>
   
          <%
    if (students!= null &&!students.isEmpty()) {
        for (Student student : students) {
            %>
            <tr>
                <td><%= student.getId() %></td>
                <td><%= student.getId() %></td>
                <td><%= student.getName() %></td>
                <td><%= student.getDob() %></td>
                <td><%= student.getStd() %></td>
                <td><a class="btn btn-success btn-sm" href="editstudent?id=<%= student.getId() %>">Edit</a></td>
                <td><a class="btn btn-danger btn-sm" href="deletestudent?id=<%= student.getId() %>">Delete</a></td>
            </tr>
            <%
        }
    } else {
        %>
        <tr>
            <td colspan="7">No students found.</td>
        </tr>
        <%
    }
%>
        </tbody>

</table>

<footer class="bg-body-tertiary text-center fixed-bottom">
  <!-- Grid container -->
  <div class="container p-4"></div>
  <!-- Grid container -->

  <!-- Copyright -->
  <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.05);">
    © 2020 Copyright:
    <a class="text-body" href="https://mdbootstrap.com/">MDBootstrap.com</a>
  </div>
  <!-- Copyright -->
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1e"></script>
</body>
</html>
