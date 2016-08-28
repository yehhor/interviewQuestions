<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/header.jsp"/>
<div class="container">
    <header class="jumbotron hero-spacer">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>question</th>
                <th>theme</th>
                <th>language</th>
                <th>Delete</th>
            </tr>
            </thead>
            <c:forEach items="${questionList}" var="q">
                <tr>
                    <td>${q.name}</td>
                    <td>${q.theme.name}</td>
                    <td>${q.language.name}</td>
                    <td><a href="questions/remove/${q.id}" class="btn btn-default">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </header>
    <hr>
    <form class="form-inline" method="post" action="questions/add">
        <div class="form-group">
            <label for="questionName">Question</label>
            <input type="text" class="form-control" name="questionName" id="questionName" placeholder="Question Text">
        </div>


        <select name="theme" class="form-control">
            <c:forEach items="${themeList}" var="t">
                <option value="${t.name}" class="btn btn-default">${t.name}</option>
            </c:forEach>
        </select>


        <select name="lang" class="form-control">
            <c:forEach items="${langList}" var="l">
                <option value="${l.name}" class="btn btn-default">${l.name}</option>
            </c:forEach>
        </select>

        <button type="submit" class="btn btn-default">Add new</button>
    </form>

    <form class="form-inline" method="post" action="theme/add">
        <div class="form-group">
            <label for="themeName">Theme</label>
            <input type="text" class="form-control" name="themeName" id="themeName" placeholder="Question Text">
        </div>
        <button type="submit" class="btn btn-default">Add new Theme</button>
    </form>

    <form class="form-inline" method="post" action="lang/add">
        <div class="form-group">
            <label for="langName">Language</label>
            <input type="text" class="form-control" name="langName" id="langName" placeholder="Question Text">
        </div>
        <button type="submit" class="btn btn-default">Add new Lang</button>
    </form>
    <!-- Title -->
    <div class="row">
        <div class="col-lg-12">
            <h3>Latest Features</h3>
        </div>
    </div>
    <!-- /.row -->

    <!-- Page Features -->
    <%--<div class="row text-center">--%>

    <%--<div class="col-md-3 col-sm-6 hero-feature">--%>
    <%--<div class="thumbnail">--%>
    <%--<img src="http://placehold.it/800x500" alt="">--%>
    <%--<div class="caption">--%>
    <%--<h3>Feature Label</h3>--%>
    <%--<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>--%>
    <%--<p>--%>
    <%--<a href="#" class="btn btn-primary">Buy Now!</a> <a href="#" class="btn btn-default">More--%>
    <%--Info</a>--%>
    <%--</p>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>

    <%--<div class="col-md-3 col-sm-6 hero-feature">--%>
    <%--<div class="thumbnail">--%>
    <%--<img src="http://placehold.it/800x500" alt="">--%>
    <%--<div class="caption">--%>
    <%--<h3>Feature Label</h3>--%>
    <%--<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>--%>
    <%--<p>--%>
    <%--<a href="#" class="btn btn-primary">Buy Now!</a> <a href="#" class="btn btn-default">More--%>
    <%--Info</a>--%>
    <%--</p>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>

    <%--<div class="col-md-3 col-sm-6 hero-feature">--%>
    <%--<div class="thumbnail">--%>
    <%--<img src="http://placehold.it/800x500" alt="">--%>
    <%--<div class="caption">--%>
    <%--<h3>Feature Label</h3>--%>
    <%--<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>--%>
    <%--<p>--%>
    <%--<a href="#" class="btn btn-primary">Buy Now!</a> <a href="#" class="btn btn-default">More--%>
    <%--Info</a>--%>
    <%--</p>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>

    <%--<div class="col-md-3 col-sm-6 hero-feature">--%>
    <%--<div class="thumbnail">--%>
    <%--<img src="http://placehold.it/800x500" alt="">--%>
    <%--<div class="caption">--%>
    <%--<h3>Feature Label</h3>--%>
    <%--<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>--%>
    <%--<p>--%>
    <%--<a href="#" class="btn btn-primary">Buy Now!</a> <a href="#" class="btn btn-default">More--%>
    <%--Info</a>--%>
    <%--</p>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>

    <%--</div>--%>
    <!-- /.row -->

    <hr>
    <jsp:include page="fragments/footer.jsp"/>
</div>
</body>
<!-- jQuery -->
<script src="webjars/jquery/3.1.0/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>

</html>
