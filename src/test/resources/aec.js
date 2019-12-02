$(document).ready(function() {	
	var readFile = $.getJSON("/Parties_and_Representatives/Party_Registration/Registered_parties/files/register-2019-11-22.json", function(json) {	
		var arr = json.Details;
		//console.log(arr);
		
		arr.sort(sortByProperty('nameOfParty'));		
		$(".list").html('');
		$.each(arr,function(i, value){ 		   	
			var partyID = value.id;
			$('.list').append('<div class="accordion"><div class="accordion__button"><h2><a href="#party'+partyID+'" class="accordion__controls collapsed" data-toggle="collapse" data-target="#party'+partyID+'" aria-expanded="false">'+value.nameOfParty+'</a></h2></div><div class="collapse" id="party'+partyID+'" aria-expanded="false"><div class="accordion__panel"><table></table></div></div></div>');
			$('#party'+partyID+' table').append('<caption>In accordance with Part XI of the Commonwealth Electoral Act 1918, the political party whose details appear below was registered on '+value.partyRegisterDate+'. The current particulars of the party, as amended on '+value.ammendmentDate+', are:-</caption>');
			$('#party'+partyID+' table').append('<tr><th>Name of party</th><td class="partyname">'+value.nameOfParty+'</td></tr>');	
			$('#party'+partyID+' table').append('<tr><th>Registered abbreviation</th><td>'+formatabbr(value.abbreviation)+'</td></tr>');
			$('#party'+partyID+' table').append('<tr><th>Parliamentary party</th><td>'+formatParlParty(value.isParliamentaryParty)+'</td></tr>');
			$('#party'+partyID+' table').append('<tr><th>Registered Officer of party</th><td>'+value.officerName+'<br>'+replaceReturns(value.officerAddress )+'<p></td></tr>');
			$('#party'+partyID+' table').append('<tr><td colspan="2">'+formatFundingtext(value.electionFundingPayments)+'</td></tr>');	
			$('#party'+partyID+' table').append('<tr><th>Party Correspondence Address:</th><td>'+replaceReturns(value.postalAddress)+'</tr>');
			$('#party'+partyID+' table').append('<tr><th>Deputy Registered Officers:</th><td>'+formatDepRegOfficer(value.deputyOfficers)+'</tr>');
			$('#party'+partyID+' table').append('<tr><th>Registered logo:</th><td>'+getLogo(value.logoDataUri)+'</tr>');
			$('#party'+partyID+' table').append('<tfoot><tr><td colspan="2"><a href="javascript:window.print()">Print party extract</a></td></tr></tfoot>');
			//branches 			
				if(value.hasOwnProperty('branches')) {
				var brancharr = value.branches;
					$.each(brancharr,function(i, value){
					var partyBranchID = value.id;
					$('.list').append('<div class="accordion accordion--branch"><div class="accordion__button"><h2><a href="#party'+partyBranchID+'" class="accordion__controls collapsed" data-toggle="collapse" data-target="#party'+partyBranchID+'" aria-expanded="false">'+value.nameOfParty+'</a></h2></div><div class="collapse" id="party'+partyBranchID+'" aria-expanded="false"><div class="accordion__panel"><table></table></div></div></div>');
					$('#party'+partyBranchID+' table').append('<caption>In accordance with Part XI of the Commonwealth Electoral Act 1918, the political party whose details appear below was registered on '+value.partyRegisterDate+'. The current particulars of the party, as amended on '+value.ammendmentDate+', are:-</caption>');
					$('#party'+partyBranchID+' table').append('<tr><th>Name of party</th><td class="partyname">'+value.nameOfParty+'</td></tr>');	
					$('#party'+partyBranchID+' table').append('<tr><th>Registered abbreviation</th><td>'+formatabbr(value.abbreviation)+'</td></tr>');
					$('#party'+partyBranchID+' table').append('<tr><th>Parliamentary party</th><td>'+formatParlParty(value.isParliamentaryParty)+'</td></tr>');
					$('#party'+partyBranchID+' table').append('<tr><th>Registered Officer of party</th><td>'+value.officerName+'<br>'+replaceReturns(value.officerAddress)+'<p></td></tr>');
					$('#party'+partyBranchID+' table').append('<tr><td colspan="2">'+formatFundingtext(value.electionFundingPayments)+'</td></tr>');	
					$('#party'+partyBranchID+' table').append('<tr><th>Party Correspondence Address:</th><td>'+replaceReturns(value.postalAddress)+'</tr>');
					$('#party'+partyBranchID+' table').append('<tr><th>Deputy Registered Officers:</th><td>'+formatDepRegOfficer(value.deputyOfficers)+'</tr>');
					$('#party'+partyBranchID+' table').append('<tr><th>Registered logo:</th><td>'+getLogo(value.logoDataUri)+'</tr>');
					$('#party'+partyBranchID+' table').append('<tfoot><tr><td colspan="2"><a href="javascript:window.print()">Print party extract</a></td></tr></tfoot>');
				});
			}
     	});		
	}).done(function() {
    	var options = {
			valueNames: [ 'partyname', 'partylink' ]
		};
		var partyList = new List('party-list', options);
		partyList.reIndex();
		// check for hash when collapse divs have unique party id's
		var hash = window.location.href.split('#')[1]
    	$('#'+hash).collapse('show');
		$('#'+hash).on('shown.bs.collapse', function () {
			var scroll_to = document.getElementById(hash);
			scroll_to.scrollIntoView();
		});
		
		//add anchor links to each li
		anchors.add('h3');
		//anchors.add('.list li');
	});
});	
$('#party-list input').keyup(function() {
	if( !$(this).val() ) {
		$('#party-list').removeClass('sorting');
	} else {
		$('#party-list').addClass('sorting');
    }
});

