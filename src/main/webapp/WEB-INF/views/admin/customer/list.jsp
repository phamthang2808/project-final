<%--
  Created by IntelliJ IDEA.
  User: Thang
  Date: 25/11/2024
  Time: 10:56 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Tìm kiếm khách hàng</title>
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
                <li class="active">customer-list</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="page-header">
                <h1>
                    Danh sách khách hàng
                    <small>
                        <i class="ace-icon fa fa-angle-double-right"></i>
                        overview &amp; stats
                    </small>
                </h1>
            </div><!-- /.page-header -->

        </div><!-- /.page-content -->
        <div class="row">
            <div class="col-xs-12">
                <div class="widget-box">
                    <div class="widget-header">
                        <h4 class="widget-title">Tìm kiếm khách hàng</h4>
                        <span class="widget-toolbar">

									<a href="#" data-action="reload">
										<i class="ace-icon fa fa-refresh"></i>
									</a>

									<a href="#" data-action="collapse">
										<i class="ace-icon fa fa-chevron-up"></i>
									</a>

									<a href="#" data-action="close">
										<i class="ace-icon fa fa-times"></i>
									</a>
								</span>
                    </div>

                    <div class="widget-body">
                        <div class="widget-main">
                            <div class="row">
                                <form:form modelAttribute="modelSearch" action="/admin/customer-list" method="get"
                                           id="listFrom">
                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <div class="col-xs-4">
                                                <div>
                                                    <label>Tên khách hàng</label>
                                                    <form:input class="form-control" path="name"
                                                                placeholder="Nhập tên khách hàng"/>
                                                </div>
                                            </div>
                                            <div class="col-xs-4">
                                                <div>
                                                    <label>Di động</label>
                                                    <form:input class="form-control" path="phone"/>
                                                </div>
                                            </div>
                                            <div class="col-xs-4">
                                                <div>
                                                    <label>email</label>
                                                    <form:input class="form-control" path="email"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <div class="col-xs-4">
                                                <div>
                                                    <labe>Tình trạng</labe>
                                                    <form:select path="status" class="form-control">
                                                        <form:option value="" label="--Chọn tình trạng--"/>
                                                        <form:options items="${statusCode}"/>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <security:authorize access="hasRole('MANAGER')">
                                                <div class="col-xs-4">
                                                    <div>
                                                        <label>Nhân viên phụ trách</label>
                                                        <form:select path="staffId" class="form-control">
                                                            <form:option value="" label="--Chọn nhân viên--"/>
                                                            <form:options items="${staffs}"/>
                                                        </form:select>
                                                    </div>
                                                </div>
                                            </security:authorize>

                                            <security:authorize access="hasRole('MANAGER')">
                                                <div class="col-xs-4">
                                                    <div>
                                                        <label>Người thêm</label>
                                                        <form:input class="form-control" path="createdBy"/>
                                                    </div>
                                                </div>
                                            </security:authorize>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <div class="col-xs-6">
                                                <button type="button" class="btn btn-sm btn-primary"
                                                        id="btnSearchCustomer" style="background-color: #880000;">
                                                    <i class="ace-icon glyphicon glyphicon-search"></i>
                                                    Tìm kiếm
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                    <div class="pull-right">
                        <a href="/admin/customer-edit">
                            <button class="btn btn-app btn-outline-primary btn-sm" title="Thêm khách hàng">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-person-fill-add" viewBox="0 0 16 16">
                                    <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0m-2-6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
                                    <path d="M2 13c0 1 1 1 1 1h5.256A4.5 4.5 0 0 1 8 12.5a4.5 4.5 0 0 1 1.544-3.393Q8.844 9.002 8 9c-5 0-6 3-6 4"/>
                                </svg>
                            </button>
                        </a>
                        <security:authorize access="hasRole('MANAGER')">
                            <button class="btn btn-app btn-outline-secondary btn-sm" title="Xóa khách hàng"
                                    id="btnDeleteCustomers">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-building-fill-dash" viewBox="0 0 16 16">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-person-fill-dash" viewBox="0 0 16 16">
                                        <path d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1m0-7a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
                                        <path d="M2 13c0 1 1 1 1 1h5.256A4.5 4.5 0 0 1 8 12.5a4.5 4.5 0 0 1 1.544-3.393Q8.844 9.002 8 9c-5 0-6 3-6 4"/>
                                    </svg>
                            </button>
                        </security:authorize>
                    </div>
                </div>
            </div>
        </div>
        <div class="hr hr-30 dotted hr-double"></div>
    </div>

    <div class="row">
        <div class="col-xs-12">
            <div class="table-responsive">
                <display:table name="customers.listResult" cellspacing="0" cellpadding="0"
                               requestURI="${formUrl}" partialList="true" sort="external"
                               size="${customers.totalItems}" defaultsort="2" defaultorder="ascending"
                               id="tableList" pagesize="${customers.maxPageItems}"
                               export="false"
                               class="table table-fcv-ace table-striped table-bordered table-hover dataTable no-footer"
                               style="margin: 3em 0 1.5em;">
                    <display:column title="<fieldset class='form-group'>
					 <input type='checkbox' id='checkAll' class='check-box-element' value=''>
					 </fieldset>" class="center select-cell" headerClass="center select-cell">
                        <fieldset>
                            <input type="checkbox" name="checkList" value="${tableList.id}"
                                   id="checkbox_${tableList.id}" class="check-box-element"/>
                        </fieldset>
                    </display:column>

                    <display:column property="name" title="Tên khách hàng" headerClass="text-left"/>
                    <display:column property="phone" title="Di động" headerClass="text-left"/>
                    <display:column property="email" title="Email" headerClass="text-left"/>
                    <display:column property="demand" title="Nhu cầu" headerClass="text-left"/>
                    <display:column property="createdBy" title="Người thêm" headerClass="text-left"/>
                    <display:column property="createdDate" title="Ngày thêm" headerClass="text-left"/>
                    <display:column property="status" title="Tình trạng" headerClass="text-left"/>

                    <display:column title="Thao tác" headerClass="text-left">
                        <div class="hidden-sm hidden-xs btn-navbar">
                            <security:authorize access="hasRole('MANAGER')">
                                <button class="btn btn-xs btn-success" title="Giao khách hàng"
                                        onclick="assignmentCustomer(${tableList.id})">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-card-checklist" viewBox="0 0 16 16">
                                        <path d="M14.5 3a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-13a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5zm-13-1A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 2z"/>
                                        <path d="M7 5.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5m-1.496-.854a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0l-.5-.5a.5.5 0 1 1 .708-.708l.146.147 1.146-1.147a.5.5 0 0 1 .708 0M7 9.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 0 1h-5a.5.5 0 0 1-.5-.5m-1.496-.854a.5.5 0 0 1 0 .708l-1.5 1.5a.5.5 0 0 1-.708 0l-.5-.5a.5.5 0 0 1 .708-.708l.146.147 1.146-1.147a.5.5 0 0 1 .708 0"/>
                                    </svg>
                                </button>
                            </security:authorize>


                            <a href="/admin/customer-edit-${tableList.id}">
                                <button class="btn btn-xs btn-purple" title="Sửa khách hàng">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-pencil-square" viewBox="0 0 16 16">
                                        <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                        <path fill-rule="evenodd"
                                              d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
                                    </svg>
                                </button>
                            </a>

                            <security:authorize access="hasRole('MANAGER')">
                                <button class="btn btn-xs btn-dark" onclick="btnDeleteCustomer(${tableList.id})"
                                        title="Xóa khách hàng">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                         class="bi bi-file-earmark-x" viewBox="0 0 16 16">
                                        <path d="M6.854 7.146a.5.5 0 1 0-.708.708L7.293 9l-1.147 1.146a.5.5 0 0 0 .708.708L8 9.707l1.146 1.147a.5.5 0 0 0 .708-.708L8.707 9l1.147-1.146a.5.5 0 0 0-.708-.708L8 8.293z"/>
                                        <path d="M14 14V4.5L9.5 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2M9.5 3A1.5 1.5 0 0 0 11 4.5h2V14a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h5.5z"/>
                                    </svg>
                                </button>
                            </security:authorize>

                        </div>
                    </display:column>
                </display:table>
            </div>
        </div><!-- /.span -->
    </div>
