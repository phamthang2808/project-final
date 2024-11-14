<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Danh sách tòa nhà</title>
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
                <li class="active">building-list</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="page-header">
                <h1>
                    Danh sách tòa nhà
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
                        <h4 class="widget-title">Tìm kiếm tòa nhà</h4>
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
                                <form:form modelAttribute="modelSearch" action="/admin/building-list" method="get"
                                           id="listFrom">
                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <div class="col-xs-6">
                                                <div>
                                                    <label>Tên tòa nhà</label>
                                                    <form:input class="form-control" path="name"
                                                                placeholder="Nhập tên tòa nhà"/>
                                                </div>
                                            </div>
                                            <div class="col-xs-6">
                                                <div>
                                                    <label>Diện tích sàn</label>
                                                    <form:input class="form-control" path="floorArea"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <div class="col-xs-2">
                                                <div>
                                                    <form:select path="district" class="form-control">
                                                        <form:option value="" label="--Chọn Quận--"/>
                                                        <form:options items="${district}"/>
                                                    </form:select>
                                                </div>
                                            </div>
                                            <div class="col-xs-5">
                                                <div>
                                                    <label>Phường</label>
                                                    <form:input class="form-control" path="ward"/>
                                                </div>
                                            </div>
                                            <div class="col-xs-5">
                                                <div>
                                                    <label>Đường</label>
                                                    <form:input class="form-control" path="street"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <div class="col-xs-4">
                                                <div>
                                                    <label>Số tầng hầm</label>
                                                    <form:input class="form-control" path="numberOfBasement"/>
                                                </div>
                                            </div>
                                            <div class="col-xs-4">
                                                <div>
                                                    <label>Hướng</label>
                                                    <form:input class="form-control" path="direction"/>
                                                </div>
                                            </div>
                                            <div class="col-xs-4">
                                                <div>
                                                    <label>Hạng</label>
                                                    <form:input class="form-control" path="level"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <div class="col-xs-3">
                                                <div>
                                                    <label>Diện tích từ</label>
                                                    <form:input class="form-control" path="areaFrom"/>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div>
                                                    <label>Diện tích đến</label>
                                                    <form:input class="form-control" path="areaTo"/>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div>
                                                    <label>Giá tiền từ</label>
                                                    <form:input class="form-control" path="rentPriceFrom"/>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div>
                                                    <label>Giá tiền đến</label>
                                                    <form:input class="form-control" path="rentPriceTo"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <div class="col-xs-4">
                                                <div>
                                                    <label>Tên quản lý</label>
                                                    <form:input class="form-control" path="managerName"/>
                                                </div>
                                            </div>
                                            <div class="col-xs-4">
                                                <div>
                                                    <label>SDT quản lý</label>
                                                    <form:input class="form-control" path="managerPhone"/>
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

                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <div class="col-xs-6">
                                                <div>
                                                        <%--                                                    <input type="checkbox" name="typeCode" value="noi-that">--%>
                                                    <form:checkboxes items="${renttype}" path="typeCode"/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <div class="col-xs-6">
                                                <button type="button" class="btn btn-sm btn-primary"
                                                        id="btnSearchBuilding">
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
                        <a href="/admin/building-edit">
                            <button class="btn btn-app btn-primary no-radius" title="Thêm tòa nhà">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-building-fill-add" viewBox="0 0 16 16">
                                    <path
                                            d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7m.5-5v1h1a.5.5 0 0 1 0 1h-1v1a.5.5 0 0 1-1 0v-1h-1a.5.5 0 0 1 0-1h1v-1a.5.5 0 0 1 1 0"/>
                                    <path
                                            d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v7.256A4.5 4.5 0 0 0 12.5 8a4.5 4.5 0 0 0-3.59 1.787A.5.5 0 0 0 9 9.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .39-.187A4.5 4.5 0 0 0 8.027 12H6.5a.5.5 0 0 0-.5.5V16H3a1 1 0 0 1-1-1zm2 1.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5m3 0v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5m3.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zM4 5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5M7.5 5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm2.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5M4.5 8a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                                </svg>
                            </button>
                        </a>
                        <security:authorize access="hasRole('MANAGER')">
                            <button class="btn btn-app btn-danger btn-sm" title="Xóa tòa nhà" id="btnDeleteBuildings">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-building-fill-dash" viewBox="0 0 16 16">
                                    <path
                                            d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"/>
                                    <path
                                            d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v7.256A4.5 4.5 0 0 0 12.5 8a4.5 4.5 0 0 0-3.59 1.787A.5.5 0 0 0 9 9.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .39-.187A4.5 4.5 0 0 0 8.027 12H6.5a.5.5 0 0 0-.5.5V16H3a1 1 0 0 1-1-1zm2 1.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5m3 0v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5m3.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zM4 5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5M7.5 5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm2.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5M4.5 8a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
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
                <display:table name="model.listResult" cellspacing="0" cellpadding="0"
                               requestURI="${formUrl}" partialList="true" sort="external"
                               size="${model.totalItems}" defaultsort="2" defaultorder="ascending"
                               id="tableList" pagesize="${model.maxPageItems}"
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

                    <display:column property="name" title="Tên tòa nhà" headerClass="text-left"/>
                    <display:column property="address" title="Địa chỉ" headerClass="text-left"/>
                    <display:column property="numberOfBasement" title="Số tầng hầm" headerClass="text-left"/>
                    <display:column property="managerName" title="Tên QL" headerClass="text-left"/>
                    <display:column property="managerPhone" title="SDT QL" headerClass="text-left"/>
                    <display:column property="floorArea" title="DT Sàn" headerClass="text-left"/>
                    <display:column property="emptyArea" title="DT Trống" headerClass="text-left"/>
                    <display:column property="rentArea" title="Diện tích Thuê" headerClass="text-left"/>
                    <display:column property="rentPrice" title="Giá thuê" headerClass="text-left"/>
                    <display:column property="serviceFee" title="Phí dịch vụ" headerClass="text-left"/>
                    <display:column property="brokerageFee" title="Phí môi giới" headerClass="text-left"/>

                    <display:column title="Thao tác" headerClass="text-left">
                        <div class="hidden-sm hidden-xs btn-group">
                            <security:authorize access="hasRole('MANAGER')">
                                <button class="btn btn-xs btn-success" title="Giao tòa nhà"
                                        onclick="assignmentBuilding(${tableList.id})">
                                    <i class="ace-icon fa fa-check bigger-120"></i>
                                </button>
                            </security:authorize>


                            <a href="/admin/building-edit-${tableList.id}">
                                <button class="btn btn-xs btn-info" title="Sửa tòa nhà">
                                    <i class="ace-icon fa fa-pencil bigger-120"></i>
                                </button>
                            </a>

                            <security:authorize access="hasRole('MANAGER')">
                                <button class="btn btn-xs btn-danger" onclick="btnDeleteBuilding(${tableList.id})"
                                        title="Xóa tòa nhà">
                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                </button>
                            </security:authorize>

                        </div>
                    </display:column>
                </display:table>
            </div>
        </div><!-- /.span -->
    </div>
