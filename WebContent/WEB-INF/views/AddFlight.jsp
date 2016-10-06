<%@include file="/WEB-INF//views/template/header.jsp"%>

		<div class="container">
  		<h2>Adding Flight</h2>
  		<br/><br/>
  		<form method="POST" action="<c:url value="/admin/AddFlight" />">
  			<div class="form-group">
				<h4>Flight Origin :</h4>
          		<select name="depart" class="selectpicker form-control" data-live-search="true">
          			<option value="London">London</option>
              		<option value="Madrid">Madrid</option>
              		<option value="Meknes">Meknes</option>
              		<option value="Dakhla">Dakhla</option>
              		<option value="Barcelona">Barcelona</option>
              		<option value="Roma">Roma</option>
              		<option value="Munchen">Munchen</option>
              		<option value="Dortmund">Dortmund</option>
              		<option value="Rabat">Rabat</option>
              		<option value="Casablanca">Casablanca</option>
              		<option value="Tanger">Tanger</option>
              		<option value="Agadir">Agadir</option>
              		<option value="Manhatan">Manhatan</option>
              		<option value="Tunis">Tunis</option>
              		<option value="Alger">Alger</option>
              		<option value="Marseille">Marseille</option>
              		<option value="Lyon">Lyon</option>
              		<option value="Benfica">Benfica</option>
              		<option value="Porto">Porto</option>
              		<option value="Valencia">Valencia</option>
              		<option value="Fes">Fes</option>
              		<option value="LasPalmas">LasPalmas</option>
              		<option value="Ghaza">Ghaza</option>
              		<option value="Oujda">Oujda</option>tion>
          		</select>
    		</div>
    		
    		
    		
    		<div class="form-group">
       			<h4>Flight Destination :</h4>
          		<select name="destination" class="selectpicker form-control" data-live-search="true">
          			<option value="Madrid">Madrid</option>
              		<option value="Meknes">Meknes</option>
              		<option value="Dakhla">Dakhla</option>
              		<option value="London">London</option>
              		<option value="Barcelona">Barcelona</option>
              		<option value="Roma">Roma</option>
              		<option value="Munchen">Munchen</option>
              		<option value="Dortmund">Dortmund</option>
              		<option value="Rabat">Rabat</option>
              		<option value="Casablanca">Casablanca</option>
              		<option value="Tanger">Tanger</option>
              		<option value="Agadir">Agadir</option>
              		<option value="Manhatan">Manhatan</option>
              		<option value="Tunis">Tunis</option>
              		<option value="Alger">Alger</option>
              		<option value="Marseille">Marseille</option>
              		<option value="Lyon">Lyon</option>
              		<option value="Benfica">Benfica</option>
              		<option value="Porto">Porto</option>
              		<option value="Valencia">Valencia</option>
              		<option value="Fes">Fes</option>
              		<option value="LasPalmas">LasPalmas</option>
              		<option value="Ghaza">Ghaza</option>
              		<option value="Oujda">Oujda</option>
          		</select>
    		</div>
   			 
   			 <div class="form-group">
   			 		<h4>Flight Time :</h4>
	       			<label for="year">Year :</label> 
	          		<select name="year" class="selectpicker form-control" data-live-search="true" data-width="15%">
						<option value = "2016">2016</option>
						<option value = "2017">2017</option>
						<option value = "2018">2018</option>
						<option value = "2019">2019</option>
						<option value = "2020">2020</option>
						<option value = "2021">2021</option>
						<option value = "2022">2022</option>
						<option value = "2023">2023</option>
						<option value = "2024">2024</option>
						<option value = "2025">2025</option>
	          		</select>
	
	       			<label for="month">Month :</label> 
	          		<select name="month" class="selectpicker form-control" data-live-search="true" data-width="15%">
						<option value = "1">January</option>
						<option value = "2">February</option>
						<option value = "3">March</option>
						<option value = "4">April</option>
						<option value = "5">May</option>
						<option value = "6">June</option>
						<option value = "7">July</option>
						<option value = "8">August</option>
						<option value = "9">September</option>
						<option value = "10">October</option>
						<option value = "11">November</option>
						<option value = "12">December</option>
	          		</select>
	
	       			<label for="day">Day :</label> 
	          		<select name="day" class="selectpicker form-control" data-live-search="true" data-width="15%">
						<option value = "1">1</option>
						<option value = "2">2</option>
						<option value = "3">3</option>
						<option value = "4">4</option>
						<option value = "5">5</option>
						<option value = "6">6</option>
						<option value = "7">7</option>
						<option value = "8">8</option>
						<option value = "9">9</option>
						<option value = "10">10</option>
						<option value = "11">11</option>
						<option value = "12">12</option>
						<option value = "13">13</option>
						<option value = "14">14</option>
						<option value = "15">15</option>
						<option value = "16">16</option>
						<option value = "17">17</option>
						<option value = "18">18</option>
						<option value = "19">19</option>
						<option value = "20">20</option>
						<option value = "21">21</option>
						<option value = "22">22</option>
						<option value = "23">23</option>
						<option value = "24">24</option>
						<option value = "25">25</option>
						<option value = "26">26</option>
						<option value = "27">27</option>
						<option value = "28">28</option>
						<option value = "29">29</option>
						<option value = "30">30</option>
						<option value = "31">31</option>
	          		</select>
	          		
	          		<label for="hour">Hour :</label> 
	          		<select name="hour" class="selectpicker form-control" data-live-search="true" data-width="15%">
						<option value = "0">00</option>
						<option value = "1">01</option>
						<option value = "2">02</option>
						<option value = "3">03</option>
						<option value = "4">04</option>
						<option value = "5">05</option>
						<option value = "6">06</option>
						<option value = "7">07</option>
						<option value = "8">08</option>
						<option value = "9">09</option>
						<option value = "10">10</option>
						<option value = "11">11</option>
						<option value = "12">12</option>
						<option value = "13">13</option>
						<option value = "14">14</option>
						<option value = "15">15</option>
						<option value = "16">16</option>
						<option value = "17">17</option>
						<option value = "18">18</option>
						<option value = "19">19</option>
						<option value = "20">20</option>
						<option value = "21">21</option>
						<option value = "22">22</option>
						<option value = "23">23</option>

	          		</select>
	          		
	          		<label for="minute">Minute :</label> 
	          		<select name="minute" class="selectpicker form-control" data-live-search="true" data-width="15%">
						<option value = "1">00</option>
						<option value = "1">01</option>
						<option value = "2">02</option>
						<option value = "3">03</option>
						<option value = "4">04</option>
						<option value = "5">05</option>
						<option value = "6">06</option>
						<option value = "7">07</option>
						<option value = "8">08</option>
						<option value = "9">09</option>
						<option value = "10">10</option>
						<option value = "11">11</option>
						<option value = "12">12</option>
						<option value = "13">13</option>
						<option value = "14">14</option>
						<option value = "15">15</option>
						<option value = "16">16</option>
						<option value = "17">17</option>
						<option value = "18">18</option>
						<option value = "19">19</option>
						<option value = "20">20</option>
						<option value = "21">21</option>
						<option value = "22">22</option>
						<option value = "23">23</option>
						<option value = "24">24</option>
						<option value = "25">25</option>
						<option value = "26">26</option>
						<option value = "27">27</option>
						<option value = "28">28</option>
						<option value = "29">29</option>
						<option value = "30">30</option>
						<option value = "31">31</option>
						<option value = "32">32</option>
						<option value = "33">33</option>
						<option value = "34">34</option>
						<option value = "35">35</option>
						<option value = "36">36</option>
						<option value = "37">37</option>
						<option value = "38">38</option>
						<option value = "39">39</option>
						<option value = "40">40</option>
						<option value = "41">41</option>
						<option value = "42">42</option>
						<option value = "43">43</option>
						<option value = "44">44</option>
						<option value = "45">45</option>
						<option value = "46">46</option>
						<option value = "47">47</option>
						<option value = "48">48</option>
						<option value = "49">49</option>
						<option value = "50">50</option>
						<option value = "51">51</option>
						<option value = "52">52</option>
						<option value = "53">53</option>
						<option value = "54">54</option>
						<option value = "55">55</option>
						<option value = "56">56</option>
						<option value = "57">57</option>
						<option value = "58">58</option>
						<option value = "59">59</option>
						<option value = "60">60</option>
	          		</select>
          			
    		</div>
    		
    		<div class="form-group">
    			<h4>Pilot <span class="requis">*</span></h4>
	    		<select name="pilot" class="selectpicker form-control" data-live-search="true">
	   			 	<c:forEach items="${pilots}" var="pilot">
	       		 		<option value="${pilot.id}"><c:out value="${pilot.nom}" /></option>
	    			</c:forEach>
				</select>
				<span class="erreur">${flightService.erreurs['pilot']}</span>
    		</div>
    		
    		<div class="form-group">
    			<h4>Airplane <span class="requis">*</span></h4>
	    		<select name="plane" class="selectpicker form-control" data-live-search="true">
	   			 	<c:forEach items="${planes}" var="plane">
	       		 		<option value="${plane.id}"><c:out value="${plane.model}" /></option>
	    			</c:forEach>
				</select>
				<span class="erreur">${flightService.erreurs['plane']}</span>
    		</div>
    		
    		<div class="form-group">
      			 <h4>Price <span class="requis">*</span></h4>
     			 <input type="text" name="prix" class="form-control" id="prix" placeholder="Enter the flight price" value="<c:out value="${flight.prix}"/>" >
     			 <span class="erreur">${flightService.erreurs['prix']}</span>
   			 </div>
    		
    		<button type="submit" class="btn btn-default">Submit</button>
    
  		</form>
	</div>


</body>
</html>