</div><!-- /.main-content -->

<div class="modal fade" id="assignmentCustomerModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Danh sách nhân viên</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <table id="staffList" class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th class="center">Chọn</th>
                        <th class="center">Tên Nhân viên</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
                <input type="hidden" id="customerId" value="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-purple" id="btnAssignmentCustomer">Giao khách hàng</button>
                <button type="button" class="btn btn-pink" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
    <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
</a>
<script>
    function assignmentCustomer(customerid) {
        console.log(customerid)
        $("#assignmentCustomerModal").modal();
        $('#customerId').val(customerid);
        loadStaffs(customerid);
    }

    function loadStaffs(customerId) {
        $.ajax({
            url: "/api/customers/" + customerId,
            type: "GET",
            // data: JSON.stringify(json),
            contentType: "application/json",
            dataType: "JSON",
            success: function (response) {
                var row = "";
                $.each(response.data, function (index, item) {
                    row += "<tr>";
                    row += "<td class='center'> <input type='checkbox' class='check-box-element' value='" + item.staffId + "' id='checkbox_" + item.staffId + "' " + item.checked + "/></td>";
                    row += "<td class='center'>" + item.userName + "</td>";
                    row += "</tr>";

                });
                $("#staffList tbody").html(row);
                alert(response.message);
            },
            error: function (response) {
                console.log("failed");
                alert(response.message);
            }
        });
    }

    $('#checkAll').on('change', function () {
        $('.check-box-element').prop('checked', this.checked);
    });


    $("#btnDeleteCustomers").click(function (e) {
        e.preventDefault();

        var customerIds = $(".table-responsive").find("input[type=checkbox].check-box-element:checked").map(function () {
            return $(this).val();
        }).get();

        if (customerIds.length == 0) {
            alert("Chưa chọn khách hàng cần xóa");
        } else {
            btnDeleteCustomer(customerIds);
        }
    });


    function deleteCustomer(buildingId) {
        btnDeleteCustomer(buildingId);
    }

    function btnDeleteCustomer(data) {
        $.ajax({
            url: "/api/customers/" + data,
            type: "DELETE",
            // data: JSON.stringify(json),
            // contentType: "application/json",
            dataType: "text",
            success: function (result) {
                console.log("success");
                alert(result);
                location.replace("/admin/customer-list");
            },
            error: function (result) {
                console.log("failed");
                alert(result);
            }
        });
    }

    $("#btnAssignmentCustomer").click(function (e) {
        e.preventDefault();
        var json = {};
        json['customerId'] = $('#customerId').val();
        var staffs = $('#staffList').find("tbody input[type=checkbox]:checked").map(function () {
            return $(this).val();
        }).get();
        json['staffs'] = staffs;
        UpdateAssignmentCustomer(json);
    });

    function UpdateAssignmentCustomer(json) {
        $.ajax({
            url: "/api/customers/staffs",
            type: "PUT",
            data: JSON.stringify(json),
            contentType: "application/json",
            dataType: "text",
            success: function (result) {
                console.log("success");
                alert(result);
            },
            error: function (result) {
                console.log("failed");
                alert(result);
            }
        });
    }

    $("#btnSearchCustomer").click(function (e) {
        e.preventDefault();
        $("#listFrom").submit()

    });
</script>
</body>
</html>