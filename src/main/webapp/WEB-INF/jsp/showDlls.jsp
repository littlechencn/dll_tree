<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/8/14
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>API依赖树</title>
    <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"
         xml:space="preserve">
    <defs>
        <pattern id="level1" width="100%" height="100%" patternContentUnits="objectBoundingBox">
            <image width="1" height="1" xlink:href="<%=basePath %>image/level1.png"/>
        </pattern>
        <pattern id="level2" width="100%" height="100%" patternContentUnits="objectBoundingBox">
            <image width="1" height="1" xlink:href="<%=basePath %>image/level2.png"/>
        </pattern>
        <pattern id="level3" width="100%" height="100%" patternContentUnits="objectBoundingBox">
            <image width="1" height="1" xlink:href="<%=basePath %>image/level3.png"/>
        </pattern>
        <pattern id="level4" width="100%" height="100%" patternContentUnits="objectBoundingBox">
            <image width="1" height="1" xlink:href="<%=basePath %>image/level4.png"/>
        </pattern>
        <style>
            .node circle {
                cursor: pointer;
                stroke: steelblue;
                stroke-width: 0px;
            }

            .circle1 {
                fill: url(#level1);
            }

            .circle2 {
                fill: url(#level2);
            }

            .circle3 {
                fill: url(#level3);
            }

            .circle4 {
                fill: url(#level4);
            }

            .node text {
                font-size: 12px;
            }

            .link {
                fill: none;
                stroke: #ccc;
                stroke-width: 1.5px;
            }
        </style>
    </defs>
</svg>
    <script src="<%=basePath %>js/d3.v3.min.js"></script>
    <script src="<%=basePath %>js/jquery-1.8.2.min.js"></script>
</head>
<body>
<label>请选择DLL ：</label>
<select style="height: 40px;line-height: 40px;" onchange="mySelect(this)" id="dllSelecter">
    <c:forEach items="${dllList}" var="dllName">
        <option value="<c:out value="${dllName}"/>"><c:out value="${dllName}"/></option>
    </c:forEach>
</select>
<div id="svgDiv"></div>
<script src="<%=basePath %>js/showDlls.js"></script>
<script>
    //下拉框选中事件；
    function mySelect(selectObj) {
        maxDepth=1;

        var selectDll = $(selectObj).val();
        var url = "<%=request.getContextPath()%>/dlls/getJsonTree?dllName=" + selectDll;
        d3.json(url, d3Inint);
    }

    //初始加载；
    var url = "<%=request.getContextPath()%>/dlls/getJsonTree?dllName=" + $("#dllSelecter").val();
    d3.json(url, d3Inint);
</script>
</body>
</html>
