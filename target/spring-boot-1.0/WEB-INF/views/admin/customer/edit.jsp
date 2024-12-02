<%--
  Created by IntelliJ IDEA.
  User: Thang
  Date: 25/11/2024
  Time: 10:56 CH
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Sửa thông tin khách hàng</title>
</head>
<body>

<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>

            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Home</a>
                </li>
                <li class="active">customer-edit</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="page-header">
                <h1>
                    Thông tin khách hàng
                </h1>
            </div><!-- /.page-header -->

        </div>
        <!-- /.page-content -->
        <div class="row">
            <div class="col-xs-12">
                <form:form method="GET" id="form-edit" modelAttribute="customerEdit">
                    <form:hidden path="id"/>
                    <div class="form-group">
                        <label class="col-xs-3">Tên khách hàng</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="name" placeholder="Nhập tên khách hàng"/>

                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Số điện thoại</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="phone"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Email</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="email"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Tên công ty</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="companyName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Nhu cầu</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="demand"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Tình trạng</label>
                        <div class="col-xs-3">
                            <form:select path="status" class="form-control" id="statusSelect">
                                <form:options items="${statusCode}"/>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-xs-3"></label>
                        <div class="col-xs-9">
                            <c:if test="${not empty customerEdit.id}">
                                <button type="button" class="btn btn-purple" id="btnAddOrUpdateCustomer">Sửa thông tin
                                </button>
                            </c:if>
                            <c:if test="${empty customerEdit.id}">
                                <button type="button" class="btn btn-purple" id="btnAddOrUpdateCustomer">Thêm khách hàng
                                </button>
                            </c:if>
                            <a href="/admin/customer-list">
                                <button type="button" class="btn btn-navbar" id="btnDeleteAction">Hủy thao tác</button>
                            </a>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
        <c:forEach var="item" items="${transactionType}">
            <div class="row form-group">
                <div class="col-xs-12">
                    <h3 class="header smaller lighter pink">${item.value}</h3>
                    <button class="btn btn-new-mail" onclick="openModelFadeAdd('${item.key}',${customerEdit.id})">
                        <div>
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-plus-circle-dotted" viewBox="0 0 16 16">
                                <path d="M8 0q-.264 0-.523.017l.064.998a7 7 0 0 1 .918 0l.064-.998A8 8 0 0 0 8 0M6.44.152q-.52.104-1.012.27l.321.948q.43-.147.884-.237L6.44.153zm4.132.271a8 8 0 0 0-1.011-.27l-.194.98q.453.09.884.237zm1.873.925a8 8 0 0 0-.906-.524l-.443.896q.413.205.793.459zM4.46.824q-.471.233-.905.524l.556.83a7 7 0 0 1 .793-.458zM2.725 1.985q-.394.346-.74.74l.752.66q.303-.345.648-.648zm11.29.74a8 8 0 0 0-.74-.74l-.66.752q.346.303.648.648zm1.161 1.735a8 8 0 0 0-.524-.905l-.83.556q.254.38.458.793l.896-.443zM1.348 3.555q-.292.433-.524.906l.896.443q.205-.413.459-.793zM.423 5.428a8 8 0 0 0-.27 1.011l.98.194q.09-.453.237-.884zM15.848 6.44a8 8 0 0 0-.27-1.012l-.948.321q.147.43.237.884zM.017 7.477a8 8 0 0 0 0 1.046l.998-.064a7 7 0 0 1 0-.918zM16 8a8 8 0 0 0-.017-.523l-.998.064a7 7 0 0 1 0 .918l.998.064A8 8 0 0 0 16 8M.152 9.56q.104.52.27 1.012l.948-.321a7 7 0 0 1-.237-.884l-.98.194zm15.425 1.012q.168-.493.27-1.011l-.98-.194q-.09.453-.237.884zM.824 11.54a8 8 0 0 0 .524.905l.83-.556a7 7 0 0 1-.458-.793zm13.828.905q.292-.434.524-.906l-.896-.443q-.205.413-.459.793zm-12.667.83q.346.394.74.74l.66-.752a7 7 0 0 1-.648-.648zm11.29.74q.394-.346.74-.74l-.752-.66q-.302.346-.648.648zm-1.735 1.161q.471-.233.905-.524l-.556-.83a7 7 0 0 1-.793.458zm-7.985-.524q.434.292.906.524l.443-.896a7 7 0 0 1-.793-.459zm1.873.925q.493.168 1.011.27l.194-.98a7 7 0 0 1-.884-.237zm4.132.271a8 8 0 0 0 1.012-.27l-.321-.948a7 7 0 0 1-.884.237l.194.98zm-2.083.135a8 8 0 0 0 1.046 0l-.064-.998a7 7 0 0 1-.918 0zM8.5 4.5a.5.5 0 0 0-1 0v3h-3a.5.5 0 0 0 0 1h3v3a.5.5 0 0 0 1 0v-3h3a.5.5 0 0 0 0-1h-3z"/>
                            </svg>
                            <span>Thêm giao dịch</span>
                        </div>
                    </button>
                </div>
            </div>
            <c:if test="${item.key == 'CSKH' }">
                <div class="row">
                    <div class="col-xs-12">
                        <table class="table table-responsive table-bordered">
                            <thead>
                            <tr>
                                <th class="center">Ngày tạo</th>
                                <th class="center">Người tạo</th>
                                <th class="center">Ngày sửa</th>
                                <th class="center">Người sửa</th>
                                <th class="center">Chi tiết giao dịch</th>
                                <th class="center">Thao tác</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="it" items="${CSKH}">
                                <tr>
                                    <td class="center">${it.createdDate}</td>
                                    <td class="center">${it.createdBy}</td>
                                    <td class="center">${it.modifiedDate}</td>
                                    <td class="center">${it.modifiedBy}</td>
                                    <td class="center">${it.note}</td>
                                    <td class="center">
                                        <button onclick="openModelFadeEdit(${it.id}, '${it.note}', ${customerEdit.id}, '${it.code}')"
                                                class="btn btn-xs btn-round">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-credit-card-fill" viewBox="0 0 16 16">
                                                <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v1H0zm0 3v5a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V7zm3 2h1a1 1 0 0 1 1 1v1a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1v-1a1 1 0 0 1 1-1"/>
                                            </svg>
                                        </button>
                                        <security:authorize access="hasRole('MANAGER')">
                                            <button onclick="deleteTransaction(${it.id})" class="btn btn-xs btn-danger">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                     fill="currentColor" class="bi bi-journal-x" viewBox="0 0 16 16">
                                                    <path fill-rule="evenodd"
                                                          d="M6.146 6.146a.5.5 0 0 1 .708 0L8 7.293l1.146-1.147a.5.5 0 1 1 .708.708L8.707 8l1.147 1.146a.5.5 0 0 1-.708.708L8 8.707 6.854 9.854a.5.5 0 0 1-.708-.708L7.293 8 6.146 6.854a.5.5 0 0 1 0-.708"/>
                                                    <path d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2"/>
                                                    <path d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1z"/>
                                                </svg>
                                            </button>
                                        </security:authorize>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:if>
            <c:if test="${item.key == 'DDX' }">
                <div class="row">
                    <div class="col-xs-12">
                        <table class="table table-responsive table-bordered">
                            <thead>
                            <tr>
                                <th class="center">Ngày tạo</th>
                                <th class="center">Người tạo</th>
                                <th class="center">Ngày sửa</th>
                                <th class="center">Người sửa</th>
                                <th class="center">Chi tiết giao dịch</th>
                                <th class="center">Thao tác</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="it" items="${DDX}">
                                <tr>
                                    <td class="center">${it.createdDate}</td>
                                    <td class="center">${it.createdBy}</td>
                                    <td class="center">${it.modifiedDate}</td>
                                    <td class="center">${it.modifiedBy}</td>
                                    <td class="center">${it.note}</td>
                                    <td class="center">
                                        <button onclick="openModelFadeEdit(${it.id}, '${it.note}', ${customerEdit.id}, '${it.code}')"
                                                class="btn btn-xs btn-round">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                 fill="currentColor" class="bi bi-credit-card-fill" viewBox="0 0 16 16">
                                                <path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v1H0zm0 3v5a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V7zm3 2h1a1 1 0 0 1 1 1v1a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1v-1a1 1 0 0 1 1-1"/>
                                            </svg>
                                        </button>
                                        <security:authorize access="hasRole('MANAGER')">
                                            <button onclick="deleteTransaction(${it.id})" class="btn btn-xs btn-danger">
                                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                                                     fill="currentColor" class="bi bi-journal-x" viewBox="0 0 16 16">
                                                    <path fill-rule="evenodd"
                                                          d="M6.146 6.146a.5.5 0 0 1 .708 0L8 7.293l1.146-1.147a.5.5 0 1 1 .708.708L8.707 8l1.147 1.146a.5.5 0 0 1-.708.708L8 8.707 6.854 9.854a.5.5 0 0 1-.708-.708L7.293 8 6.146 6.854a.5.5 0 0 1 0-.708"/>
                                                    <path d="M3 0h10a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H3a2 2 0 0 1-2-2v-1h1v1a1 1 0 0 0 1 1h10a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H3a1 1 0 0 0-1 1v1H1V2a2 2 0 0 1 2-2"/>
                                                    <path d="M1 5v-.5a.5.5 0 0 1 1 0V5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1zm0 3v-.5a.5.5 0 0 1 1 0V8h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1zm0 3v-.5a.5.5 0 0 1 1 0v.5h.5a.5.5 0 0 1 0 1h-2a.5.5 0 0 1 0-1z"/>
                                                </svg>
                                            </button>
                                        </security:authorize>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:if>
        </c:forEach>

    </div>
