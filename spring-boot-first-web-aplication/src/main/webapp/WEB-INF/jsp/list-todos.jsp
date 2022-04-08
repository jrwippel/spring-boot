<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Lists for ${name}</title>
</head>

<body>
    <H1>Your Todos</H1>
    <table>
        <caption> Your todo are</caption>
        <thead>
            <tr>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is it Done?</th>
            </tr>
        </thead>
        <tbody>
        JSTL for Loop
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.desc}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.done}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>


	<BR/>
	<a href="/add-todos">Add a Todo</a>
	<BR/>
	<a href="/list-todos-other-user">List Todo Other User</a>
</body>

</html>