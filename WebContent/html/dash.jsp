<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<html>
<head>
	<title>Agile Meeting Dashboard</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<style>
		.searchbar{
		margin-top: 20px;
		margin-bottom: 20px;
		margin-right: 30%;
		margin-left: 40%;
		width: 30%;
	
		}
		.chatbox{
			margin-right:10px; 
			margin-left:10px;  
			margin-bottom: 10%;
			overflow-y: hidden; 
			overflow-y: auto;
			background-color: #DDDDDD; 
			padding: 20px;  
		}
		.postclass{
			color : black;
			margin: 10%;
			width: 80%;
			padding: 10px;

		}
		.marginclass{
			margin-top: 10px; 
			padding-bottom: 10px;
		}
		.messageclassl{
			width: 70%;
			padding: 10px;
			background-color: white;
			margin-right: 30%;
			margin-top: 10px;
			margin-bottom: 10px;
		}
		.messageclassr{
			width: 70%;
			padding: 10px;
			background-color: #28a745;
			color: white;
			margin-left: 30%;
			margin-top: 10px;
			margin-bottom: 10px;
		}
		.delbutclass{
			float: right;
			margin-top: 5px;
		}
	</style>
	
</head>
<body>
	<nav class="navbar navbar-light bg-primary" style="top: 0; width: 100%; position: fixed;" >
  		<span class="navbar-brand mb-0 h1" style="color: white"><a style="color : white;" href="/agilemeetingdash/">Agile Meeting Dashboard</a></span>
  		<a style="color: white" href="logoutfunc">Logout</a>
	</nav>

	<div style="width:100%;" class="wrapper">
        <div class="contentWrapper" style="width:100%;">
        	<div id="leftnav"  class="left-nav" style="width:20%; float:left; position:fixed; height:100%; background-color:#007bff; top: 56px; left: 0px; overflow-y:scroll hidden;">
        		<div style="top: 56px"></div>
        		<div id="tableofcontents">
        			
        			<div style="margin-top: 20px;"></div>
					<div style="text-align: center; color: white;"><h3>Create Channel</h3></div>
					<div style="margin-top: 20px;"></div>
					<div style="margin-left: 15px; margin-right: 15px;">
						
						<form action = "createchannel">
					    		<input class="form-control mr-sm-2" placeholder="Create Channel" id="channelname" name="channelname" type="text" required="required">
					    		<div style="margin-top: 20px;"></div>
					    		<button class='btn btn-outline-light my-2 my-sm-0' id='createchannelid' >Create Channel</button>
					    </form>
					        		
					</div>
					<div style="margin-top: 20px;"></div>
					<div id="channellist" style="margin: 10px; overflow-y: auto;background-color: white; color: black; ">
						<%  String haschannel = (String) request.getAttribute("haschannel");
							if (haschannel != null && haschannel.equals("yes")){
							// retrieve your list from the request, with casting 
							ArrayList<String> list = (ArrayList<String>) request.getAttribute("channellist");
							
							// print the information about every category of the list
							for(String channel : list) {
								out.println("<p></p>");
								out.println("<div style = 'margin : 20px;'> ");
								out.println("<form action='getchannel'  method='POST'   >  <input name='channelname' type='hidden' value = '" + channel +"'>");
							    out.println("<button class='btn btn-outline-primary my-2 my-sm-0' id='createchannelid' >"+ channel +"</button>");
							    out.println("</form></div>");
							    out.println("<p></p>");
							}
							}
							%>
					</div>
        		</div>
        	</div>

        	<div id="content" runat="server" class="content" style="width:80%; float:right;">
        		<div style="margin-top: 56px;"></div>
              	<h2 class="heading">Agile Meeting Dashboard</h2>
              	<% boolean takensurvey = (boolean) request.getAttribute("takensurvey"); 
              		String useremail = (String)session.getAttribute("email");
              		if( !takensurvey ){
              			out.println("<a href='http://127.0.0.1:5000/survey/" + useremail + "' > Take Survey</a>");
              		}
              		
              	%>
              	<div style="margin : 30px">
              		
              		<div id ="varcontent">
              		
              			<div id="piechart"></div>
              			<p></p>
              			<div id = "varoverdue">
              				<h3>Your Overdue Tasks</h3>
              				<p>You have not Overdue task</p>
              			</div>
              			<div id = "varcompleted">
              				<h3>Your Completed Tasks</h3>
              				<p>You have not Completed task</p>
              			</div>
              			<div id = "varreview">
              				<h3>Your Review Tasks</h3>
              				<p>You have not Review task</p>
              			</div>
              			<div id = "varpending">
              				<h3>Your Pending Tasks</h3>
              				<p>You have not Pending task</p>
              			</div>
              		</div>
              	</div>
              </div>
          </div>
      </div>
      <script>
      var noteslist = [];
    	<%
	      	ArrayList<String> noteslist = (ArrayList<String>) request.getAttribute("noteslist");
    		int i = 0;
			for( String notes : noteslist){
				
    	%>
    		noteslist[ <%= i %>] =  '<%= notes %>' ;
		<%
			i = i + 1;
			}
    	%>
    	
    	var tasklist = [];
    	<%
	      	ArrayList<String> tasklist = (ArrayList<String>) request.getAttribute("tasklist");
    		int j = 0;
			for( String task : tasklist){
				
    	%>
    		tasklist[ <%= j %>] =  '<%= task %>' ;
		<%
			j = j + 1;
			}
    	%>
    	console.log(noteslist);
    	console.log(tasklist);
    	
    	var vardivele = document.getElementById("varcontent");
    	var varoverdue = document.getElementById("varoverdue");
    	var varcompleted = document.getElementById("varcompleted");
    	var varreview = document.getElementById("varreview");
    	var varpending = document.getElementById("varpending");
    	//vardivele.
    	
    	
    	var overduecount = 0;
    	var pendingcount = 0;
    	var reviewcount = 0;
    	var completedcount = 0;
    	var jsonnoteslist = [];
    	noteslist.forEach(notestrtojson);
    	
    	function notestrtojson(item, index){
    		jsonnoteslist.push(JSON.parse(item));
    	}
    	//console.log(jsonnoteslist);
    	tasklist.forEach(myFunction);
    	
    	function myFunction(item, index) {
      		var obj = JSON.parse(item);
      		var divele = document.createElement('div');
        	var inputele = document.createElement("INPUT");
        	inputele.setAttribute("type", "hidden");
        	inputele.setAttribute("value", obj.taskid);
        	inputele.id = "hidinp" ;
        	var note ;
        	
        	jsonnoteslist.forEach(getnote);
        	
        	function getnote(item, index){
        		if(item.noteid == obj.taskid) {
        			//console.log(item);
        			note = item;
        		}
        	}
        	//console.log("start");
        	//console.log(obj);
        	//console.log(note);
        	//console.log("end");
        	
        	var title = document.createElement("h4");
        	title.innerHTML = note.title ;
        	var datetime = note.datetime;
        	var spdate = datetime.split("T");
        	var date = spdate[0];
        	var time = spdate[1];
        	time = time.substring(0, time.length - 5);
        	
        	var newpele = document.createElement("p");
        	newpele.innerHTML = date + " " + time;
        	
        	divele.append(inputele);
        	divele.append(title);
        	
        	var duedate = obj.duedate;
        	var duedatedom = document.createElement("p");
        	duedatedom.innerHTML = "Due date is : " + duedate;
        	
        	var from = duedate.split("/");
        	var taskdate = new Date(from[2], from[1] - 1, from[0]);
        	
        	var today = new Date();
        	
        	
        	var isoverdue = "no";
        	if(today.getTime() > taskdate.getTime() ){
        		if(obj.status == "pending"){
        			isoverdue = "yes";
        		}
        	}
        	
        	
        	divele.className = "messageclass"+ "l" + " btn-outline-primary";
	    	var pele = document.createElement('h5');
	    	pele.innerHTML = note.msgvalue;
	    	divele.append(pele);
	    	divele.append(newpele);
	    	divele.append(duedatedom);
	    	divele.append(document.createElement("p"));
	    	
	    	if(isoverdue == ("yes")){
	    		overduecount = overduecount + 1;
	    		varoverdue.querySelector("p").remove();
	    		varoverdue.append(divele);
	    	}
	    	else{
	    	
				if(obj.status == ("completed")){
					completedcount = completedcount + 1;   
					varcompleted.querySelector("p").remove();
					varcompleted.append(divele);
				}
				if(obj.status == ("review")){
					reviewcount = reviewcount + 1;
					varreview.querySelector("p").remove();
					varreview.append(divele);
				}
				if(obj.status == ("pending")){
					pendingcount = pendingcount + 1;
					var reviewtask = document.createElement("button");
					reviewtask.onclick = sendforreview ;
					reviewtask.innerHTML = "Review Task";
					//console.log("pending");
					divele.append(reviewtask);
					varpending.querySelector("p").remove();
					varpending.append(divele);
				}
	    	}
	    	//vardivele.append(divele);
	        	
	    	}
        	// end of myFunction
        	
        	
        	// piechart 
        	if( reviewcount>0 || overduecount>0 || pendingcount>0 || completedcount>0){
        		google.charts.load('current', {'packages':['corechart']});
    			google.charts.setOnLoadCallback(drawChart);
    			
    			// Draw the chart and set the chart values
    			function drawChart() {
    			  var data = google.visualization.arrayToDataTable([
    			  ['Task', 'All Task'],
    			  ['Review', reviewcount],
    			  ['Overdue', overduecount],
    			  ['Pending', pendingcount],
    			  ['Completed', completedcount],
    			]);
    			
    			  // Optional; add a title and set the width and height of the chart
    			  var options = {'title':'Your All Task', 'width':550, 'height':300};
    			
    			  // Display the chart inside the <div> element with id="piechart"
    			  var chart = new google.visualization.PieChart(document.getElementById('piechart'));
    			  chart.draw(data, options);
    			}
    			 
        	}
        	       	
        	// end of piechart
        	
        	
        	//start of sendforreview function
        	function sendforreview(){
        		var ele = this.parentNode;
          		var hidinp = ele.querySelector("#hidinp");
    	    	  console.log(hidinp);
    	    	var taskid = hidinp.value;
    	    	ajaxfunc(taskid)
        	}
        	
        	// end of sendforreview
        	
        	
        	// start of ajaxfunction
        		function ajaxfunc(taskid){
		      		var xhr = new XMLHttpRequest();
					//request.open('POST' , '/agilemeetingdash/editnotes');
					
					var data = "taskid=" + encodeURIComponent(taskid);
					xhr.open("POST", '/agilemeetingdash/reviewtask', true);
					xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
					xhr.onload = () =>{
		
						var data = xhr.responseText;	
						console.log(data);
						console.log("success");
						location.reload();
					}
					xhr.send(data);
		      	}
        	//end of ajaxfunction
        	
      </script>

	
</body>
</html>