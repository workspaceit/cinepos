<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:directive.include file="../layouts/header.jsp" />
</head>


<body>

<div id="wrapper">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <jsp:directive.include file="../layouts/navbar-top.jsp" />
    </nav>

    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Add Film Rental</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-6">
                    <form id="createFilmForm">
                        <div class="form-group">
                            <label>Film</label>
                            <select class="form-control" id="filmId" >
                                <d:forEach var="film" items="${films}" >
                                    <option value="${film.id}">${film.name}</option>
                                </d:forEach>
                            </select>
                            <p class="help-block error" id="errorMsg_filmId"></p>
                        </div>

                        <div class="form-group">
                            <label>Week Name</label>
                            <input id="weekName" class="form-control">
                            <p class="help-block error" id="errorMsg_weekName"></p>
                        </div>

                        <div class="form-group">
                            <label>Start Date</label>
                            <div class='input-group date'>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                <input id="startDate" type='text' class="form-control" name="date" placeholder="MM/DD/YYY" />

                            </div>
                            <p class="help-block error" id="errorMsg_startDate"></p>
                        </div>
                        <div class="form-group">
                            <label>End Date</label>
                            <div class='input-group date'>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
                                    </span>
                                <input type='text' class="form-control" id="endDate" name="date" placeholder="MM/DD/YYY" />

                            </div>
                            <p class="help-block error" id="errorMsg_endDate"></p>
                        </div>

                        <br>
                        <p class="help-block" id="statusMsg"></p>
                        <button class="btn btn-primary" onclick="return submitPriceShiftData()">Create Price Shift</button>
                    </form>
                </div>
            </div>
        </div>
        <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->

</div>

<jsp:directive.include file="../layouts/footer.jsp" />

<script>
    function submitPriceShiftData(){

        $("#statusMsg").html("").hide();

        var filmId =$("#filmId").val();
        var startDate =$("#startDate").val();
        var endDate =$("#endDate").val();
        var weekName =$("#weekName").val();
        enableDisableFormElement("createFilmForm",["input","button","select"],false);
        var postData={
            filmId:filmId,
            weekName:weekName
        };

        if(startDate)
            postData['startDate'] = startDate;
        if(endDate)
            postData['endDate'] = endDate;

        $.ajax({
            url: BASEURL+'api/admin/film-rental/create',
            type: 'POST',
            data: postData ,
            statusCode: {
                401: function (response) {
                    console.log("unauthorized");
                    console.log(response);
                    showLoginModal();
                    enableDisableFormElement("createFilmForm",["input","button","select"],true);
                },
                422: function (response) {
                    console.log(response);
                    $("#statusMsg").html("Error found").show();
                    BindErrorsWithHtml("errorMsg_",response.responseJSON);
                    enableDisableFormElement("createFilmForm",["input","button","select"],true);
                }
            },success: function(data){
                $("#statusMsg").html("Film Rental created successfully").show();
                setTimeout(function(){
                    window.location = BASEURL+"admin/film-rental/all";
                },2000);
            }
        });
        return false;
    }
</script>
</body>
</html>