</div><!-- /.main-content -->

<div class="modal fade" id="assignmentBuildingModal">
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
                <input type="hidden" id="buildingId" value="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="btnAssignmentBuilding">Giao tòa nhà</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
    <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
</a>
<script>
    function assignmentBuilding(buildingid) {
        console.log(buildingid)
        $("#assignmentBuildingModal").modal();
        $('#buildingId').val(buildingid);
        loadStaffs(buildingid);
    }

    function loadStaffs(buildingId) {
        $.ajax({
            url: "/api/buildings/" + buildingId,
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


    $("#btnDeleteBuildings").click(function (e) {
        e.preventDefault();

        var buildingIds = $(".table-responsive").find("input[type=checkbox].check-box-element:checked").map(function () {
            return $(this).val();
        }).get();

        if (buildingIds.length == 0) {
            alert("Chưa chọn nhà cần xóa");
        } else {
            btnDeleteBuilding(buildingIds);
        }
    });


    function deleteBuilding(buildingId) {
        btnDeleteBuilding(buildingId);
    }

    function btnDeleteBuilding(data) {
        $.ajax({
            url: "/api/buildings/" + data, //api/building/1,2,3,4
            type: "DELETE",
            // data: JSON.stringify(json),
            // contentType: "application/json",
            dataType: "text",
            success: function (result) {
                console.log("success");
                alert(result);
                location.replace("/admin/building-list");
            },
            error: function (result) {
                console.log("failed");
                alert(result);
            }
        });
    }

    $("#btnAssignmentBuilding").click(function (e) {
        e.preventDefault();
        var json = {};
        json['buildingId'] = $('#buildingId').val();
        var staffs = $('#staffList').find("tbody input[type=checkbox]:checked").map(function () {
            return $(this).val();
        }).get();
        json['staffs'] = staffs;
        UpdateAssignmentBuilding(json);
    });

    function UpdateAssignmentBuilding(json) {
        $.ajax({
            url: "/api/buildings/staffs",
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

    $("#btnSearchBuilding").click(function (e) {
        e.preventDefault();
        $("#listFrom").submit()

    });
</script>
</body>
</html>