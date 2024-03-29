<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- /#wrapper -->

<!-- jQuery -->
<script src="<c:url value="/admin-resources/jquery/jquery.min.js"/>"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/admin-resources/bootstrap/js/bootstrap.min.js"/>"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="<c:url value="/admin-resources/metisMenu/metisMenu.min.js"/>"></script>

<!-- Select -->
<script src="<c:url value="/admin-resources/bootstrap/js/bootstrap-select.min.js"/>"></script>

<script src="<c:url value="/admin-resources/datatables/js/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="/admin-resources/datatables-plugins/dataTables.bootstrap.min.js"/>"></script>
<script src="<c:url value="/admin-resources/datatables-responsive/dataTables.responsive.js"/>"></script>



<!-- Custom Theme JavaScript -->
<script src="<c:url value="/admin-resources/dist/js/sb-admin-2.js"/>"></script>

<script src="<c:url value="/admin-resources/dropzone/dropzone.js"/>"></script>


<!-- Include Date Range Picker -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>

<%--Developer Custom Js--%>
<script type="text/javascript" src="<c:url value="/resources/js/helper/ErrorMessaging.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/auth-script/login.js"/>"></script>
<script>
    var BASEURL = "<c:url value="/" />";
    $(document).ready(function(){
        var date_input=$('input[name="date"]'); //our date input has the name "date"
        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
        date_input.datepicker({
            format: 'mm/dd/yyyy',
            container: container,
            todayHighlight: true,
            autoclose: true,
        });
    });

    $(document).ready(function() {
        $('#dataTables').DataTable({
            responsive: true
        });
    });


    function doLogout(){

        $.ajax({
            url: BASEURL+'auth/admin/do-logout',
            type: 'GET',
            success: function (data) {
                console.log("SUCCESS");
                console.log(data);
                window.location = BASEURL+"admin-login/auth";
            }
        });
        return false;
    }


</script>

