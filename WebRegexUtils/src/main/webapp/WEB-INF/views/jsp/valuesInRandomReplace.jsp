<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
	<head>
		<title>Web util project for replacing substrings in the text</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
		<script src="https://code.jquery.com/jquery-3.2.1.js" integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE=" crossorigin="anonymous"></script>
		<spring:url value="/resources/js/custom.js" var="customJs"/>
		<script src="${customJs}"></script>
	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="numbersReplace">Sequence Numbers Replacer</a>
					<span class="navbar-brand"> | </span>
					<a class="navbar-brand" href="valuesInRandomReplace">Values In Random Replacer</a>
				</div>
			</div>
		</nav>
		
		<div class="jumbotron">
			<div class="container">
				<div class="row">
					<h3>
						In the next form input text and string-replacement which should be replaced.
						<small>Every occurrence will be replaced with <b>one (chosen randomly)</b> replacing from the input.</small>
					</h3>
					<form:form class="form-horizontal" method="post" modelAttribute="textFormBean" action="valuesInRandomReplace">
						<form:textarea path="text" class="form-control" rows="10"/><br/>
						<div class="form-group col-md-4">
							<label for="replacement">Substrings to be replaced:</label>
							<form:input path="replacement" type="text" class="form-control"/>
							<label for="replacings">Possible values for replacing:</label>
							<div>
								<c:forEach var="replacing" items="${textFormBean.replacings}">
									<form:input path="replacings" type="text" value="${replacing}" class="form-control"/>
								</c:forEach>
								<button id="clone-replacing" class="btn btn-default" type="button">+</button>
							</div>
							<div class="navbar-text">
								<button type="submit" class="btn btn-default">Replace</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		
		<div class="container">
			<div class="row">
				<textarea class="form-control" rows="10">${resultText}</textarea>
			</div>
		</div>
		
	</body>
</html>