<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.sjsu.cmpe272.beans.AnswerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Result Page</title>
<link rel="stylesheet" href="<%request.getContextPath();%>/css/style.css" type="text/css">
<script type='text/javascript' src='https://www.google.com/jsapi'></script>
<script type='text/javascript'>
	google.load('visualization', '1', {
		packages : [ 'gauge' ]
	});
	google.setOnLoadCallback(drawChart);
	function drawChart() {
		var data1 = google.visualization.arrayToDataTable([
				[ 'Label', 'Value' ], [ 'Question One', <%=((Double)session.getAttribute("answer1weight"))%> ]

		]);

		var data2 = google.visualization.arrayToDataTable([
				[ 'Label', 'Value' ], [ 'Question Two', <%=((Double)session.getAttribute("answer2weight"))%> ]

		]);

		var data3 = google.visualization.arrayToDataTable([
				[ 'Label', 'Value' ], [ 'Question Three', <%=((Double)session.getAttribute("answer3weight"))%> ]

		]);

		var data4 = google.visualization.arrayToDataTable([
				[ 'Label', 'Value' ], [ 'Question Four', <%=((Double)session.getAttribute("answer4weight"))%> ]

		]);

		var data5 = google.visualization.arrayToDataTable([
				[ 'Label', 'Value' ], [ 'Question Five', <%=((Double)session.getAttribute("answer5weight"))%> ]

		]);

		var options = {
			width : 700,
			height : 300,
			redFrom : 0,
			redTo : 50,
			yellowFrom : 51,
			yellowTo : 100,
			minorTicks : 5
		};

		var chart1 = new google.visualization.Gauge(document
				.getElementById('chart_div1'));
		chart1.draw(data1, options);

		var chart2 = new google.visualization.Gauge(document
				.getElementById('chart_div2'));
		chart2.draw(data2, options);

		var chart3 = new google.visualization.Gauge(document
				.getElementById('chart_div3'));
		chart3.draw(data3, options);

		var chart4 = new google.visualization.Gauge(document
				.getElementById('chart_div4'));
		chart4.draw(data4, options);

		var chart5 = new google.visualization.Gauge(document
				.getElementById('chart_div5'));
		chart5.draw(data5, options);

	}
</script>


<script type="text/javascript">
	google.load('visualization', '1', {
		packages : [ 'corechart' ]
	});
</script>
<script type="text/javascript">
	function drawVisualization() {
		// Create and populate the data table.
		var oldcar = <%=(Double.parseDouble((String) session.getAttribute("result")) * 100)%>	;
		var newcar = <%=100 - (Double.parseDouble((String) session.getAttribute("result")) * 100)%>;
		var data = google.visualization.arrayToDataTable([
				[ 'Task', 'Total weightage' ], [ 'Oldcar', oldcar ],
				[ 'Newcar', newcar ] ]);

		// Create and draw the visualization.
		new google.visualization.PieChart(document
				.getElementById('visualization')).draw(data, {
			title : "So, Which car is right for you? Here is the Answer"
		});
	}

	google.setOnLoadCallback(drawVisualization);
</script>
</head>

<body style="font-family: Arial; border: 0 none;">
	<%
		List<AnswerBean> answerList = (ArrayList<AnswerBean>) session
				.getAttribute("answerList");
		Collections.sort(answerList);
		String selectedAnswers = (String) session
				.getAttribute("selectedAnswers");

		String answer1 = selectedAnswers.substring(0,
				selectedAnswers.indexOf(","));

		selectedAnswers = selectedAnswers.substring(answer1.length() + 1);
		String answer2 = selectedAnswers.substring(0,
				selectedAnswers.indexOf(","));

		selectedAnswers = selectedAnswers.substring((answer2.length()) + 1);
		String answer3 = selectedAnswers.substring(0,
				selectedAnswers.indexOf(","));

		selectedAnswers = selectedAnswers.substring((answer3.length()) + 1);
		String answer4 = selectedAnswers.substring(0,
				selectedAnswers.indexOf(","));

		selectedAnswers = selectedAnswers.substring((answer4.length()) + 1);
		String answer5 = selectedAnswers.substring(0,
				selectedAnswers.length());
	%>
	<table>
		<tr>
			<td>
				<div id='chart_div1'></div>
				<table>
					<tr>
						<td>
							&nbsp;&nbsp;&nbsp;&nbsp;<th>Used Car</th>
						</td>
					
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;
							<th>New Car</th>
						</td>
					</tr>
				</table> <div class="span123"><%=answerList.get(Integer.parseInt(answer1)-1)
					.getAnswerAnalysis()%></div>

				<div id='chart_div2'></div> <table>
					<tr>
						<td>
							&nbsp;&nbsp;&nbsp;&nbsp;<th>Used Car</th>
						</td>
					
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;
							<th>New Car</th>
						</td>
					</tr>
				</table><%=answerList.get(Integer.parseInt(answer2)-1)
					.getAnswerAnalysis()%>

				<div id='chart_div3'></div> <table>
					<tr>
						<td>
							&nbsp;&nbsp;&nbsp;&nbsp;<th>Used Car</th>
						</td>
					
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;
							<th>New Car</th>
						</td>
					</tr>
				</table><%=answerList.get(Integer.parseInt(answer3)-1)
					.getAnswerAnalysis()%>

				<div id='chart_div4'></div> <table>
					<tr>
						<td>
							&nbsp;&nbsp;&nbsp;&nbsp;<th>Used Car</th>
						</td>
					
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;
							<th>New Car</th>
						</td>
					</tr>
				</table><%=answerList.get(Integer.parseInt(answer4)-1)
					.getAnswerAnalysis()%>
				<div id='chart_div5'></div> <table>
					<tr>
						<td>
							&nbsp;&nbsp;&nbsp;&nbsp;<th>Used Car</th>
						</td>
					
						<td>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;
							<th>New Car</th>
						</td>
					</tr>
				</table><%=answerList.get(Integer.parseInt(answer5)-1)
					.getAnswerAnalysis()%>

				<div id="visualization" style="width: 600px; height: 400px;"></div>
			</td>
		</tr>

	</table>
</body>
</html>
​
