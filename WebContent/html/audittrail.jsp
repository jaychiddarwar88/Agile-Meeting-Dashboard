<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<html>
<head>
	<title>Agile Meeting Dashboard</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
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
              	<div style="margin : 30px">
              		<div id ="varcontent">
              			<div id = "varauditlist">
              				<h3>Audit of Channel <span id = "titleofaudit"></span> are</h3>
              			</div>
              			
              		</div>
              	</div>
              </div>
          </div>
      </div>
      <script>
      var auditlist = [];
    	<%
	      	ArrayList<String> auditlist = (ArrayList<String>) request.getAttribute("auditlist");
    		int i = 0;
			for( String audit : auditlist){
				
    	%>
    		auditlist[ <%= i %>] =  '<%= audit %>' ;
		<%
			i = i + 1;
			}
    	%>
    	
    	var obj = JSON.parse(auditlist[0]);
    	var titleele = document.getElementById("titleofaudit");
    	titleele.innerHTML = obj.channelname;
    	
    	
    	var vardivele = document.getElementById("varcontent");
    	var varaudit = document.getElementById("varauditlist");
    	//vardivele.
    	

    	
    	auditlist.forEach(myFunction);
    	
    	function myFunction(item, index) {
      		var obj = JSON.parse(item);
      		var divele = document.createElement('div');
        	//var inputele = document.createElement("INPUT");
        	//inputele.setAttribute("type", "hidden");
        	//inputele.setAttribute("value", obj.taskid);
        	//inputele.id = "hidinp" ;
        	
        	var newpele = document.createElement("p");
        	newpele.innerHTML = "Remark : " + obj.remark;
        	
        	var timeele = document.createElement("p");
        	timeele.innerHTML = "Time : " + obj.time;
        	
        	divele.append(newpele);
        	divele.append(timeele);

        	divele.className = "messageclass"+ "l" + " btn-outline-primary";
	    	
	        vardivele.append(divele);	
	    	}
        	// end of myFunction
        	
        	
      </script>

	
</body>
</html>