</div><!-- /.main-content -->
<div class="modal fade" id="transactionTypeModal" role="dialog">
    <div class="modal-dialog">
        <div class="modal-header">
            <h4 class="modal-title">Chi tiết giao dịch</h4>
        </div>
        <div class="modal-body">
            <div class="form-group">
                <input type="text" id="note" name="note" class="form-control">
            </div>
        </div>
        <input type="hidden" id="customerId" value="">
        <input type="hidden" id="code" value="">
        <input type="hidden" id="id" value="">
        <div class="modal-footer">
            <div class="form-group pull-right">
                <button type="button" class="btn btn-pink" id="btnTransaction" onclick="addOrEditTransaction()">
                </button>
                <button type="button" class="btn btn-purple" data-dismiss="modal">Đóng</button>
            </div>
        </div>
    </div>
</div>

<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
    <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
</a>
<script>

    function deleteTransaction(id) {
        deleteTransaction(id);
    }

    function deleteTransaction(id){
        $.ajax({
            url:"/api/deleteTransaction-" + id,
            type :"DELETE",
            dataType: "text",
            success: function (result) {
                console.log("success");
                alert(result);
                location.replace("/admin/customer-edit-${customerEdit.id}");
            },
            error: function (result) {
                console.log("failed");
                alert(result);
            }
        })
    }

    function checkAddOrUpdate(id = "", str = "") {
        // var id = document.getElementById("id").value;
        console.log(id);
        if (id == "") {
            document.getElementById("btnTransaction").textContent = "Thêm giao dịch";
        } else {
            document.getElementById("btnTransaction").textContent = "Sửa giao dịch";
        }
        document.getElementById("note").value = str;
    }

    function openModelFadeAdd(code, customerId) {
        checkAddOrUpdate("");
        $('#id').val("");
        $('#code').val(code);
        $('#customerId').val(customerId);
        $("#transactionTypeModal").modal();
    }

    function openModelFadeEdit(id, str, customerId, code) {
        $('#id').val(id);
        $('#code').val(code);
        $('#customerId').val(customerId);
        checkAddOrUpdate(id, str);
        $('#transactionTypeModal').modal();
    }

    function addOrEditTransaction() {
        var json = {};
        json['id'] = $('#id').val();
        json['note'] = $('#note').val();
        json['customerId'] = $('#customerId').val();
        json['code'] = $('#code').val();
        addOrUpdateTransactionAjax(json);
    }

    function addOrUpdateTransactionAjax(json) {
        $.ajax({
            type: "POST",
            url: "/api/transactions",
            data: JSON.stringify(json),
            contentType: "application/json",
            dataType: "json",
            success: function (response) {
                alert(response.message);
                location.replace("/admin/customer-edit-${customerEdit.id}");
            },
            error: function (response) {
                alert(response.responseJSON.detail);
            }
        })
    }

    $("#btnAddOrUpdateCustomer").click(function () {
        var formData = $("#form-edit").serializeArray(); //mang cac objects
        var json = {};
        $.each(formData, function (i, v) {
            json["" + v.name + ""] = v.value;
        });
        var name = $("#name").val();
        var phone = $("#phone").val();
        if (name.length == 0) {
            alert("Customer name not empty!");
        } else if (!/^\d+$/.test(phone)) {
            alert("Customer phone must be the number!")
        } else if (phone.length != 10) {
            alert("Customer phone must be 10 digits!")
        } else {
            btnAddOrUpdateCustomer(json);
        }
    });

    function btnAddOrUpdateCustomer(json) {
        $.ajax({
            url: "/api/customers",
            type: "POST",
            data: JSON.stringify(json),
            contentType: "application/json",
            success: function (result) {
                console.log("success");
                alert(result)
                location.replace("/admin/customer-edit-${customerEdit.id}");
            },
            error: function (result) {
                console.log(result.message);
                alert(result.detail)
            }
        });
    }

</script>
</body>
</html>
