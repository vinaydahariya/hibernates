<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Notes</title>
<%@include file="all_js_css.jsp" %>
</head>
<body>
	<div class="container">
    	<%@include file="navbar.jsp" %>
    	<br>
    	<h1>Pleae fill your note detail</h1>
    	<form action="SaveNoteServlet" method="post">"
		  <div class="form-group">
		    <label for="title">Note title</label>
		    <input 
		    	required="required"
		    	name="title"
		    	type="text" 
		    	class="form-control" 
		    	id="title" aria-describedby="emailHelp" 
		    	placeholder="Enter here">
		  </div>
		  <div class="form-group">
		    <label for="content">Note content</label>
		    <textarea 
		    	required="required"
		    	name="content"
		    	class="form-control"
		    	id="content" 
		    	placeholder="Enter your content here"
		    	style="height: 300px"></textarea>
		  </div>
		  <div class="container text-center">
		  	<button type="submit" class="btn btn-dark purple">Add</button>
		  </div>
		</form>
    </div>
</body>
</html>