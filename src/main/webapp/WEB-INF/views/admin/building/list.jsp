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
                                                        <%--                                                        <input type="text" name="name" class="form-control"--%>
                                                        <%--                                                               placeholder="Nhập tòa nhà" value=${modelSearch.name}>--%>
                                                </div>
                                            </div>
                                            <div class="col-xs-6">
                                                <div>
                                                    <label>Diện tích sàn</label>
                                                    <form:input class="form-control" path="floorArea"/>
                                                        <%--                                                        <input type="number" name="floorArea" class="form-control" value=${modelSearch.floorArea}>--%>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <div class="col-xs-2">
                                                <div>
                                                        <%--                                                    <label>Quận</label>--%>
                                                        <%--                                                                                                                <select class="form-control" name="districtCode">--%>
                                                        <%--                                                                                                                    <option value="">--Chọn quận-- </option>--%>
                                                        <%--                                                                                                                    <option value="Q1">Quận 1</option>--%>
                                                        <%--                                                                                                                    <option value="Q2">Quận 2</option>--%>
                                                        <%--                                                                                                                    <option value="Q3">Quận 3</option>--%>
                                                        <%--                                                                                                                    <option value="TK">Quận Thanh Khê</option>--%>
                                                        <%--                                                                                                                </select>--%>
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
                                                        <%--                                                        <input type="text" name="ward" class="form-control" value=${modelSearch.ward}>--%>
                                                </div>
                                            </div>
                                            <div class="col-xs-5">
                                                <div>
                                                    <label>Đường</label>
                                                    <form:input class="form-control" path="street"/>
                                                        <%--                                                        <input type="text" name="street" class="form-control" value=${modelSearch.street}>--%>
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
                                                        <%--                                                        <input type="number" name="numberOfBasement" class="form-control value=${modelSearch.numberOfBasement}"--%>
                                                        <%--                                                               placeholder="Nhập số tầng hầm">--%>
                                                </div>
                                            </div>
                                            <div class="col-xs-4">
                                                <div>
                                                    <label>Hướng</label>
                                                    <form:input class="form-control" path="direction"/>
                                                        <%--                                                        <input type="text" name="direction" class="form-control" value=${modelSearch.direction}>--%>
                                                </div>
                                            </div>
                                            <div class="col-xs-4">
                                                <div>
                                                    <label>Hạng</label>
                                                    <form:input class="form-control" path="level"/>
                                                        <%--                                                        <input type="number" name="level" class="form-control" value=${modelSearch.level}>--%>
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
                                                        <%--                                                        <input type="number" name="rentAreaFrom" class="form-control"--%>
                                                        <%--                                                               placeholder="Nhập diện tích tối thiểu" value=${modelSearch.areaFrom}>--%>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div>
                                                    <label>Diện tích đến</label>
                                                    <form:input class="form-control" path="areaTo"/>
                                                        <%--                                                        <input type="number" name="rentAreaFrom" class="form-control" value=${modelSearch.areaTo}>--%>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div>
                                                    <label>Giá tiền từ</label>
                                                    <form:input class="form-control" path="rentPriceFrom"/>
                                                        <%--                                                        <input type="number" name="rentPriceFrom" class="form-control" value=${modelSearch.rentPriceFrom}>--%>
                                                </div>
                                            </div>
                                            <div class="col-xs-3">
                                                <div>
                                                    <label>Giá tiền đến</label>
                                                    <form:input class="form-control" path="rentPriceTo"/>
                                                        <%--                                                        <input type="number" name="rentPriceTo" class="form-control" value=${modelSearch.rentPriceTo} >--%>
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
                                                        <%--                                                        <input type="text" name="managerName" class="form-control"--%>
                                                        <%--                                                               placeholder="Nhập tên quản lý" value=${modelSearch.managerName}>--%>
                                                </div>
                                            </div>
                                            <div class="col-xs-4">
                                                <div>
                                                    <label>SDT quản lý</label>
                                                    <form:input class="form-control" path="managerPhone"/>
                                                        <%--                                                        <input type="text" name="managerPhone" class="form-control" value=${modelSearch.managerPhone}>--%>
                                                </div>
                                            </div>
                                            <div class="col-xs-4">
                                                <div>
                                                    <label>Nhân viên phụ trách</label>
                                                        <%--                                                        <select class="form-control" name="staffId">--%>
                                                        <%--                                                            <option value="">--Chọn Nhân Viên-- </option>--%>
                                                        <%--                                                            <option value="1">Nguyen Van A</option>--%>
                                                        <%--                                                            <option value="2">Nguyen Van B</option>--%>
                                                        <%--                                                            <option value="3">Tran Thi C</option>--%>
                                                        <%--                                                            <option value="4">Nguyen Van D</option>--%>
                                                        <%--                                                        </select>--%>
                                                    <form:select path="staffId" class="form-control">
                                                        <form:option value="" label="--Chọn nhân viên--"/>
                                                        <form:options items="${staffs}"/>
                                                    </form:select>

                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-xs-12">
                                            <div class="col-xs-6">
                                                <div>
                                                        <%--                                                        <label>Tầng Trệt</label>--%>
                                                        <%--                                                        <input type="checkbox" name="typeCode" value="tang-tret">--%>
                                                        <%--                                                        <label>Nguyên căn</label>--%>
                                                        <%--                                                        <input type="checkbox" name="typeCode" value="nguyen-can">--%>

                                                        <%--                                                        <label>Nôị thất</label>--%>
                                                        <%--                                                        <input type="checkbox" name="typeCode" value="noi-that">--%>
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

                        <button class="btn btn-app btn-danger btn-sm" title="Xóa tòa nhà" id="btnDeleteBuildings">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-building-fill-dash" viewBox="0 0 16 16">
                                <path
                                        d="M12.5 16a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7M11 12h3a.5.5 0 0 1 0 1h-3a.5.5 0 0 1 0-1"/>
                                <path
                                        d="M2 1a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v7.256A4.5 4.5 0 0 0 12.5 8a4.5 4.5 0 0 0-3.59 1.787A.5.5 0 0 0 9 9.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .39-.187A4.5 4.5 0 0 0 8.027 12H6.5a.5.5 0 0 0-.5.5V16H3a1 1 0 0 1-1-1zm2 1.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5m3 0v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5m3.5-.5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zM4 5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5M7.5 5a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5zm2.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5M4.5 8a.5.5 0 0 0-.5.5v1a.5.5 0 0 0 .5.5h1a.5.5 0 0 0 .5-.5v-1a.5.5 0 0 0-.5-.5z"/>
                            </svg>
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <div class="hr hr-30 dotted hr-double"></div>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <table id="building-list" class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th class="center">Chọn</th>
                    <th class="center">
                        Tên tòa nhà
                    </th>
                    <th>Địa chỉ</th>
                    <th>Số tầng hầm</th>
                    <th>Tên Quản lý</th>
                    <th>SDT Quản Lý</th>
                    <th>DT sàn</th>
                    <th>DT trống</th>
                    <th>DT cho thuê</th>
                    <th>Giá thuê</th>
                    <th>Phí dịch vụ</th>
                    <th>Phí môi giới</th>
                    <th>Thao tac</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="item" items="${listBuiling}">
                    <tr>
                        <td class="center">
                            <label class="pos-rel">
                                <input type="checkbox" class="ace" value=${item.id}>
                                <span class="lbl"></span>
                            </label>
                        </td>
                        <td>${item.name}</td>
                        <td>${item.address}</td>
                        <td>${item.numberOfBasement}</td>
                        <td>${item.managerName}</td>
                        <td>${item.managerPhoneNumber}</td>
                        <td>${item.floorArea}</td>
                        <td>${item.emptyArea}</td>
                        <td>${item.rentArea}</td>
                        <td>${item.rentPrice}</td>
                        <td>${item.serviceFee}</td>
                        <td>${item.brokerageFee}</td>
                        <td>
                            <div class="hidden-sm hidden-xs btn-group">
                                <button class="btn btn-xs btn-success" title="Giao tòa nhà"
                                        onclick="assignmentBuilding(${item.id})">
                                    <i class="ace-icon fa fa-check bigger-120"></i>
                                </button>
                                <a href="/admin/building-edit-${item.id}">
                                    <button class="btn btn-xs btn-info" title="Sửa tòa nhà">
                                        <i class="ace-icon fa fa-pencil bigger-120" type="button"></i>
                                    </button>
                                </a>

                                <button class="btn btn-xs btn-danger" title="Xóa tòa nhà"
                                        onclick="deleteBuilding(${item.id})">
                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                </button>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
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

    $("#btnDeleteBuildings").click(function (e) {
        e.preventDefault();
        var buildingIds = $("#building-list").find("tbody input[type=checkbox]:checked").map(function () {
            return $(this).val();
        }).get();
        console.log("okk");
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

    function UpdateAssignmentBuilding(json){
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