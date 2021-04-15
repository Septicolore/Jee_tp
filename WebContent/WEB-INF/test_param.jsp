<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--@ import class="java.util.List" --%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
	.red{
		color:red;
	}
	
	.black{
		color:black;
	}
	
	.language{
		margin:3px;
		padding: 7px;
		background-color: rgba(0,0,0,0.7);
		font-weight:700;
		border-radius: 4px;
		color:#ffff00;
	}
</style>

<title>Insert title here</title>
</head>
<body> 
	<%--
		String nickname = (String) request.getAttribute("nickname");
		String yearsOld = (String) request.getAttribute("yearsOld"); 
		String path = (String) request.getContextPath(); --%>
		
	<c:import url="header.jsp"/>
	
	<ul>
		<li>Mon pseudo : ${ nickname }</li>
		<li>Mon age : ${ yearsOld }</li>
	</ul>
	
	name : ${ toto == null ? "pas de toto" : toto }
	
	<br>

	<a href="${ pageContext.request.contextPath }/test_param?username=toto&age=12">Toto</a>
	
	
	<a 
		href ="<c:url value="/test_param">
		<c:param name="username" value="toto"></c:param>
		<c:param name="age" value="12"></c:param>
	</c:url>">Lien version c:url</a>
	
	
	
	<br>
	
	<p>Le second élément de ma liste de noms est : ${ listeDeNom.get(1) }</p>
	
	<p>L'âge de Cubitus est : ${ listeAge.Cubitus } ans</p>
	
	<%--
		for(String name : (List)request.getAttribute("listeDeNom"))
	--%>
	
	<c:out value="première balise jstl" />
	
	<c:if test="${listeDeNom.size() > 2 }">
		<p style="color: red;">La taille de la liste de noms est supérieur à 2</p>
		
		<c:choose>
			<c:when test="${listeDeNom.contains('samuel')}">Samuel existe dans la liste</c:when>
			<c:when test="${listeDeNom.contains('lony')}">lony existe dans la liste</c:when>
			<c:when test="${listeDeNom.contains('marjolaine')}">marjolaine existe dans la liste</c:when>
			<c:otherwise>Otherwise</c:otherwise>
		</c:choose>
	</c:if>
	</br>	</br>
	quel ages as-tu ? &nbsp;
	<select>
		<c:forEach var="i" begin="18" end="120" step="1">
			<option value="${i}">${i}</option>
		</c:forEach>
	</select>

	<!-- on commence a partir du troisième élément (index 2) du tableau dans Servlet TestInitParam -->
	<ul>
		<c:forEach items="${listeDeNom}" var="name" begin="2" end="10" varStatus="status">
			<li class="${status.first || status.last ? 'red' : 'black' }">
				position dans le forEach => ${status.count} - position dans le tableau => ${status.index}: ${name}
			</li>
		</c:forEach>
	</ul>
	
	<c:set 
	var="languages"
	value="kotlin,java,golang,rust,php,js,html,css,python,flutter,symfony,springboot"
	scope="page"
	/>
	
	<div>
		<c:forTokens items="${languages}" delims="," var="language">
			<span class="language">${language}</span>
		</c:forTokens>
	</div>	
	
	

	
</body>
</html>