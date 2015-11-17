<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html>
<head>
	<!-- Deze tag is nodig voor verzenden van data met CSRF-protectie -->
	<sec:csrfMetaTags />
	<title>Rittenregistratie</title>	

	<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
	
	<script type="text/javascript" language="javascript">
		// configureer JQuery om csrf-token mee te sturen
		var csrfParameter = $("meta[name='_csrf_parameter']").attr("content");
		var csrfHeader = $("meta[name='_csrf_header']").attr("content");
		var csrfToken = $("meta[name='_csrf']").attr("content");
		$(function () {
			var token = $("meta[name='_csrf']").attr("content");
			var header = $("meta[name='_csrf_header']").attr("content");
			$(document).ajaxSend(function(e, xhr, options) {
				xhr.setRequestHeader(header, token);
			});
		});
	
		var root_url = "/spring_mvc_minimal/api/";
		var rit_url = root_url + "rit/";
		
		function add_rit_to_list(rit){
			var element = $('<li>Rit ' + rit.id + ': ' + 
							'<a href="/spring_mvc_minimal/rit/' + rit.id + '">' + rit.omschrijving  + '</a> ' +
							'<input type="button" value="verwijder" data-id="' + rit.id + '" class="deletebutton">'+
							'</li>');
			$('ul').append(element);
			// don't forget to bind click handler
			$('.deletebutton').click(remove);
		}
			
		function get_all(){
			$.get(root_url, function(data){
				for(var i=0; i < data.length; ++i){
					add_rit_to_list(data[i]);
				}
			});
		}
		
		function create(){
			var rit = {
				omschrijving: $('#omschrijving').val(),
				start: $('#start').val(),
				end: $('#end').val(),
			};
			$.post(root_url, rit, function(data){
				add_rit_to_list(data);
			});
		}
		
		function remove(){
			// called as an event handler, 'this' will be bound to element clicked
			var element = $(this);
			var id = element.data().id;
			$.ajax(rit_url + id, {method: 'DELETE', success: function(){element.parent().remove()}});
		}
		
		$(document).ready(function(){
			$('input[type=submit]').click(create);
			get_all();
		})	
	</script>
</head>
<body>
	<ul>
		<!--  Lege lijst - te vullen dmv JS -->
	</ul>
	
	<!-- Let op! We MOETEN hier form:form gebruiken in plaats van een normale HTML form -->

		<p>
			Omschrijving: <input type="text" id="omschrijving"><br>
			Start: <input type="text" id="start"><br>
			Eind: <input type="text" id="end"><br>
			<input type="submit">
		</p>

</body>
</html>