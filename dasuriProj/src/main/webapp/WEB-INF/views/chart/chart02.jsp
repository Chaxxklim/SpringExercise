<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구글차트(오라클 DBMS)</title>
<script src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
//구글 차트 라이브러리 로딩
google.load("visualization","1",{
	"packages":["corechart"]
});
google.setOnLoadCallback(drawChart);
function drawChart() {
	var jsonData = $.ajax({	
		url : "/chart/chart02_money",
		dataType : "json",
		async : false
	}).responseText;

	console.log("jsonData : " + jsonData);

	var data = new google.visualization.DataTable(jsonData);
	
	//어떤 모양으로 출력할지 정해줌
// 	var chart = new google.visualization.ColumnChart(
// 			document.getElementById("chart_div"));
// 	var chart = new google.visualization.PieChart(
// 		document.getElementById("chart_div"));
	var chart = new google.visualization.LineChart(
		document.getElementById("chart_div"));
	
	//chart.draw(데이터테이블, 옵션)
	chart.draw(data,{
		title:"차트 예제",
		width:500,
		height:400
	});
}
</script>
</head>
<body>
<div class="row">
   <div class="col-xl-8 col-lg-7">
       <!-- Area Chart -->
       <div class="card shadow mb-4">
           <div class="card-header py-3">
               <h6 class="m-0 font-weight-bold text-primary">상품 가격</h6>
           </div>
           <div id="chart_div"></div>
       </div>
	</div>
</div>

</body>
</html>