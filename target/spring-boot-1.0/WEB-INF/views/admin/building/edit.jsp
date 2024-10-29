<%@include file="/common/taglib.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông tin tòa nhà</title>
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
                <li class="active">building-edit</li>
            </ul><!-- /.breadcrumb -->
        </div>

        <div class="page-content">
            <div class="page-header">
                <h1>
                    Thông tin tòa nhà
                </h1>
            </div><!-- /.page-header -->

        </div><!-- /.page-content -->
        <div class="row">
            <div class="col-xs-12">
                <form:form method="GET" id="form-edit" modelAttribute="buildingEdit">
                    <%--                <input type="hidden" name="id" value="${buildingEdit.id}">--%>
                    <form:hidden path="id"/>
                    <div class="form-group">
                        <label class="col-xs-3">Tên tòa nhà</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="name" placeholder="Nhập tên tòa nhà"/>
                                <%--                            <input type="text" name="name" id="name" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Quận</label>
                        <div class="col-xs-3">
                                <%--                                <select class="form-control" id="districtid" class="districtid">--%>
                                <%--                                    <option value="">--Chọn quận--</option>--%>
                                <%--                                    <option value="">Quận 1</option>--%>
                                <%--                                    <option value="">Quận 2</option>--%>
                                <%--                                    <option value="">Quận 3</option>--%>
                                <%--                                    <option value="">Quận 4</option>--%>
                                <%--                                </select>--%>
                            <form:select path="district" class="form-control">
                                <form:option value="" label="--Chọn Quận--"/>
                                <form:options items="${district}"/>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Phường</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="ward"/>
                                <%--                            <input type="text" name="ward" id="ward" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Đường</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="street"/>
                                <%--                            <input type="text" name="street" id="street" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Kết cấu</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="structure"/>
                                <%--                            <input type="text" name="kc" id="kc" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Số tầng hầm</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="numberOfBasement"/>
                                <%--                            <input type="text" name="numberofbasement" id="numberofbasement" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Diện tích sàn</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="floorArea"/>
                                <%--                            <input type="text" name="floorarea" id="floorarea" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Hướng</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="direction"/>
                                <%--                            <input type="text" name="huong" id="huong" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Hạng</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="level"/>
                                <%--                            <input type="text" name="hang" id="hang" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Diện tích thuê</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="rentArea" placeholder="Nhập diện tích thuê, cách nhau bằng dấu phẩy"/>
                                <%--                            <input type="text" name="dientichthue" id="dientichthue" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Giá thuê</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="rentPrice"/>
                                <%--                            <input type="text" name="giathue" id="giathue" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Mô tả giá</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="rentPriceDescription"/>
                                <%--                            <input type="text" name="motagia" id="motagia" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Phí dịch vụ</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="serviceFee"/>
                                <%--                            <input type="text" name="phidichvu" id="phidichvu" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Phí ô tô</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="carFee"/>
                                <%--                            <input type="text" name="phioto" id="phioto" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Phí mô tô</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="motoFee"/>
                                <%--                            <input type="text" name="phimoto" id="phimoto" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Phí ngoài giờ</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="overtimeFee"/>
                                <%--                            <input type="text" name="phingoaigio" id="phingoaigio" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Tiền điện</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="electricityFee"/>
                                <%--                            <input type="text" name="tiendien" id="tiendien" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Đặt cọc</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="deposit"/>
                                <%--                            <input type="text" name="datcoc" id="datcoc" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Thanh toán</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="payment"/>
                                <%--                            <input type="text" name="thanhtoan" id="thanhtoan" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Thời hạn thuê</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="rentTime"/>
                                <%--                            <input type="text" name="thoihanthue" id="thoihanthue" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Thời gian trang trí</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="decorationTime"/>
                                <%--                            <input type="text" name="thoigiantrangtri" id="thoigiantrangtri"--%>
                                <%--                            class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Tên quản lý</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="managerName"/>
                                <%--                            <input type="text" name="tenquanly" id="tenquanly" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">SDT quản lý</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="managerPhone"/>
                                <%--                            <input type="text" name="sdtquanly" id="sdtquanly" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Phí môi giới</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="brokerageFee"/>
                                <%--                            <input type="text" name="phimoigioi" id="phimoigioi" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Loại tòa nhà</label>
                        <div class="col-xs-9">
                                <%--                            <input type="checkbox" name="typeCode" id="typeCode" value="noi-that">Nội thất--%>
                                <%--                            <input type="checkbox" name="typeCode" id="typeCode" value="tang-tret">Tầng trệt--%>
                                <%--                            <input type="checkbox" name="typeCode" id="typeCode" value="nguyen-can">Nguyên căn--%>
                            <form:checkboxes items="${renttype}" path="typeCode"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3">Ghi chú</label>
                        <div class="col-xs-9">
                            <form:input class="form-control" path="note"/>
                                <%--                            <input type="text" name="ghichu" id="ghichu" class="form-control">--%>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-xs-3"></label>
                        <div class="col-xs-9">
                            <c:if test="${not empty buildingEdit.id}">
                                <button type="button" class="btn btn-primary" id="btnAddOrUpdateBuilding">Sửa thông tin</button>
                            </c:if>
                            <c:if test="${empty buildingEdit.id}">
                                <button type="button" class="btn btn-primary" id="btnAddOrUpdateBuilding">Thêm tòa nhà</button>
                            </c:if>
                            <a href="/admin/building-list">
                                <button type="button" class="btn btn-danger" id="btnDeleteAction">Hủy thao tác</button>
                            </a>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div><!-- /.main-content -->

<%--    <div class="footer">--%>
<%--        <div class="footer-inner">--%>
<%--            <div class="footer-content">--%>
<%--					<span class="bigger-120">--%>
<%--						<span class="blue bolder">Ace</span>--%>
<%--						Application &copy; 2013-2014--%>
<%--					</span>--%>

<%--                &nbsp; &nbsp;--%>
<%--                <span class="action-buttons">--%>
<%--						<a href="#">--%>
<%--							<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>--%>
<%--						</a>--%>

<%--						<a href="#">--%>
<%--							<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>--%>
<%--						</a>--%>

<%--						<a href="#">--%>
<%--							<i class="ace-icon fa fa-rss-square orange bigger-150"></i>--%>
<%--						</a>--%>
<%--					</span>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>

<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
    <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
</a>
<script>
    $("#btnAddOrUpdateBuilding").click(function () {
        var formData = $("#form-edit").serializeArray(); //mang cac objects
        var json = {};
        var typeCode = [];
        var renArea = []; // xu ly rieng rentArea -> List<Long>
        $.each(formData, function (i, v) {
            if (v.name == "typeCode") {
                typeCode.push(v.value);
            }else if(v.name == "rentArea") {
                renArea = v.value.split(",").map(function (item) {
                    return item.trim();
                });
            }else json["" + v.name + ""] = v.value;
        });
        json["typeCode"] = typeCode;
        json["rentArea"] = renArea;
        if (typeCode.length == 0) {
            alert("typecode not empty!");
        } else {
            btnAddOrUpdateBuilding(json);
        }
    });

    function btnAddOrUpdateBuilding(json) {
        $.ajax({
            url: "/api/buildings",
            type: "POST",
            data: JSON.stringify(json),
            contentType: "application/json",
            success: function (result) {
                console.log("success");
                alert(result)
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