function sortByProperty(property) {
	//http://www.levihackwith.com/code-snippet-how-to-sort-an-array-of-json-objects-by-property/
    'use strict';
    return function (a, b) {
        var sortStatus = 0;
        if (a[property] < b[property]) {
            sortStatus = -1;
        } else if (a[property] > b[property]) {
            sortStatus = 1;
        }
 
        return sortStatus;
    };
}

function parseJsonDate(sDate) {
    var b, e, i;
    b = sDate.indexOf('(');
    e = sDate.indexOf(')');
    i = sDate.substring(b+1,e);
   	if (isNaN(i)) {
		return null
	};
	var d = new Date(parseInt(i));
	var month = new Array(12);
	month[0] = "January";
	month[1] = "February";
	month[2] = "March";
	month[3] = "April";
	month[4] = "May";
	month[5] = "June";
	month[6] = "July";
	month[7] = "August";
	month[8] = "September";
	month[9] = "October";
	month[10] = "November";
	month[11] = "December";
	// not UTC
	var date = d.getDate();
	var mnth = month[d.getMonth()];
	var year = d.getFullYear();
	
	//format as 25 Jan, 2016
	return date+' '+mnth+' '+year;
}

function getLogo(logoURI) {
	if(logoURI === null) {
		return "&nbsp;"		
	} else {
		return '<img src="'+logoURI+'">';	
	}
}//end replaceReturns

function formatabbr(abbr) {
	if(abbr === null) {
		return "&nbsp;"		
	} else {
		return abbr;	
	}
}//end replaceReturns
function formatDepRegOfficer(depOfficers) {
	var str="";
	if (depOfficers !== null) {		
		for(var i = 0; i < depOfficers.length; i++) {
			str += depOfficers[i].firstName + ' ' + depOfficers[i].surname +'<br>';
		}
		return str;
	}
	return "&nbsp;";
}
function formatParlParty(ParlParty) {
	if (ParlParty === true) {
		return "Yes";
	}
	return "No";
}
function replaceReturns(fromJSON) {
	if(fromJSON !== null) {
		return fromJSON.replace(/\n/g, "<br>");	
	} else {
		return "&nbsp;"		
	}
}//end replaceReturns
function formatFundingtext(electionFunding) {
	if(electionFunding === true) {//Yes
		return "Party wishes to receive election funding payments.";	
	}
	return "Party does not wish to receive election funding payments.";
}//end formatFundingtext
function formatROtext(name,address) {
	var returntxt = "";
	if(name){
		returntxt += "<p><strong>Name:</strong> "+name+"</p>";
	} else {
		returntxt += "&nbsp;";
	}
	if (address) {
		returntxt += "<p><strong>Address</strong>: "+address+"</p>";
	} else {
		returntxt += "&nbsp;";
	}
	return returntxt;
}//end function formatROtext
$('.list').on('click', '.accordion__button a', function(e) {
	e.preventDefault();
});	
</script>