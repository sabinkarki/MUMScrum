<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules.exporting.js"></script>
</head>
<body>
<h:header/>

<div id="container" style="min-width:310px; height: 400px; margin:0 auto" > </div>

<h:footer/>
</body>

<script language="javascript"> 
$(function () {
    Highcharts.chart('container', {
        title: {
            text: 'BurnDown Chart'
        },
        xAxis: {
            categories: ['Day 0', 'Day 1', 'Day 2', 'Day 3', 'Day 4','Day 5', 'Day 6', 'Day 7', 'Day 8', 'Day 9']
        },
        labels: {
            items: [{
                html: 'Release BurnDown',
                style: {
                    left: '50px',
                    top: '18px',
                    color: (Highcharts.theme && Highcharts.theme.textColor) || 'black'
                }
            }]
        },
        series: [{
            type: 'column',
            name: 'daily',
            data: [50, 40, 45, 30, 20]
        }, {
            type: 'spline',
            name: 'Average',
            data: [[0,50],[2,45],[4,20],[8,0]],/* 50,40,41,30,20,15,10,5,0 */
            marker: {
                lineWidth: 2,
                lineColor: Highcharts.getOptions().colors[3],
                fillColor: 'white'
            }
        }]
    });
});

</script>

</html>