<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap core JavaScript-->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>
    <script src="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/resources/js/sb-admin-2.min.js"></script>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title"/></title>
<!-- <link rel="stylesheet" href="/resources/css/tiles.css"> -->
</head>
<body>
	<tiles:insertAttribute name="header"/>
		<div>
			<tiles:insertAttribute name="aside" />
			<tiles:insertAttribute name="body"/>
		</div>
	<tiles:insertAttribute name="footer"/>
</body>
</html>