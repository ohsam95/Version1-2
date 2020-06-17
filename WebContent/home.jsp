<%@page import="com.cos.product.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"> <!--  -->
  <title>버전 1</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h2>버전 1</h2>

 <button onclick="first()" type="button" class="btn btn-primary">처음으로</button>
 <button onclick="priceDESC()" type="button" class="btn btn-primary">가격순</button>
 <button onclick="countDESC()" type="button" class="btn btn-primary">판매순</button>            
  <table class="table table-hover">
    <thead>
      <tr>
        <th>번호</th>
        <th>이름</th>
        <th>종류</th>
        <th>가격</th>
        <th>판매수</th>
        <th>삭제</th>
      </tr>
    </thead>
    <tbody id = "table">
        <c:forEach var = "product" items="${products}">
      <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.type}</td>
        <td>${product.price}</td>
        <td>${product.count}</td>		
        <td><i onclick="deleteById(${product.id})" style="font-size:30px; cursor: pointer;" class="material-icons">delete</i></td>		
      </tr>
<%-- <input type="hidden" name="id" value="${product.id}" > --%>
      </c:forEach>
    </tbody>

  </table>
</div>
<script>
function first(){
	$.ajax({
		type: "get",
		url:"/product/product?cmd=first",
		dataType: "json"
		}).done(function(result) {
			
			$("#table").empty();	
			for (var product of result) {
				var string =
					"<tr>\r\n" + 
					"			        <td>"+product.id+"</td>\r\n" + 
					"			        <td>"+product.name+"</td>\r\n" + 
					"			        <td>"+product.type+"</td>\r\n" + 
					"			        <td>"+product.price+"</td>\r\n" + 
					"			        <td>"+product.count+"</td>\r\n" + 
					"					<td><i onclick=\"deleteById("+product.id+")\" style=\"font-size:30px; cursor: pointer;\" class=\"material-icons\">delete</i></td>" 
					"			      </tr>";
			      
					$("#table").append(string);
				
			}
		}).fail(function(error) {
			alert("뭔가 잘못됐어요....휴...");
		});
}

function priceDESC(){
	$.ajax({
		type: "get",
		url:"/product/product?cmd=price",
		dataType: "json"
		}).done(function(result) {
		
			$("#table").empty();	
			for (var product of result) {
				var string =
					"<tr>\r\n" + 
					"			        <td>"+product.id+"</td>\r\n" + 
					"			        <td>"+product.name+"</td>\r\n" + 
					"			        <td>"+product.type+"</td>\r\n" + 
					"			        <td>"+product.price+"</td>\r\n" + 
					"			        <td>"+product.count+"</td>\r\n" +
					"					<td><i onclick=\"deleteById("+product.id+")\" style=\"font-size:30px; cursor: pointer;\" class=\"material-icons\">delete</i></td>"
					"			      </tr>";
			      
					$("#table").append(string);
				
			}
		}).fail(function(error) {
			alert("뭔가 잘못됐어요....휴...");
		});
}
function countDESC(){
	$.ajax({
		type: "get",
		url:"/product/product?cmd=count",
		dataType: "json"
		}).done(function(result) {
		
			$("#table").empty();	
			for (var product of result) {
				var string =
					"<tr>\r\n" + 
					"			        <td>"+product.id+"</td>\r\n" + 
					"			        <td>"+product.name+"</td>\r\n" + 
					"			        <td>"+product.type+"</td>\r\n" + 
					"			        <td>"+product.price+"</td>\r\n" + 
					"			        <td>"+product.count+"</td>\r\n" +
					"					<td><i onclick=\"deleteById("+product.id+")\" style=\"font-size:30px; cursor: pointer;\" class=\"material-icons\">delete</i></td>"
					"			      </tr>";
			      
					$("#table").append(string);
				
			}
		}).fail(function(error) {
			alert("뭔가 잘못됐어요....휴...");
		});
}
function deleteById(id){
	$.ajax({
		type: "get",
		url:"/product/product?cmd=delete",
		data : "id="+id,
		dataType: "json"
		}).done(function(result) {
		
			alert("삭제되었습니다.")
			
			$("#table").empty();	
			for (var product of result) {
				var string =
					"<tr>\r\n" + 
					"			        <td>"+product.id+"</td>\r\n" + 
					"			        <td>"+product.name+"</td>\r\n" + 
					"			        <td>"+product.type+"</td>\r\n" + 
					"			        <td>"+product.price+"</td>\r\n" + 
					"			        <td>"+product.count+"</td>\r\n" + 
					"					<td><i onclick=\"deleteById("+product.id+")\" style=\"font-size:30px; cursor: pointer;\" class=\"material-icons\">delete</i></td>"
					"			      </tr>";
			      
					$("#table").append(string);
				
			}
		}).fail(function(error) {
			alert("뭔가 잘못됐어요....휴... 델리트....");
		});
}

</script>



</body>
</html>