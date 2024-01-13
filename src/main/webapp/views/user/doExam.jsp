<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

	<script>
	    
		function markColor(id){
			 document.getElementById("answer"+id).style.backgroundColor = "rgb(167,162,162)";
		}
		
		function markTrue(id){
			 document.getElementById("answer"+id).style.backgroundColor = "rgb(0,255,0)";
		}
		
		function markFalse(id){
			 document.getElementById("answer"+id).style.backgroundColor = "rgb(255,0,0)";
		}
		
		var timecheck;
		function startTimer(duration, display) {
		    var timer = duration, minutes, seconds;
		    
			   timecheck= setInterval(function () {
			        minutes = parseInt(timer / 60, 10)
			        seconds = parseInt(timer % 60, 10);
			
			        minutes = minutes < 10 ? "0" + minutes : minutes;
			        seconds = seconds < 10 ? "0" + seconds : seconds;
			
			        display.textContent = minutes + ":" + seconds;
			
			        if (--timer < 0) {
			           clearInterval(timecheck);
			          //do someth after countdown
			           alert("Đã hết thời gian làm bài test Listening.");
			           $("#btnResult").click()
			        }
			    },1000);
			     
		};

		window.onload = function () {
				 var fortyMinutes = 60*40;
		         display = document.querySelector('#time');
		    	 startTimer(fortyMinutes, display);
		    };
		    
		function clickStop(){		
			//clear clock,stop countdown
		    clearInterval(timecheck);
		    $('#btnResult').hide();
		    
		    var answers = document.getElementById("answers");
		    if (answers.style.display === "none") 
		    {
		    	answers.style.display = "block";
		    } 
		    else 
		    {
		    	answers.style.display = "none";
		    }
		    
		    var answerArr = answerUser();

			var correctArr = correctAns();
			var countCorrect = 0;
			for(var i = 0; i < 40; i++){
				if (correctArr[i].length === 2)
				{
					if (correctArr[i + 1].length === 2)
					{
						if ((answerArr[i] == correctArr[i][0] && answerArr[i+1] == correctArr[i+1][0]) || (answerArr[i] == correctArr[i][1] && answerArr[i+1] == correctArr[i+1][1]) )
						{
							countCorrect += 2;
							markTrue(i+1);
							markTrue(i+2);
							i++;
							continue;
						}
						if ((answerArr[i] == correctArr[i][0] && answerArr[i+1] == correctArr[i+1][1]) || (answerArr[i] == correctArr[i][1] && answerArr[i+1] == correctArr[i+1][0]) )
						{
							countCorrect++;
							markTrue(i+1);
							markFalse(i+2);
							i++;
							continue;
						}
					}				
				}
				
				var flag = 0;
				for (var j = 0; j < 2; j++) {
					if(answerArr[i] == correctArr[i][j]) 
					{
						countCorrect++;							
						markTrue(i+1);
						flag = 1;
					}
				}
				
				if(flag === 0)
				{
					markFalse(i+1);
				}
				
			}
		 	    
		   $("#resultTest h4").text("Kết quả: " + countCorrect + "/40");
		   $('#resultTest').show();
	    };
    
	    function correctAns(){
	    	var correctAnswer = [];
	    	<c:forEach var="listdapan" items="${listDapAn}" varStatus="i_listdapan">
	    		var innerArray = [];
	    		<c:forEach var="dapan" items="${listdapan}" varStatus="i_dapan">
	    			innerArray[${i_dapan.index}] = "${dapan.noiDungDapAn}";
	    		</c:forEach>
	    		correctAnswer[${i_listdapan.index}] = innerArray;
	    	</c:forEach>
	    	return correctAnswer;
	    };
	    
	    function answerUser(){
	    	var answerArr = [];
	    	
	    	for (var i = 1; i < 41; i++) {
	    		 var nameRadio = "question"+i;
	    		 var result = document.getElementById("submitForm").elements.namedItem(nameRadio);
	    		
	    		 if(result == null) 
	    			 answerArr.push("");
	    		 else
	    		 {  			 	
	    		 	var x = document.getElementById("submitForm").elements.namedItem(nameRadio).value;
	    		 	answerArr.push(x);
	    		 }
	    			
	    	}

	    	return answerArr;
	    }


	</script>

	<div class="testReading" id="testReading">
		<div class="navbar navbar-default navbar-fixed-top">
			<br>
			<div style="display: block;">
					<a href="/listening-ielts/test-exam" id="backhome" style="display: inline;">&larr; Back</a> &nbsp &nbsp &nbsp &nbsp &nbsp 
					<h1 style="margin: auto 34%; display: inline; color: blue;">BÀI THI LISTENING</h1>
			</div>

		</div>

		<div id="content" class="container-fluid fill">
			<form id="submitForm" name="submitForm">
				<div class="row">
					<div id="navigation" class="col-md-3">
						<div class="fix-scrolling">
							<br>
							<div>
								<span id="time">40:00</span>
							</div>
							<hr width="60%">
							<c:forEach begin="1" end="40" varStatus="loop">
								<c:if test="${loop.index % 5 == 1}">
									<div>
									</div>
								</c:if>
								<div class="numberCircle" id="answer${loop.index}">${loop.index}</div>
							</c:forEach>
							<br> <br>
							<input type="button" class="btn btn-primary" id="btnResult" style="margin-left: 88px;" value="Submit" onclick="clickStop()"/> 
							<div id="resultTest" style="display: none;">
								<h4 style="padding-left: 70px; font-weight: bold;"></h4>
							</div>
						</div>
					</div>
					<div class="col-md-3 ">
						<!-- Placeholder - keep empty -->
					</div>				
					<div id="main" class="col-md-8 web-font">
						<c:forEach items="${listCauHoi}" var="cauhoi">
							<c:if test="${cauhoi.maCauHoi % 10 == 1}">
								<c:if test="${(cauhoi.maCauHoi + 41) % 41 != 1}"> <!-- audio xuống hàng trừ dòng đầu-->
									<br>
								</c:if>										
								<audio controls> 
									<source src="${pageContext.request.contextPath}/resources/file/audio/exam/${cauhoi.getPart().getAudio()}" type="audio/wav">
								</audio>	
							</c:if>
							<h4>${cauhoi.noiDungCauHoi}</h4>
							<div>
								<c:if test="${cauhoi.anhCauHoi != null}">
									<img alt="lỗi" src="${pageContext.request.contextPath}/resources/file/images/exam/${cauhoi.anhCauHoi}.png">
								</c:if>							 
							</div>
							<div>
								${((cauhoi.maCauHoi- 1) % 40) + 1}. <input type="text" id="${((cauhoi.maCauHoi- 1) % 40) + 1}" name="question${((cauhoi.maCauHoi- 1) % 40) + 1}" onclick="markColor(this.id)">
							</div>
						</c:forEach>					
						<br><br>
						<div id="answers" style="display: none;">
							<h2 style="color: orange; font-weight: bold; margin-left: 42%;">ĐÁP ÁN</h2>
							<c:forEach items="${listCauHoi}" var="cauhoi">
								<span style="font-weight: bold;">${((cauhoi.maCauHoi- 1) % 40) + 1}. </span>
									<c:forEach items="${cauhoi.getListDapAn()}" var="dapan">						
										<h4 style="font-weight: bold; padding-left: 40px;"> ${dapan.noiDungDapAn} </h4>	
									</c:forEach>
							</c:forEach>
							
						</div>
					</div>
				</div>
			</form>
		</div>
		<div class="row" style="margin-left: 42%;">
			<h1 style="color: blue;">KẾT THÚC BÀI THI</h1>
		</div>
	</div>
</body>
</html>
