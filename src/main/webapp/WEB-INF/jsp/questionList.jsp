<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<link rel="stylesheet" href="webjars/datatables/1.10.5/css/jquery.dataTables.min.css"/>
<body>
<jsp:include page="fragments/header.jsp"/>
<div class="container">
    <header class="jumbotron hero-spacer">
        <table class="table table-striped" id="dataTable">
            <thead>
            <tr>
                <th>question</th>
                <th>theme</th>
                <th>language</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            </thead>
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


    <hr>
    <jsp:include page="fragments/footer.jsp"/>
</div>
<div class="modal fade" id="addAnswer">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">New Answer</h2>
            </div>
            <div class="modal-body">
                <form class="form-inline" method="post" id="addAnswerForm">
                    <div class="form-group">
                        <input type="hidden" id="questionId" name="questionId">
                        <label for="questionName1">Text</label>
                        <input type="text" class="form-control" name="text" id="questionName1" placeholder="Answer Text">
                    </div>
                    <button type="submit" class="btn btn-default">Add</button>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="showAnswers">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title">Answers</h2>
            </div>
            <div class="modal-body">
                <table class="table table-striped" id="dataTableAnswers">
                    <thead>
                    <tr>
                        <th>name</th>
                        <th></th>
                    </tr>
                    </thead>

                </table>
            </div>
        </div>
    </div>
</div>
</body>
<!-- scripts -->
<script src="webjars/jquery/3.1.0/jquery.js"></script>
<script type="text/javascript" src="webjars/datatables/1.10.5/js/jquery.dataTables.min.js"></script>
<script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
<script src="resources/js/datatableUtil.js"></script>
<script src="resources/js/btnRenders.js"></script>

</html>
